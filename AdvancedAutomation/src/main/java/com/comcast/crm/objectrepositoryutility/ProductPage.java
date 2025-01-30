package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	String prodname;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductBtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchField;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchBtn;
	

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
