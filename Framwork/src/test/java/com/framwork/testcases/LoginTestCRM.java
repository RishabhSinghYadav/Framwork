package com.framwork.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framwork.pages.BaseClass;
import com.framwork.pages.LoginPage;
import com.framwork.utility.Browserfactory;
import com.framwork.utility.ExcelDataProvider;
import com.aventstack.extentreports.ExtentTest;

public class LoginTestCRM extends BaseClass{
	
	
	
	@Test(priority=1)
	public void LoginApp() {
		
		logger =report.createTest("Login to CRM");
		
		//ExcelDataProvider excel = new ExcelDataProvider();//sent it to base class 
		//excel.getStringData("Login", 0, 0);
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);//page factory loginpage class me jake sab elements ko initialize karke page object ko return karega.
		//loginpage.LoginToCRM("Admin1","admin1231");
		logger.info("Starting Application");
		
		loginpage.LoginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));//here we change above line with parameters
		
		logger.pass("Login success");
		
	}
	@Test(priority=2)
	public void LogoutApp() {
		logger =report.createTest("Logout to CRM");
		logger.fail("Login failed");
	}
}

