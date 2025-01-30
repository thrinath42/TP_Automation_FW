package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	
	public void createContact(String lastNamev) {
		lastName.sendKeys(lastNamev);
		saveBtn.click();
	}	
}
