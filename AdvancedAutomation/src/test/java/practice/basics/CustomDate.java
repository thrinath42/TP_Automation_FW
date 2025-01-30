 package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomDate {

	public static void main(String[] args) {
		 Date dateObj = new Date();			//It will provide raw date and time with timezone
		 System.out.println(dateObj);
		 SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");			//we can capture date in required format
		 String actdate= sim.format(dateObj); 								//it will format the date to required format
		 System.out.println(actdate);
		 
		 Calendar cal = sim.getCalendar();  								//Calender Class provides whole calender details
		 cal.add(Calendar.DAY_OF_MONTH,+30);						//In calender a method called add,inside this there a static variable called Days of month,using this i will specify how many days before or after we want 
		 String reqDate = sim.format(cal.getTime());
		 System.out.println(reqDate);;
	
	}
	

}
