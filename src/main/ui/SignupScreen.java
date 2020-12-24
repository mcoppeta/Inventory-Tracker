package main.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * Creates a screen to set up a new profile
 */
public class SignupScreen extends StackPane {

    /**
     * Creates the sign up screen
     */
    public SignupScreen() {
        Label temp = new Label("HELLO");
        this.getChildren().add(temp);
    }
}
