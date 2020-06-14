package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import org.w3c.dom.Text;


public class UniversalScene extends Scene {

    private Button cancelButton;

    private Scene mPrevScene;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label fatsLabel;
    private Label caloriesLabel;
    private Label carbsLabel;


    private TextField nameTF;
    private TextField descriptionTF;
    private TextField fatsTF;
    private TextField caloriesTF;
    private TextField carbsTF;

    public UniversalScene(Scene prevScene) {
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

        TextField nameTF = new TextField();
        TextField descriptionTF = new TextField();
        TextField fatsTF = new TextField();
        TextField caloriesTF = new TextField();
        TextField carbsTF = new TextField();

        Button addButton = new Button("Add");
        cancelButton = new Button("Cancel");

        pane.add(nameLabel,0,0);
        pane.add(descriptionLabel,0,1);
        pane.add(fatsLabel,0,2);
        pane.add(caloriesLabel,0,3);
        pane.add(carbsLabel,0,4);

        pane.add(nameTF,1,0);
        pane.add(descriptionTF,1,1);
        pane.add(fatsTF,1,2);
        pane.add(caloriesTF,1,3);
        pane.add(carbsTF,1,4);

        pane.add(addButton,0,5);
        pane.add(cancelButton, 1, 5);
        cancelButton.setOnAction(event -> cancel());

        addButton.setOnAction(event -> addDish());


        setRoot(pane);


    }

    protected void cancel(){
        ViewNavigator.loadScene("Recipe Book", mPrevScene);
    }

    protected void addDish() {
        double fats;
        double calories;
        double carbs;
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

        if(!carbsTF.getText().equals(""))
            carbs = Double.parseDouble(carbsTF.getText());
        else
            carbs = 0.0;


    }
}
