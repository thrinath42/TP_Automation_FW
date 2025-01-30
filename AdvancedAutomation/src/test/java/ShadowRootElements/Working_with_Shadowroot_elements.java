package ShadowRootElements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_with_Shadowroot_elements {

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoapps.qspiders.com/ui?scenario=1");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//section[contains(text(),'Shadow')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//section[contains(text(),'Shadow')])[2]")).click();
			Thread.sleep(2000);
			//identify shadow host for user name
			SearchContext shadowHost = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
			shadowHost.findElement(By.cssSelector("input[type='text']")).sendKeys("3nath");
			//identify host for password
			SearchContext shadowhost2 = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
			shadowhost2.findElement(By.cssSelector("input[type='text']")).sendKeys("Thiruveedhula");

	}

}
