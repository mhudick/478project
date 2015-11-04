package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 10/3/2015.
 */
public class DailyCounter {
    private double dailyTotal, runningTotal;
    private boolean overBudget;
    private int daysNotOverBudget, totalDaysLogged;
    private String creation_date;
    List<Day> listDays = new ArrayList();


    public DailyCounter() {


    }

    public double getRunningTotal() {
        //runningTotal = SELECT SUM(dailyTotal) from DailyCounter;
        return runningTotal;
    }

    public boolean overBudgetChecker(double dailyTotal, double goal) {
        return dailyTotal > goal;
    }

    public int setDaysNotOverBudget(int daysNotOverBudget, double dailyTotal, double goal) {
        //daysNotOverBudget = SQL statement to COUNT database records where dailyTotal <= goal
        //SELECT COUNT dailyTotal, goal FROM DailyCounter where dailyTotal <= goal;
        return daysNotOverBudget;
    }

    public int setTotalDays(int totalDaysLogged) {
        //totalDaysLogged = SQL statement to COUNT database records where record != NULL
        //SELECT COUNT dailyTotal from DailyCounter;
        return totalDaysLogged;
    }
}

