package util.database;

import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class UserData {

    public User getUser() {
        return null;
    }

    public HashMap<String,User> getAllUsers(){
        String sql = "SELECT * FROM user";
        HashMap<String, User> userList = new HashMap<>();
        ResultSet rs = DatabaseManager.getResultSet(sql);
        try {
            rs.next();
            while(!rs.isAfterLast()){
                User user = new User();
                user.setName(rs.getString("name"));
                user.setAge(rs.getString("age"));
                userList.put(user.getName(),user);
                rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userList.toString();
        return userList;
    }

    public void saveUser(User user) {
        String sql = "INSERT OR REPLACE INTO user(name, age) VALUES(\'"+user.getName()+"\', "+user.getAge()+")";
        DatabaseManager.executeStatment(sql);
    }

    public void deleteUser(int id) {

    }
}
