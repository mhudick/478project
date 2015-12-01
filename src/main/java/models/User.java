package models;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This Class is the data model for the User object. The user object
 * contains 6 fields. UserId, dailyCalorieLimit, name, weightCurrent,
 * weightStart, and weightGoal.
 */

public class User {

    /**
     * User profiles should contain multiple fields of data
     * (Requirement 2.1.0)
     */
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

    /**
     * User should have a name
     * (Requirement 2.1.1)
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * User should have a calorie limit
     * (Requirement 2.1.5)
     */
    public int getDailyCalorieLimit() {
        return dailyCalorieLimit;
    }

    public void setDailyCalorieLimit(int dailyCalorieLimit) {
        this.dailyCalorieLimit = dailyCalorieLimit;
    }

    /**
     * User should have a goal weight
     * (Requirement 2.1.4)
     */
    public double getWeightCurrent() {
        return weightCurrent;
    }

    public void setWeightCurrent(double weightCurrent) {
        this.weightCurrent = weightCurrent;
    }

    /**
     * User should have a starting weight
     * (Requirement 2.1.2)
     */
    public double getWeightStart() {
        return weightStart;
    }

    public void setWeightStart(double weightStart) {
        this.weightStart = weightStart;
    }

    /**
     * User should have a goal weight
     * (Requirement 2.1.3)
     */
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
