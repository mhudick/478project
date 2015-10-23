package util.database;

import models.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class FoodData {

    public static Food getFood(String ndbno) {
        String sql = "SELECT * FROM food WHERE ndbno = "+ndbno+";";
        NutrientData nutrientData = new NutrientData();
        Food food = null;

        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            food.setNdbno(resultSet.getString("ndbno"));//These methods set the attributes of the Food object
            food.setName(resultSet.getString("name"));
            food.setFg(resultSet.getString("food_group"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        food.setNutrients(nutrientData.getNutrientList(ndbno));
        return food;
    }


    public static List<Food> getAllFoods() {
        String sql = "SELECT * FROM food;";
        List<Food> list = new ArrayList<>();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            while(!resultSet.isAfterLast()){
                System.out.println(resultSet.getString("ndbno"));
                list.add(getFood(resultSet.getString("ndbno")));
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        return list;
    }


    public static void saveFood(Food food) {
        //String created from attributes of the object
        NutrientData nutrientData = new NutrientData();
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, food_group) values(\"" +
                food.getNbdno()+"\",\""+food.getName()+"\",\""+food.getFg()+"\");";
        //This iterates through nutrient list

        DatabaseManager.executeStatment(sql);
        nutrientData.saveNutrientList(food.getNutrients());
        //Executes sql as background thread so the GUI is unaffected.
        /*
        new Thread() {
            // runnable for that thread
            public void run() {
                //Static method to execute update.
            }
        }.start();
        */
    }


    public static void deleteFood(String ndbno) {
        String foodSql = "DELETE FROM food WHERE ndbno = \'"+ndbno+"\';";
        NutrientData nutrientData = new NutrientData();
        nutrientData.deleteNutrientList(ndbno);
        DatabaseManager.executeStatment(foodSql);
    }
}
