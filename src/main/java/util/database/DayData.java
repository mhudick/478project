package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This interface provides an easy to insure that the implementing class
 * provides the necessary methods.
 */

import javafx.collections.ObservableList;
import models.Day;


public interface DayData {
    boolean saveDay(Day day);
    boolean createNewDay(int userId, String today);
    boolean deleteDay(int dayId);
    boolean isNewDay(int userId, String today);
    Day getCurrentDay(int userId, String today);
    ObservableList<Day> getDayList(int userId);
}
