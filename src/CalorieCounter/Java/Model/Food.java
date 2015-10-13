package CalorieCounter.Java.Model;

import CalorieCounter.Java.Controllers.DataManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 9/30/2015.
 */
public class Food{
    private String ndbno, name,fg;
    private List<Nutrient> nutrients = new ArrayList<>();

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

    public void saveFood(){

        //String created from attributes of the object
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, food_group) values(\"" +
                getNbdno()+"\",\""+getName()+"\",\""+getFg()+"\");";

        DataManager.updateData(sql);//Static method to execute update.

        //This iterates through nutrient list
        Iterator<Nutrient> iterator = getNutrients().iterator();
        while(iterator.hasNext()){
            iterator.next().saveNutrient(getNbdno());
        }
    }

    //STILL WORKING ON THIS ONE!!!
    public void loadFood(){
        String sql = "SELECT * FROM food WHERE ndbno = "+getNbdno()+";";
        String nutrientSql = "SELECT * FROM nutrient WHERE food_id = "+getNbdno()+";";
        List<Nutrient> nutrientList = new ArrayList<>();
        ResultSet resultSet = DataManager.retrieveData(sql);
        try {
            setNdbno(resultSet.getString("ndbno"));//These methods set the attributes of the Food object
            setName(resultSet.getString("name"));
            setFg(resultSet.getString("food_group"));
            resultSet = DataManager.retrieveData(nutrientSql);
            while (!resultSet.isAfterLast()){
                //The Nutrient class has a constructor that you can pass the records straight to the object when it is instantiated and adds it to list.
                nutrientList.add(new Nutrient(resultSet.getInt("id"), resultSet.getInt("food_id"),resultSet.getString("name"),resultSet.getString("food_group"),resultSet.getString("unit"),resultSet.getString("value")));
                resultSet.next();//Iterates to next row.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setNutrients(nutrientList);
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
