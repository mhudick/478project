import models.SearchResponse;
import org.junit.Before;
import org.junit.Test;
import util.database.DayData;
import util.database.DayDataImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;
/**
 * Created by Mike on 11/25/2015.
 */
public class SearchResponseTest {
    private SearchResponse response = new SearchResponse();
    @Before
    public void initSearchResponse(){
        response.setGroup("string");
        response.setQ("Q");
        response.setSort("sort");
    }
    @Test
    public void getSearchResponseTest(){
        assertEquals("string", response.getGroup());
        assertEquals("Q",response.getQ());
        assertEquals("sort",response.getSort());
    }
    @Test
    public void modifyResponse(){
        response.setGroup("string1");
        response.setQ("Q1");
        response.setSort("sort1");
        assertEquals("string1", response.getGroup());
        assertEquals("Q1",response.getQ());
        assertEquals("sort1",response.getSort());
    }
}
