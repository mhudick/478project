package CalorieCounter.Java.Model;

import CalorieCounter.Java.Controllers.DataHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Food implements DataHandler{
    private String id,name,fg;
    private List<Nutrient> nutrients = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        sb.append("\nID: "+getId()+"\nName: "+getName()+"\nFood Group: "+getFg()+"\nNutrient List:\n");
        Iterator<Nutrient> iterator = nutrients.iterator();
        while (iterator.hasNext()){
            sb.append("\n"+iterator.next().toString()+"\n");
        }
        return sb.toString();
    }

    @Override
    public String saveSql() {
        String sql = "INSERT INTO food(name, food_group) "+
                    "VALUES('"+getName()+"', '"+getFg()+"');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String deleteSql() {
        return null;
    }

    @Override
    public String searchSql() {
        return null;
    }
}
