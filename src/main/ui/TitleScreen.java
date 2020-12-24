package main.ui;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.resources.UserResources;
import main.structures.User;

public class TitleScreen extends StackPane {

    /**
     * Creates the title screen
     */
    public TitleScreen() {
        VBox pane = new VBox(50);
        pane.setAlignment(Pos.TOP_CENTER);

        Label blank = new Label("");

        Label title = new Label("Title");

        //Pane to hold usernames and password entry
        VBox userSelection = new VBox(10);
        userSelection.setAlignment(Pos.CENTER);

        ObservableList<User> users = UserResources.getUsers();
        ReadOnlyListWrapper<String> usernames = new ReadOnlyListWrapper<>();
        usernames.set(FXCollections.observableArrayList());
        usernames.add("<new profile>");
        for (User u : users) {
            usernames.add(u.getName());
        }
        ComboBox<String> combo = new ComboBox(usernames);
        combo.getSelectionModel().selectFirst();

        TextField password = new TextField();
        password.setPromptText("Enter Password");

        userSelection.getChildren().addAll(combo);

        //Back in initial pane
        Button btn = new Button("Create Profile");

        pane.getChildren().addAll(blank, title, userSelection, btn);

        //Combo
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {

                //Create a new user
                if (newValue.equals("<new profile>")) {
                    if (userSelection.getChildren().contains(password)) {
                        userSelection.getChildren().remove(password);
                        btn.textProperty().set("Create Profile");
                        btn.setOnAction(e -> {
                            getScene().setRoot(new SignupScreen()); //switch to sign up screen
                        });
                    } else {
                        displayError(); //something went wrong
                    }
                } else { //Login as an existing user
                    if (!userSelection.getChildren().contains(password)) {
                        userSelection.getChildren().add(password);
                        btn.textProperty().set("Login");
                        btn.setOnAction(e -> {
                            Alert waterAlert = new Alert(Alert.AlertType.WARNING);
                            waterAlert.setContentText("log in");
                            waterAlert.showAndWait();
                        });
                    } else {
                        displayError(); //something went wrong
                    }
                }
            }
        });

        this.getChildren().add(pane);
    }

    /**
     * Displays a straightfoward error alert
     */
    private void displayError() {
        Alert error = new Alert(Alert.AlertType.WARNING);
        error.setContentText("Something went wrong");
        error.showAndWait();
    }
}