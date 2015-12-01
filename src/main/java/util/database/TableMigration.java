package util.database;

/* Developer: Philip Churchill
** Date: 2015.10.11
** Configuration Version: 1.0.0
*/

/**
 * This class sole purpose is to create the sql statements as a list of
 * strings that are used to create the tables during the initial creation
 * of the database
 */

import java.util.ArrayList;
import java.util.List;

public class TableMigration {
    //Constant for sql that creates the tables.

    /**
     * Multiple users can exist
     * (Requirement 2.0.0)
     */
    private static final String USER_TABLE =
            "CREATE TABLE user"+
                    "(userId INTEGER PRIMARY KEY,"+
                    "name TEXT NOT NULL UNIQUE,"+
                    "dailyCalorieLimit INTEGER,"+
                    "weightCurrent NUMBER,"+
                    "weightStart NUMBER,"+
                    "weightGoal NUMBER);";

    /**
     * Multiple Food objects can exist
     * (Requirement 3.0.0)
     */
    private static String FOOD_TABLE =
            "CREATE TABLE food("+
                    "ndbno TEXT PRIMARY KEY,"+
                    "name TEXT NOT NULL,"+
                    "fg TEXT NOT NULL,"+
                    "kCal NUMBER);";

    /**
     * Day objects can keep track of daily calorie counts for each user
     * (Requirement 5.0.0)
     */
    private static final String DAY_TABLE =
            "CREATE TABLE day"+
                    "(dayId INTEGER PRIMARY KEY,"+
                    "userId INTEGER,"+
                    "date TEXT,"+
                    "totalCal INTEGER,"+
                    "FOREIGN KEY (userId) references USER(userId));";

    /**
     * Weigh-in objects can keep track of weigh-in events of the user
     * (Requirement 4.0.0)
     */
    private static final String WEIGH_IN_TABLE =
            "CREATE TABLE weigh_in"+
                    "(weighId INTEGER PRIMARY KEY,"+
                    "userId INTEGER,"+
                    "date TEXT,"+
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
