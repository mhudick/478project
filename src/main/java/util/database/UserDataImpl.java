package util.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class UserDataImpl implements UserData{

    public UserDataImpl(){

    }
    public User getUser(int id) {
        String sql = "SELECT * FROM user WHERE id = "+id;
        User user = new User();
        ResultSet rs = DatabaseManager.getResultSet(sql);
        try {
            rs.next();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public HashMap<String,Integer> getAllUsers(){
        String sql = "SELECT id, name FROM user";
        HashMap<String,Integer> userList = new HashMap<>();
        ResultSet rs = DatabaseManager.getResultSet(sql);
        try {
            rs.next();
            while(!rs.isAfterLast()){
                userList.put(rs.getString("name"),rs.getInt("id"));
                rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userList.toString();
        return userList;
    }

    @Override
    public ObservableList<String> getUserNames() {
        String sql = "SELECT name FROM user";
        ObservableList<String> userNames = FXCollections.observableArrayList();
        ResultSet rs = DatabaseManager.getResultSet(sql);
        try {
            rs.next();
            while (!rs.isAfterLast()){
                userNames.add(rs.getString("name"));
                rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userNames;
    }

    public Boolean saveUser(User user) {
        String sql = "INSERT OR REPLACE INTO user(name, age) VALUES(\'"+user.getName()+"\', "+user.getAge()+")";
        DatabaseManager.executeStatment(sql);
        return true;
    }

    public Boolean deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = "+id;
        DatabaseManager.executeStatment(sql);
        return true;
    }
}
