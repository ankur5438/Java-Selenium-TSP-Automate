package com.tsp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppHomePage {
	
	//SETTING ICON IN SIDENAVBAR
	@FindBy (xpath = "//div[@id='settingboardpage']//a")
	private
	WebElement setting;
	
	//SETTING/USER ICON IN SIDENAVBAR
		@FindBy (id = "rolesids")
		private
		WebElement users;
	
		
		WebDriver driver;
		WebDriverWait wait;
		
		
		public AppHomePage(WebDriver rdriver) 
		{
			
			driver = rdriver;
			PageFactory.initElements(rdriver, this);
			wait = new WebDriverWait(driver, 10);
			

		}	
		
	public boolean openUserPanel() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(setting).moveToElement(users).click().build().perform();
		UserPanelPage up = new UserPanelPage(driver);
		return up.isUserPanelOpen();

	}
}
