package edu.miracosta.cs112.mavericks.Backend;

import java.util.Objects;

public class Pasta extends Dish {

    private String mtypeofPasta;
    private String mtypeofSauce;


    public Pasta( String mName, String mDescription, double mFats, double mCalories, String mtypeofPasta, String mtypeofSauce) {
       this.mName= mName;
       this.mDescription= mDescription;
       this.mFats= mFats;
       this.mCalories= mCalories;
        this.mtypeofPasta = mtypeofPasta;
        this.mtypeofSauce = mtypeofSauce;
    }

    public String getMtypeofPasta() {
        return mtypeofPasta;
    }

    public void setMtypeofPasta(String mtypeofPasta) {
        this.mtypeofPasta = mtypeofPasta;
    }

    public String getMtypeofSauce() {
        return mtypeofSauce;
    }

    public void setMtypeofSauce(String mtypeofSauce) {
        this.mtypeofSauce = mtypeofSauce;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasta pasta = (Pasta) o;
        return mtypeofPasta.equals(pasta.mtypeofPasta) &&
                mtypeofSauce.equals(pasta.mtypeofSauce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mtypeofPasta, mtypeofSauce);
    }





    public int compareTo(Object o){

    if( o instanceof Pasta){

        Pasta other =(Pasta)o;
        int pastaSauceDiff=  mtypeofSauce.compareTo(other.mtypeofSauce);

        if(pastaSauceDiff != 0){

            return pastaSauceDiff;
        }
    int pastaDifferent = mtypeofPasta.compareTo(other.mtypeofPasta);

        if(pastaDifferent !=0 ){
            return pastaDifferent;
        }




    }else{

    }

        return -1;

}

    @Override
    public String toString() {
        return "Pasta{" +
                "Type of Pasta='" + mtypeofPasta + '\'' +
                ", Type of Sauce='" + mtypeofSauce + '\'' +
                ", Name='" + mName + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Fats=" + mFats +
                ", Calories=" + mCalories +
                ", Carbs=" + mCarbs +
                '}';
    }
}
