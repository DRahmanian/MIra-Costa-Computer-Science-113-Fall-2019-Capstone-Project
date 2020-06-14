package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Backend.Drinks;
import edu.miracosta.cs112.mavericks.Controller.Controller;
import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class DrinksScene extends Scene {
    private Drinks currentDrink;
    private Scene mPrevScene;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label fatsLabel;
    private Label caloriesLabel;
    private Label carbsLabel;
    private Label carbonationLabel;

    private Label carbonatedLabel;

    private TextField nameTF;
    private TextField descriptionTF;
    private TextField fatsTF;
    private TextField caloriesTF;
    private TextField carbsTF;
    private TextField carboTF;
    public DrinksScene(Scene prevScene) {
        super(new GridPane(), 250, 350);
        mPrevScene = prevScene;
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(20);

         nameLabel = new Label("Name:");
         descriptionLabel = new Label("Description:");
        fatsLabel = new Label("Fats:");
        caloriesLabel = new Label("Calories:");
         carbsLabel = new Label("Carbs");
         carbonatedLabel= new Label("Carbonated");

         nameTF = new TextField();
        descriptionTF = new TextField();
        fatsTF = new TextField();
        caloriesTF = new TextField();
         carbsTF = new TextField();
         carboTF= new TextField();
        Button addButton = new Button("Add");

        pane.add(nameLabel,0,0);
        pane.add(descriptionLabel,0,1);
        pane.add(fatsLabel,0,2);
        pane.add(caloriesLabel,0,3);
        pane.add(carbsLabel,0,4);
        pane.add(carbonatedLabel,0,5);

        pane.add(nameTF,1,0);
        pane.add(descriptionTF,1,1);
        pane.add(fatsTF,1,2);
        pane.add(caloriesTF,1,3);
        pane.add(carbsTF,1,4);
        pane.add(carboTF,1,5);
        pane.add(addButton,0,6);

        addButton.setOnAction(event -> addDish());

        Button cancelButton = new Button("Cancel");
        pane.add(cancelButton, 1, 6);
        cancelButton.setOnAction(event -> ViewNavigator.loadScene("Recipe Book", mPrevScene));
        setRoot(pane);


    }

    public void addDish() {
        double fats;
        double calories;
        double carbs;
        boolean carbo;
        String name = nameTF.getText();
        String description = descriptionTF.getText();

        if(!fatsTF.getText().equals(""))
            fats = Double.parseDouble(fatsTF.getText());
        else
            fats = 0.0;

        if(!caloriesTF.getText().equals(""))
            calories = Double.parseDouble(caloriesTF.getText());
        else
            calories = 0.0;

        if(!carbsTF.getText().equals("True"))
            carbs = Double.parseDouble(carbsTF.getText());
        else
            carbs = 0.0;

        carbo= carboTF.getText().equalsIgnoreCase("True")? true : false;


        currentDrink= new Drinks(name,description,fats,calories,carbo);
        if(currentDrink!=null){


            Controller controller = Controller.getInstance();
            controller.getAllDishList().add(currentDrink);
        }else{

            return;
        }
        ViewNavigator.loadScene("Recipe Book", mPrevScene);

    }
}