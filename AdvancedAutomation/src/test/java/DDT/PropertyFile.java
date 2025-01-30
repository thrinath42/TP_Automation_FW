package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String Browser=prop.getProperty("browser");
		WebDriver driver = null;
		//Runtime Polymorphism example because based on data available in prop file the browser will be lauched
		if(Browser.equals("chrome")) {
			driver= new ChromeDriver();
		}else if (Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}else if (Browser.equals("edge")) {
			driver=new EdgeDriver();			
		}
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("un"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		driver.quit();

	}

}
