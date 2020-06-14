package edu.miracosta.cs112.mavericks.Backend;

import java.io.Serializable;
import java.util.Objects;

public class Drinks extends Dish {


    private boolean  mCarbonated;


    public Drinks(  String mName, String mDescription, double mFats, double mCalories,boolean mCarbonated) {
        this.mName= mName;
        this.mDescription= mDescription;
        this.mFats= mFats;
        this.mCalories= mCalories;

        this.mCarbonated = mCarbonated;

    }




    public boolean ismCarbonated() {
        return mCarbonated;
    }

    public void setmCarbonated(boolean mCarbonated) {
        this.mCarbonated = mCarbonated;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drinks drinks = (Drinks) o;
        return mCarbonated == drinks.mCarbonated ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( mCarbonated);
    }

    @Override
    public String toString() {
        return "Drinks{" +
                ", Carbonated=" + mCarbonated +
                ", Name='" + mName + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Fats=" + mFats +
                ", Calories=" + mCalories +
                ", Carbs=" + mCarbs +
                '}';
    }

    public int compareTo(Object o){

if(o instanceof Drinks  ) {

    Drinks other = (Drinks) o;



    return mCarbonated == other.mCarbonated ? 0 : 1 ;


}else{
    return -1;
}





    }







}
