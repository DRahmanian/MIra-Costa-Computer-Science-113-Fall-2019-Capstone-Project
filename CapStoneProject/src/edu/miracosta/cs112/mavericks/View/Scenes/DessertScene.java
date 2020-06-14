package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Backend.Desserts;
import edu.miracosta.cs112.mavericks.Controller.Controller;
import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import org.w3c.dom.Text;


public class DessertScene extends Scene {

    private Scene mPrevScene;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label fatsLabel;
    private Label caloriesLabel;
    private Label carbsLabel;
    private Label sugarLabel;
    private Label nutLabel;
    private Label glutenLabel;

    private TextField nameTF;
    private TextField descriptionTF;
    private TextField fatsTF;
    private TextField caloriesTF;
    private TextField carbsTF;

    private TextField sugarTF;
    private TextField nutTF;
    private TextField glutenTF;

    public DessertScene(Scene prevScene) {
        super(new GridPane(), 250, 400);
        mPrevScene = prevScene;
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(20);

        nameLabel = new Label("Name:");
       descriptionLabel = new Label("Description:");
        fatsLabel = new Label("Fats:");
        caloriesLabel = new Label("Calories:");
        carbsLabel = new Label("Carbs");
        sugarLabel = new Label("Is sugar free:");
        nutLabel = new Label("Is nut free:");
       glutenLabel = new Label("Is gluten free:");

        nameTF = new TextField();
        descriptionTF = new TextField();
        fatsTF = new TextField();
        caloriesTF = new TextField();
        carbsTF = new TextField();
        sugarTF = new TextField();
       nutTF = new TextField();
         glutenTF = new TextField();

        Button addButton = new Button("Add");

        pane.add(nameLabel,0,0);
        pane.add(descriptionLabel,0,1);
        pane.add(fatsLabel,0,2);
        pane.add(caloriesLabel,0,3);
        pane.add(carbsLabel,0,4);
        pane.add(sugarLabel, 0, 5);
        pane.add(nutLabel, 0, 6);
        pane.add(glutenLabel, 0, 7);

        pane.add(nameTF,1,0);
        pane.add(descriptionTF,1,1);
        pane.add(fatsTF,1,2);
        pane.add(caloriesTF,1,3);
        pane.add(carbsTF,1,4);
        pane.add(sugarTF, 1, 5);
        pane.add(nutTF, 1, 6);
        pane.add(glutenTF, 1, 7);

        pane.add(addButton,0,8);

        Button cancelButton = new Button("Cancel");
        pane.add(cancelButton, 1, 8);
        cancelButton.setOnAction(event -> ViewNavigator.loadScene("Recipe Book", mPrevScene));

        addButton.setOnAction(event -> addDish());


        setRoot(pane);


    }

    public void addDish() {
        double fats;
        double calories;
        double carbs;
        String name = nameTF.getText();
        String description = descriptionTF.getText();
        boolean sugarBool = sugarTF.getText().equalsIgnoreCase("true") ? true : false;
        boolean nutBool = nutTF.getText().equalsIgnoreCase("true") ? true : false;
        boolean glutenBool = glutenTF.getText().equalsIgnoreCase("true") ? true : false;

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

        Desserts desserts = new Desserts(name, description, fats, calories, carbs, sugarBool, nutBool, glutenBool);
        if(desserts != null) {
            Controller controller = Controller.getInstance();
            controller.getAllDishList().add(desserts);
        } else {
            return;

        }

        ViewNavigator.loadScene("Recipe Book", mPrevScene);


    }
}
