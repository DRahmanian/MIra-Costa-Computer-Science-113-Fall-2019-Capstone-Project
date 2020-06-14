package edu.miracosta.cs112.mavericks.Backend;

import java.io.Serializable;

public abstract class Dish implements Serializable, Comparable {

    protected String mName;
    protected String mDescription;

    protected double mFats;
    protected double mCalories;
    protected double mCarbs;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public double getFats() {
        return mFats;
    }

    public void setFats(double fats) {
        mFats = fats;
    }

    public double getCalories() {
        return mCalories;
    }

    public void setCalories(double calories) {
        mCalories = calories;
    }

    public double getCarbs() {
        return mCarbs;
    }

    public void setCarbs(double carbs) {
        mCarbs = carbs;
    }
}
