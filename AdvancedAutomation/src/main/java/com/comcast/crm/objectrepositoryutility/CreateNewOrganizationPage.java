package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
		
		public CreateNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}		
		
		@FindBy(name="accountname")
		private WebElement orgNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(name="industry")
		private WebElement industryDB;
		
		@FindBy(name="accounttype")
		private WebElement typeDB;
		
		@FindBy(id="phone")
		private WebElement phoneEdt;

		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getIndustryDB() {
			return industryDB;
		}
		
		
		public WebElement getPhoneEdt() {
			return phoneEdt;
		}
		

		public WebElement getTypeDB() {
			return typeDB;
		}

		public void createOrg(String orgName) {
			orgNameEdt.sendKeys(orgName);
			saveBtn.click();
		}
		
		public void createOrg(String orgName,String industry) {
			orgNameEdt.sendKeys(orgName);
			Select sel=new Select(industryDB);
			sel.selectByVisibleText(industry);
			saveBtn.click();
		}
		public void createOrgwithphone(String orgName,String phone) {
			orgNameEdt.sendKeys(orgName);
			phoneEdt.sendKeys(phone);
			saveBtn.click();
		}
}
