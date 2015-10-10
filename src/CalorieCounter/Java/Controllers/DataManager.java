package CalorieCounter.Java.Controllers;
import CalorieCounter.Java.Model.Food;
import CalorieCounter.Java.Model.Nutrient;
import CalorieCounter.Java.Model.Recipe;

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
    //Constant for database file name.
    private final String DB_NAME = "MyData";

    //Constant for sql that creates the tables.
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
            "ndbno TEXT PRIMARY KEY,"+
            "name TEXT NOT NULL,"+
            "food_group TEXT NOT NULL);";

    private final String NUTRIENT_TABLE =
            "CREATE TABLE nutrient"+
            "(id INTEGER PRIMARY KEY,"+
            "food_id INT NOT NULL,"+//Foreign key from food table
            "name TEXT NOT NULL,"+
            "food_group TEXT NOT NULL,"+
            "unit TEXT NOT NULL,"+
            "value NUMBER NOT NULL," +
            "FOREIGN KEY(food_id) REFERENCES food(id));";
/*
    NOT USED AT THIS POINT
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
    //Object that handles http request
    Connection conn  = null;

    //Constructor for DataManager, checks for file if it does not exist it creates it.
    public DataManager(){
        if(!new File(DB_NAME+".db").exists()){
            createDatabase(DB_NAME);//Creates tables
            System.out.println("Created database successfully");
        }
    }
    //Pass Food object to this method to save it. Nutrients in the Food's List get saved automatically.
    public void saveFood(Food food){
        Statement statement;//Statement objects that executes sql.
        String sql = "INSERT OR REPLACE INTO FOOD(ndbno, name, food_group) values(\"" +
                food.getNbdno()+"\",\""+food.getName()+"\",\""+food.getFg()+"\");";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Iterator<Nutrient> iterator = food.getNutrients().iterator();
        while (iterator.hasNext()){
            saveNutrient(iterator.next(),food.getNbdno());//iterates through nutrients and calls saveNutrient
        }
    }
    //Called from saveFood method. Saves the nutrients to a table with the food objects primary key.
    //This enables us to easily recall the nutrient information when we load the Food object.
    public void saveNutrient(Nutrient nutrient, String foodId){
        Statement statement;
        String sql = "INSERT OR REPLACE INTO nutrient(food_id,name, food_group, unit, value) values("+foodId+",\""+nutrient.getName()+
                "\",\""+nutrient.getGroup()+"\",\""+nutrient.getUnit()+"\",\""+nutrient.getValue()+"\");";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //When you pass the food id it returns the food object
    public Food loadFood(int id){
        Statement statement;
        Food food = new Food();
        String sql = "SELECT * FROM food WHERE ndbno = "+id+";";
        String nutrientSql = "SELECT * FROM nutrient WHERE food_id = "+id+";";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            food.setNdbno(rs.getString("ndbno"));//These methods set the attributes of the Food object
            food.setName(rs.getString("name"));
            food.setFg(rs.getString("food_group"));
            List<Nutrient> nutrientList = new ArrayList<>();
            rs = statement.executeQuery(nutrientSql);//Record set holds the row of data returned by the database.
            //This loop uses builds the Food object's nutrient list.
            while (!rs.isAfterLast()){
                //The Nutrient class has a constructor that you can pass the records straight to the object when it is instantiated and adds it to list.
                nutrientList.add(new Nutrient(rs.getInt("id"), rs.getInt("food_id"),rs.getString("name"),rs.getString("food_group"),rs.getString("unit"),rs.getString("value")));
                rs.next();//Iterates to next row.
            }
            food.setNutrients(nutrientList);//Adds list to the food object.
            System.out.println();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;//returns food object
    }
    //Deletes food and nutrients associated with the food. Just pass the food id.
    public void deleteFood(String ndbno){
        String sql = "DELETE FROM food WHERE ndbno = \""+ndbno+"\";";
        String nutrientSql = "DELETE FROM nutrient WHERE food_id = \""+ndbno+"\";";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
            Statement statement = conn.createStatement();
            statement.executeUpdate(nutrientSql);
            statement.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void saveRecipe(Recipe recipe){

    }

    public Recipe loadRecipe(){
        return null;
    }

    //This method returns a list of the ndbno we could modify this to return various information as we need.
    public List getFoodList(){
        String sql = "SELECT ndbno FROM food;";
        List<String> ls = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            while (!rs.isAfterLast()){
                ls.add(rs.getString("ndbno"));
                System.out.println(rs.getString("ndbno"));
                rs.next();
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return ls;
    }
    //This is the method that is responsible for creating the database.
    public void createDatabase(String dbName){
        Statement statement;
        //Creating list to iterate through SQL commands.
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
                statement.executeUpdate(iterator.next());//Executes the SQL
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

}
