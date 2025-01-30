package practice.product;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ProductIfoPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;
import com.comcast.crm.objectrepositoryutility.createProductPage;

@Listeners(ListenerImplementationClass.class)
public class CreateProducttest extends BaseClass{
		@Test
		public void createProduct() throws InterruptedException, EncryptedDocumentException, IOException {
			String prodname = eLib.getDataFromExcel("product", 1, 2)+jLib.getRandomNumber();
			UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
			HomePage hp=new HomePage(driver);
			ProductPage pp=new ProductPage(driver);
			createProductPage cp=new createProductPage(driver);
			ProductIfoPage cip=new ProductIfoPage(driver);
			
			hp.getProductLink().click();
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to product module");
			Thread.sleep(2000);
			pp.getCreateProductBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new product page");
			cp.getProductName().sendKeys(prodname);
			cp.getSaveBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "New product "+prodname+ " created");
			//Verify Header orgname info expected result			
			String Header = cip.getHeader().getText();
			wLib.validateUsingHardAssert(Header, prodname);
			//Verify orgname field info expected result
			String actProdName = cip.getProductField().getText();
			wLib.validateUsingHardAssert(actProdName, prodname);
		}
		@Test
		public void createProductAndSearch() throws InterruptedException, EncryptedDocumentException, IOException {
			String prodname = eLib.getDataFromExcel("product", 1, 2)+jLib.getRandomNumber();
			UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
			HomePage hp=new HomePage(driver);
			ProductPage pp=new ProductPage(driver);
			createProductPage cp=new createProductPage(driver);
			ProductIfoPage cip=new ProductIfoPage(driver);

			hp.getProductLink().click();
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to product module");
			pp.getCreateProductBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new product page");
			cp.getProductName().sendKeys(prodname);
			cp.getSaveBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "New product "+prodname+ " created");
			String Header = cip.getHeader().getText();
			wLib.validateUsingHardAssert(Header, prodname);
						
			hp.getProductLink().click();
			Thread.sleep(2000);
			pp.getSearchField().sendKeys(prodname);
			pp.getSearchBtn().click();
			
			boolean res = driver.findElement(By.xpath("//a[text()='"+prodname+"']")).isDisplayed();
			Assert.assertEquals(res, true);
				driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
		}
		@Test
		public void createProductAndEdit() throws InterruptedException, EncryptedDocumentException, IOException {
			String prodname = eLib.getDataFromExcel("product", 1, 2)+jLib.getRandomNumber();
			UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
			HomePage hp=new HomePage(driver);
			ProductPage pp=new ProductPage(driver);
			createProductPage cp=new createProductPage(driver);
			ProductIfoPage cip=new ProductIfoPage(driver);
			
			hp.getProductLink().click();
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to product module");
			pp.getCreateProductBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new product page");
			cp.getProductName().sendKeys(prodname);
			cp.getSaveBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "New product "+prodname+ " created");
			cip.getEditBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "New product "+prodname+ " opened in edit mode");
			String startDate = jLib.getSystemDateYYYYDDMM();
			String endDate = jLib.getRequiredDateYYYYDDMM(30);
			
			cp.getStartDate().clear();
			cp.getStartDate().sendKeys(startDate);
			cp.getExpiryDate().clear();
			cp.getExpiryDate().sendKeys(endDate);
			UtilityClassObject.getTest().log(Status.INFO, "Added StartDate and EndDate");
			cp.getSaveBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "Saved the changes");
			
			String actstartDate = cip.getStartdate().getText();
			wLib.validateUsingHardAssert(actstartDate, startDate);
			Reporter.log("StartDate Validated",true);
			// Verify Enddate Exepected Result
			String actEndDate = cip.getEnddate().getText();
			wLib.validateUsingHardAssert(actEndDate, endDate);
			Reporter.log("EndDate Validated",true);
		}
}
