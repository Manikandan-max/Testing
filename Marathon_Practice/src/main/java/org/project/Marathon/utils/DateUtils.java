package org.project.Marathon.utils;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getTimeStamp(){
        DateFormat dateFormat=new SimpleDateFormat("dd_MM_yy_HH_mm");
        Date date=new Date();
        return dateFormat.format(date);
    }
}
