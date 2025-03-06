package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.FinanceLib;
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
import org.testng.asserts.SoftAssert;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.organizationChild;


@Listeners(ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {
	@Test(groups="smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		
		ContactPage cp = new ContactPage(driver);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact module");
		// click on create organization button
		cp.getCreateContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new contact page");
		// enter all details create org
		cncp.createContact(lastName);
		UtilityClassObject.getTest().log(Status.INFO, "New contact "+lastName+ " created");
		// Verify Header message Exepected Result
		String actName = cip.getLastNameField().getText();
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actName, lastName);
		Reporter.log("Validated Successfully",true);
		
		String actHeading=cip.getHeaderText().getText();
		wLib.validateUsingHardAssert(actHeading, lastName);
		Reporter.log("Validated Successfully",true);
		soft.assertAll();
		}

	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest()
			throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);

		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact module");
		cp.getCreateContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new contact page");

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
		cncp.getLastName().sendKeys(lastName);
		cncp.getStartDate().clear();
		cncp.getStartDate().sendKeys(startDate);
		cncp.getEndDate().clear();
		cncp.getEndDate().sendKeys(endDate);
		cncp.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "New contact "+lastName+ " created with StartDate and EndDate");
		// Verify Startdate Exepected Result
		String actstartDate = cip.getStartDateField().getText();
		wLib.validateUsingHardAssert(actstartDate, startDate);
		// Verify Enddate Exepected Result
		String actEndDate = cip.getEndDateField().getText();
		wLib.validateUsingHardAssert(actEndDate, endDate);
	}

	@Test(groups="regressionTest")
	public void createContactWithOrganizationTest()
			throws EncryptedDocumentException, IOException, InterruptedException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org2", 7, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		organizationChild opc = new organizationChild(driver);

		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org module");

		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new Org page");
		
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getSaveBtn().click();
		// navigate to module
		Thread.sleep(2000);
		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact module");
		// click on create organization button
		cp.getCreateContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new contact page");
		// enter all details create contact
		cncp.getLastName().sendKeys(lastName);
		// click on org
		cncp.getOrgBtn().click();

		// switch to child
		wLib.switchToNewTab(driver, "Popup&popuptype");
		opc.getSearchEdt().sendKeys(orgName);
		opc.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent
		wLib.switchToNewTab(driver, "Contacts&action");
		cncp.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "New contact "+lastName+ " created with "+orgName);
		// Verify org came in contacts page
		String actOrg = cip.getOrgName().getText();
		wLib.validateUsingHardAssert(actOrg, orgName);
		
	}
}