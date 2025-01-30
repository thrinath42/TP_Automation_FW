package practice.product;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.DashboardPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
@Listeners(ListenerImplementationClass.class)
public class AccessingDashboardtest extends BaseClass{
	@Test
	public void dashboard() throws IOException, InterruptedException {
		UtilityClassObject.getTest().log(Status.INFO, "Logging into crm application");
		HomePage hp=new HomePage(driver);
		DashboardPage dp=new DashboardPage(driver);

		Thread.sleep(2000);
		hp.getDashBoard().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on dashboard module");
		Thread.sleep(2000);
		WebElement dropDown = dp.getDropDown();
		wLib.selectByVisibleValue(dropDown, "Products by Category");
		UtilityClassObject.getTest().log(Status.INFO, "changing the dropdown to Products by Category");
		String heading = dp.getHeading().getText();
		Assert.assertEquals(heading, "Products by Category");
		Reporter.log("Graphs Loaded",true);
	}

}
