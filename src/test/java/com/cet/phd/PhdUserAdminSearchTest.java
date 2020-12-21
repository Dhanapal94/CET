package com.cet.phd;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.HomePage;
import com.cet.pagerepositery.phdpages.PhdUserAdminPage;
import com.cet.pagerepositery.UserAdminPage;
import com.cet.utility.phd.PHDDBData;


public class PhdUserAdminSearchTest  extends Base  {
	static String  sMSId,sFirstName,sLastName,sEmpId,sSupervisorName;
	static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> searchData = PHDDBData.getUserAdminSearchData();
		sMSId=searchData.get("MSId");
		sFirstName=searchData.get("FirstName");
		sLastName=searchData.get("LastName");
		sEmpId=searchData.get("EmpId");
		sSupervisorName= searchData.get("SupervisorFirstName")+" "+searchData.get("SupervisorLastName");
		childTest=true;
		parentTest=extent.createTest("Phd-User Admin Search Test");
		team="Phd";
	}

	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue(PhdUserAdminPage.launch(driver));
			fopenBrowser = true;
			initFlag=false;
		}	
	}

	@Test(priority=1)
	public static void verifyDefaultPage() throws InterruptedException {
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelUserAdmin(driver)),"User Administrator");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelSearchPanel(driver)),"Search User");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelMsId(driver)),"MS ID");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelFName(driver)),"First Name");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelLName(driver)),"Last Name");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelEmpId(driver)),"Employee ID");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelSupervisor(driver)),"Supervisor");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelManager(driver)),"Manager");
		softAssert.assertTrue(PhdUserAdminPage.inputMsId(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.inputFName(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.inputLName(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.inputEmpId(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.selectSupervisor(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.selectManager(driver).isEnabled());
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.btnAddUser(driver)),"Add New User");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.btnCancel(driver)),"Cancel");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.btnReset(driver)),"Reset");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.btnSearch(driver)),"Search");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.labelSearchResult(driver)),"Search Result");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"MS ID")),"MS ID");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"First Name")),"First Name");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"Last Name")),"Last Name");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"Employee ID")),"Employee ID");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"Supervisor")),"Supervisor");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"Manager")),"Manager");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.headertext(driver,"Action")),"Action");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.linkFirst(driver)),"First");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.linkPrevious(driver)),"Previous");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.linkNext(driver)),"Next");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.linkLast(driver)),"Last");
		verifyassert(softAssert);  
	}
	@Test(priority=2)
	public static void searchByMSID() throws InterruptedException {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.colValue(driver, sMSId).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=3)
	public static void searchByFirstName() throws InterruptedException {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.inputFName(driver).sendKeys(sFirstName);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.colValue(driver, sFirstName).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=4)
	public static void searchByLastName() throws InterruptedException {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.inputLName(driver).sendKeys(sLastName);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.colValue(driver, sLastName).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=5)
	public static void searchByEmpID() throws InterruptedException {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.inputEmpId(driver).sendKeys(sEmpId);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.colValue(driver, sEmpId).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=6)
	public static void searchBySupervisor() throws Exception {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.selectText(PhdUserAdminPage.selectSupervisor(driver), sSupervisorName, driver);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.colValue(driver, sSupervisorName).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=7)
	public static void searchByManager() throws Exception {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.selectTextByIndex(driver, PhdUserAdminPage.selectManager(driver), 1);
		String selectedtext = PhdUserAdminPage.getSelectedtext(driver, PhdUserAdminPage.selectManager(driver));
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		softAssert.assertTrue(PhdUserAdminPage.colValue(driver, selectedtext).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=8)
	public static void searchByAllFields() throws Exception {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		PhdUserAdminPage.inputFName(driver).sendKeys(sFirstName);
		PhdUserAdminPage.inputLName(driver).sendKeys(sLastName);
		PhdUserAdminPage.inputEmpId(driver).sendKeys(sEmpId);
		PhdUserAdminPage.selectText(PhdUserAdminPage.selectSupervisor(driver), sSupervisorName, driver);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(PhdUserAdminPage.tableRow(driver).isEnabled());
		verifyassert(softAssert);  
	}
	@Test(priority=9)
	public static void resetAllFields() throws Exception {
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		PhdUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		PhdUserAdminPage.inputFName(driver).sendKeys(sFirstName);
		PhdUserAdminPage.inputLName(driver).sendKeys(sLastName);
		PhdUserAdminPage.inputEmpId(driver).sendKeys(sEmpId);
		PhdUserAdminPage.selectText(PhdUserAdminPage.selectSupervisor(driver), sSupervisorName, driver);
		PhdUserAdminPage.btnReset(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.inputMsId(driver)),"");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.inputFName(driver)),"");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.inputLName(driver)),"");
		softAssert.assertEquals(PhdUserAdminPage.getText(PhdUserAdminPage.inputEmpId(driver)),"");
		softAssert.assertEquals(PhdUserAdminPage.getSelectedtext(driver, PhdUserAdminPage.selectManager(driver)),"Select");
		softAssert.assertEquals(PhdUserAdminPage.getSelectedtext(driver,PhdUserAdminPage.selectSupervisor(driver)),"Select");
		verifyassert(softAssert);  
	}
	
	@Test(priority=10)
	public void verifyNoDataFoundText() {
		UserAdminPage.btnReset(driver).click();
		String sJunkValue="junk1234";
		PhdUserAdminPage.inputMsId(driver).sendKeys(sJunkValue);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(PhdUserAdminPage.txtNoDataFound(driver).getText(),"No data available in records","Failed: Data not MSG Text not match");
		softAssert.assertEquals(PhdUserAdminPage.linkNext(driver).getAttribute("class").contains("disabled"),true);
		softAssert.assertEquals(PhdUserAdminPage.linkLast(driver).isEnabled(),true);
		softAssert.assertEquals(PhdUserAdminPage.linkFirst(driver).getAttribute("class").contains("disabled"),true,"Failed : 'First' button default state");
		softAssert.assertEquals(PhdUserAdminPage.linkPrevious(driver).getAttribute("class").contains("disabled"),true,"Failed : 'Previous' button default state");
	}

	@Test(priority=11)
	public void verifyAddUserBtnNavigation() throws Exception {
		PhdUserAdminPage.btnAddUser(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(PhdUserAdminPage.getTitle(driver),"AddUser - CampaignManagement", "Failed : Text for 'Add User' is mismatch");
		PhdUserAdminPage.btnCancel(driver).click();
		PhdUserAdminPage.waitForPageLoad(driver);
	}
	//cancel button on the User Administratore Page :: Keep this test always last priority 
	@Test (priority=12)
	public void verifyCancelBtnNavigation() throws Exception {
		PhdUserAdminPage.btnCancel(driver).click();
		HomePage.waitForPageLoad(driver);
		softAssert.assertEquals(HomePage.getTitle(driver),"Home Page - CampaignManagement", "Failed : Text for 'Home Page' is mismatch");
	}

}
