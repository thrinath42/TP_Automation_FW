package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Receiver{
	
	@Test(dataProviderClass = DataSender.class, dataProvider = "getProductData")
	public void amazonReceiver(String Brand, String Model) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Brand,Keys.ENTER);
		
		System.out.println(Brand);
		System.out.println(Model);
		String x = "//span[text()='"+Model+"']/../../../..//span[@class='a-price-whole']";
		
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
}