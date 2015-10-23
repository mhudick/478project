package util.database;

import models.*;

import java.util.List;

/**
 * Created by Philip on 10/18/2015.
 */
public class DataAccessImpl implements DataAccess {
    /*
        USER METHODS
     */
    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    /*
        RECIPE METHODS
     */
    @Override
    public Recipe getRecipe(int id) {
        return null;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return null;
    }

    @Override
    public void saveRecipe(Recipe recipe) {

    }

    @Override
    public void deleteRecipe(int id) {

    }

    /*
        FOOD METHODS
     */
    @Override
    public Food getFood(String ndbno) {
        return FoodData.getFood(ndbno);
    }

    @Override
    public List<Food> getAllFoods() {
        return FoodData.getAllFoods();
    }

    @Override
    public void saveFood(Food food) {
        FoodData.saveFood(food);
    }

    @Override
    public void deleteFood(String ndbno) {
        FoodData.deleteFood(ndbno);
    }

    /*
        DAY METHODS
     */
    @Override
    public Day getDay(int id) {
        return null;
    }

    @Override
    public List<Day> getAllDays() {
        return null;
    }

    @Override
    public void saveDay(Day day) {

    }

    @Override
    public void deleteDay(int id) {

    }

    /*
        WEIGH-IN METHODS
     */
    @Override
    public WeighIn getWeighIn(int id) {
        return null;
    }

    @Override
    public List<WeighIn> getAllWeighIns() {
        return null;
    }

    @Override
    public void saveWeighIn(int id) {

    }

    @Override
    public void deleteWeighIn(int id) {

    }
}
