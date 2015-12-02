import models.Food;
import static org.junit.Assert.*;
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
public class FoodTest {
    private Food food1 = new Food();

    @Before
    public void initFood(){
        food1.setFg("food");
        food1.setName("Tato");
        food1.setNdbno("123");
        food1.setkCal(100);
       // food1.setNutrientList();
    }
    @Test
    public void getFoods(){
        assertEquals("food",food1.getFg());
        assertEquals("Tato",food1.getName());
        assertEquals("123", food1.getNdbno());
        assertEquals(100, food1.getkCal(), 0);
    }
    @Test
    public void toStringTest(){
        assertEquals("Ndbno: "+food1.getNdbno()+"\n"+"Name: "+food1.getName()+"\n"+"Group: "+food1.getFg()+"\n"+"kCal: "+food1.getkCal()+"/100g\n", food1.toString());
    }

}
