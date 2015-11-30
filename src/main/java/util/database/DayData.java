package util.database;

import javafx.collections.ObservableList;
import models.Day;
import models.User;

import java.util.HashMap;

/**
 * Created by Phil on 11/24/2015.
 */
public interface DayData {
    boolean saveDay(Day day);
    boolean createNewDay(int userId, String today);
    boolean deleteDay(int dayId);
    boolean isNewDay(int userId, String today);
    Day getCurrentDay(int userId, String today);
    ObservableList<Day> getDayList(int userId);
}
