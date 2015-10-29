package util.database;

import models.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Philip on 10/18/2015.
 */
public interface DataAccess {

    //User Methods
    User getUser(int id);
    HashMap<String,User> getAllUser();
    void saveUser(User user);
    void deleteUser(int id);

    //Recipe Methods
    Recipe getRecipe(int id);
    List<Recipe> getAllRecipes();
    void saveRecipe(Recipe recipe);
    void deleteRecipe(int id);

    //Food Methods
    Food getFood(String ndbno);
    List<Food> getAllFoods();
    void saveFood(Food food);
    void deleteFood(String ndbno);

    //Day Methods
    Day getDay(int id);
    List<Day> getAllDays();
    void saveDay(Day day);
    void deleteDay(int id);

    //WeighIn Methods
    WeighIn getWeighIn(int id);
    List<WeighIn> getAllWeighIns();
    void saveWeighIn(int id);
    void deleteWeighIn(int id);


}
