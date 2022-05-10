package com.framwork.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {

	
	public static WebDriver startApplication(WebDriver driver, String browserName,String appURL) {
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver","./Driver/msedgedriver.exe");
			
			driver = new EdgeDriver();
			
		}
				
		else {
			System.out.println("we do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		
		
		return driver;
		
		
	}
	
	public static void  quitBrowser(WebDriver driver) {
	
		driver.quit();
	}
}
