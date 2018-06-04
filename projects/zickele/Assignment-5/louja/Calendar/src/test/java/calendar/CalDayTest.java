/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;

public class CalDayTest{

    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH);
    int thisDay = today.get(Calendar.DAY_OF_MONTH);
    int thisYear = today.get(Calendar.YEAR);
    Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
    GregorianCalendar date = new GregorianCalendar(thisYear,thisMonth,thisDay);

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
        CalDay bad = new CalDay();
        CalDay good = new CalDay(date);
        assertTrue(good.isValid());
        assertFalse(bad.isValid());
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
        CalDay day = new CalDay(date);
        assertTrue(day.isValid());
        
        Appt appt1 = new Appt(11, 0, 16, 6, 2018, "Graduation", "I'm finally graduating", "xyz@gmail.com");
        Appt appt2 = new Appt(0, 0, 13, 8, 2018, "My Birthday", "'tis my birthday", "xyz@gmail.com");
        Appt appt3 = new Appt(0, 0, 15, 12, 2018, "Vacation", "Off to Mexico", "xyz@gmail.com");
        Appt appt4 = new Appt(0, 0, 1, 1, 2019, "NYE", "Time to party", "xyz@gmail.com");
        Appt appt5 = new Appt(0, 0, 15, 4, 2019, "Tax Day", "Do your taxes", "xyz@gmail.com");
        
        day.addAppt(appt1);
        day.addAppt(appt2);
        day.addAppt(appt3);
        day.addAppt(appt4);
        day.addAppt(appt5);
   }     
}