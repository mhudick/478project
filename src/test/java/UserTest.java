import models.User;
import org.junit.Before;
import org.junit.Test;
import util.database.DayData;
import util.database.DayDataImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;
/**
 * Created by Mike on 11/25/2015.
 */
public class UserTest {
    private User user = new User();

    @Before
    public void initUser(){
        user.setDailyCalorieLimit(1000);
        user.setName("user");
        user.setUserId(1);
        user.setWeightCurrent(235.5);
        user.setWeightGoal(200.01);
        user.setWeightStart(900.6);

    }

    @Test
    public void getUserTest(){
        assertEquals(1000, user.getDailyCalorieLimit(), 0);
        assertEquals("user", user.getName());
        assertEquals(1, user.getUserId(), 0);
        assertEquals(235.5, user.getWeightCurrent(), 0);
        assertEquals(200.01, user.getWeightGoal(), 0);
        assertEquals(900.6, user.getWeightStart(), 0);
    }
}
