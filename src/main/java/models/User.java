package models;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Phil on 9/28/2015.
 */
public class User {
    private int UserId, dailyCalorieLimit;
    private String name;
    double weightCurrent, weightStart, weightGoal;

    public User(){
        dailyCalorieLimit = 2000;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        this.UserId = userId;
    }

    public int getDailyCalorieLimit() {
        return dailyCalorieLimit;
    }

    public void setDailyCalorieLimit(int dailyCalorieLimit) {
        this.dailyCalorieLimit = dailyCalorieLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightCurrent() {
        return weightCurrent;
    }

    public void setWeightCurrent(double weightCurrent) {
        this.weightCurrent = weightCurrent;
    }

    public double getWeightStart() {
        return weightStart;
    }

    public void setWeightStart(double weightStart) {
        this.weightStart = weightStart;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", dailyCalorieLimit=" + dailyCalorieLimit +
                ", name='" + name + '\'' +
                ", weightCurrent=" + weightCurrent +
                ", weightStart=" + weightStart +
                ", weightGoal=" + weightGoal +
                '}';
    }
}
