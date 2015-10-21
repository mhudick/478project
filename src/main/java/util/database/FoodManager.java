package util.database;

import models.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class FoodManager {

    public Food getFood(String ndbno) {
        String sql = "SELECT * FROM food WHERE ndbno = "+ndbno+";";
        Food food = null;

        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            food.setNdbno(resultSet.getString("ndbno"));//These methods set the attributes of the Food object
            food.setName(resultSet.getString("name"));
            food.setFg(resultSet.getString("food_group"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return food;
    }


    public List<Food> getAllFoods() {
        String sql = "SELECT * FROM food;";
        List<Food> list = new ArrayList<>();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            while(!resultSet.isAfterLast()){
                System.out.println(resultSet.getString("ndbno"));
                list.add(new Food(resultSet.getString("ndbno"),resultSet.getString("name"),resultSet.getString("food_group")));
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        return list;
    }


    public void saveFood(Food food) {
        //String created from attributes of the object
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, food_group) values(\"" +
                food.getNbdno()+"\",\""+food.getName()+"\",\""+food.getFg()+"\");";
        //This iterates through nutrient list

        //Executes sql as background thread so the GUI is unaffected.
        new Thread() {
            // runnable for that thread
            public void run() {
                DatabaseManager.executeStatment(sql);//Static method to execute update.
            }
        }.start();
    }


    public void deleteFood(String ndbno) {
        String foodSql = "DELETE FROM food WHERE ndbno = \'"+ndbno+"\';";
        String nutrientSql = "DELETE FROM nutrient WHERE food_id = \'"+ndbno+"\';";
        List<String> list = new ArrayList<>();
        list.add(foodSql);
        list.add(nutrientSql);
        DatabaseManager.executeBatch(list);
    }
}
