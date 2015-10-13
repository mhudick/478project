package CalorieCounter.Java.Controllers;

import CalorieCounter.Java.Model.TableHelper;
import java.io.File;
import java.sql.*;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Phil on 9/28/2015.
 */
public class DataManager {
    //Constant for database file name.
    private static final String DB_NAME = "MyData";

    //Object that handles http request
    private static Connection conn  = null;

    //private constructor prevents unnecessary instantiation
    private DataManager(){
    }

    //Checks for database and creates one if it does not exist
    public static void checkForDatabase(){
        if(!new File(DB_NAME+".db").exists()){
            executeSqlList(TableHelper.getTables());
            System.out.println("Created database successfully");
        }
    }

    //Executes a sql update string
    public static void updateData(String sql){
        Statement statement;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Executes a List of sql statements
    public static void executeSqlList(List sqlList){
        Statement statement;
        Iterator<String> iterator = sqlList.iterator();
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DB_NAME+".db");
            statement = conn.createStatement();
            while(iterator.hasNext()){
                statement.addBatch(iterator.next());
            }
            statement.executeBatch();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Returns the result set of a sql query
    public static ResultSet retrieveData(String sql){
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
