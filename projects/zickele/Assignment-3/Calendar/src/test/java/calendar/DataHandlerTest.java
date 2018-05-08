
package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import java.util.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{
    Calendar day = Calendar.getInstance();
    int thisMonth = day.get(Calendar.MONTH);
    int thisDay = day.get(Calendar.DAY_OF_MONTH);
    int thisYear = day.get(Calendar.YEAR);
    GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
    GregorianCalendar range1 = new GregorianCalendar(thisYear,thisMonth,thisDay + 1);
    GregorianCalendar range2 = new GregorianCalendar(thisYear,thisMonth + 4,thisDay);
    
	@Test(timeout = 4000)
    public void test00()  throws Throwable  {
        DataHandler dh1 = new DataHandler("temp3.xml");

        Appt appt1 = new Appt(11, 0, 16, 6, 2018, "Graduation", "I'm finally graduating", "xyz@gmail.com");
        Appt appt2 = new Appt(0, 0, 13, 8, 2018, "My Birthday", "'tis my birthday", "xyz@gmail.com");
        Appt appt3 = new Appt(0, 0, 15, 12, 2018, "Vacation", "Off to Mexico", "xyz@gmail.com");
        Appt appt4 = new Appt(0, 0, 1, 1, 2019, "NYE", "Time to party", "xyz@gmail.com");
        Appt appt5 = new Appt(0, 0, 15, 4, 2019, "Tax Day", "Do your taxes", "xyz@gmail.com");
        Appt appt6 = new Appt(0, 0, 1, 20, -100, "negative", "test", "xyz@gmail.com");
        
        appt2.setRecurrence(null, 1, 365, 100);
        appt4.setRecurrence(null, 1, 365, 10000);
        appt5.setRecurrence(null, 1, 365, 10000);

        appt1.setValid();
        appt2.setValid();
        appt3.setValid();
        appt4.setValid();
        appt5.setValid();
        appt6.setValid();
        
        dh1.saveAppt(appt1);
        dh1.saveAppt(appt2);
        dh1.saveAppt(appt3);
        dh1.saveAppt(appt4);
        dh1.saveAppt(appt5);
        dh1.saveAppt(appt6);
	}
}
