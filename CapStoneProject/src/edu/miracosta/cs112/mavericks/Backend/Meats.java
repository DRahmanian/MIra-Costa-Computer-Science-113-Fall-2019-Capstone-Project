package edu.miracosta.cs112.mavericks.Backend;

import edu.miracosta.cs112.mavericks.Backend.Dish;

import java.util.Objects;

public class Meats extends Dish {
    private String mMeatType;

    public Meats(String name, String description, double fats, double calories, double carbs, String meatType) {
        mName = name;
        mDescription = description;
        mFats = fats;
        mCalories = calories;
        mCarbs = carbs;
        mMeatType = meatType;

    }

    public String isGrassFed() {
        return mMeatType;
    }

    public void setGrassFed(String grassFed) {
        mMeatType = grassFed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meats)) return false;
        if (!super.equals(o)) return false;
        Meats meats = (Meats) o;
        return isGrassFed() == meats.isGrassFed();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isGrassFed());
    }

    @Override
    public String toString() {
        return "Meats{" +
                "GrassFed=" + mMeatType +
                ", Name='" + mName + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Fats=" + mFats +
                ", Calories=" + mCalories +
                ", Carbs=" + mCarbs +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Meats) {
            Meats other = (Meats)o;
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
            if(mMeatType == other.mMeatType)
                return 1;
        }
        return 0;
    }
}