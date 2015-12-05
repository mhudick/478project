import models.SearchItem;
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
public class SeachItemTest {

    private SearchItem item = new SearchItem();
    @Before
    public void initSearchItem(){
        item.setGroup("food");
        item.setName("tato");
        item.setNdbno("1");
    }
    @Test
    public void getSearchItemTest(){
      assertEquals("food", item.getGroup());
      assertEquals("tato",item.getName());
      assertEquals("1",item.getNdbno());
    }
    @Test
    public void modifySearchItem(){
        item.setGroup("food1");
        item.setName("tato1");
        item.setNdbno("12");
        assertEquals("food1", item.getGroup());
        assertEquals("tato1",item.getName());
        assertEquals("12",item.getNdbno());
    }
}
