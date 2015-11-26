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
                    "(userId INTEGER PRIMARY KEY,"+
                    "name TEXT NOT NULL UNIQUE,"+
                    "dailyCalorieLimit INTEGER,"+
                    "weightCurrent NUMBER,"+
                    "weightStart NUMBER,"+
                    "weightGoal NUMBER);";

    private static String FOOD_TABLE =
            "CREATE TABLE food("+
                    "ndbno TEXT PRIMARY KEY,"+
                    "name TEXT NOT NULL,"+
                    "fg TEXT NOT NULL,"+
                    "kCal NUMBER);";

    private static final String DAY_TABLE =
            "CREATE TABLE day"+
                    "(dayId INTEGER PRIMARY KEY,"+
                    "userId INTEGER,"+
                    "date TEXT,"+
                    "totalCal INTEGER,"+
                    "FOREIGN KEY (userId) references USER(userId));";

    private static final String WEIGH_IN_TABLE =
            "CREATE TABLE weigh_in"+
                    "(weighId INTEGER PRIMARY KEY,"+
                    "userId INTEGER,"+
                    "date DATE,"+
                    "weight NUMBER,"+
                    "FOREIGN KEY(userId) REFERENCES day(userId));";

    //private constructor prevents unnecessary instantiation
    private TableMigration(){

    }

    //Static method that creates and returns List of sql statements to create tables
    public static List<String> getTables(){
        List<String> tables = new ArrayList<>();
        tables.add(USER_TABLE);
        tables.add(FOOD_TABLE);
        tables.add(DAY_TABLE);
        tables.add(WEIGH_IN_TABLE);

        return tables;
    }
}
