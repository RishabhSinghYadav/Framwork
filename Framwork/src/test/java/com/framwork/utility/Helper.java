package com.framwork.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshots,alert,frames,window,sync issue, js excutor
	
	public static String captureSreenshots(WebDriver driver) {//we make it static coz no need to create object and use anytime this methoda
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/OrangeCRM_"+getCurrentDateTime()+".png";
		//String screenshotPath="./Screenshots/OrangeCRM_"+getCurrentDateTime()+".png";
		
		try {
			//FileHandler.copy(src, new File("./Screenshots/OrangeCRM"+getCurrentDateTime()+".png"));
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("unable to capture screenshot "+e.getMessage());
		}
		return screenshotPath;
		
	}
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("HH_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
	

}
