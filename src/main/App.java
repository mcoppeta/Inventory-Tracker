package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private int width = 1300;
    private int height = 675;

    @Override
    public void start(Stage primaryStage) {


        Scene scene = new Scene(root, width, height);

        primaryStage.setTitle("Inventory Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
