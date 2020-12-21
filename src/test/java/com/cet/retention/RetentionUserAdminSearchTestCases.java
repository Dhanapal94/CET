package com.cet.retention;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.HomePage;
import com.cet.pagerepositery.UserAdminPage;
import com.cet.pagerepositery.retentionpages.RetentionUserAdminPage;
import com.cet.utility.retention.RetentionDBData;


public class RetentionUserAdminSearchTestCases  extends Base  {
	static String  sMSId,sFirstName,sLastName,sEmpId,sSupervisorName;
	private static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> searchData = RetentionDBData.getUserAdminSearchData();
		sMSId=searchData.get("MSId");
		sFirstName=searchData.get("FirstName");
		sLastName=searchData.get("LastName");
		sEmpId=searchData.get("EmpId");
		sSupervisorName= searchData.get("SupervisorFirstName")+" "+searchData.get("SupervisorLastName");
		childTest=true;
		parentTest=extent.createTest("Retention-User Admin Add Search Test");
	}

	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp(); // enable for individual
			Assert.assertTrue(RetentionUserAdminPage.launch(driver));
			fopenBrowser = false; // true for individual
			initFlag=false;
			team="Retention";
		}
		
	}

	@Test(priority=1)
	public static void verifyDefaultPage() throws InterruptedException {
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelUserAdmin(driver), driver),"User Administrator");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSearchPanel(driver), driver),"Search User");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelMsId(driver), driver),"MS ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelFName(driver), driver),"First Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelLName(driver), driver),"Last Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelEmpId(driver), driver),"Employee ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSupervisor(driver), driver),"Supervisor");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelManager(driver), driver),"Manager");
		softAssert.assertTrue(RetentionUserAdminPage.inputMsId(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.inputFName(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.inputLName(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.inputEmpId(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.selectSupervisor(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.selectManager(driver).isEnabled());
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnAddUser(driver), driver),"Add New User");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnCancel(driver), driver),"Cancel");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnReset(driver), driver),"Reset");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnSearch(driver), driver),"Search");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSearchResult(driver), driver),"Search Result");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"MS ID"), driver),"MS ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"First Name"), driver),"First Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"Last Name"), driver),"Last Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"Employee ID"), driver),"Employee ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"Supervisor"), driver),"Supervisor");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"Manager"), driver),"Manager");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.headertext(driver,"Action"), driver),"Action");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.linkFirst(driver), driver),"First");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.linkPrevious(driver), driver),"Previous");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.linkNext(driver), driver),"Next");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.linkLast(driver), driver),"Last");
		verifyassert(softAssert);  
	}
	@Test(priority=2)
	public static void searchByMSID() throws InterruptedException {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.colValue(driver, sMSId).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=3)
	public static void searchByFirstName() throws InterruptedException {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputFName(driver).sendKeys(sFirstName);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.colValue(driver, sFirstName).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=4)
	public static void searchByLastName() throws InterruptedException {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputLName(driver).sendKeys(sLastName);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.colValue(driver, sLastName).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=5)
	public static void searchByEmpID() throws InterruptedException {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputEmpId(driver).sendKeys(sEmpId);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.colValue(driver, sEmpId).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=6)
	public static void searchBySupervisor() throws Exception {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.selectText(RetentionUserAdminPage.selectSupervisor(driver), sSupervisorName, driver);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.colValue(driver, sSupervisorName).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=7)
	public static void searchByManager() throws Exception {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.selectTextByIndex(driver, RetentionUserAdminPage.selectManager(driver), 1);
		String selectedtext = RetentionUserAdminPage.getSelectedtext(driver, RetentionUserAdminPage.selectManager(driver));
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(RetentionUserAdminPage.colValue(driver, selectedtext).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=8)
	public static void searchByAllFields() throws Exception {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		RetentionUserAdminPage.inputFName(driver).sendKeys(sFirstName);
		RetentionUserAdminPage.inputLName(driver).sendKeys(sLastName);
		RetentionUserAdminPage.inputEmpId(driver).sendKeys(sEmpId);
		RetentionUserAdminPage.selectText(RetentionUserAdminPage.selectSupervisor(driver), sSupervisorName, driver);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=9)
	public static void resetAllFields() throws Exception {
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		RetentionUserAdminPage.inputFName(driver).sendKeys(sFirstName);
		RetentionUserAdminPage.inputLName(driver).sendKeys(sLastName);
		RetentionUserAdminPage.inputEmpId(driver).sendKeys(sEmpId);
		RetentionUserAdminPage.selectText(RetentionUserAdminPage.selectSupervisor(driver), sSupervisorName, driver);
		RetentionUserAdminPage.btnReset(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.inputMsId(driver), driver),"");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.inputFName(driver), driver),"");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.inputLName(driver), driver),"");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.inputEmpId(driver), driver),"");
		softAssert.assertEquals(RetentionUserAdminPage.getSelectedtext(driver, RetentionUserAdminPage.selectManager(driver)),"Select");
		softAssert.assertEquals(RetentionUserAdminPage.getSelectedtext(driver,RetentionUserAdminPage.selectSupervisor(driver)),"Select");
		verifyassert(softAssert);  
	}
	
	@Test(priority=10)
	public void verifyNoDataFoundText() {
		UserAdminPage.btnReset(driver).click();
		String sJunkValue="junk1234";
		RetentionUserAdminPage.inputMsId(driver).sendKeys(sJunkValue);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.txtNoDataFound(driver).getText(),"No data available in records","Failed: Data not MSG Text not match");
		softAssert.assertEquals(RetentionUserAdminPage.linkNext(driver).getAttribute("class").contains("disabled"),true);
		softAssert.assertEquals(RetentionUserAdminPage.linkLast(driver).isEnabled(),true);
		softAssert.assertEquals(RetentionUserAdminPage.linkFirst(driver).getAttribute("class").contains("disabled"),true,"Failed : 'First' button default state");
		softAssert.assertEquals(RetentionUserAdminPage.linkPrevious(driver).getAttribute("class").contains("disabled"),true,"Failed : 'Previous' button default state");
	}

	@Test(priority=11)
	public void verifyAddUserBtnNavigation() throws Exception {
		RetentionUserAdminPage.btnAddUser(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getTitle(driver),"AddUser - CampaignManagement", "Failed : Text for 'Add User' is mismatch");
		RetentionUserAdminPage.btnCancel(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
	}
	//cancel button on the User Administratore Page :: Keep this test always last priority 
	@Test (priority=12)
	public void verifyCancelBtnNavigation() throws Exception {
		RetentionUserAdminPage.btnCancel(driver).click();
		HomePage.waitForPageLoad(driver);
		softAssert.assertEquals(HomePage.getTitle(driver),"Home Page - CampaignManagement", "Failed : Text for 'Home Page' is mismatch");
	}
}
