package practice.mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class selfinalmock030225 {
	
	@Test
	public void clinique() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.clinique.in/");
		
		
		Actions act=new Actions(driver);
		WebElement skincare = driver.findElement(By.partialLinkText("Skincare"));
		act.moveToElement(skincare).perform();
		Thread.sleep(2000);
		System.out.println("===list of products===");
		List<WebElement> products = driver.findElements(By.xpath("//a[contains(text(),'All Skincare')]/..//a[@class='gnav-desktop-sub-nav-item-text']"));
		for(WebElement prod : products) {
			Reporter.log(prod.getText(),true);
		}
		driver.quit();
	}

}
