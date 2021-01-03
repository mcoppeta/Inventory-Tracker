package main.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import main.structures.Category;
import main.structures.Item;
import main.structures.User;

public class InventoryScreen extends BorderPane {
    private User user; //The user that is logged in

    /**
     * Creates InventoryScreen -> The main screen
     */
    public InventoryScreen(User user) {
        // Top Pane
        AnchorPane topPane = new AnchorPane();

        Label message = new Label();
        message.setText("Welcome, " + user.getName() + "!");

        Button settingsButton = new Button("Settings");

        double topMargin = 10.0;

        topPane.getChildren().addAll(message, settingsButton);
        topPane.setTopAnchor(message, topMargin);
        topPane.setTopAnchor(settingsButton, topMargin);
        topPane.setLeftAnchor(message, topMargin);
        topPane.setRightAnchor(settingsButton, topMargin);

        this.setTop(topPane);

        // Center Content
        HBox centerPane = new HBox();

        // Category Pane
        VBox categoryBox = new VBox();

        Label categoryPaneTitle = new Label("Catgeories");

        ObservableList<String> categoryTitles = user.getCategoryTitles();
        ListView<String> categoryDisplay = new ListView<>();
        categoryDisplay.setItems(categoryTitles);

        // New Category Button
        Button newCategoryButton = new Button("New Category");
        newCategoryButton.setOnAction(e -> {
            NewCategoryScreen newCategoryAlert = new NewCategoryScreen();
            newCategoryAlert.display("New Category", "Enter Category Name",
                    "category name", "Add Category");
            Category newCategory = new Category(newCategoryAlert.getInput());

            if (user.addCategory(newCategory)) {
                //success
            } else {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setContentText("This category could not be added");
                error.showAndWait();
            }
        });

        // Remove Category Button
        Button removeCategoryButton = new Button("Remove Category");
        removeCategoryButton.setOnAction(e -> {
            String selectedCategoryTitle = categoryDisplay.getSelectionModel().getSelectedItem();
            if (selectedCategoryTitle == null || selectedCategoryTitle.equals("")) { //unselected category
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setContentText("Must select a category to remove (getSelectedItem returns \"\" or null)");
                error.showAndWait();
            }
            else {

                Category selectedCategory = user.getCorrespondingCategory(selectedCategoryTitle);

                ProceedAlertScreen proceedAlert = new ProceedAlertScreen();
                String proceedMessage = "Are you sure you want to delete the \"" + selectedCategoryTitle
                        + "\" category and all items it contains?";
                proceedAlert.display("Remove Category?", proceedMessage, "Remove Category");

                if (proceedAlert.getProceed()) { //remove category
                    if (user.removeCategory(selectedCategory) == null) { // removes category
                        Alert error = new Alert(Alert.AlertType.WARNING);
                        error.setContentText("Something went wrong (getCorrespondingCategory returned null)");
                        error.showAndWait();
                    }
                }
            }
        });

        HBox categoryButtons = new HBox();
        categoryButtons.getChildren().addAll(newCategoryButton, removeCategoryButton);

        categoryBox.getChildren().addAll(categoryPaneTitle, categoryDisplay, categoryButtons);

        // Items Pane
        VBox itemBox = new VBox();

        Label itemPaneTitle = new Label("Items");

        ObservableList<String> itemTitles = FXCollections.observableArrayList();
        ListView<String> itemDisplay = new ListView<>();
        itemDisplay.setItems(itemTitles);

        // New Item Button
        Button newItemButton = new Button("New Item");
        newItemButton.setOnAction(e -> {
            NewItemScreen newItemAlert = new NewItemScreen();
            newItemAlert.display(user);
            Item newItem = new Item(newItemAlert.getInput());
            Category selectedCategory = user.getCorrespondingCategory(newItemAlert.getSelectedCategory());

            if (selectedCategory.addItem(newItem)) {
                // success
            } else {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setContentText("This item could not be added");
                error.showAndWait();
            }
        });

        itemBox.getChildren().addAll(itemPaneTitle, itemDisplay, newItemButton);

        centerPane.getChildren().addAll(categoryBox, itemBox);
        this.setCenter(centerPane);

        // Listener for category changes, to get corresponding item changes
        categoryDisplay.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                Category current = user.getCorrespondingCategory(categoryDisplay.getSelectionModel().getSelectedItem());
                if (current != null) {
                    itemDisplay.setItems(current.getItemTitles());
                } else {
                    itemDisplay.setItems(FXCollections.observableArrayList());
                }
            }
        });
    }
}
