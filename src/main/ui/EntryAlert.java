package main.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EntryAlert {

    public static void display(String title, String message, String lbl) {
        Stage win = new Stage();

        win.initModality(Modality.APPLICATION_MODAL);
        win.setTitle(title);
        win.setMinWidth(250);

        Label msg = new Label(message);

        TextField entry = new TextField();
        entry.setPromptText(lbl);

        VBox pane = new VBox();
        pane.getChildren().addAll(msg, entry);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        win.setScene(scene);
        win.showAndWait();
    }
}
