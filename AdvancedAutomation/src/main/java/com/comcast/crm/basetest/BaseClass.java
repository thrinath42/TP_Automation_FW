package com.comcast.crm.basetest;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
		public DataBaseUtility dLib=new DataBaseUtility();
		public FileUtility fLib=new FileUtility();
		public ExcelUtility eLib=new ExcelUtility();
		public JavaUtility jLib= new JavaUtility();
		public WebDriverUtility wLib=new WebDriverUtility();
		
		public WebDriver driver=null;
		
		public String URL;
		public String UN;
		public String PWD;
		
		@BeforeSuite(groups= {"smokeTest","regressionTest"})
			public void configBS() throws SQLException {
			System.out.println("====connect to DB, Report Config====");
			dLib.getDbConnection();
		}
		
		@Parameters("Browser")
		@BeforeClass(groups= {"smokeTest","regressionTest"})		
			public void configBC(@Optional("chrome") String browser) throws IOException {
			System.out.println("===launch the browser===");
		//	String Browser = fLib.getDataFromProperties("browser");
			String Browser = browser;
			if (Browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (Browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (Browser.equals("edge")) {
				driver = new EdgeDriver();
			}
			
			UtilityClassObject.setDriver(driver);
		}
		
		@BeforeMethod(groups= {"smokeTest","regressionTest"})
		public void configBM(XmlTest test) throws IOException {
			LoginPage lp=new LoginPage(driver);
			System.out.println("===Login===");
			try {
				URL= test.getParameter("url");
				UN=  test.getParameter("un");
				PWD= test.getParameter("pwd");
				lp.loginToApp(URL, UN, PWD);
				System.out.println("common data fetched from xml file");
			} catch (Exception e) {
				e.printStackTrace();
				URL= fLib.getDataFromProperties("url");
				UN= fLib.getDataFromProperties("un");
				PWD= fLib.getDataFromProperties("pwd");
				System.out.println("common data fetched from Property file");
				lp.loginToApp(URL, UN, PWD);
			}
			
			System.out.println("==Logined==");
		}
		
		@AfterMethod(groups= {"smokeTest","regressionTest"})
		public void configAM() {
			System.out.println("==Logout==");
			HomePage hp=new HomePage(driver);
			hp.logout();
		}
		
		@AfterClass(groups= {"smokeTest","regressionTest"})
		public void configAC() {
			System.out.println("===close the browser");
			driver.quit();
		}
		
		@AfterSuite(groups= {"smokeTest","regressionTest"})
		public void configAS() throws SQLException {
			System.out.println("====close DB, Report backup====");
			dLib.closeDbConnection();
		}

}
