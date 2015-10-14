package CalorieCounter.Java.Model;

import CalorieCounter.Java.Controllers.DataManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Nutrient {
    private String name,group,unit,value;
    private int id,foodId;

    public Nutrient(int id, int foodId, String name, String group, String unit , String value){
        this.id = id;
        this.foodId = foodId;
        this.name = name;
        this.group = group;
        this.unit = unit;
        this.value = value;
    }
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

    public String getNutrientSql(String foodId){
        String sql = "INSERT OR REPLACE INTO nutrient(food_id,name, food_group, unit, value) values("+foodId+",\""+
                getName()+ "\",\""+getGroup()+"\",\""+getUnit()+"\",\""+getValue()+"\");";
        return sql;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nNutrient ID: "+getId()+"\nName: "+getName()+
            "\nGroup: "+getGroup()+"\nUnit: "+getUnit()+"\nValue: "+getValue()+"\n");

        return sb.toString();
    }
}
