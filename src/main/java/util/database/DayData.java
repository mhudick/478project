package util.database;

import models.Day;
import models.User;

/**
 * Created by Phil on 11/24/2015.
 */
public interface DayData {
    boolean saveDay(Day day);
    boolean deleteDay(int id);
    Day getCurrentDay(User user);

}
