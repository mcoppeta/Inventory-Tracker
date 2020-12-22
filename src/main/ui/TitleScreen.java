package main.ui;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

        VBox userSelection = new VBox(30);
        userSelection.setAlignment(Pos.CENTER);

        ObservableList<User> users = UserResources.getUsers();
        ReadOnlyListWrapper<String> usernames = new ReadOnlyListWrapper<>();
        usernames.set(FXCollections.observableArrayList());
        for (User u : users) {
            usernames.add(u.getName());
        }
        ComboBox combo = new ComboBox(usernames);
        combo.getSelectionModel().selectFirst();

        userSelection.getChildren().addAll(combo);

        Button temp = new Button("Next");

        pane.getChildren().addAll(blank, title, userSelection, temp);

        this.getChildren().add(pane);
    }
}