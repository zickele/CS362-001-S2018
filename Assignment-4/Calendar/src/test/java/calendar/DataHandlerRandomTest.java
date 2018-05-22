package calendar;

import java.util.Calendar;
import java.util.Random;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 60 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
			 float probability = (float).5;
			 boolean autoSaveBool = ValuesGenerator.getBoolean(probability, random);	
			DataHandler dh = new DataHandler("testName1",autoSaveBool);
			 int startHour=ValuesGenerator.getRandomIntBetween(random, -2, 24);
			 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 61);
			 int startDay=ValuesGenerator.getRandomIntBetween(random, -5, 32);
			 int startMonth=ValuesGenerator.getRandomIntBetween(random, -2, 12);
			 int startYear=ValuesGenerator.getRandomIntBetween(random, -100, 100000);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
			appt.isOn(startMonth, startDay, startYear);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				
				int year = ValuesGenerator.getRandomIntBetween(random, 1, 2018);
				int month = ValuesGenerator.getRandomIntBetween(random, 0, 11);
				int day = ValuesGenerator.getRandomIntBetween(random, 1, 31);
				GregorianCalendar date1 = new GregorianCalendar(year, month, day);
		
				int year2 = ValuesGenerator.getRandomIntBetween(random, 2020, 2025);
				int month2 = ValuesGenerator.getRandomIntBetween(random, 0, 11);
				int day2 = ValuesGenerator.getRandomIntBetween(random, 1, 31);
				GregorianCalendar date2 = new GregorianCalendar(year2, month2, day2);

				GregorianCalendar CalDay = new GregorianCalendar(startYear, startMonth, startDay);
				
			
				LinkedList<CalDay> caldays = new LinkedList<CalDay>();
				caldays = (LinkedList<CalDay>) dh.getApptRange(date1,date2);
			
				dh.deleteAppt(appt);

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }
	
}
