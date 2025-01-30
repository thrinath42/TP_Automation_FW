package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
		WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameField;

	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateField;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateField;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgName;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getStartDateField() {
		return startDateField;
	}

	public WebElement getEndDateField() {
		return endDateField;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getHeaderText() {
		return headerText;
	}
	
	
}
