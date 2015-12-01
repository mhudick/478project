package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This class implements the interface for the UserData Class. The main
 * functionality of this class is meant to save and retrieve information
 * on the database specifically for the User object.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class UserDataImpl implements UserData{

    @Override
    public boolean saveUser(User user) {
        String sql = "INSERT OR REPLACE INTO user(userId, name, dailyCalorieLimit, weightCurrent, weightStart, weightGoal)"+
                "VALUES("+user.getUserId()+",\'"+user.getName()+"\', "+user.getDailyCalorieLimit()+", "+user.getWeightCurrent()+", "+
                user.getWeightStart()+", "+user.getWeightGoal()+");";
        return DatabaseManager.executeStatement(sql);
    }

    @Override
    public boolean saveNewUser(User user) {
        String sql = "INSERT INTO user(name, dailyCalorieLimit, weightCurrent, weightStart, weightGoal)"+
                "VALUES(\'"+user.getName()+"\', "+user.getDailyCalorieLimit()+", "+user.getWeightCurrent()+", "+
                user.getWeightStart()+", "+user.getWeightGoal()+");";
        return DatabaseManager.executeStatement(sql);
    }

    @Override
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE userId = "+userId;
        return DatabaseManager.executeStatement(sql);
    }

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
            return null;
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
            return null;
        }
        return userMap;
    }

    /**
     * A list of user names can be loaded from the database
     * (Requirement 2.4.0)
     */
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
            return null;
        }
        return userNames;
    }
}
