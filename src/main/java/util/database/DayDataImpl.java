package util.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Day;
import models.User;

import javax.swing.plaf.synth.SynthStyle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by Phil on 11/24/2015.
 */
public class DayDataImpl implements DayData {

    @Override
    public boolean saveDay(Day day) {
        String sql = "INSERT OR REPLACE INTO day(dayId, userId, date, totalCal) "+
                "VALUES("+day.getId()+","+day.getUserId()+",\'"+day.getDate()+"\',"+day.getTotalCal()+");";;
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save Day");
            return false;
        }
        System.out.println("SaveDay completed");
        return true;
    }

    @Override
    public boolean createNewDay(int userId, String today) {
        String sql = "INSERT INTO day(userId, date) VALUES("+userId+",\'"+today+"\');";
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("createNewDay failed");
            return false;
        }
        System.out.println("createNewDay completed");
        return true;
    }

    @Override
    public boolean deleteDay(int dayId) {
        String sql = "DELETE FROM day WHERE dayId = "+dayId+";";
        try {
            DatabaseManager.executeStatment(sql);
            System.out.println("Day id: "+dayId+" deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Day id: " + dayId + " failed to deleted");
            return false;
        }
        return true;
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


    @Override
    public Day getCurrentDay(int userId, String today) {
        String sql = "SELECT * From day WHERE userId = "+userId+" AND date = \'"+today+"\';";
        Day day = new Day();
        try {
            ResultSet resultSet = DatabaseManager.getResultSet(sql);
            resultSet.next();
            day.setId(resultSet.getInt("dayId"));
            day.setUserId(resultSet.getInt("userId"));
            day.setTotalCal(resultSet.getInt("totalCal"));
            day.setDate(resultSet.getString("date"));
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("getCurrentDay failed.");
            e.printStackTrace();
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
                day.setId(resultSet.getInt("dayId"));
                day.setUserId(resultSet.getInt("userId"));
                day.setDate(resultSet.getString("date"));
                day.setTotalCal(resultSet.getInt("totalCal"));
                dayList.add(day);
                resultSet.next();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayList;
    }
}
