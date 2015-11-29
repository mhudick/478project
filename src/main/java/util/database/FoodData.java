package util.database;

import javafx.collections.ObservableList;
import models.Food;

import java.util.HashMap;

/**
 * Created by Phil on 11/23/2015.
 */
public interface FoodData {
    boolean saveFood(Food food);
    boolean deleteFood(String ndbno);
    HashMap<String, Food> getFoodMap();
    ObservableList<String> getFoodNameList();
}
