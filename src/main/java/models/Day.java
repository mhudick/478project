package models;

/* Developer: Philip Churchill
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

/**
 * This Class is the data model for the Day object. It will keep track
 * of 4 fields.
 */

public class Day {

    private int dayId, totalCal, userId;

    private String date;

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalCal() {
        return totalCal;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public void setTotalCal(int totalCal) {
        this.totalCal = totalCal;
    }

    @Override
    public boolean equals(Object other){
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (!(other instanceof Day))
            return false;
        Day otherDay = (Day)other;
        if(this.dayId == otherDay.getDayId()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + dayId +
                ", totalCal=" + totalCal +
                ", userId=" + userId +
                ", date=" + date +
                '}';
    }

}
