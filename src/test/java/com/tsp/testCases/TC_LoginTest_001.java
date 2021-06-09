package com.tsp.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tsp.pageObjects.AppHomePage;
import com.tsp.pageObjects.LoginPage;
import com.tsp.pageObjects.UserPanelPage;



public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test(priority=1)
	public void loginTest ()
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.baseURL();							//Open office.com
		lp.signInButton();						//CLick on sign in button
		lp.enterUserName(userName);				//Enter user name
		lp.nextButton();						//Click on Next button
		lp.enterUserPassword(userPassword);		//Enter password
		lp.nextButton();						//Click on Sign in Button
		lp.nextButton();						//Click on Yes button
		lp.secondURL();							//Navigate to TSP App URL
		
		
		if(driver.getTitle().equals("Timesheet Plus - HR365")) {
			
			Assert.assertTrue(true);
		}
		
		else {
			
			Assert.assertTrue(false);
		}
		
		
		
	}
@Test (priority=2)
public void opeUserPanel()
{
	
	AppHomePage hp = new AppHomePage(driver);
	boolean result = hp.openUserPanel();
	Assert.assertTrue(result);
}


@Test (priority=3)
public void addUsers() throws Exception
{
	
	UserPanelPage up = new UserPanelPage(driver);
	boolean result = up.addUser();
	Assert.assertTrue(result);
	
}

@Test (priority = 4)
public void sort() 
{
	UserPanelPage up = new UserPanelPage(driver);
	boolean result = up.sorting();
	Assert.assertTrue(result);
}

@Test (priority = 5)
public void search() throws InterruptedException 
{
	UserPanelPage up = new UserPanelPage(driver);
	boolean result = up.searching();
	Assert.assertTrue(result);
}





}
