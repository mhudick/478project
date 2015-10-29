package models;

/**
 * Created by Phil on 9/28/2015.
 */
public class User {
    private int id;
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;
    private int dailyCalorieCount;
    private int dailyCalorieGoal;
    private int lbs;
    private int lbsGoal;

    public User(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDailyCalorieCount() {
        return dailyCalorieCount;
    }

    public void setDailyCalorieCount(int dailyCalorieCount) {
        this.dailyCalorieCount = dailyCalorieCount;
    }

    public int getLbsGoal() {
        return lbsGoal;
    }

    public void setLbsGoal(int lbsGoal) {
        this.lbsGoal = lbsGoal;
    }

    public int getLbs() {
        return lbs;
    }

    public void setLbs(int lbs) {
        this.lbs = lbs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(int dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public String getName() {
        return name;
    }
}
