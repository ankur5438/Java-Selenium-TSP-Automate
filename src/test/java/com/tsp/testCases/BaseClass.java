package com.tsp.testCases;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String baseURL = "https://www.office.com/";
	public String secondURL = "https://tsptesting.sharepoint.com/sites/tsp/TSP";
	public String userName = "ankur@tsptesting.onmicrosoft.com";
	public String userPassword = "Laptop5438#";
	public static WebDriver driver;
	
	
	
	@BeforeClass
	public void setup () 
	
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() 
	{
		
		driver.quit();
	}
	

}
