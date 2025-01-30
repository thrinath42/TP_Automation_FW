package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// Generate random numbers
		Random random = new Random();
		int randomInt = random.nextInt(1000); // to set upper limit for a random number

		FileInputStream fis = new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fis1 = new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
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
		// click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// enter all details create org
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header message Exepected Result
		String actName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actName.contains(lastName)) {
			System.out.println(lastName + " is created==pass");
		} else {
			System.out.println(lastName + " is not created==fail");
		}

	
		// logout
//				Actions act = new Actions(driver);
//				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//				driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
