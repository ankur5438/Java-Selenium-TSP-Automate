package com.tsp.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPanelPage {

	public List <String> expectedList;
	public List<String> actualList;

	//USER PANEL FRAME
	@FindBy (xpath = "//iframe[contains(@src,'Roles.aspx')]")
	private
	WebElement userFrame;
	
	//SELECT ROLE OF USER 
	@FindBy (id = "addrolesedit")
	public
	WebElement selectRole;
	
	// EMPLOYEE NAME COLUMN OF TABLE
	@FindBy (xpath = "//table/tbody/tr/td[2]")
	private
	List <WebElement> userNames;
	
	//ADD BUTTON IN PANEL
	@FindBy (xpath = "/html[1]/body[1]/form[1]/div[12]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]")
	private
	WebElement addButton;
	
	//USER NAME INPUT BOX
	@FindBy (id = "manager0_TopSpan_EditorInput")
	private
	WebElement enterUser;
	
	//PERSON OR GROUP'S FIRST USER
	@FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	WebElement userClick;
	
	
	
	//COLUMN OF EMPLOYEE ROLES
	@FindBy (xpath = "//tbody/tr/td[3]")
	private
	List <WebElement> userRoles;
	
	//EMPLOYEE ROLES HEADER FOR SORTING
	@FindBy (xpath = "//th[contains(text(),'Role')]")
	private
	WebElement userRolesHeader;
	
	//EMPLOYEE NAME HEADER FOR SORTING
	@FindBy (xpath = "//th[contains(text(),'Name')]")
	private
	WebElement userNamesHeader;
	
	
	//EMPLOYEE NAME COLUMN SEARCH BOX
	@FindBy (xpath = "//thead/tr[2]/th[2]/input[1]")
	private
	WebElement searchName;
	
	//EMPLOYEE ROLES COLUMN SEARCH BOX
	@FindBy (xpath = "//thead/tr[2]/th[3]/input[1]")
	private
	WebElement searchRole;
	

	// HOURLY RATE INPUT BOX
	@FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/input[1]")
	private
	WebElement hourlyRate;
	
	//ONSITE RATE HOURLY RATE
	@FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[5]/span[1]/input[1]")
	private
	WebElement onSiteRate;
	
	//SUBMIT BUTTON
	@FindBy (xpath = "(//button[@name='Submit'])[2]")
	private
	WebElement submit;
	
	@FindBy (xpath = "//button[contains(text(),'OK')]")
	private
	WebElement alertButton;
	
	//SWEET ALERT
	@FindBy (id = "swal2-title")
	private
	WebElement alert;
	
	
	//CHECK BOX CORRESPOND TO BABBETE
	@FindBy (xpath = "//td[contains(text(),'Babette H')]/preceding-sibling::td/input")
	private
	WebElement checkboxBabbete;
	
	
	//ROLE CORRESPOND TO BABBETE
	@FindBy (xpath = "//td[contains(text(),'Babette H')]/following-sibling::td[1]")
	private
	WebElement babbeteRole;
	
	//HOURLY RATE CORRESPOND TO BABBETE
	@FindBy (xpath = "//td[contains(text(),'Babette H')]/following-sibling::td[2]/div/input")
	private
	WebElement babbeteHourly;
	
	//EDIT BUTTON IN PANEL
	@FindBy (xpath = "//button/span[contains(text(), \"Edit\")]")
	private
	WebElement editButton;
	
	//SELECT ROLE ELEMENT IN EDIT PANEL
	@FindBy (id = "rolesedit")
	private
	WebElement editSelectRole;
	
	//HOURLY RATE ELEMEENT IN EDIT PANEL
	@FindBy (xpath = "//input[@id='horlyvalue1']")
	private
	WebElement editHourlyRate;
	
	
	//ONSITE RATE ELEMEENT IN EDIT PANEL
	@FindBy (xpath = "//input[@id='horlyvalueoff1']")
	private
	WebElement editOnSiteRate;
	
	//DELETE BUTTON IN PANEL
	@FindBy (xpath = "//button[@id='deleteids']")
	private
	WebElement deleteButton;
	
	//CHECK BOX CORRESPOND TO BIPIN
	@FindBy (xpath = "//td[contains(text(),'Bipin Kumar')]/preceding-sibling::td/input")
	private
	WebElement checkboxBipin;
	
	//DELETE CONFIRM YES ELEMENT
	@FindBy (xpath = "//button[contains(text(),'Yes, delete it!')]")
	private
	WebElement deleteConfirm;
	
	
	@FindBy (id = "swal2-title")
	private
	WebElement swalAlert;
	
	
	//PANEL CLOSE BUTTON
	@FindBy (xpath = "//body/div[2]/div[1]/button[1]")
	private
	WebElement panelCloseBtn;	
	
	
	//LOCAL FUNCTION
	private void enterUser(String user) {
		enterUser.clear();
		enterUser.sendKeys(user);
	}




WebDriver driver;
WebDriverWait wait;

private List <String> originalListNames;
private List <String> originalListRoles;
private List <String> sortedListRoles;
private List <String> sortedListNames;


//CONSTRUCTOR FUNCTION

public UserPanelPage(WebDriver rdriver) 
{
	
	driver = rdriver;
	PageFactory.initElements(rdriver, this);
	wait = new WebDriverWait(driver, 20);
	

}	

//GLOBAL FUNCTIONS


//Check whether panel open or not
public boolean isUserPanelOpen()
{
	if(userFrame.isDisplayed())
	{
		return true;
	}
	
	else
	{
		return false;
	}
}



//Add Users to app
public boolean addUser() throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	wait.until(ExpectedConditions.visibilityOf(userFrame));
	driver.switchTo().frame(userFrame);
	ArrayList<String> userArray = new ArrayList<String>();
	ArrayList<String> role = new ArrayList<String>();
	userArray.add("Eden Jayson");
	userArray.add("John Taylor");
	userArray.add("Maya Jane");
	userArray.add("Babette H");
	userArray.add("Bipin Kumar");
	
	role.add("Project Manager");
	role.add("Admin");
	role.add("Coordinator");
	role.add("User");
	role.add("User");
	
	Select selectRoles = new Select(selectRole);
	List <String> userNamesText = userNames.stream().map(s-> s.getText()).collect(Collectors.toList());
	System.out.println(userNamesText);
	System.out.println(userArray);
	
	//That User which are not in Name Column will add
	
	
	for(int i=0; i<userArray.size(); i++) {
		
		if(userNamesText.contains(userArray.get(i))) {
			
			System.out.println(userArray.get(i) + " is already there");
		}
		
		else {
			
				wait.until(ExpectedConditions.visibilityOf(addButton));
				for (int m = 0; m < 3 ; m++) {
				try {
				
					addButton.click();
				}
				catch (org.openqa.selenium.ElementClickInterceptedException e){
					
				}
				catch (org.openqa.selenium.NoSuchElementException e){
					
				}
				
				
				}
				if (wait.until(ExpectedConditions.attributeToBe(enterUser, "aria-label", ""))) {
				enterUser(userArray.get(i));
				};
				wait.until(ExpectedConditions.elementToBeClickable(userClick));
				userClick.click();
				selectRoles.selectByVisibleText(role.get(i));
				wait.until(ExpectedConditions.visibilityOf(hourlyRate));
				hourlyRate.sendKeys("5");
				onSiteRate.sendKeys("7");
				submit.click();
				wait.until(ExpectedConditions.visibilityOf(alert));
				System.out.println(userArray.get(i) + "" + alert.getText());
					
		}
	}	
					
		
	if (wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr[5]"))) != null) { 
	
	List <WebElement> userName = userNames;
	actualList = userName.stream().map(s-> s.getText()).collect(Collectors.toList());
	
	
	actualList  = actualList.stream().sorted().collect(Collectors.toList());
	expectedList  = userArray.stream().sorted().collect(Collectors.toList());
	System.out.println("Actual List :"+ actualList);
	System.out.println("ExpectedList :"+ expectedList);
	
	
	
	
	/*
	if (expectedList.equals(actualList)) {
		
		System.out.println("!--------Test is passed for User Add--------!");
	
	}
	
	else  {
		
		System.out.println("!--------Test is failed for User Add--------!");
		
		
// CAPTURE THE SCREENSHOT		
		
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File(".\\Screenshots\\UserAddFail.png");
	FileUtils.copyFile(src,trg);
			
	}
	
	*/
	}
	
	return (expectedList.equals(actualList));

}

