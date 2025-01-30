package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{							//Rule-1 create a separete java class
								
	WebDriver driver;
	public LoginPage(WebDriver driver) {			//Rule-3 Object Intialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")						//Rule-2 Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
								

															//Rule-4 object Encapsulation
	public void setUsernameEdt(WebElement usernameEdt) {	//Rule-4 object Utiliazation
		this.usernameEdt = usernameEdt;
	}

	public void setPasswordEdt(WebElement passwordEdt) {
		this.passwordEdt = passwordEdt;
	}

	public void setLoginBtn(WebElement loginBtn) {
		LoginBtn = loginBtn;
	}
	
	//Rule-5 provide Action
	public void loginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		LoginBtn.click();
	}
	
}
