package models;

/**
 * Created by Philip on 9/30/2015.
 */
public class Nutrient {
    private String ndbno, name,group,unit,value;
    private int id;

    public Nutrient(int id, String foodId, String name, String group, String unit , String value){
        this.id = id;
        this.ndbno = foodId;
        this.name = name;
        this.group = group;
        this.unit = unit;
        this.value = value;//Equivalent of 100 grams.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNdbno() {
        return ndbno;
    }

    public void setFoodId(String ndbno) {
        this.ndbno = ndbno;
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nutrient ID: "+getId()+"\nName: "+getName()+
            "\nGroup: "+getGroup()+"\nUnit: "+getUnit()+"\nValue: "+getValue());

        return sb.toString();
    }
}
