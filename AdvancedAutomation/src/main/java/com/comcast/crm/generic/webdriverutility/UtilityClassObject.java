package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest>test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver>driver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() 		//this method will give the extent report object for multiple threads.
	{				//When u achieve parallel execution,Even though it is static variable this method will share the object by taking help of threadlocal
		return test.get();
	}
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	
}
