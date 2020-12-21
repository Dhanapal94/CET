package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cet.utility.Readconfig;

public class SearchEditPage extends SearchTaskPage {
	
	static WebElement element;

	public SearchEditPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static boolean launch(WebDriver driver, String expbconnId) {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		System.out.println("********************TaskEditPage::TaskLaunch*********************");
		SearchTaskPage.inputBconnId(driver).sendKeys(expbconnId);
		SearchTaskPage.btnSearch(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		Assert.assertEquals(SearchEditPage.lnkEdit(driver).isEnabled(), true,
				"Failed: Edit link not displayed in search result");
		SearchTaskPage.lnkEdit(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		return getPageLabel(driver).getText().contains("Task Details");
	}

	// Label Search
	public static WebElement labelSearchPage(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
		highLighterMethod(element,driver);
		return element;
	}

	// Label Search
	public static WebElement getPageLabel(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get page title
	public static String gettitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Application Details Label
	public static WebElement labelApplicationDetails(WebDriver driver) {
		element= driver.findElement(By.xpath("//h6[contains(text(),'Application Details')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get bconnId Label
	public static WebElement labelBconnId(WebDriver driver) {
		element= scrollIntoView(driver, driver.findElement(By.xpath("//label[contains(text(),'bConn ID')]")));
		highLighterMethod(element,driver);
		return element;
	}

	// get bconnId
	public static WebElement getBconnId(WebDriver driver) {
		element= scrollIntoView(driver,
				driver.findElement(By.xpath("//label[contains(text(),'bConn ID')]/following::input[1]")));
		highLighterMethod(element,driver);
		return element;
	}

	// get current plan
	public static WebElement getCurrentPlan(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdCurrentPlan']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get current plan Label
	public static WebElement labelCurrentPlan(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Current Plan')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get plan to promote Label
	public static WebElement labelPlantoPromote(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Plan to Promote')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get plan to promote Label
	public static WebElement getPlanToPromote(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdPlanToPromot']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get FirstName Label
	public static WebElement labelFirstName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get FirstName
	public static WebElement getFirstName(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdFirstName']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get LastName Label
	public static WebElement labelLastName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get LastName
	public static WebElement getLastName(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdLastName']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Additional Household Label
	public static WebElement labelAdditionalHousehold(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'# of Additional Household Members')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Additional Household value
	public static WebElement getAdditionalHousehold(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdSameHousHoldMemberCount']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Additional Household Member First Name Label
	public static WebElement labelAddHouseholdFirstName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Addl HH Member First Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Additional Household Member First Name Value
	public static WebElement getAddHouseholdFirstName(WebDriver driver) {
		element= driver
				.findElement(By.xpath("//label[contains(text(),'Addl HH Member First Name')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Additional Household Member Last Name Label
	public static WebElement labelAddHouseholdLastName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Addl HH Member Last Name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Additional Household Member Last Name Value
	public static WebElement getAddHouseholdLastName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Addl HH Member Last Name')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Address
	public static WebElement labelAddress(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Address')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Address
	public static WebElement getAddress(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdAddress']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get City
	public static WebElement labelCity(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'City')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get City
	public static WebElement getCity(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdCity']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get State
	public static WebElement labelState(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'State')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get State
	public static WebElement getState(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdState']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Zip Code
	public static WebElement labelZipCode(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Zip Code')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Zip Code
	public static WebElement getZipCode(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdZipCode']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get county
	public static WebElement labelCounty(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'County')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get County
	public static WebElement getCounty(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdCounty']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get phone number 1
	public static WebElement labelPhone1(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Phone #1')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Phone number 1
	public static WebElement getPhoneNum1(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdPrimaryPhoneNumber']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get phone number 2
	public static WebElement labelPhone2(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Phone #2')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Phone number 2
	public static WebElement getPhoneNum2(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdPhoneNumber1']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get phone number 3
	public static WebElement labelPhone3(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Phone #3')]"));
		highLighterMethod(element,driver);
		return element;

	}

	// get Phone number 3
	public static WebElement getPhoneNum3(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdPhoneNumber2']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Wrong Number
	public static WebElement labelWrongNumber(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),' Wrong Number')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Bad/Disconnected Number
	public static WebElement labelBadNumber(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),' Bad/Disconnected Number')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Wrong Number
	public static WebElement getWrongNumber(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdIsWrongNumber1']"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Bad/Disconnected Number
	public static WebElement getBadNumber(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdIsDisconnectedNumber1']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Language Label
	public static WebElement labelLanguage(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Language')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Language
	public static WebElement getLanguage(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdLanguage']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get MBI# Label
	public static WebElement labelMBI(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'MBI #')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get MBI#
	public static WebElement getMBI(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdMBI']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Employer Group Label
	public static WebElement labelEmployerGroup(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Employer Group')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Employer Group value
	public static WebElement getEmployerGroup(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdEmployerGroup']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Medicaid Number Label
	public static WebElement labelMedicaidNumber(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Medicaid Number')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Medicaid Number
	public static WebElement getMedicaidNumber(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdMedicaidNumber']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Provider Information Label
	public static WebElement labelProviderInformation(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Provider Information')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Provider Information
	public static WebElement getProviderInformation(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdProviderInformation']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Other Label
	public static WebElement labelOther(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Other')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Other
	public static WebElement getOther(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdOther']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Agent Assigned
	public static WebElement labelAgentAssigned(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Agent Assigned')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Agent Assigned
	public static WebElement getAgentAssigned(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdAssignedTo']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Agent Supervisor
	public static WebElement labelAgentSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Agent's Supervisor')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Agent Supervisor
	public static WebElement getAgentSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdSupervisorName']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Task History Label
	public static WebElement labelTaskHistory(WebDriver driver) {
		element= driver.findElement(By.xpath("//h6[contains(text(),'Task History')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get No Records to display label
	public static WebElement labelNoRecordsToDisplay(WebDriver driver) {
		element= driver.findElement(By.xpath("//span[@class='validationErrors']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Job Name
	public static WebElement headerJobName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[1]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Attempt Result
	public static WebElement headerAttemptResult(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[2]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Attempt Date
	public static WebElement headerAttemptDate(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[3]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Attempt Count
	public static WebElement headerAttemptCount(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[4]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header User
	public static WebElement headerUser(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[5]"));
		highLighterMethod(element,driver);
		return element;
	}

	// Result set header Notes
	public static WebElement headerNotes(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[6]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row in Task Details
	@SuppressWarnings("deprecation")
	public static WebElement tableRowTaskDetails(WebDriver driver) {
		WebElement row = new WebDriverWait(driver, 120).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//table[@id='tblTaskHistory']//tbody/tr[1]")));
		WebElement scrollIntoView = scrollIntoView(driver, row);
		return scrollIntoView;
	}

	// table first row Job Name value in Task Details
	public static WebElement colJobName(WebDriver driver) {
		element= tableRowTaskDetails(driver).findElement(By.xpath(".//td[1]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row Attempt Result in Task Details
	public static WebElement colAttemptResult(WebDriver driver) {
		element= tableRowTaskDetails(driver).findElement(By.xpath(".//td[2]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row Attempt Date in Task Details
	public static WebElement colAttemptDate(WebDriver driver) {
		element= tableRowTaskDetails(driver).findElement(By.xpath(".//td[3]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row Attempt Count in Task Details
	public static WebElement colAttemptCount(WebDriver driver) {
		element= tableRowTaskDetails(driver).findElement(By.xpath(".//td[4]"));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row User in Task Details
	public static WebElement colUser(WebDriver driver) {
		element= scrollIntoView(driver, driver.findElement(By.xpath(".//td[5]")));
		highLighterMethod(element,driver);
		return element;
	}

	// table first row Notes in Task Details
	public static WebElement colNotes(WebDriver driver) {
		element= tableRowTaskDetails(driver).findElement(By.xpath(".//td[6]"));
		highLighterMethod(element,driver);
		return element;
	}

	public static WebElement labelTaskDetails(WebDriver driver) {
		element= driver.findElement(By.xpath(".//h6[contains(text(), 'Task Details']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Task ID
	public static WebElement labelTaskId(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Task ID')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Task ID
	public static WebElement getTaskId(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdTaskId']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Task Type
	public static WebElement labelTaskType(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Task Type')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Task Type
	public static WebElement getTaskType(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdTaskType']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Campaign Description
	public static WebElement labelCampaignDescription(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Campaign Description')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Campaign Description
	public static WebElement getCampaignDescription(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdCampaignDescription']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Job name
	public static WebElement labelJobName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Job name')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Job Name
	public static WebElement getJobName(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdJobName']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Created Date (UTC)
	public static WebElement labelCreatedDate(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Created Date (UTC)')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Created Date
	public static WebElement getCreatedDate(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdCreatedOn']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Task Status
	public static WebElement labelTaskStatus(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Task Status')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Task Status
	public static WebElement getTaskStatus(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdTaskStatus']"));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Schedule Date
	public static WebElement labelScheduledDate(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Scheduled Date')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Schedule Date
	public static WebElement getScheduleDate(WebDriver driver) {
		element= driver.findElement(By.xpath("//input[@id='tdScheduleDate']"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Disposition label
	public static WebElement labelDisposition(WebDriver driver) {
		element= scrollIntoView(driver,
				driver.findElement(By.xpath(".//label[contains(text(),'Disposition')]")));
		highLighterMethod(element,driver);
		return element;
	}

	// Select DispositionLkup
	public static WebElement dropDownDispositionLkup(WebDriver driver) {
		element= scrollIntoView(driver,
				driver.findElement(By.xpath(".//label[contains(text(),'Disposition')]/following-sibling::select")));
		highLighterMethod(element,driver);
		return element;
	}

	// Get Label Notes
	public static WebElement labelNotes(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Notes')]"));
		highLighterMethod(element,driver);
		return element;
	}

	// get Notes
	public static WebElement getNotes(WebDriver driver) {
		element= driver.findElement(By.xpath("//textarea[@id='tdNotes']"));
		highLighterMethod(element,driver);
		return element;
	}

	// btnSaveAndClose
	public static WebElement btnSaveAndClose(WebDriver driver) {
		element= scrollIntoView(driver, driver.findElement(By.id("btnSaveAndClose")));
		highLighterMethod(element,driver);
		return element;
	}

	// btnCampaignscript
	public static WebElement btnCampaignScript(WebDriver driver) {
		element= scrollIntoView(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary']")));
		highLighterMethod(element,driver);
		return element;
	}

	// btnSave And Gext Next
	public static WebElement btnSaveGetNext(WebDriver driver) {
		element= scrollIntoView(driver, driver.findElement(By.xpath("//button[@class='btn btn-primary']")));
		highLighterMethod(element,driver);
		return element;
	}

	public static void setDropDownValue(WebElement element, String value) {
		element.click();
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}

	public static String expTitle() {
		return Readconfig.getValue("searchEditpage", "title");
	}

	public static String expTxtTitle() {
		return Readconfig.getValue("searchEditpage", "labelTitle");
	}

	public static String expApplicationSecTitle() {
		return Readconfig.getValue("searchEditpage", "textApplicationDetailsTitle");
	}

	public static String expTxtBconnId() {
		return Readconfig.getValue("searchEditpage", "txtBconnId");
	}

	public static String getBconnId() {
		return Readconfig.getValue("searchEditpage", "txtBconnId");
	}

	public static String expCurrentPlan() {
		return Readconfig.getValue("searchEditpage", "txtCurrentPlan");
	}

	public static String expPlanToPromote() {
		return Readconfig.getValue("searchEditpage", "txtPlanToPromote");
	}

	public static String expFirstName() {
		return Readconfig.getValue("searchEditpage", "txtFirstName");
	}

	public static String expLastName() {
		return Readconfig.getValue("searchEditpage", "txtLastName");
	}

	public static String expAdditionalHousehold() {
		return Readconfig.getValue("searchEditpage", "txtAdditionalHousehold");
	}

	public static String expAddlHHMemberFirstName() {
		return Readconfig.getValue("searchEditpage", "txtAddlHHMemberFirstName");
	}

	public static String expAddlHHMemberLastName() {
		return Readconfig.getValue("searchEditpage", "txtAddlHHMemberLastName");
	}

	public static String expAddress() {
		return Readconfig.getValue("searchEditpage", "txtAddress");
	}

	public static String expCity() {
		return Readconfig.getValue("searchEditpage", "txtCity");
	}

	public static String expState() {
		return Readconfig.getValue("searchEditpage", "txtState");
	}

	public static String expZipCode() {
		return Readconfig.getValue("searchEditpage", "txtZipCode");
	}

	public static String expEmployerGroup() {
		return Readconfig.getValue("searchEditpage", "txtEmployerGroup");
	}

	public static String expCounty() {
		return Readconfig.getValue("searchEditpage", "txtCounty");
	}

	public static String expPhone1() {
		return Readconfig.getValue("searchEditpage", "txtPhone1");
	}

	public static String expPhone2() {
		return Readconfig.getValue("searchEditpage", "txtPhone2");
	}

	public static String expPhone3() {
		return Readconfig.getValue("searchEditpage", "txtPhone3");
	}

	public static String expLanguage() {
		return Readconfig.getValue("searchEditpage", "txtLanguage");
	}

	public static String expMBI() {
		return Readconfig.getValue("searchEditpage", "txtMBI");
	}

	public static String expMedicaidNumber() {
		return Readconfig.getValue("searchEditpage", "txtMedicaidNumber");
	}

	public static String expProviderInformation() {
		return Readconfig.getValue("searchEditpage", "txtProviderInformation");
	}

	public static String expOther() {
		return Readconfig.getValue("searchEditpage", "txtOther");
	}

	public static String expAgentAssigned() {
		return Readconfig.getValue("searchEditpage", "txtAgentAssigned");
	}

	public static String expAgentSupervisor() {
		return Readconfig.getValue("searchEditpage", "txtAgentSupervisor");
	}

	public static String expTaskHistory() {
		return Readconfig.getValue("searchEditpage", "textTaskHistoryTitle");
	}

	public static String expColJobName() {
		return Readconfig.getValue("searchEditpage", "txtColJobName");
	}

	public static String expColAttemptResult() {
		return Readconfig.getValue("searchEditpage", "txtColAttemptResult");
	}

	public static String expColAttemptDate() {
		return Readconfig.getValue("searchEditpage", "txtColAttemptDate");
	}

	public static String expColAttemptCount() {
		return Readconfig.getValue("searchEditpage", "txtColAttemptCount");
	}

	public static String expColUser() {
		return Readconfig.getValue("searchEditpage", "txtColUser");
	}

	public static String expColNotes() {
		return Readconfig.getValue("searchEditpage", "txtColNotes");
	}

	public static String expTaskDetailsTitle() {
		return Readconfig.getValue("searchEditpage", "textTaskDetailsTile");
	}

	public static String expTaskID() {
		return Readconfig.getValue("searchEditpage", "txtTaskID");
	}

	public static String expTaskType() {
		return Readconfig.getValue("searchEditpage", "txtTaskType");
	}

	public static String expCampaignDescription() {
		return Readconfig.getValue("searchEditpage", "txtCampaignDescription");
	}

	public static String expJobName() {
		return Readconfig.getValue("searchEditpage", "txtJobName");
	}

	public static String expCreatedDate() {
		return Readconfig.getValue("searchEditpage", "txtCreatedDate");
	}

	public static String expTaskStatus() {
		return Readconfig.getValue("searchEditpage", "txtTaskStatus");
	}

	public static String expScheduledDate() {
		return Readconfig.getValue("searchEditpage", "txtScheduledDate");
	}

	public static String expNotes() {
		return Readconfig.getValue("searchEditpage", "txtNotes");
	}

	public static String expDispositionLkup() {
		return Readconfig.getValue("searchEditpage", "txtDispositionLkup");
	}

	public static String expMsgSaveAndClose() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("searchEditpage", "txtMsgSaveClose");
	}
}
