import models.Day;
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
public class TestDay {

    private Day day = new Day();

    @Before
    public void initDay(){
        day.setDate("12/10/2000");
        day.setDayId(1);
        day.setTotalCal(1000);
        day.setUserId(1);
    }
    @Test
    public void getDayTest(){
        assertEquals("12/10/2000", day.getDate());
        assertEquals(1, day.getDayId(), 0);
        assertEquals(1000, day.getTotalCal(),0);
        assertEquals(1, day.getUserId(), 0);
    }
    @Test
    public void modifyDay(){
        day.setDate("12/11/2000");
        day.setDayId(11);
        day.setTotalCal(11000);
        day.setUserId(11);
        assertEquals("12/11/2000", day.getDate());
        assertEquals(11, day.getDayId(), 0);
        assertEquals(11000, day.getTotalCal(),0);
        assertEquals(11, day.getUserId(), 0);
    }



}
