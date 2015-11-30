package util.database;

import javafx.collections.ObservableList;
import models.User;

import java.util.HashMap;

/**
 * Created by Phil on 11/3/2015.
 */
public interface UserData {
    User getUser(int userId);
    HashMap<String,User> getUserMap();
    ObservableList<String> getUserNames();
    boolean saveUser(User user);
    boolean saveNewUser(User user);
    boolean deleteUser(int userId);
}
