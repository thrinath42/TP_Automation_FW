package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(partialLinkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(partialLinkText = "Products")
	private WebElement productLink;
	
	@FindBy(partialLinkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(partialLinkText = "More")
	private WebElement moreLink;
	
	@FindBy(partialLinkText = "Dashboard")
	private WebElement dashBoard;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignMore;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//select[@id='qccombo']")
	private WebElement dropDown;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
		
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getDashBoard() {
		return dashBoard;
	}
	
	public WebElement getCampaignMore() {
		return campaignMore;
	}
	

	public WebElement getDropDown() {
		return dropDown;
	}

	public void navigateToCampaign() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLink.click();
	}
	
}
