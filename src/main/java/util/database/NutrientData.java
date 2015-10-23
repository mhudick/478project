package util.database;

import models.Nutrient;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class NutrientData {

    public List<Nutrient> getNutrientList(String ndbno) {
        String sql = "SELECT * FROM nutrient WHERE ndbno = \'"+ndbno+"\';";
        List<Nutrient> nutrientList = new ArrayList<>();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);

        try {
            while(!resultSet.isAfterLast()){
                nutrientList.add(new Nutrient(resultSet.getInt("id"),resultSet.getString("food_id"),
                        resultSet.getString("name"),resultSet.getString("food_group"),resultSet.getString("unit"), resultSet.getString("value")));
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nutrientList;
    }


    public void saveNutrientList(List<Nutrient> list) {
        String sql;
        List<String> sqlList = new ArrayList<>();
        Nutrient currentNutrient;
        Iterator<Nutrient> iterator = list.iterator();
        while(iterator.hasNext()){
            currentNutrient = iterator.next();
            sql = "INSERT OR REPLACE INTO nutrient(food_id, name, food_group, unit, value) " +
                    "VALUES(\'"+currentNutrient.getFoodId()+"\',\'"+currentNutrient.getName()+"\',\'"
                    +currentNutrient.getGroup()+"\',\'"+currentNutrient.getUnit()+"\',"+currentNutrient.getValue()+");";
            System.out.println(sql);
            sqlList.add(sql);
        }
        DatabaseManager.executeBatch(sqlList);
    }

    public void deleteNutrientList(String ndbno) {
        String sql = "DELETE FROM nutrient WHERE food_id = \'"+ndbno+"\';";
        DatabaseManager.executeStatment(sql);
    }
}
