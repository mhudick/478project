import models.Day;
import org.junit.Before;
import org.junit.Test;
import util.database.DayData;
import util.database.DayDataImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by Philip on 11/28/2015.
 */
public class TestDayDataImpl {

    private Day day1 = new Day();
    private Day day2 = new Day();
    private DayData dayData = new DayDataImpl();

    @Before
    public void initDays(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(Calendar.getInstance().getTime());

        day1.setDate(today);
        day1.setId(1);
        day1.setTotalCal(1500);
        day1.setUserId(1);

        day2.setDate("2015-11-21");
        day2.setId(2);
        day2.setTotalCal(1000);
        day2.setUserId(1);

        dayData.saveDay(day1);
        dayData.saveDay(day2);
    }

    //Requirement: 0.6.1
    @Test
    public void testSaveDay(){
        assertTrue(dayData.saveDay(day1));
    }

    //Requirement: 0.6.2
    @Test
    public void testGetDay() {
        assertEquals(this.day1,dayData.getDay(day1.getId()));
    }

    //Requirement: 0.6.3
    @Test
    public void testDeleteDay(){
        assertTrue(dayData.deleteDay(day2.getId()));
    }

    //Requirement: 0.6.4
    @Test
    public void testGetCurrentDay(){
        assertEquals(dayData.getCurrentDay(day1.getUserId(), day1.getDate()), this.day1);
    }

    //Requirement: 0.6.5
    @Test
    public void testIsNewDay(){
        assertTrue(dayData.isNewDay(day2.getUserId()));
        assertFalse(dayData.isNewDay(day1.getUserId()));
    }
}
