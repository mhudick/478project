package CalorieCounter.Java.Model;

import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Measures {
    private String label,eqv,qty,value;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEqv() {
        return eqv;
    }

    public void setEqv(String eqv) {
        this.eqv = eqv;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString(){
        return "ID: "+getId()+"\nLabel: "+getLabel()+"\neqv: "+getEqv()+"\nqty: "+getQty()+"\nValue: "+getValue();
    }
}
