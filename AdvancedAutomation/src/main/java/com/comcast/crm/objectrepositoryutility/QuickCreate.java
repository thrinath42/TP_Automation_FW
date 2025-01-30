package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickCreate {
	public QuickCreate(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement saveBtn;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
