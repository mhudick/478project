package controllers;

import models.Day;
import models.User;
import util.database.DayData;
import util.database.DayDataImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by Phil on 11/3/2015.
 */
public class SessionManager {

    private String today;
    private User currentUser;
    private Day currentDay;
    private DayData dayData = new DayDataImpl();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public SessionManager(){
        today = simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public User getUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        setCurrentDay();
    }
    public Day getCurrentDay() {
        return currentDay;
    }

    private void setCurrentDay(){
        if(dayData.isNewDay(currentUser.getUserId(),today)){
            dayData.createNewDay(currentUser.getUserId(),today);
        }
        currentDay = dayData.getCurrentDay(currentUser.getUserId(),today);
    }

    public String getCaloriesAvailable(){
        return String.valueOf((currentUser.getDailyCalorieLimit()-currentDay.getTotalCal()));
    }

    public void addCaloriesToDay(int kCal){
        System.out.println("Adding "+kCal+" calories to currentDay");
        currentDay.setTotalCal(currentDay.getTotalCal()+kCal);
        dayData.saveDay(currentDay);
    }

}
