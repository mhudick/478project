package controllers;

import models.Day;
import util.database.DayData;
import util.database.DayDataImpl;

import java.util.Calendar;

/**
 * Created by Phil on 11/24/2015.
 */
public class DailyCounter {

    DayData dayData = new DayDataImpl();

    Day currentDay;

    public DailyCounter(){

    }
}
