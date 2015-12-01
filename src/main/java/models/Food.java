package models;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This Class is the data model for the Food object. It keeps track
 * of the ndbno(Nutritional Database key), the name, the food group,
 * and the kCalories which is measured in 100 grams.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Food{

    /**
     * Food objects contain multiple fields of data
     * (Requirement 3.1.0)
     */
    private String ndbno, name, fg;
    private double kCal;//Per 100 grams

    List<Nutrient> nutrients = new ArrayList<>();

    public String getNdbno() {
        return ndbno;
    }

    public void setNdbno(String ndbno) {
        this.ndbno = ndbno;
    }

    /**
     * Food objects have a name
     * (Requirement 3.1.1)
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFg() {
        return fg;
    }

    public void setFg(String fg) {
        this.fg = fg;
    }

    public double getkCal() {
        return kCal;
    }

    /**
     * Food objects have calories/mass value
     * (Requirement 3.1.2)
     */
    public void setkCal(double kCal){
        this.kCal = kCal;
    }

    public void setkCalFromList() {
        Iterator<Nutrient> iterator = nutrients.iterator();
        while (iterator.hasNext()){
            Nutrient nutrient = iterator.next();
            if (nutrient.getUnit().equalsIgnoreCase("kcal")){
                this.kCal = nutrient.getValue();
            }
        }
    }

    public List<Nutrient> getNutrientList() {
        return nutrients;
    }

    public void setNutrientList(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public String toString(){
        String str = "Ndbno: "+getNdbno()+"\n"+"Name: "+getName()+"\n"+"Group: "+getFg()+"\n"+"kCal: "+getkCal()+"/100g\n";
        return str;
    }
}
