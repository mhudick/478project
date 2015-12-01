package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This class implements the interface for the DayData Class. The main
 * functionality of this class is meant to save and retrieve information
 * on the database specifically for the Day object.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Day;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DayDataImpl implements DayData {

    /**
     * Day objects can be saved to the database
     * (Requirement 5.1.0)
     */
    @Override
    public boolean saveDay(Day day) {
        String sql = "INSERT OR REPLACE INTO day(dayId, userId, date, totalCal) "+
                "VALUES("+day.getUserId()+","+day.getUserId()+",\'"+day.getDate()+"\',"+day.getTotalCal()+");";;
        return DatabaseManager.executeStatement(sql);
    }

    @Override
    public boolean createNewDay(int userId, String today) {
        String sql = "INSERT INTO day(userId, date) VALUES("+userId+",\'"+today+"\');";
        return DatabaseManager.executeStatement(sql);
    }

    /**
     * Day objects can be deleted from the database
     * (Requirement 5.3.0)
     */
    @Override
    public boolean deleteDay(int dayId) {
        String sql = "DELETE FROM day WHERE dayId = "+dayId+";";
        return DatabaseManager.executeStatement(sql);
    }

    @Override
    public boolean isNewDay(int userId, String today) {
        String sql = "SELECT * From day WHERE userId = "+userId+" AND date = \'"+today+"\';";
        try {
            ResultSet resultSet = DatabaseManager.getResultSet(sql);
            resultSet.next();
            if(resultSet.isAfterLast()){
                resultSet.close();
                System.out.println("It is a new day.");
                return true;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("It is not a new day.");
        return false;
    }

    /**
     * Day objects can be retrieved from the database
     * (Requirement 5.2.0)
     */
    @Override
    public Day getCurrentDay(int userId, String today) {
        String sql = "SELECT * From day WHERE userId = "+userId + " AND date = \'" + today +"\';";
        Day day = new Day();
        try {
            ResultSet resultSet = DatabaseManager.getResultSet(sql);
            resultSet.next();
            day.setUserId(resultSet.getInt("dayId"));
            day.setUserId(resultSet.getInt("userId"));
            day.setTotalCal(resultSet.getInt("totalCal"));
            day.setDate(resultSet.getString("date"));
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("getCurrentDay failed.");
            e.printStackTrace();
            return null;
        }
        System.out.println("getCurrentDay Completed.");
        return day;
    }

    @Override
    public ObservableList<Day> getDayList(int userId) {
        String sql = "SELECT * FROM day WHERE userId = "+userId+";";
        ObservableList<Day> dayList = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = DatabaseManager.getResultSet(sql);
            resultSet.next();
            while(!resultSet.isAfterLast()){
                Day day = new Day();
                day.setUserId(resultSet.getInt("dayId"));
                day.setUserId(resultSet.getInt("userId"));
                day.setDate(resultSet.getString("date"));
                day.setTotalCal(resultSet.getInt("totalCal"));
                dayList.add(day);
                resultSet.next();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dayList;
    }
}
