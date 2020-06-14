package edu.miracosta.cs112.mavericks.Backend;

import java.util.Objects;

public class Desserts extends Dish {

    private boolean mIsSugarFree;
    private boolean mIsNutFree;
    private boolean mIsGlutenFree;

    public Desserts(String name, String description, double fat, double calories, double carbs,  boolean isSugarFree, boolean isNutFree, boolean isGlutenFree){

        mName = name;
        mDescription = description;
        mFats = fat;
        mCalories = calories;
        mCarbs = carbs;
        mIsSugarFree = isSugarFree;
        mIsNutFree = isNutFree;
        mIsGlutenFree = isGlutenFree;

    }

    public boolean isSugarFree() {
        return mIsSugarFree;
    }

    public void setSugarFree(boolean sugarFree) {
        mIsSugarFree = sugarFree;
    }

    public boolean isNutFree() {
        return mIsNutFree;
    }

    public void setNutFree(boolean nutFree) {
        mIsNutFree = nutFree;
    }

    public boolean isGlutenFree() {
        return mIsGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        mIsGlutenFree = glutenFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desserts desserts = (Desserts) o;
        return mIsSugarFree == desserts.mIsSugarFree &&
                mIsNutFree == desserts.mIsNutFree &&
                mIsGlutenFree == desserts.mIsGlutenFree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIsSugarFree, mIsNutFree, mIsGlutenFree);
    }

    @Override
    public String toString() {
        return "Desserts{" +
                "IsSugarFree=" + mIsSugarFree +
                ", IsNutFree=" + mIsNutFree +
                ", IsGlutenFree=" + mIsGlutenFree +
                ", Name='" + mName + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Fats=" + mFats +
                ", Calories=" + mCalories +
                ", Carbs=" + mCarbs +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        if(o instanceof Desserts){

            Desserts other = (Desserts)o;

            int sugarDiff = mIsSugarFree == other.mIsSugarFree ? 0 : 1;

            if(sugarDiff != 0)
                return sugarDiff;

            int nutDiff = mIsNutFree == other.mIsNutFree ? 0 : 1;

            if(nutDiff != 0)
                return nutDiff;

            int glutenDiff = mIsGlutenFree == other.mIsGlutenFree ? 0 : 1;

            if(glutenDiff != 0)
                return glutenDiff;

        }

        return -1;

    }

}
