package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int randonNumber=random.nextInt(50000);
		return randonNumber;
	}
	
	public String getSystemDateYYYYDDMM() {
		Date dateobj=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateobj);
		return date;
	}
	public String getRequiredDateYYYYDDMM(int days) {
		Date obj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
		
		String date=sim.format(obj);
		
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		
		return reqDate;
		
		
	}
}
