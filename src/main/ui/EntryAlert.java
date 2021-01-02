package main.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EntryAlert {
    private String input = "";

    /**
     * Displays the entry alert box
     * @param title Title
     * @param message Message that is displayed
     * @param prompt TextField prompt text
     */
    public void display(String title, String message, String prompt, String btnText) {
        Stage win = new Stage();

        win.initModality(Modality.APPLICATION_MODAL);
        win.setTitle(title);
        win.setMinWidth(250);

        Label msg = new Label(message);

        TextField entry = new TextField();
        entry.setPromptText(prompt);

        Button exitBtn = new Button(btnText);
        exitBtn.setOnAction(e -> {
            this.input = entry.getText().trim();
            win.close();
        });

        VBox pane = new VBox();
        pane.getChildren().addAll(msg, entry, exitBtn);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        win.setScene(scene);
        win.showAndWait();
    }

    public String getInput() {
        return input;
    }
}
