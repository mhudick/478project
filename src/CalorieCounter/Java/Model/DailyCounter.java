package CalorieCounter.Java.Model;

/**
 * Created by Mike on 10/3/2015.
 */
public class DailyCounter {
    private double dailyTotal, runningTotal, goal;
    private boolean overBudget;
    private int daysNotOverBudget, totalDaysLogged;

    public double getDailyTotal() {
        //will need SQL logic to SUM(calories) from how we are saving foods
        return dailyTotal;
    }

    public double getRunningTotal() {
        //runningTotal = SELECT SUM(dailyTotal) from DailyCounter;
        return runningTotal;
    }

    public double getGoal(){
        return goal;
    }

    public boolean overBudgetChecker(double dailyTotal, double goal){
        return dailyTotal > goal;
    }

    public int setDaysNotOverBudget(int daysNotOverBudget, double dailyTotal, double goal){
        //daysNotOverBudget = SQL statement to COUNT database records where dailyTotal <= goal
        //SELECT COUNT dailyTotal, goal FROM DailyCounter where dailyTotal <= goal;
        return daysNotOverBudget;
    }

    public int setTotalDays(int totalDaysLogged){
        //totalDaysLogged = SQL statement to COUNT database records where record != NULL
        //SELECT COUNT dailyTotal from DailyCounter;
        return totalDaysLogged;
    }
}
