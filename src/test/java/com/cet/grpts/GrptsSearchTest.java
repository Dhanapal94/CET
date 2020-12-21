package com.cet.grpts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.SearchEditPage;
import com.cet.pagerepositery.SearchTaskPage;
import com.cet.utility.grpts.GetDataFromExcelGRPTS;


public class GrptsSearchTest extends Base{

	private static boolean initFlag = true;
	
	@BeforeClass
	public static void getinit() throws Exception {
		childTest=true;
		parentTest=extent.createTest("Grpts-Search Test");
		team="Grpts";
		grptstasksearch = GetDataFromExcelGRPTS.grptstasksearch();
	}

	@BeforeMethod
	public static void getTaskSearch() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			SearchTaskPage.launch(driver);
			fopenBrowser = false;
			initFlag=false;
		}
		
	}

	@Test(priority = 1)
	public void verifyTitle() throws Exception  {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.getSearchLabels("searchpagetitle"),SearchTaskPage.getTitle(driver),"Failed : On Search Page tab Title is mismatch.");
	}
	@Test(priority = 2)
	public void verifyPageTitle() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelSearchPage(driver).getText(),SearchTaskPage.getSearchLabels("searchtitle"),"Failed : On Search Page Title is mismatch");
	}
	//label search panel
	@Test(priority = 3)
	public void verifylabelSearch() throws Exception  {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelSearchPanel(driver).getText(),SearchTaskPage.getSearchLabels("searchpanel"),"Failed : On Search Page Search Panel label is mismatch");
	}
	//label bconid
	@Test(priority = 4)
	public void verifylabelBconnId() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelBconnId(driver).getText(),SearchTaskPage.getSearchLabels("bconnid"),"Failed : On Search Page bConn ID label is mismatch");
	}
	//label TaskType
	@Test(priority = 5)
	public void verifylabelTaskType() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelTaskType(driver).getText(),SearchTaskPage.getSearchLabels("tasktype"),"Failed : On Search Page Task Type label is mismatch");
	}
	//label CampaignFocus
	@Test(priority = 6)
	public void verifylabelCampaignFocus() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelCampaignFocus(driver).getText(),SearchTaskPage.getSearchLabels("searchpagecampaignfocus"),"Failed : On Search Page Campaign Focus label is mismatch");
	}
	//label TaskStatus
	@Test(priority = 7)
	public void verifylabelTaskStatus() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelTaskStatus(driver).getText(),SearchTaskPage.getSearchLabels("taskstatus"),"Failed : On Search Page Task Status label is mismatch");
	}
	//verify labelJobName
	@Test(priority = 8)
	public void verifylabelJobName() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelJobName(driver).getText(),SearchTaskPage.getSearchLabels("jobname"),"Failed : On Search Page Job Name label is mismatch");
	}
	//verify labelDialingMethod
	@Test(priority = 9)
	public void verifylabelDialingMethod() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelDialingMethod(driver).getText(),SearchTaskPage.getSearchLabels("dialingmethod"),"Failed : On Search Page Dialing Method label is mismatch");
	}
	//verify label Member First Name
	@Test(priority = 10)
	public void verifylabelMemberFName() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelMemberFName(driver).getText(),SearchTaskPage.getSearchLabels("memberfirstname"),"Failed : On Search Page Member First Name label is mismatch");
	}
	//verify label Member Last Name
	@Test(priority = 11)
	public void verifylabelMemberLName() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelMemberLName(driver).getText(),SearchTaskPage.getSearchLabels("memberlastname"),"Failed : On Search Page Member Last Name label is mismatch");
	}
	//verify label Phone Number
	@Test(priority = 12)
	public void verifylabelPhoneNumber() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelPhoneNumber(driver).getText(),SearchTaskPage.getSearchLabels("phonenumber"),"Failed : On Search Page Phone Number label is mismatch");
	}
	//verify label Created Date From
	@Test(priority = 13)
	public void verifylabelCreatedDateFrom() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelCreatedDateFrom(driver).getText(),SearchTaskPage.getSearchLabels("createddatefrom"),"Failed : On Search Page Created Date From label is mismatch");
	}
	//verify label Created Date To
	@Test(priority = 14)
	public void verifylabelCreatedDateTo() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelCreatedDateTo(driver).getText(),SearchTaskPage.getSearchLabels("createddateto"),"Failed : On Search Page Created Date To label is mismatch");
	}
	//verify label Agent Name
	@Test(priority = 15)
	public void verifylabelAgentName() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelAgentName(driver).getText(),SearchTaskPage.getSearchLabels("agentname"),"Failed : On Search Page Agent Name label is mismatch");
	}
	//verify Button Cancel
	@Test(priority = 16)
	public void verifyBtnCancel() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.btnCancel(driver).getText(),SearchTaskPage.getSearchLabels("cancel"),"Failed : On Search Page Cancel label is mismatch");
		softAssert.assertTrue(SearchTaskPage.btnCancel(driver).isEnabled(),"Failed : On Search Page Cancel button not enabled is mismatch");
	}
	//verify Button Reset 
	@Test(priority = 17)
	public void verifyBtnReset() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.btnReset(driver).getText(),SearchTaskPage.getSearchLabels("reset"),"Failed : On Search Page Reset label is mismatch");
		softAssert.assertTrue(SearchTaskPage.btnReset(driver).isEnabled(),"Failed : On Search Page Reset button not enabled is mismatch");
	}
	//verify Button Search 
	@Test(priority = 18)
	public void verifyBtnSearch() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.btnSearch(driver).getText(),SearchTaskPage.getSearchLabels("searchbutton"),"Failed : On Search Page Search label is mismatch");
		softAssert.assertTrue(SearchTaskPage.btnSearch(driver).isEnabled(),"Failed : On Search Page Search button not enabled is mismatch");
	}
	//verify label Search Result
	@Test(priority = 19)
	public void verifylabelSearchResult() throws Exception {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		softAssert.assertEquals(SearchTaskPage.labelSearchResult(driver).getText(),SearchTaskPage.getSearchLabels("searchresult"),"Failed : On Search Page Search Result label is mismatch");
	}
	@Test(priority = 20)
	public void verifyEditEnbled() {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		SearchTaskPage.inputBconnId(driver).sendKeys(grptstasksearch.get("bConnID"));
		SearchTaskPage.btnSearch(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		//Validating status=open 
		Assert.assertEquals(SearchTaskPage.colTaskStatus(driver).getText(),"Open","Failed : Task Status is not open");
		Assert.assertEquals(SearchTaskPage.colDialingMethod(driver).getText(),"Manual","Failed : Dialing method is not Manual");
		softAssert.assertTrue(SearchTaskPage.lnkEdit(driver).isEnabled(),"Failed Edit link not visible");//.click();

	}
	@Test(priority = 21)
	public void verifyViewEnbled() {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		SearchTaskPage.inputBconnId(driver).sendKeys(grptstasksearch.get("bConnID"));
		SearchTaskPage.btnSearch(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		//Validating status=open 
		Assert.assertEquals(SearchTaskPage.colTaskStatus(driver).getText(),"Open","Failed : Task Status is not open");
		Assert.assertEquals(SearchTaskPage.colDialingMethod(driver).getText(),"Manual","Failed : Dialing method is not Manual");
		softAssert.assertTrue(SearchTaskPage.lnkView(driver).isEnabled(),"Failed View link not visible");//.click();
	}
	@Test(priority = 22)
	public void verifyEditFlow() {
		Assert.assertTrue(SearchTaskPage.launch(driver));
		SearchTaskPage.inputBconnId(driver).sendKeys(grptstasksearch.get("bConnID"));
		SearchTaskPage.btnSearch(driver).click();
		SearchTaskPage.waitForPageLoad(driver);
		//Validating status=open 
		Assert.assertEquals(SearchTaskPage.colTaskStatus(driver).getText(),"Open","Failed : Task Status is not open");
		Assert.assertEquals(SearchTaskPage.colDialingMethod(driver).getText(),"Manual","Failed : Dialing method is not Manual");
		softAssert.assertTrue(SearchTaskPage.lnkEdit(driver).isEnabled(),"Failed Edit link not visible");//.click();
		SearchTaskPage.lnkEdit(driver).click();
		softAssert.assertEquals(SearchEditPage.gettitle(driver),"Task Details - CampaignManagement","Failed : from search page edit click is not working");
	}

}
