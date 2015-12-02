import models.Nutrient;
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
public class NutrientTest {
    private Nutrient nutrient = new Nutrient();

    @Before
    public void initNutrient(){
        nutrient.setName("nut");
        nutrient.setUnit("string");
        nutrient.setValue(1);
    }
    @Test
    public void getNutrientTest(){
        assertEquals("nut",nutrient.getName());
        assertEquals("string",nutrient.getUnit());
        assertEquals(1,nutrient.getValue(), 0);
    }
}
