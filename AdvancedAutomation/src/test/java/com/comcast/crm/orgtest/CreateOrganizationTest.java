package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.collections4.functors.IfClosure;
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
import org.openqa.selenium.interactions.Actions;
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
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups={"smokeTest","regressionTest"})
	public void createOrganizationTest() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org2", 7, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org2", 4, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create org page");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry);
		UtilityClassObject.getTest().log(Status.INFO, "New Organization created");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		wLib.validateUsingHardAssert(actorgName, orgName);
	}

	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNumber()
			throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org2", 7, 2) + jLib.getRandomNumber();
		String phone = eLib.getDataFromExcel("org2", 7, 3);
		UtilityClassObject.getTest().log(Status.INFO, "Login to application");
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		// navigate to module
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to org page");
		Thread.sleep(1000);
		// click on create organization button
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create org page");
		// enter all details create org
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getPhoneEdt().sendKeys(phone);
		cnop.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "New Organization "+orgName+" created");
		// Verify phone number info Exepected Result
		String actPhone = oip.getPhoneField().getText();
		wLib.validateUsingHardAssert(actPhone, phone);
	}

	@Test(groups="regressionTest")
	public void createOrganizationWithIndustry() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org2", 7, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org2", 4, 3);
		String type = eLib.getDataFromExcel("org2", 4, 4);
		UtilityClassObject.getTest().log(Status.INFO, "Login to application");
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

// navigate to module
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to org page");
// click on create organization button
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create org page");
// enter all details create org
		cnop.getOrgNameEdt().sendKeys(orgName);
// select the Industry from dropdrown		
		wLib.select(cnop.getIndustryDB(), industry);
		wLib.select(cnop.getTypeDB(), type);
		cnop.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "New Organization created");
// Verify the industries and type info
		String actIndustries = oip.getIndustryfd().getText();
		wLib.validateUsingSoftAsset(actIndustries, industry);
		String actType = oip.getTypefd().getText();
		wLib.validateUsingHardAssert(actType, type);
		wLib.assertAllSoft();
	}

	@Test(groups="regressionTest")
	public void createOrganizationAndDelete() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org2", 10, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org2", 4, 3);
		
		// navigate to module
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Login to application");
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to org page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create org page");
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry);
		UtilityClassObject.getTest().log(Status.INFO, "New Organization created");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actorgName=oip.getHeaderMsg().getText();
		wLib.validateUsingHardAssert(actorgName, orgName);
		
		//go back to org page
		hp.getOrgLink().click();
		
		//search for organization and delete it
		op.getSearchEdt().sendKeys(orgName);
		wLib.select(op.getSearchDD(), "Organization Name");
		op.getSubmitBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();	//dynamic element using pom we cannot store these	
		wLib.switchToAlertAndAccept(driver);
	}
}