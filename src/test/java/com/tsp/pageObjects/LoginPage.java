package com.tsp.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsp.testCases.BaseClass;


public class LoginPage extends BaseClass {
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoginPage(WebDriver rdriver) 
	{
		
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(driver, 10);
		

	}
	
	
	@FindBy (id = "hero-banner-sign-in-to-office-365-link")
	private
	WebElement signInBtn;
	
	@FindBy (id = "i0116")
	private
	WebElement userName;
	
	@FindBy (id = "i0118")
	private
	WebElement userPwd;
	
	@FindBy (id = "idSIButton9")
	private
	WebElement nextBtn;
	
	@FindBy (xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/a[1]")
	private
	WebElement skipBtn;
	
	
	
	
public void baseURL() 
	{
			
		driver.get(baseURL);			
	}	
	
public void secondURL() 
{
		
	driver.get(secondURL);			
}

public void signInButton() 
{
		
	wait.until(ExpectedConditions.visibilityOf(signInBtn));
	signInBtn.click();
		
}

public void nextButton() 
{
	
	wait.until(ExpectedConditions.visibilityOf(nextBtn));
	nextBtn.click();
	
}


public void enterUserName(String uname) 
{
	wait.until(ExpectedConditions.visibilityOf(userName));
	userName.sendKeys(uname);
}

public void enterUserPassword(String pwd) {
	wait.until(ExpectedConditions.visibilityOf(userPwd)).sendKeys(pwd);
}

public void skipBtn() {
	wait.until(ExpectedConditions.visibilityOf(skipBtn)).click();
}
	
	
	
}
