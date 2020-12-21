package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cet.pagerepositery.manager.PageObject;
import com.cet.utility.Readconfig;

public class SearchViewPage extends SearchTaskPage {
	
	static WebElement element;

	public SearchViewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static boolean launch(WebDriver driver) {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		SearchTaskPage.inputBconnId(driver).sendKeys(getBconnId());
		SearchTaskPage.btnSearch(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		SearchTaskPage.lnkView(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		PageObject.switchToWindow(driver);
		driver.manage().window().maximize();
		return getPageLabel(driver).getText().contains("Task View");
	}
	// Label Search
	public static WebElement getPageLabel(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static WebElement clickCloseButton(WebDriver driver) {
		element= driver.findElement(By.xpath("//button[contains(text(),'Close']"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static String expTitle() {
		return Readconfig.getValue("searchViewPage", "title");
		
	}
	
	// Get BconnID
	public static String getBconnId() {
		return Readconfig.getValue("searchViewPage", "txtBconnId");
	}
		
	public static String expTxtTitle() {
		return Readconfig.getValue("searchViewPage", "labelTitle");
	}

	public static String expApplicationSecTitle() {
		return Readconfig.getValue("searchViewPage", "textApplicationDetailsTitle");
	}
	public static String expTxtBconnId() {
		return Readconfig.getValue("searchViewPage", "txtBconnId");
	}

	public static String expCurrentPlan() {
		return Readconfig.getValue("searchViewPage", "txtCurrentPlan");
	}

	public static String expPlanToPromote() {
		return Readconfig.getValue("searchViewPage", "txtPlanToPromote");
	}

	public static String expFirstName() {
		return Readconfig.getValue("searchViewPage", "txtFirstName");
	}

	public static String expLastName() {
		return Readconfig.getValue("searchViewPage", "txtLastName");
	}
	
	public static String expAdditionalHousehold() {
		return Readconfig.getValue("searchViewPage", "txtAdditionalHousehold");
	}
	
	public static String expAddlHHMemberFirstName() {
		return Readconfig.getValue("searchViewPage", "txtAddlHHMemberFirstName");
	}

	public static String expAddlHHMemberLastName() {
		return Readconfig.getValue("searchViewPage", "txtAddlHHMemberLastName");
	}
	
	public static String expAddress() {
		return Readconfig.getValue("searchViewPage", "txtAddress");
	}

	public static String expCity() {
		return Readconfig.getValue("searchViewPage", "txtCity");
	}

	public static String expState() {
		return Readconfig.getValue("searchViewPage", "txtState");
	}

	public static String expZipCode() {
		return Readconfig.getValue("searchViewPage", "txtZipCode");
	}

	public static String expCounty() {
		return Readconfig.getValue("searchViewPage", "txtCounty");
	}

	public static String expPhone1() {
		return Readconfig.getValue("searchViewPage", "txtPhone1");
	}

	public static String expPhone2() {
		return Readconfig.getValue("searchViewPage", "txtPhone2");
	}

	public static String expPhone3() {
		return Readconfig.getValue("searchViewPage", "txtPhone3");
	}

	public static String expLanguage() {
		return Readconfig.getValue("searchViewPage", "txtLanguage");
	}

	public static String expMBI() {
		return Readconfig.getValue("searchViewPage", "txtMBI");
	}

	public static String expMedicaidNumber() {
		return Readconfig.getValue("searchViewPage", "txtMedicaidNumber");
	}

	public static String expProviderInformation() {
		return Readconfig.getValue("searchViewPage", "txtProviderInformation");
	}

	public static String expOther() {
		return Readconfig.getValue("searchViewPage", "txtOther");
	}

	public static String expAgentAssigned() {
		return Readconfig.getValue("searchViewPage", "txtAgentAssigned");
	}

	public static String expAgentSupervisor() {
		return Readconfig.getValue("searchViewPage", "txtAgentSupervisor");
	}

	public static String expTaskHistory() {
		return Readconfig.getValue("searchViewPage", "textTaskHistoryTitle");
	}

	public static String expColJobName() {
		return Readconfig.getValue("searchViewPage", "txtColJobName");
	}

	public static String expColAttemptResult() {
		return Readconfig.getValue("searchViewPage", "txtColAttemptResult");
	}

	public static String expColAttemptDate() {
		return Readconfig.getValue("searchViewPage", "txtColAttemptDate");
	}

	public static String expColAttemptCount() {
		return Readconfig.getValue("searchViewPage", "txtColAttemptCount");
	}

	public static String expColUser() {
		return Readconfig.getValue("searchViewPage", "txtColUser");
	}

	public static String expColNotes() {
		return Readconfig.getValue("searchViewPage", "txtColNotes");
	}

	public static String expTaskDetailsTitle() {
		return Readconfig.getValue("searchViewPage", "textTaskDetailsTile");
	}

	public static String expTaskID() {
		return Readconfig.getValue("searchViewPage", "txtTaskID");
	}

	public static String expTaskType() {
		return Readconfig.getValue("searchViewPage", "txtTaskType");
	}

	public static String expCampaignDescription() {
		return Readconfig.getValue("searchViewPage", "txtCampaignDescription");
	}

	public static String expJobName() {
		return Readconfig.getValue("searchViewPage", "txtJobName");
	}

	public static String expCreatedDate() {
		return Readconfig.getValue("searchViewPage", "txtCreatedDate");
	}

	public static String expTaskStatus() {
		return Readconfig.getValue("searchViewPage", "txtTaskStatus");
	}

	public static String expScheduledDate() {
		return Readconfig.getValue("searchViewPage", "txtScheduledDate");
	}

	public static String expNotes() {
		return Readconfig.getValue("searchViewPage", "txtNotes");
	}
	public static String expDispositionLkup() {
		return Readconfig.getValue("searchViewPage", "txtDispositionLkup");
	}
}