//SORTING

public boolean sorting()
{
	try {
			userNamesHeader.click();
		}
		catch (org.openqa.selenium.ElementClickInterceptedException e) {
			userNamesHeader.click();
		}
		List <String> originalNames = userNames.stream().map(s -> s.getText()).collect(Collectors.toList());
		List <String> sortedNames = originalNames.stream().sorted().collect(Collectors.toList()); 
	
		userRolesHeader.click();
		
		List <String> originalRoles = userRoles.stream().map(s -> s.getText()).collect(Collectors.toList());
		List <String> sortedRoles = originalRoles.stream().sorted().collect(Collectors.toList());
		
		System.out.println("SortedNames :" + sortedNames);
		System.out.println("OriginalNames :" + originalNames);
		System.out.println("SortedRoles :" + sortedRoles);
		System.out.println("OriginalRoles :" + originalRoles);
		
		return (sortedNames.equals(originalNames) && (sortedRoles.equals(originalRoles)));
		
}

//SEARCHING

public boolean searching() throws InterruptedException
{
	//Name Search
	
	
		sortedListNames = userNames.stream().filter(name -> name.getText().contains("Eden"))
			.collect(Collectors.toList()).stream().map(s -> s.getText()).collect(Collectors.toList());

	searchName.sendKeys("eden");

	originalListNames = userNames.stream().map(s -> s.getText()).collect(Collectors.toList());
	
	//Role Search
	
	searchName.clear();
	if (wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr[4]"))) != null) 
	{ 
		sortedListRoles = userRoles.stream().filter(name -> name.getText().contains("Admin"))
			.collect(Collectors.toList()).stream().map(s -> s.getText()).collect(Collectors.toList());
	
	searchRole.sendKeys("Admin");
	
	originalListRoles = userRoles.stream().map(s -> s.getText()).collect(Collectors.toList());
	searchRole.clear();
	
	}
	
	System.out.println(sortedListNames);
	System.out.println(originalListNames);
	System.out.println(sortedListRoles.equals(originalListRoles));
	
	return (sortedListNames.equals(originalListNames) && sortedListRoles.equals(originalListRoles));

}

}