package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.28
** Configuration Version: 1.0.0
*/

/**
 * The DatabaseManager in the main class that interacts with the database.
 * It has a few simple methods; checkForDataBase, executeStatement,
 * executeBatch, and getResultSet.
 */

import java.io.File;
import java.sql.*;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

public class DatabaseManager {
    //Constant for database file name.
    private static final String DB_NAME = "MyData";

    //Object that handles http request
    private static Connection conn  = null;

    //private constructor prevents unnecessary instantiation
    private DatabaseManager(){
    }

    /**
     * Application checks for database when launched
     * (Requirement 1.1.0)
     */
    //Checks for database and creates one if it does not exist
    public static void checkForDatabase(){
        /**
         * Application creates database if one does not exist
         * (Requirement 1.1.1)
         */
        if(!new File(DB_NAME+".db").exists()){
            /**
             * Application sets tables for the database
             * (Requirement 1.1.2)
             */
            executeBatch(TableMigration.getTables());
            System.out.println("Created database successfully");
        }else{
            System.out.print("Database already exist.");
        }
    }

    /**
     * Application can execute a Sql statement
     * (Requirement 1.2.0)
     */
    //Executes a sql update string
    public static boolean executeStatement(String sql){
        Statement statement;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Application can execute a list of Sql statements
     * (Requirement 1.2.1)
     */
    //Executes a List of sql statements
    public static boolean executeBatch(List<String> sqlList){
        Statement statement;
        Iterator<String> iterator = sqlList.iterator();
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
            statement = conn.createStatement();
            while(iterator.hasNext()){
                statement.addBatch(iterator.next());
            }
            statement.executeBatch();
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Application can query database and receive a result set.
     * (Requirement 1.3.0)
     */
    //Returns the result set of a sql query
    public static ResultSet getResultSet(String sql){
        ResultSet rs;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
