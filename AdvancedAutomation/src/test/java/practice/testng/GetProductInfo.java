package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;



public class GetProductInfo {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		//capture product info
		try {
			
			String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div/div/a/span/span[2]/span[2]";
			String price=driver.findElement(By.xpath(x)).getText();	
			System.out.println(price);
		} catch (Exception e) {
			driver.findElement(By.xpath("//a[contains(@aria-label,'Go to next page')]")).click();
			String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div/div/a/span/span[2]/span[2]";
			String price=driver.findElement(By.xpath(x)).getText();
			System.out.println(price);
		}
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getRowCount("amazonProduct");
		Object[][] objArr=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) {
			objArr[i][0]=elib.getDataFromExcel("amazonProduct", i+1, 0);
			objArr[i][1]=elib.getDataFromExcel("amazonProduct", i+1, 1);
		}
		return objArr;
	
	}

}
