package edu.miracosta.cs112.mavericks.Backend;

import java.util.Objects;

public class Salads extends Dish {

    private boolean mIsOrganic;

    public Salads(String name, String description, double fat, double calories, double carbs, boolean isOrganic){

        mName = name;
        mDescription = description;
        mFats = fat;
        mCalories = calories;
        mCarbs = carbs;
        mIsOrganic = isOrganic;

    }

    public boolean isOrganic() {
        return mIsOrganic;
    }

    public void setOrganic(boolean organic) {
        mIsOrganic = organic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salads salads = (Salads) o;
        return mIsOrganic == salads.mIsOrganic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIsOrganic);
    }

    @Override
    public String toString() {
        return "Salads{" +
                "IsOrganic=" + mIsOrganic +
                ", Name='" + mName + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Fats=" + mFats +
                ", Calories=" + mCalories +
                ", Carbs=" + mCarbs +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        if (o instanceof Salads) {

            Salads other = (Salads) o;

            return mIsOrganic == other.mIsOrganic ? 0 : 1;

        } else {
            return -1;
        }

    }

}
