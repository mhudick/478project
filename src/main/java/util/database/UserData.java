package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This interface provides an easy to insure that the implementing class
 * provides the necessary methods.
 */

import javafx.collections.ObservableList;
import models.User;
import java.util.HashMap;

public interface UserData {
    User getUser(int userId);
    HashMap<String,User> getUserMap();
    ObservableList<String> getUserNames();
    boolean saveUser(User user);
    boolean saveNewUser(User user);
    boolean deleteUser(int userId);
}
