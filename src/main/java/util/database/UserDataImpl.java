/**
 * Created by Philip on 10/17/2015.
 */


package util.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class UserDataImpl implements UserData{

    @Override
    public User getUser(int userId) {
        String sql = "SELECT * FROM user WHERE userId = "+userId;
        User user = new User();
        try {
            ResultSet rs = DatabaseManager.getResultSet(sql);
            rs.next();
            user.setUserId(rs.getInt("userId"));
            user.setName(rs.getString("name"));
            user.setDailyCalorieLimit(rs.getInt("dailyCalorieLimit"));
            user.setWeightCurrent(rs.getDouble("weightCurrent"));
            user.setWeightStart(rs.getDouble("weightStart"));
            user.setWeightGoal(rs.getDouble("weightGoal"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public HashMap<String,User> getUserMap(){
        String sql = "SELECT * FROM user";
        User user;
        HashMap<String,User> userMap = new HashMap<>();
        try {
            ResultSet rs = DatabaseManager.getResultSet(sql);
            rs.next();
            while(!rs.isAfterLast()){//Making HashMap from ResultSet.
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setDailyCalorieLimit(rs.getInt("dailyCalorieLimit"));
                user.setWeightCurrent(rs.getDouble("weightCurrent"));
                user.setWeightStart(rs.getDouble("weightStart"));
                user.setWeightGoal(rs.getDouble("weightGoal"));
                userMap.put(user.getName(),user);
                rs.next();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMap;
    }

    @Override
    public ObservableList<String> getUserNames() {
        String sql = "SELECT name FROM user";
        ObservableList<String> userNames = FXCollections.observableArrayList();
        try {
            ResultSet rs = DatabaseManager.getResultSet(sql);
            rs.next();
            while (!rs.isAfterLast()){
                userNames.add(rs.getString("name"));
                rs.next();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userNames;
    }

    @Override
    public boolean saveUser(User user) {
        String sql = "INSERT OR REPLACE INTO user(userId, name, dailyCalorieLimit, weightCurrent, weightStart, weightGoal)"+
                    "VALUES("+user.getUserId()+",\'"+user.getName()+"\', "+user.getDailyCalorieLimit()+", "+user.getWeightCurrent()+", "+
                    user.getWeightStart()+", "+user.getWeightGoal()+");";
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean saveNewUser(User user) {
        String sql = "INSERT INTO user(name, dailyCalorieLimit, weightCurrent, weightStart, weightGoal)"+
                "VALUES(\'"+user.getName()+"\', "+user.getDailyCalorieLimit()+", "+user.getWeightCurrent()+", "+
                user.getWeightStart()+", "+user.getWeightGoal()+");";
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE userId = "+userId;
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
