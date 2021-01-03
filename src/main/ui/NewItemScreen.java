package main.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.structures.Category;
import main.structures.User;

public class NewItemScreen {
    private String input = "";
    private String selectedCategory = "";

    public void display(User user) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Item");
        stage.setMinWidth(250);

        // Screen Content
        Label txtMsg = new Label("Enter Item Name");

        TextField nameEntry = new TextField();

        Label selectMsg = new Label("Select Category");

        ObservableList<String> categoryTitles = user.getCategoryTitles();
        ComboBox<String> categories = new ComboBox<>();
        categories.setItems(categoryTitles);
        categories.getSelectionModel().selectFirst();

        Button exitButton = new Button("Add Item");
        exitButton.setOnAction(e -> {
            input = nameEntry.getText().trim();
            selectedCategory = categories.getSelectionModel().getSelectedItem();
            stage.close();
        });

        // Main pane

        VBox pane = new VBox();
        pane.getChildren().addAll(txtMsg, nameEntry, selectMsg, categories, exitButton);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public String getInput() {
        return input;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }
}
