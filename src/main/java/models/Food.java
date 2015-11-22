package models;

import util.database.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Food{
    private String ndbno, name, fg, kCalMeasure, measure;
    private List<Nutrient> nutrients = new ArrayList<>();

    public Food(String ndbno, String name, String fg){
        this.ndbno = ndbno;
        this.name = name;
        this.fg = fg;
    }

    //TODO implement getKCalMeasure method (used in FoodCard controller)
    public String getKCalMeasure(){
        return kCalMeasure;
    }

    //TODO implement getMeasure method (used in FoodCard controller)
    public String getMeasure(){
        return measure;
    }

    //TODO implement setMeasure method
    public void setMeasure(String measure){
        this.measure = measure;
    }

    //TODO implement setKCalMeasure method
    public void setkCalMeasure(String kCalMeasure){
        this.kCalMeasure = kCalMeasure;
    }

    public String getNbdno() {
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

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("\nNdbno: "+getNbdno()+"\nName: "+getName()+"\nFood Group: "+getFg()+"\nNutrient List:\n");

        Iterator<Nutrient> iterator = nutrients.iterator();
        while (iterator.hasNext()){
            sb.append("\n"+iterator.next().toString()+"\n");
        }

        return sb.toString();
    }
}
