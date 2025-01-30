package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// Generate random numbers
		Random random = new Random();
		int randomInt = random.nextInt(1000); // to set upper limit for a random number

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString() + randomInt;
		wb.close();

		String Browser = prop.getProperty("browser");
		WebDriver driver = null;
		// Runtime Polymorphism example because based on data available in prop file the
		// browser will be lauched
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		// Login to application
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("un"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.id("submitButton")).click();
		// navigate to module
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(1000);
		
		// click on create Contact button		 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		// enter all details create org
		Date dateObj = new Date();			//It will provide raw date and time with timezone
		 
		 SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");			//we can capture date in required format
		 String startDate= sim.format(dateObj); 								//it will format the date to required format
		 
		 
		 Calendar cal = sim.getCalendar();  								//Calender Class provides whole calender details
		 cal.add(Calendar.DAY_OF_MONTH,+30);						//In calender a method called add,inside this there a static variable called Days of month,using this i will specify how many days before or after we want 
		 String endDate = sim.format(cal.getTime());
		 
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Startdate Exepected Result
		String actstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actstartDate.contains(startDate)) {
			System.out.println(startDate + " is created==pass");
		} else {
			System.out.println(startDate + " is not created==fail");
		}
		
		// Verify Enddate Exepected Result
				String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				if (actEndDate.contains(endDate)) {
					System.out.println(endDate + " is created==pass");
				} else {
					System.out.println(endDate + " is not created==fail");
				}

		// logout
//						Actions act = new Actions(driver);
//						act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//						driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
