package com.cet.pagerepositery.configurationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class ConfigurationPage extends PageObject {

	static WebElement element;
	
	public ConfigurationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static boolean launch(WebDriver driver) {
		LeftPanel.lnkConfiguration(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		return labelConfigurationPage(driver).isEnabled();
	}

	// Get Page title
	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Get Label Configuration
	public static WebElement labelConfigurationPage(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Configuration')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Get Search Label
	public static WebElement labelSearch(WebDriver driver) {
		element=  driver.findElement(By.xpath("//h6[contains(text(),'Search')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Add or Search New Campaign Label
	public static WebElement buttonAddSearchNewCampaign(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Add/Search New Campaign')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Add or Search New Campaign Script Label
	public static WebElement buttonAddSearchNewCampaignScript(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Add/Search Campaign Script Name')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Configure Attempt Label
	public static WebElement buttonConfigureAttempt(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Configure Attempt')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Add/Remove Disposition
	public static WebElement buttonAddRemoveDisposition(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Add/Remove Disposition')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Update Campaign Focus Priority
	public static WebElement buttonCampaignFocusPriority(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Update Campaign Focus Priority')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Search Campaign
	public static WebElement labelSearchCampaign(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Search Campaign')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Search Campaign Page title
	public static String labelSearchCampaigntitle(WebDriver driver) {
		return driver.getTitle();

	}

	// Get Team Label
	public static WebElement labelTeam(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Team')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get Team Value
	public static WebElement getTeamValue(WebDriver driver) {
		element=  driver.findElement(By.id("campaignlkup"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Get CampaignFocus Label
	public static WebElement labelCampaignFocus(WebDriver driver) {
		return driver.findElement(By.xpath("//label[contains(text(),'Campaign Focus')]"));

	}

	public static WebElement dropDownCampaignFocus(WebDriver driver) {
		element=  scrollIntoView(driver,
				driver.findElement(By.xpath(".//label[contains(text(),'Campaign Focus')]/following-sibling::select")));
		highLighterMethod(element,driver);
		return element;		
	}

	// Back to Configuration button
	public static WebElement buttonBackToConfiguration(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Back To Configuration')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Search Button
	public static WebElement buttonSearch(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Add New Campaign button
	public static WebElement buttonAddNewCampaign(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Add New Campaign')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Search Result
	public static WebElement labelSearchResult(WebDriver driver) {
		element=  driver.findElement(By.xpath("//h6[contains(text(),'Search Result')]"));
		highLighterMethod(element,driver);
		return element;		

	}

	// Result set header Team
	public static WebElement headerTeam(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[1]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Campaign Focus
	public static WebElement headerCampaignFocus(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[2]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Campaign Description
	public static WebElement headerCampaignDescription(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[3]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Clone Campaign focus
	public static WebElement headerCloneCampaignFocus(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[4]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Priority
	public static WebElement headerPriority(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[5]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Created By
	public static WebElement headerCreatedBy(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[6]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Created On
	public static WebElement headerCreatedOn(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[7]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Result set header Action
	public static WebElement headerAction(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='table-responsive']//th[8]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement tableRow(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//table[@class='table table-bordered table-striped']//tbody/tr[1]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// first row in search result Edit Link
	public static WebElement lnkEdit(WebDriver driver) {
		element=  scrollIntoView(driver, driver.findElement(By.xpath(
				".//a[@href='/Configuration/UpdateCampaign?currentUserId=114&amp;appCampaignTypeId=98&amp;campaignType=Edit']")));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colTeam(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[2]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colCampaignFocus(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[3]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colCampaignDescription(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[4]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colCloneCampaignFocus(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[5]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colPriority(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[6]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colCreatedBy(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[7]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// table first row in search result
	public static WebElement colCreatedOn(WebDriver driver) {
		element=  tableRow(driver).findElement(By.xpath(".//td[8]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// empty row msg
	public static WebElement txtNoDataFound(WebDriver driver) {
		element=  tableRow(driver)
				.findElement(By.xpath(".//td[contains(text(),'No records to display /Change the search criteria')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Add New Campaign Page title
	public static String pageTitleAddNewCampaign(WebDriver driver) {
		return driver.getTitle();
	}

	// Add New Campaign top section 
	public static WebElement labelTopSectionNewCampaign(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//div[@class='top-sctn']"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Add New Campaign Panel Label
	public static WebElement labelAddNewCampaignPanel(WebDriver driver) {
		element=  driver.findElement(By.xpath("//h6[contains(text(),'Add New Campaign')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Label New Campaign focus
	public static WebElement labelNewCampaignFocus(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'New Campaign Focus')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// input New Campaign focus
	public static WebElement inputCampaignFocus(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'New Campaign Focus')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Label New Campaign Team
	public static WebElement labelNewCampaignTeam(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Team')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// input New Campaign Team
	public static WebElement inputNewCampaignTeam(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Team')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// Label New Campaign Description
	public static WebElement labelNewCampaignDescription(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Campaign Description')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// input New Campaign Description
	public static WebElement inputCampaignDescription(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Campaign Description')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// label Clone Campaign Focus
	public static WebElement labelCloneCampaignFocus(WebDriver driver) {
		element=  driver.findElement(By.xpath(".//label[contains(text(),'Clone Campaign Focus')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// select Clone Campaign Focus
	public static WebElement dropDownCloneCampaignFocus(WebDriver driver) {
		element=  scrollIntoView(driver, driver
				.findElement(By.xpath(".//label[contains(text(),'Clone Campaign Focus')]/following-sibling::select")));
		highLighterMethod(element,driver);
		return element;		
	}

	// Label New Campaign Attempt
	public static WebElement labelNewCampaignAttempt(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Attempt')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// input New Campaign Description
	public static WebElement inputNewCampaignAttempt(WebDriver driver) {
		element=  driver.findElement(By.xpath("//label[contains(text(),'Attempt')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// button Submit in Add New Campaign
	public static WebElement buttonAddCampaignSubmit(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	// button Cancel in Add New Campaign
	public static WebElement buttonCancel(WebDriver driver) {
		element=  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
		highLighterMethod(element,driver);
		return element;		
	}

	public static String getAddCampaignLabels(String label) throws Exception {
		String value = "";
		switch (label) {
		case "configurationpagetitle":
			value = "Configuration - CampaignManagement";
			break;
		case "newcampaignpagetitle":
			value = "Add New Campaign - CampaignManagement";
			break;
		case "confugrationlabel":
			value = "Configuration";
			break;
		case "configurationsearchlabel":
			value = "Search";
			break;
		case "searchcampaignlabel":
			value = "Search Campaign";
			break;
		case "searchcampaignpagetitle":
			value = "SearchCampaign - CampaignManagement";
			break;
		case "teamlabel":
			value = "Team";
			break;
		case "campaignfocus":
			value = "SearchCampaign - CampaignManagement";
			break;
		case "searchresult":
			value = "Search Result";
			break;
		case "searchcampaignteam":
			value = "Team";
			break;
		case "searchcampaignfocus":
			value = "Campaign Focus";
			break;
		case "searchcampaigndescription":
			value = "Campaign Description";
			break;
		case "searchpriority":
			value = "Priority";
			break;
		case "searchcreatedby":
			value = "Created By";
			break;
		case "searchcreatedon":
			value = "Created On";
			break;
		case "topsectionaddcampaign":
			value = "Campaign";
			break;
		case "addnewcampaignpanel":
			value = "Add New Campaign";
			break;
		case "addnewcampaignfocus":
			value = "New Campaign Focus";
			break;
		case "addcampaignteam":
			value = "Team";
			break;
		case "addcampaigndescription":
			value = "Campaign Description";
			break;
		case "addclonecampaignfocus":
			value = "Clone Campaign Focus";
			break;
		case "addcampaignattempt":
			value = "Attempt";
			break;
		case "addcampaign":
			value = "Campaign Focus saved successfully!";
			break;
		case "addexistingcampaign":
			value = "New Campaign Focus is already exist";
		}
		return value;
	}

}
