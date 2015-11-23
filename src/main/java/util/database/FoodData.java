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
        String sql = "SELECT ndbno, name, food_group FROM food WHERE ndbno = "+ndbno+";";
        Food food = null;
        NutrientData nutrientData = new NutrientData();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);

        try {
            resultSet.next();
            //These methods set the attributes of the Food object
            String foodName = resultSet.getString("name");
            String foodGroup = resultSet.getString("food_group");
            food = new Food(ndbno, foodName, foodGroup);
            food.setNutrients(nutrientData.getNutrientList(ndbno));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    /*
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
    */

    public static ArrayList<Food> getAllFoods() {
        String sql = "SELECT * FROM food;";
        ArrayList<Food> foodArraylist = new ArrayList<>();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            while(!resultSet.isAfterLast()){
                System.out.println(resultSet.getString("ndbno"));
                String ndbno = resultSet.getString("ndbno");
                Food food = getFood(ndbno);
                foodArraylist.add(food);
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(foodArraylist.toString());
        return foodArraylist;
    }

    public static void saveFood(Food food) {
        //String created from attributes of the object
        NutrientData nutrientData = new NutrientData();
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, food_group) values(\"" +
                food.getNbdno()+"\",\""+food.getName()+"\",\""+food.getFg()+"\");";
        //TODO can the sql statement below be used instead of the one above?
        /*
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, food_group) values" +
                food.getNbdno() + ", " + food.getName() + ", " + food.getFg();
        */
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
