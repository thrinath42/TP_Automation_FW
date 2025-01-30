package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='dashboard_combo']")
	private WebElement dropDown;
	@FindBy(xpath="//span[text()='Products by Category']")
	private WebElement heading;
	public WebElement getDropDown() {
		return dropDown;
	}
	public WebElement getHeading() {
		return heading;
	}
	
}
