package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Backend.Pasta;
import edu.miracosta.cs112.mavericks.Controller.Controller;
import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PastaScene extends Scene {
    private Pasta currentPasta;
    private Scene mPrevScene;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label fatsLabel;
    private Label caloriesLabel;
    private Label carbsLabel;
    private Label typeofPastaLable;
    private Label typeofSauceLable;


    private TextField nameTF;
    private TextField descriptionTF;
    private TextField fatsTF;
    private TextField caloriesTF;
    private TextField carbsTF;
    private TextField pastaTf;
    private TextField sauceTF;



    public PastaScene(Scene prevScene) {
        super(new GridPane(), 250, 350);
        mPrevScene = prevScene;
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(20);

        Label nameLabel = new Label("Name:");
        Label descriptionLabel = new Label("Description:");
        Label fatsLabel = new Label("Fats:");
        Label caloriesLabel = new Label("Calories:");
        Label carbsLabel = new Label("Carbs");
        Label pastaLabel= new Label("Type of Pasta");
        Label  sauceLabel= new Label(" Type of Sauce");


        TextField nameTF = new TextField();
        TextField descriptionTF = new TextField();
        TextField fatsTF = new TextField();
        TextField caloriesTF = new TextField();
        TextField carbsTF = new TextField();
        TextField pastaTF= new TextField();
        TextField sauceTF= new TextField();
        Button addButton = new Button("Add");

        pane.add(nameLabel,0,0);
        pane.add(descriptionLabel,0,1);
        pane.add(fatsLabel,0,2);
        pane.add(caloriesLabel,0,3);
        pane.add(carbsLabel,0,4);
        pane.add(pastaLabel,0,5);
        pane.add(sauceLabel,0,6);

        pane.add(nameTF,1,0);
        pane.add(descriptionTF,1,1);
        pane.add(fatsTF,1,2);
        pane.add(caloriesTF,1,3);
        pane.add(carbsTF,1,4);
        pane.add(pastaTF,1,5);
        pane.add(sauceTF,1,6);
        pane.add(addButton,0,7);

        addButton.setOnAction(event -> addDish());

        Button cancelButton = new Button("Cancel");
        pane.add(cancelButton, 1, 8);
        cancelButton.setOnAction(event -> ViewNavigator.loadScene("Recipe Book", mPrevScene));
        setRoot(pane);


    }

    public void addDish() {
        double fats;
        double calories;
        double carbs;
        String name = nameTF.getText();
        String description = descriptionTF.getText();
        String pasta= pastaTf.getText();
        String sauce= sauceTF.getText();
        if(!fatsTF.getText().equals(""))
            fats = Double.parseDouble(fatsTF.getText());
        else
            fats = 0.0;

        if(!caloriesTF.getText().equals(""))
            calories = Double.parseDouble(caloriesTF.getText());
        else
            calories = 0.0;

        if(!carbsTF.getText().equals(""))
            carbs = Double.parseDouble(carbsTF.getText());
        else
            carbs = 0.0;

        currentPasta=  new Pasta(name,description,fats,calories,pasta,sauce);
        if(currentPasta!=null){

            Controller controller= Controller.getInstance();
            controller.getAllDishList().add(currentPasta);
        }

        ViewNavigator.loadScene("Recipe Book", mPrevScene);

    }
}