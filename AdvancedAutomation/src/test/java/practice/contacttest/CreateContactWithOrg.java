package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class CreateContactWithOrg {

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
				Row row = sh.getRow(7);
				String orgname = row.getCell(2).toString() + randomInt;
				String phone = row.getCell(3).toString();
				Sheet sh1 = wb.getSheet("contact");
				String lastName = sh1.getRow(1).getCell(2).toString() + randomInt;
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
				driver.findElement(By.linkText("Organizations")).click();
				Thread.sleep(1000);
				// click on create organization button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				// enter all details create org
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				driver.findElement(By.id("phone")).sendKeys(phone);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(1000);
				// navigate to module
				driver.findElement(By.linkText("Contacts")).click();
				Thread.sleep(1000);
				
				// click on create contact button
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				// enter all details create contact
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				//click on org
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				//switch to child
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				while(it.hasNext()) {
					String windowID = it.next();
					driver.switchTo().window(windowID);
					
					String actUrl=driver.getCurrentUrl();
					if(actUrl.contains("Popup&popuptype"))
						break;
				}
				driver.findElement(By.name("search_text")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				
				//switch to parent
				Set<String> set1 = driver.getWindowHandles();
				Iterator<String> it1 = set1.iterator();
				while(it1.hasNext()) {
					String windowID1 = it1.next();
					driver.switchTo().window(windowID1);
					
					String actUrl1=driver.getCurrentUrl();
					
					if(actUrl1.contains("Contacts&action"))
						
						break;
				}				
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
				//Verify org came in contacts page
				String actOrg = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if (actOrg.contains(orgname)) {
					System.out.println(orgname + " is created==pass");
					System.out.println(lastName+ " is created==pass");
				} else {
					System.out.println(orgname + " is not created==fail");
				}
				

				driver.quit();



	}

}
