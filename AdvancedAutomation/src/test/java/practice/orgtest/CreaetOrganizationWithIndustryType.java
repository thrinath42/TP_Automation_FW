package practice.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreaetOrganizationWithIndustryType {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// Generate random numbers
		Random random = new Random();
		int randomInt = random.nextInt(1000); // to set upper limit for a random number

		FileInputStream fis = new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fis1 = new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org2");
		Row row = sh.getRow(4);
		String orgname = row.getCell(2).toString() + randomInt;
		String industry = row.getCell(3).toString();
		String type = row.getCell(4).toString();

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
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		// click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// enter all details create org
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		// select the Industry from dropdrown
		WebElement industryD = driver.findElement(By.name("industry"));
		Select sel = new Select(industryD);
		sel.selectByVisibleText(industry);

		WebElement typeD = driver.findElement(By.name("accounttype"));
		Select sel1 = new Select(typeD);
		sel1.selectByVisibleText(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify the industries and type info
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustries.contains(industry)) {
			System.out.println(industry + " is created==pass");
		} else {
			System.out.println(industry + " is not created==fail");
		}
		
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.contains(type)) {
			System.out.println(type + " is created==pass");
		} else {
			System.out.println(type + " is not created==fail");
		}

		// logout
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
