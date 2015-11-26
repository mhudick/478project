package util.database;

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
        DatabaseManager.executeStatment(sql);
        return true;
    }

    @Override
    public boolean saveNewDay(Day day) {
        String sql = "INSERT INTO day(userId, date, totalCal) "+
                "VALUES("+day.getUserId()+",\'"+day.getDate()+"\',"+day.getTotalCal()+");";
        DatabaseManager.executeStatment(sql);
        return false;
    }

    @Override
    public boolean deleteDay(int id) {
        String sql = "DELETE FROM day WHERE dayId = "+id+";";
        DatabaseManager.executeStatment(sql);
        return true;
    }

    @Override
    public boolean isNewDay(int userId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(Calendar.getInstance().getTime());
        String sql = "SELECT * From day WHERE userId = "+userId+" AND date = \'"+today+"\';";
        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            resultSet.next();
            if(resultSet.isAfterLast()){
                resultSet.close();
                return true;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Day getCurrentDay(int userId, String today) {
        String sql = "SELECT * From day WHERE userId = "+userId+" AND date = \'"+today+"\';";
        Day day = new Day();
        ResultSet resultSet = DatabaseManager.getResultSet(sql);
        try {
            resultSet.next();
            day.setId(resultSet.getInt("dayId"));
            day.setUserId(resultSet.getInt("userId"));
            day.setTotalCal(resultSet.getInt("totalCal"));
            day.setDate(resultSet.getString("date"));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return day;
    }
}