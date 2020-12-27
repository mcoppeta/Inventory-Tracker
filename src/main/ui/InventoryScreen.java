package main.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.structures.User;

//todo may not extend stackpane
public class InventoryScreen extends StackPane {
    private User user; //The user that is logged in

    /**
     * Creates InventoryScreen -> The main screen
     */
    public InventoryScreen(User user) {
        // Main pane holds everything
        VBox mainPane = new VBox();

        // Top bar to contain welcome message and settings button
        HBox topPane = new HBox();

        Label message = new Label();
        message.setText("Welcome, " + user.getName() + "!");

        topPane.getChildren().addAll(message);

        mainPane.getChildren().addAll(topPane);
        this.getChildren().add(mainPane);
    }
}
