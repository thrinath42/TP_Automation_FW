package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductIfoPage {
	public ProductIfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement header;
	
	@FindBy(id="dtlview_Product Name")
	private WebElement productField;
	
	@FindBy(xpath = "//input[@name='Edit']")
	private WebElement editBtn;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement startdate;
	
	@FindBy(id="mouseArea_Support Expiry Date")
	private WebElement enddate;
	
	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getProductField() {
		return productField;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}
	
	
}
