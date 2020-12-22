package main.ui;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        usernames.add("<new user>");
        for (User u : users) {
            usernames.add(u.getName());
        }
        ComboBox<String> combo = new ComboBox(usernames);
        combo.getSelectionModel().selectFirst();

        TextField password = new TextField();
        password.setPromptText("Enter Password");

        userSelection.getChildren().addAll(combo);

        //Back in initial pane
        Button btn = new Button("Create User");

        pane.getChildren().addAll(blank, title, userSelection, btn);

        //Combo
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.equals("<new user>")) {
                    if (userSelection.getChildren().contains(password)) {
                        userSelection.getChildren().remove(password);
                        btn.textProperty().set("Create User");
                    }
                } else {
                    if (!userSelection.getChildren().contains(password)) {
                        userSelection.getChildren().add(password);
                        btn.textProperty().set("Login");
                    }
                }
            }
        });

        this.getChildren().add(pane);
    }
}