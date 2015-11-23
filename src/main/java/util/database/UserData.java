package util.database;

import javafx.collections.ObservableList;
import models.User;

import java.util.HashMap;

/**
 * Created by Phil on 11/3/2015.
 */
public interface UserData {
    User getUser(int id);
    HashMap<String,Integer> getUserMap();
    ObservableList<String> getUserNames();
    Boolean saveUser(User user);
    Boolean deleteUser(int id);
}
