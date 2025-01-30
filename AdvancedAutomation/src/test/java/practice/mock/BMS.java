package practice.mock;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BMS {
	@Test
	public void threatres() throws InterruptedException, IOException {
		FileInputStream fis=new FileInputStream("./ConfigAppData/BMS.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String city1 = prop.getProperty("city1");
		String city2 = prop.getProperty("city2");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='"+city1+"']")).click();
		driver.findElement(By.partialLinkText("See All")).click();
		List<WebElement> city1movies=driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 hGuczM']"));
		printmovies(city1movies,city1);
		driver.findElement(By.xpath("//span[text()='"+city1+"']")).click();
		driver.findElement(By.xpath("//span[text()='"+city2+"']")).click();
		List<WebElement> city2movies=driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 hGuczM']"));
		printmovies(city2movies,city2);	
		driver.quit();
	}
	
	public void printmovies(List<WebElement> movies,String city){
		Reporter.log("=================Movies Playing "+city+"=================",true);	
		for(WebElement film: movies) {
			Reporter.log(film.getText(),true);
		}
	}

}
