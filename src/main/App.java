package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.resources.UserResources;
import main.structures.User;
import main.ui.TitleScreen;

import java.util.ArrayList;

public class App extends Application {
    private int width = 800;
    private int height = 400;

    public static ArrayList<User> users = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        UserResources.init(); //todo remove this after user storage is implemented

        TitleScreen root = new TitleScreen();

        Scene scene = new Scene(root, width, height);

        primaryStage.setTitle("Inventory Tracker");
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}