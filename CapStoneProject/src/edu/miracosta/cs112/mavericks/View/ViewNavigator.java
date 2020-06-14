package edu.miracosta.cs112.mavericks.Controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator {

    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void loadScene(String title, Scene scene) {
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }

}
