package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductPage {
	public createProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="start_date")
	private WebElement startDate;
	
	@FindBy(name="expiry_date")
	private WebElement expiryDate;
	
	@FindBy(id="productcode")
	private WebElement partNumber;
	
	@FindBy(id="commissionrate")
	private WebElement commission;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getExpiryDate() {
		return expiryDate;
	}

	public WebElement getPartNumber() {
		return partNumber;
	}

	public WebElement getCommission() {
		return commission;
	}
	
}
