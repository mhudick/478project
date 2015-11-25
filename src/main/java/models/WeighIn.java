package models;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Philip on 10/22/2015.
 */
public class WeighIn {
    int WeighId, userId;
    double weight;
    Date date;

    public WeighIn(){
        System.out.println("WeighIn Constructor.");
        date = Calendar.getInstance().getTime();
        System.out.println("Date set to: " + date);
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
