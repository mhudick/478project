package util.database;

import javafx.collections.ObservableList;
import models.Food;

import java.util.HashMap;

/**
 * Created by Phil on 11/23/2015.
 */
public interface FoodData {
    Boolean saveFood(Food food);
    Boolean deleteFood(String ndbno);
    HashMap<String, Food> getFoodMap();
    ObservableList<String> getFoodNameList();
}
