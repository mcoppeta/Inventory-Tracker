package main.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        // Main pane to hold everything
        VBox mainPane = new VBox(50);
        mainPane.setAlignment(Pos.TOP_CENTER);

        Label temp = new Label("");

        Label title = new Label("Create New Profile");

        // Horizontal pane to enter username
        HBox usernamePane = new HBox(15);
        usernamePane.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Enter Username:");
        TextField usernameField = new TextField();
        usernamePane.getChildren().addAll(usernameLabel, usernameField);

        // Horizontal pane to enter password
        HBox passwordPane = new HBox(15);
        passwordPane.setAlignment(Pos.CENTER);

        Label passwordLabel = new Label("Enter Password:");
        TextField passwordField = new TextField();
        passwordPane.getChildren().addAll(passwordLabel, passwordField);

        // Horizontal pane for button controls
        HBox buttonPane = new HBox(15);
        buttonPane.setAlignment(Pos.CENTER);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            getScene().setRoot(new TitleScreen());
        });

        Button createButton = new Button("Create Profile");
        buttonPane.getChildren().addAll(backButton, createButton);

        mainPane.getChildren().addAll(temp, title, usernamePane, passwordPane, buttonPane);
        this.getChildren().add(mainPane);
}
}
