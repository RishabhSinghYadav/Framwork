package com.framwork.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public void ConfigDataProvider() {//constructor help us to initialize variable n objects
		
		File src=new File("./Config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Not able to load config file "+e.getMessage());
			
		}
		
		
	}
	
	public String getDataFromConfig(String KeyToSearch) {
		pro=new Properties();
		return pro.getProperty(KeyToSearch);
		
	}
	
	public String getBrowser() {//get browser name from config.properties file
		pro=new Properties();
	return pro.getProperty("Browser");
	}
	
	public String getStagingURL() {	//get qaURl name from config.properties file
		pro=new Properties();
		return pro.getProperty("qaURL");
		}
}
