package models;

/**
 * Created by Philip on 9/30/2015.
 */
public class Nutrient {
    private String name, unit;
    private double value;

    public Nutrient(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
