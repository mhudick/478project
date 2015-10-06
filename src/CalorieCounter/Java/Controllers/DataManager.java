package CalorieCounter.Java.Controllers;
import CalorieCounter.Java.Model.Food;
import CalorieCounter.Java.Model.Recipe;

import java.beans.*;
import java.io.File;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Phil on 9/28/2015.
 */
public class DataManager {
    //testing
    private final String DB_NAME = "MyData";

    private final String USER_TABLE =
            "CREATE TABLE user"+
            "(id INTEGER PRIMARY KEY,"+
            "name TEXT NOT NULL,"+
            "age INT NOT NULL);";

    private final String USER_RECIPE_TABLE =
            "CREATE TABLE user_recipe("+
            "id INT PRIMARY KEY NOT NULL,"+
            "user_id INT NOT NULL,"+
            "recipe_id INT NOT NULL,"+
            "FOREIGN KEY(user_id) REFERENCES user(id)," +
            "FOREIGN KEY(recipe_id) REFERENCES recipe(id))";

    private final String RECIPE_TABLE =
            "CREATE TABLE recipe"+
            "(id INT PRIMARY KEY NOT NULL,"+
            "title TEXT NOT NULL);";

    private final String RECIPE_FOOD_TABLE =
            "CREATE TABLE recipe_food("+
            "id INT PRIMARY KEY NOT NULL,"+
            "recipe_id INT NOT NULL,"+
            "food_id INT NOT NULL," +
            "FOREIGN KEY(recipe_id) REFERENCES recipe(id)," +
            "FOREIGN KEY(food_id) REFERENCES food(id));";

    private final String FOOD_TABLE =
            "CREATE TABLE food("+
            "ndbno INTEGER PRIMARY KEY,"+
            "name TEXT NOT NULL,"+
            "food_group TEXT NOT NULL);";

    private final String NUTRIENT_TABLE =
            "CREATE TABLE nutrient"+
            "(id INT PRIMARY KEY NOT NULL,"+
            "food_id INT NOT NULL,"+//Foreign key from food table
            "name TEXT NOT NULL,"+
            "fg TEXT NOT NULL,"+
            "unit TEXT NOT NULL,"+
            "value NUMBER NOT NULL," +
            "FOREIGN KEY(food_id) REFERENCES food(id));";
/*
    private final String MEASURE_TABLE =
            "CREATE TABLE measure("+
            "id INT PRIMARY KEY NOT NULL," +
            "nutrient_id INT NOT NULL,"+
            "label TEXT NOT NULL,"+
            "eqv NUMBER," +
            "qty NUMBER,"+
            "value NUMBER," +
            "FOREIGN KEY(nutrient_id) REFERENCES nutrient(id));";
*/
    Connection conn  = null;

    public DataManager(){
        if(!new File(DB_NAME+".db").exists()){
            createTables(DB_NAME);
            System.out.println("Created database successfully");
        }
    }

    public void saveFood(Food food){
    //Food passed as param
        //save food to db
        //retrieve food id and nutrient list
        //nutrient save(id, nutrient list);
    }

    public Food loadFood(){
        return null;
    }

    public void saveRecipe(Recipe recipe){

    }

    public Recipe loadRecipe(){
        return null;
    }

    public void createTables(String dbName){
        Statement statement;

        List<String> tables = new ArrayList<>();
        tables.add(USER_TABLE);
        tables.add(USER_RECIPE_TABLE);
        tables.add(RECIPE_TABLE);
        tables.add(RECIPE_FOOD_TABLE);
        tables.add(FOOD_TABLE);
        tables.add(NUTRIENT_TABLE);

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+dbName+".db");
            Iterator<String> iterator = tables.iterator();
            while (iterator.hasNext()){
                statement = conn.createStatement();
                statement.executeUpdate(iterator.next());
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

}
