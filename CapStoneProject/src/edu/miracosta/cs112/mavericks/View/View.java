package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Controller.Controller;
import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

       ViewNavigator.setStage(primaryStage);
       ViewNavigator.loadScene("Recipe Book", new MainScene());

    }

    @Override
    public void stop(){
        Controller.getInstance().saveData();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
