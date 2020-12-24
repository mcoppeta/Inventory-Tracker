package main.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.resources.UserResources;
import main.structures.User;

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
        createButton.setOnAction(e -> {
            String name = usernameField.getText().trim();
            if (name.equals("")) {
                Alert invalidNameAlert = new Alert(Alert.AlertType.WARNING);
                invalidNameAlert.setContentText("Invalid Name");
                invalidNameAlert.showAndWait();
                usernameField.setText("");
            } else { //name is format-valid
                String password = passwordField.getText().trim();
                if (UserResources.validUsername(name)) { // Username is valid and unused -> check password
                    if (password.equals("")) { //invalid password
                        Alert invalidPasswordAlert = new Alert(Alert.AlertType.WARNING);
                        invalidPasswordAlert.setContentText("Invalid Password");
                        invalidPasswordAlert.showAndWait();
                    } else { //Password is valid
                        User newUser = new User(name, password);
                        UserResources.addUser(newUser);
                    }
                } else {
                    Alert unusableNameAlert = new Alert(Alert.AlertType.WARNING);
                    unusableNameAlert.setContentText("This Username is Already Being Used");
                    unusableNameAlert.showAndWait();
                }
            }
        });

        buttonPane.getChildren().addAll(backButton, createButton);

        mainPane.getChildren().addAll(temp, title, usernamePane, passwordPane, buttonPane);
        this.getChildren().add(mainPane);
}
}
