package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HpzLogin extends HpzCredentials{

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.get("https://www.shoppersstack.com/");
			driver.findElement(By.name("loginBtn")).click();
		
			driver.findElement(By.name("Email")).sendKeys(username);
			driver.findElement(By.name("Password")).sendKeys(pwd);
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Hello')]"))));
			driver.findElement(By.name("men")).click();
			driver.findElement(By.xpath("//div[contains(@class,'MuiAvatar-root MuiAvatar-circular')]")).click();
			driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[7]")).click();
			Thread.sleep(2000);
			System.out.println("====execution done successfully=====");
			driver.quit();
	}

}
