package com.cet.grpts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.utility.grpts.*;
import com.cet.intit.Base;
import com.cet.pagerepositery.HomePage;
import com.cet.pagerepositery.UserAdminAddUserPage;
import com.cet.pagerepositery.UserAdminPage;


public class GrptsUserAdministratorTest extends Base {
	
	private static boolean initFlag=true;
	
	@BeforeClass
	public static void getinit() throws Exception {
		viewGrptsUserData = GetDataFromExcelGRPTS.viewGrptsUserData();
		childTest=true;
		parentTest=extent.createTest("Grpts-UserAdmin Test");
		team="Grpts";
	}
	@BeforeMethod
	public static void getViewUserInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue( UserAdminPage.launch(driver));
			initFlag=false;
			fopenBrowser=false;
		}
		
	}

	@Test(priority=1)
	public static void verifyUserAdministratorLabel() throws InterruptedException,Exception {
		softAssert.assertEquals(WriteExcelGRPTS.getGrptslabel("UseradminTitle"),UserAdminPage.getTitle(driver), "Failed : Text for text 'User Administrator  - CampaignManagement' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelUserAdmin(driver).getText(),WriteExcelGRPTS.getGrptslabel("UseradminLabel"), "Failed : Text for text 'User Administrator' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelSearchPanel(driver).getText(),WriteExcelGRPTS.getGrptslabel("UseradminSearchPanel"), "Failed : Text for text 'Search User' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelMsId(driver).getText(),WriteExcelGRPTS.getGrptslabel("MSID"), "Failed : Text for MS ID is mismatch");
		softAssert.assertEquals(UserAdminPage.labelFName(driver).getText(),WriteExcelGRPTS.getGrptslabel("fname"), "Failed : Text for 'First Name' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelLName(driver).getText(),WriteExcelGRPTS.getGrptslabel("lanme"), "Failed : Text for 'Last Name' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelEmpId(driver).getText(),WriteExcelGRPTS.getGrptslabel("empId"), "Failed : Text for 'Employee ID' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelDialingTeam(driver).getText(),WriteExcelGRPTS.getGrptslabel("dialingteam"), "Failed : Text for 'Dialingteam' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelSupervisor(driver).getText(),WriteExcelGRPTS.getGrptslabel("supervisor"), "Failed : Text for 'Supervisor' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelManager(driver).getText(),WriteExcelGRPTS.getGrptslabel("manager"), "Failed : Text for 'Manager' is mismatch");
		softAssert.assertEquals(UserAdminPage.btnCancel(driver).getText(),WriteExcelGRPTS.getGrptslabel("cancel"), "Failed : Text for 'Cancel' is mismatch");
		softAssert.assertEquals(UserAdminPage.btnReset(driver).getText(),WriteExcelGRPTS.getGrptslabel("reset"), "Failed : Text for 'Reset' is mismatch");
		softAssert.assertEquals(UserAdminPage.btnSearch(driver).getText(),WriteExcelGRPTS.getGrptslabel("search"), "Failed : Text for 'Search' is mismatch");
		softAssert.assertEquals(UserAdminPage.btnAddUser(driver).getText(),WriteExcelGRPTS.getGrptslabel("AddUser"), "Failed : Text for 'Add New User' is mismatch");
		softAssert.assertEquals(UserAdminPage.labelSearchResult(driver).getText(),WriteExcelGRPTS.getGrptslabel("searchResult"), "Failed : Text for 'Search Result' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerMSID(driver).getText(),WriteExcelGRPTS.getGrptslabel("MSID"), "Failed : Text for 'MS ID' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerFname(driver).getText(),WriteExcelGRPTS.getGrptslabel("fname"), "Failed : Text for 'First Name' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerLName(driver).getText(),WriteExcelGRPTS.getGrptslabel("lanme"), "Failed : Text for 'Last Name' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerSupervisor(driver).getText(),WriteExcelGRPTS.getGrptslabel("supervisor"), "Failed : Text for 'Supervisor' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerManager(driver).getText(),WriteExcelGRPTS.getGrptslabel("manager"), "Failed : Text for 'Manager' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerEmpID(driver).getText(),WriteExcelGRPTS.getGrptslabel("empId"), "Failed : Text for 'Employee ID' is mismatch");
		softAssert.assertEquals(UserAdminPage.headerAction(driver).getText(),WriteExcelGRPTS.getGrptslabel("action"), "Failed : Text for 'Action' is mismatch");
		softAssert.assertEquals(UserAdminPage.linkFirst(driver).getText(),WriteExcelGRPTS.getGrptslabel("first"), "Failed : Text for 'First' is mismatch");
		softAssert.assertEquals(UserAdminPage.linkPrevious(driver).getText(),WriteExcelGRPTS.getGrptslabel("previous"), "Failed : Text for 'Previous' is mismatch");
		softAssert.assertEquals(UserAdminPage.linkNext(driver).getText(),WriteExcelGRPTS.getGrptslabel("next"), "Failed : Text for 'Next' is mismatch");
		softAssert.assertEquals(UserAdminPage.linkLast(driver).getText(),WriteExcelGRPTS.getGrptslabel("last"), "Failed : Text for 'Last' is mismatch");
	}
	@Test (priority=2)
	public static void verifyUserAdministratorFieldEnabled() {
		softAssert.assertEquals(UserAdminPage.inputMsId(driver).isEnabled(),true,"Failed : Input box Ms ID not Enabled");	
		softAssert.assertEquals(UserAdminPage.inputFName(driver).isEnabled(),true,"Failed : Input box First Name not Enabled");
		softAssert.assertEquals(UserAdminPage.inputLName(driver).isEnabled(),true,"Failed : Input box Last Name not Enabled");
		softAssert.assertEquals(UserAdminPage.inputEmpId(driver).isEnabled(),true,"Failed : Input box Last Name not Enabled");
		softAssert.assertEquals(UserAdminPage.selectDialingTeam(driver).isEnabled(),true,"Failed : select DialingTeam not Enabled");
		softAssert.assertEquals(UserAdminPage.selectSupervisor(driver).isEnabled(),true,"Failed : select Supervisor not Enabled");
		softAssert.assertEquals(UserAdminPage.selectManager(driver).isEnabled(),true,"Failed : select Manager not Enabled");
		softAssert.assertEquals(UserAdminPage.btnCancel(driver).isEnabled(),true,"Failed : Button 'Cancel' not Enabled");	
		softAssert.assertEquals(UserAdminPage.btnReset(driver).isEnabled(),true,"Failed : Button 'Reset' not Enabled");	
		softAssert.assertEquals(UserAdminPage.btnSearch(driver).isEnabled(),true,"Failed : Button 'Search'not Enabled");	
		softAssert.assertEquals(UserAdminPage.btnAddUser(driver).isEnabled(),true,"Failed : Button 'Add New User'not Enabled");	
		softAssert.assertEquals(UserAdminPage.linkNext(driver).isEnabled(),true);
		softAssert.assertEquals(UserAdminPage.linkLast(driver).isEnabled(),true);
		softAssert.assertEquals(UserAdminPage.linkFirst(driver).getAttribute("class").contains("disabled"),true,"Failed : 'First' button default state");
		softAssert.assertEquals(UserAdminPage.linkPrevious(driver).getAttribute("class").contains("disabled"),true,"Failed : 'Previous' button default state");
	}

	@Test(priority=3)
	public void verifyRestBtnFun() throws Exception {
		String sJunkValue="junk1234";
		UserAdminPage.inputMsId(driver).sendKeys(sJunkValue);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);

		softAssert.assertEquals(UserAdminPage.inputMsId(driver).getText(),"","Failed : 'Reset' is not working for MS ID Inputbox");

		UserAdminPage.inputFName(driver).sendKeys(sJunkValue);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.inputFName(driver).getText(),"","Failed : 'Reset' is not working for 'First Name'Inputbox");

		UserAdminPage.inputLName(driver).sendKeys(sJunkValue);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.inputLName(driver).getText(),"","Failed : 'Reset' is not working for 'Last Name' Inputbox");

		UserAdminPage.inputEmpId(driver).sendKeys(sJunkValue);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.inputEmpId(driver).getText(),"","Failed : 'Reset' is not working for 'Employee ID' Inputbox");

		//Added for new controls ;;1-10-2020
		UserAdminPage.selectTextByIndex(driver, UserAdminPage.selectDialingTeam(driver), 1);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getSelectedtext(driver, UserAdminPage.selectDialingTeam(driver)),"Select","Failed : Rest for Dialing Team is not working");

		//Added for new controls ;;1-10-2020
		UserAdminPage.selectTextByIndex(driver, UserAdminPage.selectSupervisor(driver), 1);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getSelectedtext(driver,UserAdminPage.selectSupervisor(driver)),"Select","Failed : Rest for Supervisor is not working");
	
		//Added for new controls ;;1-10-2020
		UserAdminPage.selectTextByIndex(driver, UserAdminPage.selectManager(driver), 1);
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getSelectedtext(driver,UserAdminPage.selectManager(driver)),"Select","Failed : Rest for Manager is not working");

	}
	@Test(priority=4)
	public void verifyMsIdSearch() {
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.inputMsId(driver).sendKeys(viewUserData.get("MS ID"));
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		softAssert.assertEquals(UserAdminPage.colMSID(driver).getText(),viewUserData.get("MS ID"),"Failed: Data not match for MS ID ");
		softAssert.assertEquals(UserAdminPage.colFName(driver).getText(),viewUserData.get("First Name"),"Failed: Data not match for First Name ");
		softAssert.assertEquals(UserAdminPage.colLName(driver).getText(),viewUserData.get("Last Name"),"Failed: Data not match for Last Name ");
		softAssert.assertEquals(UserAdminPage.colEMPID(driver).getText(),viewUserData.get("Employee ID"),"Failed: Data not match for Employee ID ");
		softAssert.assertEquals(UserAdminPage.colSupervisor(driver).getText(),viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName"),"Failed: Data not match for Supervisor ");
		softAssert.assertEquals(UserAdminPage.colManager(driver).getText(),viewUserData.get("Manager"),"Failed: Data not match for Manager ");
		softAssert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),true,"Failed: Edit link not displayed in search result");
		softAssert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
	}
	@Test(priority=5)
	public void verifyFNameSearch() {
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.inputFName(driver).sendKeys(viewUserData.get("First Name"));
		UserAdminPage.btnSearch(driver).click();
		softAssert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		softAssert.assertEquals(UserAdminPage.colMSID(driver).getText(),viewUserData.get("MS ID"),"Failed: Data not match for MS ID ");
		softAssert.assertEquals(UserAdminPage.colFName(driver).getText(),viewUserData.get("First Name"),"Failed: Data not match for First Name ");
		softAssert.assertEquals(UserAdminPage.colLName(driver).getText(),viewUserData.get("Last Name"),"Failed: Data not match for Last Name ");
		softAssert.assertEquals(UserAdminPage.colEMPID(driver).getText(),viewUserData.get("Employee ID"),"Failed: Data not match for Employee ID ");
		softAssert.assertEquals(UserAdminPage.colSupervisor(driver).getText(),viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName"),"Failed: Data not match for Supervisor ");
		softAssert.assertEquals(UserAdminPage.colManager(driver).getText(),viewUserData.get("Manager"),"Failed: Data not match for Manager ");
		softAssert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),true,"Failed: Edit link not displayed in search result");
		softAssert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
	}
	@Test(priority=6)
	public void verifyLNameSearch() {
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.inputLName(driver).sendKeys(viewUserData.get("Last Name"));
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		softAssert.assertEquals(UserAdminPage.colMSID(driver).getText(),viewUserData.get("MS ID"),"Failed: Data not match for MS ID ");
		softAssert.assertEquals(UserAdminPage.colFName(driver).getText(),viewUserData.get("First Name"),"Failed: Data not match for First Name ");
		softAssert.assertEquals(UserAdminPage.colLName(driver).getText(),viewUserData.get("Last Name"),"Failed: Data not match for Last Name ");
		softAssert.assertEquals(UserAdminPage.colEMPID(driver).getText(),viewUserData.get("Employee ID"),"Failed: Data not match for Employee ID ");
		softAssert.assertEquals(UserAdminPage.colSupervisor(driver).getText(),viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName"),"Failed: Data not match for Supervisor ");
		softAssert.assertEquals(UserAdminPage.colManager(driver).getText(),viewUserData.get("Manager"),"Failed: Data not match for Manager ");
		softAssert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),true,"Failed: Edit link not displayed in search result");
		softAssert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
	}
	@Test(priority=7)
	public void verifyEmpIdSearch() {
		UserAdminPage.btnReset(driver).click();
		UserAdminPage.inputEmpId(driver).sendKeys(viewUserData.get("Employee ID"));
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		softAssert.assertEquals(UserAdminPage.colMSID(driver).getText(),viewUserData.get("MS ID"),"Failed: Data not match for MS ID ");
		softAssert.assertEquals(UserAdminPage.colFName(driver).getText(),viewUserData.get("First Name"),"Failed: Data not match for First Name ");
		softAssert.assertEquals(UserAdminPage.colLName(driver).getText(),viewUserData.get("Last Name"),"Failed: Data not match for Last Name ");
		softAssert.assertEquals(UserAdminPage.colEMPID(driver).getText(),viewUserData.get("Employee ID"),"Failed: Data not match for Employee ID ");
		softAssert.assertEquals(UserAdminPage.colSupervisor(driver).getText(),viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName"),"Failed: Data not match for Supervisor ");
		softAssert.assertEquals(UserAdminPage.colManager(driver).getText(),viewUserData.get("Manager"),"Failed: Data not match for Manager ");
		softAssert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),true,"Failed: Edit link not displayed in search result");
		softAssert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
	}
	//Added on 1-10-2020 New control
	@Test(priority=8)
	public void verifySupervisor() throws Exception {
		UserAdminPage.btnReset(driver).click();
		String supervisor=viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName");
		UserAdminPage.selectByVisibleText(UserAdminPage.selectSupervisor(driver),supervisor, driver);
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		softAssert.assertEquals(UserAdminPage.colSupervisor(driver).getText(),viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName"),"Failed: Data not match for Supervisor ");
		softAssert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),true,"Failed: Edit link not displayed in search result");
		softAssert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
	}
	@Test(priority=9)
	public void verifyNoDataFoundText() {
		UserAdminPage.btnReset(driver).click();
		String sJunkValue="junk1234";
		UserAdminPage.inputMsId(driver).sendKeys(sJunkValue);
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.txtNoDataFound(driver).getText(),UserAdminPage.expTxtNoDataFound(),"Failed: Data not MSG Text not match");
		softAssert.assertEquals(UserAdminPage.linkNext(driver).getAttribute("class").contains("disabled"),true);
		softAssert.assertEquals(UserAdminPage.linkLast(driver).isEnabled(),true);
		softAssert.assertEquals(UserAdminPage.linkFirst(driver).getAttribute("class").contains("disabled"),true,"Failed : 'First' button default state");
		softAssert.assertEquals(UserAdminPage.linkPrevious(driver).getAttribute("class").contains("disabled"),true,"Failed : 'Previous' button default state");
	}

	@Test(priority=10)
	public void verifyAddUserBtnNavigation() throws Exception {
		UserAdminPage.btnAddUser(driver).click();
		UserAdminAddUserPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminAddUserPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminAddUserTitle"), "Failed : Text for 'Add User' is mismatch");
		UserAdminAddUserPage.btnCancel(driver).click();
		UserAdminPage.waitForPageLoad(driver);
	}
	//cancel button on the User Administratore Page :: Keep this test always last priority 
	@Test (priority=11)
	public void verifyCancelBtnNavigation() throws Exception {
		UserAdminPage.btnCancel(driver).click();
		HomePage.waitForPageLoad(driver);
		softAssert.assertEquals(HomePage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("homeTitle"), "Failed : Text for 'Home Page' is mismatch");
	}

}
