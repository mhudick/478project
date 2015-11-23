package util.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip on 10/11/2015.
 */
public class TableMigration {
    //Constant for sql that creates the tables.
    private static final String USER_TABLE =
            "CREATE TABLE user"+
                    "(id INTEGER PRIMARY KEY,"+
                    "name TEXT NOT NULL UNIQUE,"+
                    "age INT NULL);";

    private static final String USER_RECIPE_TABLE =
            "CREATE TABLE user_recipe("+
                    "id INTEGER PRIMARY KEY NOT NULL,"+
                    "user_id INT NOT NULL,"+
                    "recipe_id INT NOT NULL,"+
                    "FOREIGN KEY(user_id) REFERENCES user(id)," +
                    "FOREIGN KEY(recipe_id) REFERENCES recipe(id))";

    private static final String RECIPE_TABLE =
            "CREATE TABLE recipe"+
                    "(id INT PRIMARY KEY NOT NULL,"+
                    "title TEXT NOT NULL);";

    private static final String RECIPE_FOOD_TABLE =
            "CREATE TABLE recipe_food("+
                    "id INT PRIMARY KEY NOT NULL,"+
                    "recipe_id INT NOT NULL,"+
                    "food_id INT NOT NULL," +
                    "FOREIGN KEY(recipe_id) REFERENCES recipe(id)," +
                    "FOREIGN KEY(food_id) REFERENCES food(id));";

    private static String FOOD_TABLE =
            "CREATE TABLE food("+
                    "ndbno TEXT PRIMARY KEY,"+
                    "name TEXT NOT NULL,"+
                    "food_group TEXT NOT NULL);";

    private static String NUTRIENT_TABLE =
            "CREATE TABLE nutrient"+
                    "(id INTEGER PRIMARY KEY,"+
                    "ndbno TEXT NOT NULL,"+//Foreign key from food table
                    "name TEXT NOT NULL,"+
                    "food_group TEXT NOT NULL,"+
                    "unit TEXT NOT NULL,"+
                    "value NUMBER NOT NULL," +
                    "FOREIGN KEY(ndbno) REFERENCES food(ndbno));";
    private static final String DAILY_COUNTER_TABLE =
            "CREATE TABLE daily_counter"+
                    "(id INTEGER PRIMARY KEY,"+
                    "runningTotal NUMBER ,"+
                    "overBudget BOOLEAN ,"+
                    "daysNotOverBudget INT);";
    private static final String DAY_TABLE =
            "CREATE TABLE day"+
                    "(id INTEGER PRIMARY KEY,"+
                    "creation_date date,"+
                    "user_id INTEGER,"+
                    "FOREIGN KEY (user_id) references USER(id);";

    //private constructor prevents unnecessary instantiation
    private TableMigration(){

    }

    //Static method that creates and returns List of sql statements to create tables
    public static List<String> getTables(){
        List<String> tables = new ArrayList<>();
        tables.add(USER_TABLE);
        tables.add(USER_RECIPE_TABLE);
        tables.add(RECIPE_TABLE);
        tables.add(RECIPE_FOOD_TABLE);
        tables.add(FOOD_TABLE);
        tables.add(NUTRIENT_TABLE);
        tables.add(DAILY_COUNTER_TABLE);

        return tables;
    }
}
