package edu.miracosta.cs112.mavericks.View;

import edu.miracosta.cs112.mavericks.Backend.Dish;
import edu.miracosta.cs112.mavericks.Controller.Controller;
import edu.miracosta.cs112.mavericks.Controller.ViewNavigator;
import edu.miracosta.cs112.mavericks.MeatScene;
import edu.miracosta.cs112.mavericks.View.DrinksScene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import javax.swing.text.DefaultEditorKit;

public class MainScene extends Scene {

    //region Constants
    private final String OPTION_SEAFOOD = "Seafood";
    private final String OPTION_MEAT = "Meat";
    private final String OPTION_DESSERT = "Desserts";
    private final String OPTION_SALADS = "Salads";
    private final String OPTION_DRINKS = "Drinks";
    private final String OPTION_PASTA = "Pasta";
    //endregion

    private Button removeButton;

    private ComboBox<String> dishCombo;

    private Label dishLabel;

    private ListView dishView;

    private Dish selectedDish;

    public MainScene(){

        super(new GridPane(), 600, 600);

        removeButton = new Button("Remove");



        //region Initializing Dish Combo Box
        dishCombo = new ComboBox<>();
        ObservableList<String> options = FXCollections.observableArrayList();
        options.add(OPTION_SEAFOOD);
        options.add(OPTION_MEAT);
        options.add(OPTION_DESSERT);
        options.add(OPTION_SALADS);
        options.add(OPTION_DRINKS);
        options.add(OPTION_PASTA);
        dishCombo.setItems(options);
        dishCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> changeScene(newValue));
        //endregion




        //region Initializing Dish Label
        dishLabel = new Label("Dish");
        dishLabel.setFont(new Font(16));
        //endregion

        //region Initializing Dish List View
        dishView = new ListView();
        dishView.setPrefWidth(400);
        dishView.setItems(Controller.getInstance().getAllDishList());

        dishView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selectedDish = (Dish) newValue;
                removeButton.setDisable(selectedDish == null);
            }
        });

        // Remove button listener
        removeButton.setDisable(true);
        removeButton.setOnAction(event -> removeDish());


        //endregion

        //region Adding stuff
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(10));

        gridPane.add(dishLabel, 0, 0);
        gridPane.add(dishCombo, 1, 0);
        gridPane.add(removeButton, 2, 2);
        gridPane.add(dishView, 2, 1);
        //endregion

        setRoot(gridPane);

    }


    private void changeScene(String chosenValue){

        switch(chosenValue){

            case OPTION_SEAFOOD:
                ViewNavigator.loadScene("Add Seafood", new SeafoodScene(this));
                break;

            case OPTION_MEAT:
                ViewNavigator.loadScene("Add Meat", new MeatScene(this));
                break;

            case OPTION_DESSERT:
                ViewNavigator.loadScene("Add Dessert", new DessertScene(this));
                break;

            case OPTION_SALADS:
                ViewNavigator.loadScene("Add Salads", new SaladsScene(this));
                break;

            case OPTION_DRINKS:
                ViewNavigator.loadScene("Add Drinks", new DrinksScene(this));
                break;

            case OPTION_PASTA:
                ViewNavigator.loadScene("Add Pasta", new PastaScene(this));
                break;

            default:
                break;

        }


    }

    public void removeDish() {
        if(selectedDish == null) {
            return;
        }
        Controller.getInstance().getAllDishList().remove(selectedDish);
        updateLV();
    }
    public void updateLV() {
        dishView.refresh();
    }



}
