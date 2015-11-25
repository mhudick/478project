package controllers;

import models.Day;
import models.User;
import util.database.DayData;
import util.database.DayDataImpl;
import util.database.UserData;
import util.database.UserDataImpl;

/**
 * Created by Phil on 11/3/2015.
 */
public class UserManager {
    User user;
    DayData dayData = new DayDataImpl();
    UserData userData = new UserDataImpl();
    Day currentDay;

    public UserManager(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        setCurrentDay();
        //currentDay.setDate("2015-11-23");
        //currentDay.setTotalCal(30000);
        dayData.saveDay(currentDay);
        userData.saveUser(user);
        setCurrentDay();
        System.out.println(currentDay.toString());

    }
    private void setCurrentDay(){
        currentDay = dayData.getCurrentDay(user);
    }

    public String getCaloriesAvailable(){
        return String.valueOf((user.getDailyCalorieLimit()-currentDay.getTotalCal()));
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
