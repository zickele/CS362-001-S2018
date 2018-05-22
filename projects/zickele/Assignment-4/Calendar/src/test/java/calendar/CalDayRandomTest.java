package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import org.junit.Test;

/**
 * Random Test Generator  for CalDay class.
 */



public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

 		 System.out.println("Start testing...");

		  long randomseed =System.currentTimeMillis();
		try{
		    for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 			 Random random = new Random(randomseed);
				 int year = ValuesGenerator.getRandomIntBetween(random, -100, 100000);
				 int month = ValuesGenerator.getRandomIntBetween(random, -10, 12);
				 int day = ValuesGenerator.getRandomIntBetween(random, -20, 32);
	
				 GregorianCalendar calendar = new GregorianCalendar(year, month, day);
				 CalDay calday = new CalDay(calendar);
	
				 int startHour=ValuesGenerator.getRandomIntBetween(random, -2, 24);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 61);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -5, 32);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -2, 12);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -100, 100000);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";
	
				 Appt appt = new Appt(startHour,
				 		 startMinute ,
				 		 startDay ,
				 		 startMonth ,
				 		 startYear ,
				 		 title,
				 		description,
				 		emailAddress);
				 		
				calday.addAppt(appt);
				appt.setValid();		 
	
	 		  	 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 	  		 if((iteration%10000)==0 && iteration!=0 ){
	 					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	 			 }
			 	}
		}catch(NullPointerException e){
			
		} 
	}
}
