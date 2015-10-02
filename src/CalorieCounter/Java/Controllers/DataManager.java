package CalorieCounter.Java.Controllers;
import java.sql.*;

/**
 * Created by Phil on 9/28/2015.
 */
public class DataManager {

    Connection conn  = null;

    public DataManager(){
        openConnection();
        System.out.println("Opened database successfully");
    }
    public void openConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:MyLib.db");
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
}
