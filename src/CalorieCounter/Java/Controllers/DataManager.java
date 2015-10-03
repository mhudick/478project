package CalorieCounter.Java.Controllers;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Phil on 9/28/2015.
 */
public class DataManager {

    private final String DB_NAME = "MyData";

    private final String USER_TABLE =
            "CREATE TABLE user"+
            "(id     INT     PRIMARY KEY,"+
            "name   TEXT    NOT NULL,"+
            "age    INT     NOT NULL);";

    private final String RECIPE_TABLE =
            "CREATE TABLE recipe"+
            "(id INT PRIMARY KEY,"+
            "title TEXT NOT NULL);";

    private final String NUTRIENT_TABLE =
            "CREATE TABLE nutrient"+
            "(nutrient_id INT PRIMARY KEY NOT NULL,"+
            "food_id TEXT NOT NULL,"+
            "name TEXT NOT NULL,"+
            "fg TEXT NOT NULL,"+
            "unit TEXT NOT NULL,"+
            "value INT NOT NULL);";

    private final String FOOD_TABLE =
            "CREATE TABLE food("+
            "id INT PRIMARY KEY NOT NULL,"+
            "name TEXT NOT NULL,"+
            "fg TEXT NOT NULL);";

    private final String MEASURE_TABLE = "";
    Connection conn  = null;

    public DataManager(){
        if(!new File(DB_NAME+".db").exists()){
            createTables(DB_NAME);
            System.out.println("Created database successfully");
        }
    }

    public void createTables(String dbName){
        Statement statement;

        List<String> tables = new ArrayList<>();
        tables.add(USER_TABLE);
        tables.add(RECIPE_TABLE);
        tables.add(FOOD_TABLE);
        tables.add(NUTRIENT_TABLE);
        //tables.add(MEASURE_TABLE);

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
