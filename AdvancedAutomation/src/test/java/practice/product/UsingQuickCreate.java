package practice.product;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.QuickCreate;


@Listeners(ListenerImplementationClass.class)
public class UsingQuickCreate extends BaseClass{
	@Test
	public void quickCreate() throws IOException, InterruptedException {
		UtilityClassObject.getTest().log(Status.INFO, "Logging into crm application");
		String orgName = eLib.getDataFromExcel("org2", 7, 2)+jLib.getRandomNumber();		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		HomePage hp=new HomePage(driver);
		QuickCreate qc=new QuickCreate(driver);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				
		WebElement quickSelect = hp.getDropDown();
		wLib.selectByValue(quickSelect, "Accounts");
		UtilityClassObject.getTest().log(Status.INFO, "Selecting Accounts from dropdown");
		qc.getOrgName().sendKeys(orgName);
		qc.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "clicking on save button");
		String Header = oip.getOrganizationfield().getText();
		Assert.assertEquals(Header, orgName);
		UtilityClassObject.getTest().log(Status.INFO, "organization got created");
		Reporter.log(orgName +" is created==pass",true);
	}

}
