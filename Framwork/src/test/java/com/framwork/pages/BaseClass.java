package com.framwork.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.framwork.utility.Browserfactory;
import com.framwork.utility.ConfigDataProvider;
import com.framwork.utility.ExcelDataProvider;
import com.framwork.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter  extent=new ExtentHtmlReporter(new File("./Reports/OrangeCRM"+Helper.getCurrentDateTime()+".html"));// (new File(System.getProperty("user.dir")+"Reports/orangeCRM.html")); 
		//ExtentSparkReporter  extent=new ExtentSparkReporter (new File(System.getProperty("user.dir")+"Reports/orangeCRM"+Helper.getCurrentDateTime()+".html"));
		//ExtentHtmlReporter  extent=new ExtentHtmlReporter (new File(System.getProperty("user.dir")+"Reports/orangeCRM"+Helper.getCurrentDateTime()+".html"));
		
		//we use ExtentSparkReporter of the replcement of ExtentHtmlReporter coz in 5th version its removed
		report=new ExtentReports();
		report.attachReporter(extent);
		

		Reporter.log("Setting Done.. Test can be started", true);
		
	}
	
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url) {
		

		Reporter.log("Trying to start browser, getting application ready", true);
		
		//driver = Browserfactory.startApplication(driver,"Chrome", "https://opensource-demo.orangehrmlive.com");
		driver = Browserfactory.startApplication(driver,browser, url);//we are updating or using it from pom.xml
		//driver = Browserfactory.startApplication(driver,config.getBrowser(), config.getStagingURL());
		

		Reporter.log("Browser and application up and running", true);
	}
	
	@AfterClass
	public void tearDown() {
		

		
		Browserfactory.quitBrowser(driver);
	}
	
	@AfterMethod//this method we are making to take screenshot after run everymethod, if its pass or fail
	public void tearDownMethod(ITestResult result) throws IOException {
		

		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			//Helper.captureSreenshots(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSreenshots(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSreenshots(driver)).build());
		}
		//else if(result.getStatus()==ITestResult.SKIP) {		}
		report.flush();
		

		Reporter.log("Test Completed>>>>>>>> Reports generated", true);
	}

		@AfterClass
        public void ReportAdd()
        {
            System.out.print("Reached report flush");
            report.flush();
        }
	
}
