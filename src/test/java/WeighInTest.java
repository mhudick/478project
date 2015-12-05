import models.WeighIn;
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
public class WeighInTest {

    private WeighIn weight = new WeighIn();

    @Before
    public void initWeightIn(){
        weight.setDate("12/10/2000");
        weight.setUserId(1);
        weight.setWeighId(1);
        weight.setWeight(200);
    }

    @Test
    public void getWeightInTest(){
        assertEquals("12/10/2000", weight.getDate());
        assertEquals(1, weight.getUserId(), 0);
        assertEquals(1, weight.getWeighId(), 0);
        assertEquals(200, weight.getWeight(), 0);
    }
    @Test
    public void modifyWeightIn(){
        weight.setDate("12/11/2000");
        weight.setUserId(11);
        weight.setWeighId(11);
        weight.setWeight(2001);
        assertEquals("12/11/2000", weight.getDate());
        assertEquals(11, weight.getUserId(), 0);
        assertEquals(11, weight.getWeighId(), 0);
        assertEquals(2001, weight.getWeight(), 0);
    }
}
