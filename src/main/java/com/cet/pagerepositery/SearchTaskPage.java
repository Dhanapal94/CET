package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class SearchTaskPage extends PageObject {
	
	static WebElement element;

	// Constructor
	public SearchTaskPage(WebDriver driver) {
		super(driver);

	}

	public static boolean launch(WebDriver driver) {
		LeftPanel.lnkSearch(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		/*
		 * Wait<WebDriver> wait = new WebDriverWait(driver, 120);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@class='top-sctn']/label"))); //waitForElementToAppear(new
		 * WebDriverWait(driver, 60),By.xpath("//div[@class='top-sctn']/label"));
		 * SearchTaskPage.waitForPageLoad(driver);
		 */return labelSearchPage(driver).isEnabled();
	}

	// return title of page
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Label Search
	public static WebElement labelSearchPage(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
		highLighterMethod(element,driver);
		return element;
		
	}

	// Label Search Panel
	public static WebElement labelSearchPanel(WebDriver driver) {
		element = driver.findElement(By.xpath(".//h6[@class='wdgt-hdr']"));
		highLighterMethod(element,driver);
		return element;
	}

	// BconnId label
	public static WebElement labelBconnId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'bConn ID')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// BconnId Value
	public static WebElement inputBconnId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='BconId']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Tasktype label
	public static WebElement labelTaskType(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Task Type')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Task type Value
	public static Select dropDownTaskType(WebDriver driver) {
		Select tasktype = new Select(
				driver.findElement(By.xpath(".//label[contains(text(),' Task Type')]/following-sibling::select")));
		return tasktype;
	}

	// Campaign Focus Label
	public static WebElement labelCampaignFocus(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Campaign Focus')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Campaign Focus Value
	public static Select dropDownCampaignFocus(WebDriver driver) {
		Select campaignfocus = new Select(
				driver.findElement(By.xpath(".//label[contains(text(),'Campaign Focus')]/following-sibling::select")));
		return campaignfocus;
	}

	// Task Status Label
	public static WebElement labelTaskStatus(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Task Status')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Task Status Value
	public static Select dropDownTaskStatus(WebDriver driver) {
		Select taskstatus = new Select(
				driver.findElement(By.xpath(".//label[contains(text(),'Task Status')]/following-sibling::select")));
		return taskstatus;
	}

	// Job Name Label
	public static WebElement labelJobName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Job Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Job Name Value
	public static Select dropDownJobName(WebDriver driver) {
		Select jobname = new Select(
				driver.findElement(By.xpath(".//label[contains(text(),'Job Name')]/following-sibling::select")));
		return jobname;
	}

	// Dialing Method Label
	public static WebElement labelDialingMethod(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Dialing Method')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Dialing Method Value
	public static Select dropDownDialingMethod(WebDriver driver) {
		Select dialingmethod = new Select(
				driver.findElement(By.xpath(".//label[contains(text(),'Dialing Method')]/following-sibling::select")));
		return dialingmethod;
	}

	// Member First Name Label
	public static WebElement labelMemberFName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Member First Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Member First Name Value
	public static WebElement inputMemberFName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='MemberFirstName']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Member Last Name Label
	public static WebElement labelMemberLName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Member Last Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Member Last Name Value
	public static WebElement inputMemberLName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='MemberLastName']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Phone Number Label
	public static WebElement labelPhoneNumber(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Phone Number')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Phone Number Value
	public static WebElement inputPhoneNumber(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='PhoneNumber']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Created From Label
	public static WebElement labelCreatedDateFrom(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Created Date From  ')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Created From Value
	public static WebElement inputCreatedDateFrom(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='CreatedDateFrom']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Created To Label
	public static WebElement labelCreatedDateTo(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Created Date To  ')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Created To Value
	public static WebElement inputCreatedDateTo(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='CreatedDateTo']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Agent Name Label
	public static WebElement labelAgentName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Agent Name ')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Agent Name value
	public static WebElement inputAgentName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='demoAutoComplete']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Button Cancel
	public static WebElement btnCancel(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Cancel')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Button Reset
	public static WebElement btnReset(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Reset')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Button Search
	public static WebElement btnSearch(WebDriver driver) {
		element = driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Search')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// label Search Result
	public static WebElement labelSearchResult(WebDriver driver) {
		element = driver.findElement(By.xpath(".//h6[contains(text(),'Search Result')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Actions
	public static WebElement headerActions(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[1]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Task ID
	public static WebElement headerTaskId(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[2]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Task Type
	public static WebElement headerTasktype(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[3]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Campaign Focus
	public static WebElement headerCampaignFocus(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[4]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Job Name
	public static WebElement headerJobName(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[5]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Created Date
	public static WebElement headerCreatedDate(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[6]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Task Status
	public static WebElement headerTaskStatus(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[7]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Dialing Method
	public static WebElement headerDialingMethod(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[8]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Final Disposition
	public static WebElement headerFinalDisposition(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[9]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Final Attempt Date
	public static WebElement headerFinalAttemptDate(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[10]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Final Attempt Date
	public static WebElement headerFinalAssignedTo(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='table-responsive']//th[11]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Link First
	public static WebElement linkFirst(WebDriver driver) {
		element = scrollIntoView(driver,
				driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button first')]")));
		highLighterMethod(element,driver);
		return element;
	}

	// Link Previous
	public static WebElement linkPrevious(WebDriver driver) {
		element = scrollIntoView(driver,
				driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button previous')]")));
		highLighterMethod(element,driver);
		return element;
	}

	// Link Next
	public static WebElement linkNext(WebDriver driver) {
		element = scrollIntoView(driver, driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button next')]")));
		highLighterMethod(element,driver);
		return element;
	}

	// link Last
	public static WebElement linkLast(WebDriver driver) {
		element = scrollIntoView(driver, driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button last')]")));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement tableRow(WebDriver driver) {
		element = driver.findElement(By.xpath(".//table[@id='taskTable']//tbody/tr[1]"));
		highLighterMethod(element,driver);
		return element;
	}

	// first row in search result Edit Link
	public static WebElement lnkEdit(WebDriver driver) {
		element = scrollIntoView(driver, driver.findElement(By.xpath(".//a[@title='Edit']")));
		highLighterMethod(element,driver);
		return element;
	}

	// first row in search result View Link
	public static WebElement lnkView(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath("//a[@title='View']"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colTaskId(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[2]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colTaskType(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[3]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colCampaignFocus(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[4]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colJobName(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[5]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colCreatedDate(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[6]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colTaskStatus(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[7]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colDialingMethod(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[8]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colFinalDisposition(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[9]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in search result
	public static WebElement colFinalAttemptDate(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[10]"));
		highLighterMethod(element,driver);
		return element;
	}
	

	// table first row in search result
	public static WebElement colAssignedTo(WebDriver driver) {
		element = tableRow(driver).findElement(By.xpath(".//td[11]"));
		highLighterMethod(element,driver);
		return element;
	}

	// empty row msg
	public static WebElement txtNoDataFound(WebDriver driver) {
		element = tableRow(driver)
				.findElement(By.xpath(".//td[contains(text(),'No records to display /Change the search criteria')]"));
		highLighterMethod(element,driver);
		return element;
	}

	public static String getSearchLabels(String label) throws Exception {
		String value = "";
		switch (label) {
		case "searchpagetitle":
			value = "Search - CampaignManagement";
			break;
		case "searchtitle":
			value = "Search";
			break;
		case "searchpanel":
			value = "Search";
			break;
		case "bconnId":
			value = "bConn ID";
			break;
		case "tasktype":
			value = "Task Type";
			break;
		case "searchpagecampaignfocus":
			value = "Campaign Focus";
			break;
		case "taskstatus":
			value = "Task Status";
			break;
		case "jobname":
			value = "Job Name";
			break;
		case "dialingmethod":
			value = "Dialing Method";
			break;
		case "memberfirstname":
			value = "Member First Name";
			break;
		case "memberlastname":
			value = "Member Last Name";
			break;
		case "phonenumber":
			value = "Phone Number";
			break;
		case "createddatefrom":
			value = "Created Date From";
			break;
		case "createddateto":
			value = "Created Date To";
			break;
		case "agentname":
			value = "Agent Name";
			break;
		case "cancel":
			value = "Cancel";
			break;
		case "reset":
			value = "Reset";
			break;
		case "searchbutton":
			value = "Search";
			break;
		case "searchresult":
			value = "Search Result";
			break;
		case "last":
			value = "Last";
			break;
		case "next":
			value = "Next";
			break;
		case "previous":
			value = "Previous";
			break;
		case "first":
			value = "First";
			break;
		case "addexistingcampaign":
			value = "New Campaign Focus is already exist";
		}
		return value;
	}

	// read from config file methods
	//
	// public static String expTitle() {
	// return Readconfig.getValue("searchpage","title");
	// }
	//
	// public static String expTxtTitle() {
	// return Readconfig.getValue("searchpage","labelTitle");
	// }
	// public static String expTxtSearchPanel() {
	// return Readconfig.getValue("searchpage","txtSearchPanel");
	// }
	// public static String expTextBconnID() {
	// return Readconfig.getValue("searchpage","TxtBconnID");
	// }
	// public static String expTextTaskType() {
	// return Readconfig.getValue("searchpage","TextTaskType");
	// }
	// public static String expTextCampaignFocus() {
	// return Readconfig.getValue("searchpage","TextCampaignFocus");
	// }
	// public static String expTextTaskStatus() {
	// return Readconfig.getValue("searchpage","TextTaskStatus");
	// }
	// public static String expTextJobName() {
	// return Readconfig.getValue("searchpage","TextJobName");
	// }
	// public static String expTextDialingMethod() {
	// return Readconfig.getValue("searchpage","TextDialingMethod");
	// }
	// public static String expTextMemberFirstName() {
	// return Readconfig.getValue("searchpage","TextMemberFirstName");
	// }
	// public static String expTextMemberLastName() {
	// return Readconfig.getValue("searchpage","TextMemberLastName");
	// }
	// public static String expTextPhoneNumber() {
	// return Readconfig.getValue("searchpage","TextPhoneNumber");
	// }
	// public static String expTextCreatedDateFrom() {
	// return Readconfig.getValue("searchpage","TextCreatedDateFrom");
	// }
	//
	// public static String expTextCreatedDateTo() {
	// return Readconfig.getValue("searchpage","TextCreatedDateTo");
	// }
	// public static String expTextAgentName() {
	// return Readconfig.getValue("searchpage","TextAgentName");
	// }
	// public static String exptextBtnCancel() {
	// return Readconfig.getValue("searchpage","textBtnCancel");
	// }
	// public static String expisEnabledBtnCancel() {
	// return Readconfig.getValue("searchpage","isEnabledBtnCancel");
	// }
	// public static String exptextBtnReset() {
	// return Readconfig.getValue("searchpage","textBtnReset");
	// }
	// public static String expisEnabledBtnReset() {
	// return Readconfig.getValue("searchpage","isEnabledBtnReset");
	// }
	// public static String exptextBtnSearch() {
	// return Readconfig.getValue("searchpage","textBtnSearch");
	// }
	// public static String explabelSearchResult() {
	// return Readconfig.getValue("searchpage","textSearchResult");
	// }
	// public static String exptextNavLast() {
	// return Readconfig.getValue("searchpage","textNavLast");
	// }
	// public static String exptextNavNext() {
	// return Readconfig.getValue("searchpage","textNavNext");
	// }
	// public static String exptextNavPrevious() {
	// return Readconfig.getValue("searchpage","textNavPrevious");
	// }
	// public static String exptextNavFirst() {
	// return Readconfig.getValue("searchpage","textNavFirst");
	// }
	// public static String exptextjunkvalue() {
	// return Readconfig.getValue("searchpage","junkvalue");
	// }
	// public static String expTxtBconnID() {
	// return Readconfig.getValue("searchpage","TxtBconnID");
	// }
	// public static String expTxtTaskType() {
	// return Readconfig.getValue("searchpage","TxtTaskType");
	// }
	// public static String expTxtCampaignFocus() {
	// return Readconfig.getValue("searchpage","TxtCampaignFocus");
	// }
	// public static String expTxtTaskStatus() {
	// return Readconfig.getValue("searchpage","TxtTaskStatus");
	// }
	// public static String expTxtJobName() {
	// return Readconfig.getValue("searchpage","TxtJobName");
	// }
	// public static String expTxtDialingMethod() {
	// return Readconfig.getValue("searchpage","TxtDialingMethod");
	// }
	// public static String expTxtMemberFirstName() {
	// return Readconfig.getValue("searchpage","TxtMemberFirstName");
	// }
	// public static String exp() {
	// return Readconfig.getValue("searchpage","TxtMemberLastName");
	// }
	// public static String expTxtPhoneNumber() {
	// return Readconfig.getValue("searchpage","TxtPhoneNumber");
	// }
	// public static String expTxtCreatedDateFrom() {
	// return Readconfig.getValue("searchpage","TxtCreatedDateFrom");
	// }
	// public static String expTxtCreatedDateTo() {
	// return Readconfig.getValue("searchpage","TxtCreatedDateTo");
	// }
	// public static String expTxtAgentName() {
	// return Readconfig.getValue("searchpage","TxtAgentName");
	// }
	// public static String exptxtNoDataFound() {
	// return Readconfig.getValue("searchpage","txtNoDataFound");
	// }

	public static String getSelectedDropDown(Select dropDown) {
		// TODO Auto-generated method stub
		return dropDown.getFirstSelectedOption().getText();
	}
}
