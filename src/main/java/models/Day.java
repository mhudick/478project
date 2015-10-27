package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Philip on 10/17/2015.
 */
public class Day {

    private String creation_date;

    public String setDate(String creation_date){
        creation_date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        return creation_date;
    }
}
