package CalorieCounter.Java.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Nutrient {
    private String name,group,unit,value;
    private int id,foodId;

//private List<Measures> measures = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

/*
    public List<Measures> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measures> measures) {
        this.measures = measures;
    }
*/
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNutrient ID: "+getId()+"\nName: "+getName()+
            "\nGroup: "+getGroup()+"\nUnit: "+getUnit()+"\nValue: "+getValue()+"\n");
        /*
        Iterator<Measures> iterator = measures.iterator();
        while(iterator.hasNext()){
            sb.append("\n"+iterator.next().toString()+"\n");
        }*/
        return sb.toString();
    }
}
