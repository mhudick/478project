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
       // String[] a = {"1","2","3"};
       // ArrayList<String> b = new ArrayList<String>();
       // for ( String str : a ) {
       //    b.add(str);
       // }

        response.setGroup("string");
        response.setQ("Q");
        response.setSort("sort");
       // response.setItem(b);
    }
    @Test
    public void getSearchResponseTest(){
        assertEquals("string", response.getGroup());
        assertEquals("Q",response.getQ());
        assertEquals("sort",response.getSort());
    }
}
