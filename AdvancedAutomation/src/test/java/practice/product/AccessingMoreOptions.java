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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
@Listeners(ListenerImplementationClass.class)
public class AccessingMoreOptions extends BaseClass {
	@Test
	public void moreOptions() throws EncryptedDocumentException, IOException, InterruptedException {
		UtilityClassObject.getTest().log(Status.INFO, "Logging into crm application");
		HomePage hp = new HomePage(driver);
		CampaignsPage cp=new CampaignsPage(driver);

		wLib.mousemoveOnElement(driver, hp.getMoreLink());
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to more link");
		hp.getCampaignMore().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on campaign module");
		Assert.assertEquals(cp.getHeadingField().getText(), "Campaigns");
		UtilityClassObject.getTest().log(Status.INFO, "campaign page loaded");
	}

}
