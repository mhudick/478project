package controllers;

import models.Day;
import models.User;
import util.database.DayData;
import util.database.DayDataImpl;
import util.database.UserData;
import util.database.UserDataImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Phil on 11/3/2015.
 */
public class SessionManager {
    private User currentUser;
    private Day currentDay;
    private DayData dayData = new DayDataImpl();
    private UserData userData = new UserDataImpl();

    public User getUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        setCurrentDay();
    }
    private void setCurrentDay(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(Calendar.getInstance().getTime());
        if(dayData.isNewDay(currentUser.getUserId())){
            Day day = new Day();
            day.setDate(today);
            day.setUserId(currentUser.getUserId());
            dayData.saveNewDay(day);
        }
        currentDay = dayData.getCurrentDay(currentUser.getUserId(), today);
    }

    public String getCaloriesAvailable(){
        return String.valueOf((currentUser.getDailyCalorieLimit()-currentDay.getTotalCal()));
    }

    public void addCaloriesToDay(int kCal){
        System.out.println("Adding calories");
        currentDay.setTotalCal(currentDay.getTotalCal()+kCal);
        System.out.println(currentDay.getTotalCal());
        dayData.saveDay(currentDay);
    }

    public Day getCurrentDay() {
        return currentDay;
    }
}
