package main.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import main.structures.User;

public class InventoryScreen extends BorderPane {
    private User user; //The user that is logged in

    /**
     * Creates InventoryScreen -> The main screen
     */
    public InventoryScreen(User user) {
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

    }
}
