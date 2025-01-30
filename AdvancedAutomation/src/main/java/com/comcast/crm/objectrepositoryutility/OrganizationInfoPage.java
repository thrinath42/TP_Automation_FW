package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneField;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryfd;
	
	@FindBy(id="dtlview_Type")
	private WebElement typefd;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement organizationfield;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getIndustryfd() {
		return industryfd;
	}

	public WebElement getTypefd() {
		return typefd;
	}

	public WebElement getOrganizationfield() {
		return organizationfield;
	}
		
}
