package main.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProceedAlertScreen {
    private boolean proceed = false;

    public void display(String title, String msg, String proceedButtonText) {
        Stage win = new Stage();

        win.initModality(Modality.APPLICATION_MODAL);
        win.setTitle(title);
        win.setMinWidth(250);

        //content
        Label message = new Label(msg);

        HBox buttons = new HBox();
        Button proceedButton = new Button(proceedButtonText);
        proceedButton.setOnAction(e -> {
            proceed = true;
            win.close();
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            proceed = false;
            win.close();
        });
        buttons.getChildren().addAll(proceedButton, cancelButton);

        VBox pane = new VBox();
        pane.getChildren().addAll(message, buttons);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        win.setScene(scene);
        win.showAndWait();
    }

    public boolean getProceed() {
        return proceed;
    }
}
