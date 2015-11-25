package models;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Food{
    private String ndbno, name, fg;
    private double kCal;//Per 100 grams

    List<Nutrient> nutrients = new ArrayList<>();

    public String getNdbno() {
        return ndbno;
    }

    public void setNdbno(String ndbno) {
        this.ndbno = ndbno;
    }

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
