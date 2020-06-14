package edu.miracosta.cs112.mavericks.Controller;

import edu.miracosta.cs112.mavericks.Backend.Dish;
import edu.miracosta.cs112.mavericks.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private static Controller theInstance;
    private ObservableList<Dish> AllDishList;
    private ObservableList<Dish> FilteredDishList;

    private Controller() {}


    public static Controller getInstance(){

        if(theInstance == null){

            theInstance= new Controller();

            if(Model.binaryHasData()){
                theInstance.AllDishList = Model.importDishFromBinary();
            }else{
                theInstance.AllDishList= Model.importDishFromBinary();
                theInstance.FilteredDishList= FXCollections.observableArrayList();

            }
        }

        return theInstance;
    }

    public ObservableList<Dish> getAllDishList() {
        return AllDishList;
    }

    public ObservableList<Dish> filter(String name, String description, double maxfats,double minfats ,double maxcarbs, double mincarbs){
        FilteredDishList.clear();

        boolean meetCriteria;

        for( Dish d: AllDishList){
            meetCriteria= true;
            if(name != null && !name.equalsIgnoreCase(" ") && !name.equalsIgnoreCase(d.getName())  )
                meetCriteria=false;

            if(description != null && !description.equalsIgnoreCase(" ") && !description.equalsIgnoreCase(d.getName())  )
                meetCriteria=false;
            if(d.getCarbs()<mincarbs  || d.getFats() > maxfats)
                meetCriteria=false;


        }


        return FilteredDishList;

    }

    public void saveData(){

        Model.writeDishToFile(AllDishList);

    }

}
