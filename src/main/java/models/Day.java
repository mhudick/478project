package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Philip on 10/17/2015.
 */
public class Day {

    private int id, totalCal, userId;

    private String date;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private List<String> calEntries = new ArrayList<>();

    public Day(){
        System.out.println("Day Constructor.");

    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(int totalCal) {
        this.totalCal = totalCal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", totalCal=" + totalCal +
                ", userId=" + userId +
                ", date=" + date +
                '}';
    }

}
