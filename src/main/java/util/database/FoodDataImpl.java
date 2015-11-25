package util.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class FoodDataImpl implements FoodData{

    @Override
    public Boolean saveFood(Food food) {
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, fg, kCal) values(\'" +
                food.getNdbno()+"\',\'"+food.getName()+"\',\'"+food.getFg()+"\',"+food.getkCal()+");";
        DatabaseManager.executeStatment(sql);
        return true;
    }

    @Override
    public Boolean deleteFood(String ndbno) {
        String foodSql = "DELETE FROM food WHERE ndbno = \'"+ndbno+"\';";
        DatabaseManager.executeStatment(foodSql);
        return true;
    }

    @Override
    public HashMap<String, Food> getFoodMap() {
        String sql = "SELECT * FROM food;";
        HashMap<String, Food> foodMap = new HashMap<>();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
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
        ResultSet rs = DatabaseManager.getResultSet(sql);
        try {
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
}
