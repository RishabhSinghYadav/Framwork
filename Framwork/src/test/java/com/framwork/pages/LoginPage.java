package com.framwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	//this comment for check git
	public void LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
	}

	@FindBy(name="txtUsername") WebElement uname;
	@FindBy(id="txtPassword") WebElement pass ;
	@FindBy(id="btnLogin") WebElement LoginButton;


	public void LoginToCRM(String usernameApplication,String passwordApplication) {
		
		try {
		Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			
		}
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		LoginButton.click();
		
	}
}