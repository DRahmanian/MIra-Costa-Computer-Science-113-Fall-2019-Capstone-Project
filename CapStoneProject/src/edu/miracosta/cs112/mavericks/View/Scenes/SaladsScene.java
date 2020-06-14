package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Backend.Salads;
import edu.miracosta.cs112.mavericks.Controller.Controller;
import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import org.w3c.dom.Text;


public class SaladsScene extends Scene {

    private Scene mPrevScene;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label fatsLabel;
    private Label caloriesLabel;
    private Label carbsLabel;
private Label orgLabel;

    private TextField nameTF;
    private TextField descriptionTF;
    private TextField fatsTF;
    private TextField caloriesTF;
    private TextField carbsTF;

    private TextField orgTF;

    public SaladsScene(Scene prevScene) {
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
        orgLabel = new Label("Is Organic:");

         nameTF = new TextField();
         descriptionTF = new TextField();
         fatsTF = new TextField();
         caloriesTF = new TextField();
         carbsTF = new TextField();
        orgTF = new TextField();


        Button addButton = new Button("Add");

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

        pane.add(orgLabel, 0, 5);
        pane.add(orgTF, 1, 5);

        pane.add(addButton,0,6);

        addButton.setOnAction(event -> addDish());

        Button cancelButton = new Button("Cancel");
        pane.add(cancelButton, 1, 6);
        cancelButton.setOnAction(event -> ViewNavigator.loadScene("Recipe Book", mPrevScene));

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
        boolean orgBool = orgTF.getText().equalsIgnoreCase("true") ? true : false;

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

        Salads currentSalad = new Salads(name, description, fats, calories, carbs, orgBool);


        if(currentSalad != null) {
            Controller controller = Controller.getInstance();
            controller.getAllDishList().add(currentSalad);
        } else {
            return;

        }
        ViewNavigator.loadScene("Recipe Book", mPrevScene);
    }
}
