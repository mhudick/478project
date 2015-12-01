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
import models.Food;
import java.util.HashMap;

public interface FoodData {
    boolean saveFood(Food food);
    boolean deleteFood(String ndbno);
    HashMap<String, Food> getFoodMap();
    ObservableList<String> getFoodNameList();
}
