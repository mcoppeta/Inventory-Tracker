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
        message.setText("Welcome, " + user.getTitle() + "!");

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

        ObservableList<String> categoryTitles = user.getCategoryTitles();
        ListView<String> categoryDisplay = new ListView<>();
        categoryDisplay.setItems(categoryTitles);

        // New Category Button
        Button newCategoryButton = new Button("<New Category>");
        newCategoryButton.setOnAction(e -> {
            EntryAlert newCategoryAlert = new EntryAlert();
            newCategoryAlert.display("New Category", "Enter Category Name",
                    "category name", "Add Category");
            Category newCategory = new Category(newCategoryAlert.getInput());

            if (user.addCategory(newCategory)) {
                Alert y = new Alert(Alert.AlertType.WARNING);
                y.setContentText(newCategory.getTitle());
                y.showAndWait();
            } else {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setContentText("This category could not be added");
                error.showAndWait();
            }
        });

        categoryBox.getChildren().addAll(categoryDisplay, newCategoryButton);

        // Items Pane
        VBox itemBox = new VBox();

        ObservableList<String> itemTitles = FXCollections.observableArrayList();
        categoryDisplay.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                itemTitles.clear();
                for (String title : user.getCorrespondingCategory(newValue).getItemTitles()) {
                    itemTitles.add(title);
                }
            }
        });
        ListView<String> itemDisplay = new ListView<>(itemTitles);

        Button newItemButton = new Button("<New Item>");

        itemBox.getChildren().addAll(itemDisplay, newItemButton);

        centerPane.getChildren().addAll(categoryBox, itemBox);
        this.setCenter(centerPane);

    }
}
