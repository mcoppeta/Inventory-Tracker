package main.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import main.structures.User;

//todo may not extend stackpane
public class InventoryScreen extends StackPane {
    private User user; //The user that is logged in

    /**
     * Creates InventoryScreen -> The main screen
     */
    public InventoryScreen(User user) {
        Label temp = new Label("HELLO, " + user.getName());
        this.getChildren().add(temp);
    }
}
