package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.ui.TitleScreen;

public class App extends Application {
    private int width = 800;
    private int height = 400;

    @Override
    public void start(Stage primaryStage) {
        TitleScreen root = new TitleScreen();

        Scene scene = new Scene(root, width, height);

        primaryStage.setTitle("Inventory Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}