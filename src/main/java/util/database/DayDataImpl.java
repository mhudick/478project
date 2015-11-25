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
        String sql;
        if(day.isNew()){
            System.out.println("isNew");
            sql = "INSERT INTO day(userId, creation_date, totalCal) "+
                    "VALUES("+day.getUserId()+",\'"+day.getDate()+"\',"+day.getTotalCal()+");";
        }else{
            sql = "INSERT OR REPLACE INTO day(dayId, userId, creation_date, totalCal) "+
                    "VALUES("+day.getId()+","+day.getUserId()+",\'"+day.getDate()+"\',"+day.getTotalCal()+");";
        }

        DatabaseManager.executeStatment(sql);
        return true;
    }

    @Override
    public boolean deleteDay(int id) {
        String sql = "DELETE FROM day WHERE dayId = "+id+";";
        DatabaseManager.executeStatment(sql);
        return true;
    }

    @Override
    public Day getCurrentDay(User user) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(Calendar.getInstance().getTime());
        String sql = "SELECT * From day WHERE userId = "+user.getUserId()+" AND creation_date = \'"+today+"\';";
        System.out.println(sql);
        Day day = new Day();
        ResultSet rs = DatabaseManager.getResultSet(sql);
        try {
            rs.next();
            if(rs.isAfterLast()){
                day.setUserId(user.getUserId());
                day.setDate(today);
                day.setIsNew(true);
            }else{
                System.out.println("Retrieving");
                day.setId(rs.getInt("dayId"));
                day.setUserId(rs.getInt("userId"));
                day.setDate(rs.getString("creation_date"));
                day.setTotalCal(rs.getInt("totalCal"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return day;
    }
}
