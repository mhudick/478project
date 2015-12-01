package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This class implements the interface for the FoodData Class. The main
 * functionality of this class is meant to save and retrieve information
 * on the database specifically for the Food object.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Food;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class FoodDataImpl implements FoodData{

    @Override
    public boolean saveFood(Food food) {
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, fg, kCal) values(\'" +
                food.getNdbno()+"\',\'"+formatName(food.getName())+"\',\'"+food.getFg()+"\',"+food.getkCal()+");";
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFood(String ndbno) {
        String foodSql = "DELETE FROM food WHERE ndbno = \'"+ndbno+"\';";
        try {
            DatabaseManager.executeStatment(foodSql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public HashMap<String, Food> getFoodMap() {
        String sql = "SELECT * FROM food;";
        HashMap<String, Food> foodMap = new HashMap<>();
        try {
            ResultSet resultSet = DatabaseManager.getResultSet(sql);
            resultSet.next();
            while(!resultSet.isAfterLast()){
                Food food = new Food();
                food.setNdbno(resultSet.getString("ndbno"));
                food.setName(resultSet.getString("name"));
                food.setFg(resultSet.getString("fg"));
                food.setkCal(resultSet.getDouble("kCal"));
                foodMap.put(food.getName(), food);
                resultSet.next();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodMap;
    }

    @Override
    public ObservableList<String> getFoodNameList() {
        String sql = "SELECT name FROM food";
        ObservableList<String> foodNames = FXCollections.observableArrayList();
        try {
            ResultSet rs = DatabaseManager.getResultSet(sql);
            rs.next();
            while (!rs.isAfterLast()){
                foodNames.add(rs.getString("name"));
                rs.next();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodNames;
    }
    private String formatName(String name){
        name = name.replace('\'', '`');
        return name;
    }
}
