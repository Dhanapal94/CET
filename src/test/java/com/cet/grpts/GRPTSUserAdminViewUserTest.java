package com.cet.grpts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.UserAdminPage;
import com.cet.pagerepositery.ViewUserPage;
import com.cet.utility.grpts.GetDataFromExcelGRPTS;
import com.cet.utility.grpts.WriteExcelGRPTS;


public class GRPTSUserAdminViewUserTest extends Base{

	private static boolean initFlag=true;
	
	@BeforeClass
	public static void getinit() throws Exception {
		fopenBrowser=true;
		childTest=true;
		parentTest=extent.createTest("Grpts-User Admin View Test");
		team="Grpts";

		viewGrptsUserData = GetDataFromExcelGRPTS.viewGrptsUserData();
	}
	@BeforeMethod
	public static void getViewUserInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue(ViewUserPage.viewLaunch(driver, viewGrptsUserData.get("MS ID")));
			initFlag=false;
		}
	}

	@Test(priority = 1)
	public void verifyLabelsOnViewUser() throws Exception {
		softAssert.assertEquals(ViewUserPage.labelUserInfo(driver).getText(),WriteExcelGRPTS.getGrptslabel("userInfo"),
				"Failed :On View User Page 'User Info' mismatch.");
		softAssert.assertEquals(ViewUserPage.labelMsId(driver).getText(),WriteExcelGRPTS.getGrptslabel("MSID"),
				"Failed : on View 'MS ID' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelFName(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("fname"),"Failed : on View 'First Name' mismatch.");
		softAssert.assertEquals(ViewUserPage.labelLName(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("lanme"),"Failed : On View 'Last Name' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelEmpId(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("empId"),"Failed : On View 'Employee ID' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelEmailId(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("emailId"),"Failed : on View 'Email Id' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelSupervisor(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("supervisor")
				,"Failed : On View 'Supervisor' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelStatus(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("status"),"Failed : On View 'Status' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelActive(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("astatus"),"Failed : On view 'Active' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelInActive(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("inActivestatus"),"Failed: On View 'InActive' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelAssignWork(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("assignWork")
				,"Failed : On View 'Assign work' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelSkill(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("skills"),"Failed : On View 'Skills' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelTeam(driver).getText(),WriteExcelGRPTS.getGrptslabel("team"),"Failed : On View 'Team' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelLanguage(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("language"),"Failed : On View 'Language' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelDialingTeam(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("dialingteam")
				,"Failed : On View 'Dialing Team' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelDialingMethod(driver).getText(),
				WriteExcelGRPTS.getGrptslabel("dialingMehod")
				,"Failed : On View 'Dialing Method' label is mismatch.");
	}

	@Test(priority = 2) // Title Of View User Page::tab Name
	public void verifyTitle() throws Exception {
		softAssert.assertEquals(WriteExcelGRPTS.getGrptslabel("UseradminviewUserTitle")
				, ViewUserPage.getTitle(driver),
				"Failed : View User Page title mismatch.");
	}

	@Test(priority = 3)
	public static void verifyFieldEnabledstatus() {
		softAssert.assertFalse(ViewUserPage.inputFName(driver).isEnabled()
				,"Failed :on View 'MS ID' InputBox is not Enabled.");
		softAssert.assertFalse(ViewUserPage.inputLName(driver).isEnabled()
				,"Failed : On View 'Last Name' InputBox is Enabled.");
		softAssert.assertFalse(ViewUserPage.inputEmpId(driver).isEnabled()
				,"Failed : On View 'Employee Id ' InputBox is Enabled.");
		softAssert.assertFalse(ViewUserPage.inputEmailId(driver).isEnabled()
				,"Failed : On View 'Email Id ' InputBox is Enabled."); 
		softAssert.assertFalse(ViewUserPage.inputSupervisor(driver).isEnabled()
				,"Failed : On View 'Supervisor' InputBox is Enabled.");
		softAssert.assertFalse(ViewUserPage.inputActive(driver).isEnabled()
				,"Failed : On View 'Active' is Enabled."); 
		softAssert.assertFalse(ViewUserPage.inputInActive(driver).isEnabled()
				,"Failed : On View 'InActive' is Enabled.");
		softAssert.assertFalse(ViewUserPage.inputAssignWork(driver).isEnabled()
				,"Failed : On View 'Assign Work' is Enabled.");
		softAssert.assertFalse(ViewUserPage.isTeamEditable(driver)
				,"Failed : on View 'Team' panel is Editable."); 
		softAssert.assertFalse(ViewUserPage.isLanguageEditable(driver)
				,"Failed : on View 'Language' panel is Editable."); 
		softAssert.assertFalse(ViewUserPage.isDialingMethodEditable(driver)
				,"Failed : on View 'Dialing Method' panel is Editable.");
		softAssert.assertFalse(ViewUserPage.isDialingTeamEditable(driver)
				,"Failed : on View 'Dialing Team' panel is Editable.");
		softAssert.assertTrue(ViewUserPage.btnCancel(driver).isEnabled()
				,"Failed : Cancel Button is not displayed");

	}
	@Test (priority = 4)
	public static void verifyValueWithDB() {
		softAssert.assertEquals(ViewUserPage.getInputBoxValue(ViewUserPage.inputMsId(
				driver)),viewUserData.get("MS ID"),"Failed: Data not match for MS ID ");
		softAssert.assertEquals(ViewUserPage.getInputBoxValue(ViewUserPage.inputFName
				(driver)),viewUserData.get("First Name")
				,"Failed: Data not match for 'First Name'");
		softAssert.assertEquals(ViewUserPage.getInputBoxValue(ViewUserPage.inputLName
				(driver)),viewUserData.get("Last Name")
				,"Failed: Data not match for 'Last Name'");
		softAssert.assertEquals(ViewUserPage.getInputBoxValue(ViewUserPage.inputEmpId
				(driver)),viewUserData.get("Employee ID")
				,"Failed: Data not match for 'Employee ID'");
		softAssert.assertEquals(ViewUserPage.getInputBoxValue(ViewUserPage.
				inputEmailId(driver)),viewUserData.get("Email ID")
				,"Failed: Data not match for 'Email ID'");
		softAssert.assertEquals(ViewUserPage.getInputBoxValue(ViewUserPage.
				inputSupervisor(driver)),viewUserData.get("SupervisorF")+" "+viewUserData.get("SupervisorLasttName")
				,"Failed: Data not match for'Supervisor'");
		if(viewUserData.get("Status").contentEquals("1"))
		{
			softAssert.assertTrue(ViewUserPage.inputActive(driver).isSelected()
					,"Failed:Status as 'Active' not selected");
		}else {
			softAssert.assertTrue(ViewUserPage.inputInActive(driver).isSelected()
					,"Failed:Status as 'InActive' not selected");

		}
		if(viewUserData.get("Assign Work").contentEquals("1"))
		{
			softAssert.assertEquals(ViewUserPage.inputAssignWork(driver).isSelected(),
					ViewUserPage.expAssignWorkStatus()
					,"Failed : Assign work inputbox is not selected.");
		}else {
			softAssert.assertFalse(ViewUserPage.inputAssignWork(driver).isSelected()
					,"Failed:Status as 'InActive' not selected");

		}
		softAssert.assertTrue(ViewUserPage.cheklistequal(ViewUserPage.
				selectedInputDialingTeam(driver),ViewUserPage.expDialingTeam(viewUserData.get("Dialing Team")))
				,"Failed : Dialing Team Selected option is not match as per input");
		softAssert.assertTrue(ViewUserPage.cheklistequal(ViewUserPage.
				selectedInputDialingMethod(driver), ViewUserPage.expDialingMethos(viewUserData.get("Dialing Method")))
				,"Failed : Dialing Methods Selected option is not match as per input");
		softAssert.assertTrue(ViewUserPage.cheklistequal(ViewUserPage.
				selectedInputLanguage(driver), ViewUserPage.expLanguage(viewUserData.get("language")))
				,"Failed : Dialing Methods Selected option is not match as per input");
		softAssert.assertTrue(ViewUserPage.cheklistequal(ViewUserPage.
				selectedInputTeam(driver), ViewUserPage.expTeam(viewUserData.get("TEAM")))
				,"Failed : Team Selected option is not match as per input");
	}
	@Test (priority = 5)
	//Cancel button on the View Action Page
	public void verifyViewCancelBtnNavigation() throws Exception {
		ViewUserPage.waitForPageLoad(driver); ViewUserPage.btnCancel(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");
	}



}
