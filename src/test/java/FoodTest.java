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
    private Food food2 = new Food();

    @Before
    public void initFood(){
        food1.setFg("food");
        food1.setName("Tato");
        food1.setNdbno("123");
        food1.setkCal(100);
        food2.setFg("food2");
        food2.setName("Tato2");
        food2.setNdbno("1233");
        food2.setkCal(100);
    }
    @Test
    public void getFoods(){
        assertEquals("food",food1.getFg());
        assertEquals("Tato",food1.getName());
        assertEquals("123", food1.getNdbno());
        assertEquals(100, food1.getkCal(), 0);
    }
    @Test
    public void modifyFoods(){
        food1.setFg("food1");
        food1.setName("Tato1");
        food1.setNdbno("1231");
        food1.setkCal(101);
        assertEquals("food1",food1.getFg());
        assertEquals("Tato1",food1.getName());
        assertEquals("1231", food1.getNdbno());
        assertEquals(101, food1.getkCal(), 0);
    }
    @Test
    public void multipleFoods(){
        assertNotNull(food1);
        assertNotNull(food2);
    }
    @Test
    public void toStringTest(){
        assertEquals("Ndbno: "+food1.getNdbno()+"\n"+"Name: "+food1.getName()+"\n"+"Group: "+food1.getFg()+"\n"+"kCal: "+food1.getkCal()+"/100g\n", food1.toString());
    }

}
