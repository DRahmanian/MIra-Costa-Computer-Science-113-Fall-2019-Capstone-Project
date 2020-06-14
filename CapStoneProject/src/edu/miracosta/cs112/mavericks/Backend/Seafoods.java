package edu.miracosta.cs112.mavericks.Backend;

import java.util.Objects;

public class Seafoods extends Dish {
    protected String mTypeOfFish;

    public Seafoods(String name, String description, double fats, double calories, double carbs, String typeOfFish) {
        mName = name;
        mDescription = description;
        mFats = fats;
        mCalories = calories;
        mCarbs = carbs;
        mTypeOfFish = typeOfFish;
    }

    public String getTypeOfFish() {
        return mTypeOfFish;
    }

    public void setTypeOfFish(String typeOfFish) {
        mTypeOfFish = typeOfFish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seafoods)) return false;
        if (!super.equals(o)) return false;
        Seafoods seafoods = (Seafoods) o;
        return getTypeOfFish().equals(seafoods.getTypeOfFish());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTypeOfFish());
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Meats) {
            Seafoods other = (Seafoods) o;
            int nameDiff = mName.compareTo(other.mName);
            if(nameDiff != 0)
                return nameDiff;
            int descriptionDiff = mDescription.compareTo(other.mDescription);
            if(descriptionDiff != 0)
                return descriptionDiff;
            if(mFats == other.mFats)
                return 1;
            if(mCalories == other.mCalories)
                return 1;
            if(mCarbs == other.mCarbs)
                return 1;
            int fishTypeDiff = mTypeOfFish.compareTo(other.mTypeOfFish);
            if(mTypeOfFish == other.mTypeOfFish)
                return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Seafoods{" +
                "TypeOfFish='" + mTypeOfFish + '\'' +
                ", Name='" + mName + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Fats=" + mFats +
                ", Calories=" + mCalories +
                ", Carbs=" + mCarbs +
                '}';
    }
}
