package main.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Creates a screen to set up a new profile
 */
public class SignupScreen extends StackPane {

    /**
     * Creates the sign up screen
     */
    public SignupScreen() {
        VBox mainPane = new VBox();


        HBox buttonPane = new HBox();

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            getScene().setRoot(new TitleScreen());
        });

        Button createButton = new Button("Create Profile");

        buttonPane.getChildren().addAll(backButton, createButton);
        mainPane.getChildren().add(buttonPane);
        this.getChildren().add(mainPane);
}
}
