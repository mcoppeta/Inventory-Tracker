package main.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
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

        ObservableList<String> categoryTitles = user.getCategoryTitles();
        ListView categoryDisplay = new ListView(categoryTitles);

        centerPane.getChildren().addAll(categoryDisplay);
        this.setCenter(centerPane);

    }
}
