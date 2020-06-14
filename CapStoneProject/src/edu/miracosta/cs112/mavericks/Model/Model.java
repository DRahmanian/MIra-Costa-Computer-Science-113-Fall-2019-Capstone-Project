package edu.miracosta.cs112.mavericks.Model;

import edu.miracosta.cs112.mavericks.Backend.Dish;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class Model {

    private static final String BINARY_FILE = "Dish.dat";

    public static Boolean binaryHasData() {
        File binaryfile = new File(BINARY_FILE);
        return (binaryfile.exists() && binaryfile.length() > 0);

    }

    public static ObservableList<Dish> importDishFromBinary() {
        ObservableList<Dish> allDish = FXCollections.observableArrayList();

        File binaryfile = new File(BINARY_FILE);

        if (binaryfile.exists()) {

            try {
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(binaryfile));
                Dish[] temparray = (Dish[]) readFile.readObject();
                allDish.addAll(temparray);
                readFile.close();


            } catch (Exception e) {

                System.err.println("you mae big doo doo this time !");
            }


        }


        return allDish;

    }

    public static boolean writeDishToFile(ObservableList<Dish> allDish) {
        File binaryfile = new File(BINARY_FILE);
        try {
            ObjectOutputStream writeFile = new ObjectOutputStream( new FileOutputStream(BINARY_FILE));
            Dish[] tempDish = new Dish[allDish.size()];

            for (int i = 0; i < tempDish.length; i++) {

                tempDish[i] = allDish.get(i);

            }

            writeFile.writeObject(tempDish);
            writeFile.close();

        } catch (Exception e){

            System.err.println("FILE DNE");
        }

        return false;




    }


}
