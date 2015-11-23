package util.database;

import javafx.collections.ObservableList;
import models.Food;

import java.util.HashMap;

/**
 * Created by Phil on 11/23/2015.
 */
public interface FoodData {
    Food getFood(String ndbno);
    Boolean saveFood(Food food);
    Boolean deleteFood(String ndbno);
    HashMap<String, String> getFoodMap();
    ObservableList<String> getFoodNameList();
}
