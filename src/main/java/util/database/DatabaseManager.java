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

    //Checks for database and creates one if it does not exist
    public static boolean checkForDatabase(){
        if(!new File(DB_NAME+".db").exists()){
            try {
                executeBatch(TableMigration.getTables());
                System.out.println("Created database successfully");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    //Executes a sql update string
    public static void executeStatment(String sql) throws SQLException {
        Statement statement;
        conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
        statement = conn.createStatement();
        statement.executeUpdate(sql);
        conn.close();
        conn = null;
    }

    //Executes a List of sql statements
    public static void executeBatch(List<String> sqlList) throws SQLException {
        Statement statement;
        Iterator<String> iterator = sqlList.iterator();
        conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
        statement = conn.createStatement();
        while(iterator.hasNext()){
            statement.addBatch(iterator.next());
        }
        statement.executeBatch();
        conn.close();
        conn = null;
    }

    //Returns the result set of a sql query
    public static ResultSet getResultSet(String sql) throws SQLException {
        ResultSet rs;
        conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sql);
        return rs;
    }
}
