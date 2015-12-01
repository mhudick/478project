package models;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This Class is the data model for the WeighIn object. The WeighIn object
 * is used to represent a weigh-in event, where the user can keep track of
 * their current weight as they reach their goals.
 */

public class WeighIn {
    int WeighId, userId;
    double weight;
    String date;

    public int getWeighId() {
        return WeighId;
    }

    public void setWeighId(int weighId) {
        WeighId = weighId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
