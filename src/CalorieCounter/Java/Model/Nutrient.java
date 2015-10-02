package CalorieCounter.Java.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Nutrient {
    private String nutrient_id,name,group,unit,value,dp,se;
    private List<Measures> measures = new ArrayList<>();

    public String getNutrient_id() {
        return nutrient_id;
    }

    public void setNutrient_id(String nutrient_id) {
        this.nutrient_id = nutrient_id;
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

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }

    public List<Measures> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measures> measures) {
        this.measures = measures;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNutrient ID: "+getNutrient_id()+"\nName: "+getName()+
            "\nGroup: "+getGroup()+"\nUnit: "+getUnit()+"\nValue: "+getValue()+
            "\nDp: "+getDp()+"\nse: "+getSe()+"\nMeasures:\n");
        Iterator<Measures> iterator = measures.iterator();
        while(iterator.hasNext()){
            sb.append("\n"+iterator.next().toString()+"\n");
        }
        return sb.toString();
    }
}
