package com.cet.indts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.UserAdminPage;
import com.cet.pagerepositery.ViewUserPage;
import com.cet.utility.indts.GetDataFromExcel;
import com.cet.utility.indts.WriteExcel;

public class UserAdminViewUserTest extends Base {

	private static boolean initFlag=true;
	
	@BeforeClass
	public static void getinit() throws Exception {
		fopenBrowser=true;
		viewUserData = GetDataFromExcel.viewUserData();
		childTest=true;
		parentTest=extent.createTest("Indts-User Admin View Test");
		team="Indts";
	}
	@BeforeMethod
	public static void getViewUserInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp();
			Assert.assertTrue(ViewUserPage.viewLaunch(driver, viewUserData.get("MS ID")));
			initFlag=false;
		}

	}

	@Test(priority=1)
	public void verifyLabelsOnViewUser() throws Exception {
		softAssert.assertEquals(ViewUserPage.labelUserInfo(driver).getText(),WriteExcel.getlabel("userInfo"),
				"Failed :On View User Page 'User Info' mismatch.");
		softAssert.assertEquals(ViewUserPage.labelMsId(driver).getText(),WriteExcel.getlabel("MSID"),
				"Failed : on View 'MS ID' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelFName(driver).getText(),
				WriteExcel.getlabel("fname"),"Failed : on View 'First Name' mismatch.");
		softAssert.assertEquals(ViewUserPage.labelLName(driver).getText(),
				WriteExcel.getlabel("lanme"),"Failed : On View 'Last Name' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelEmpId(driver).getText(),
				WriteExcel.getlabel("empId"),"Failed : On View 'Employee ID' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelEmailId(driver).getText(),
				WriteExcel.getlabel("emailId"),"Failed : on View 'Email Id' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelSupervisor(driver).getText(),
				WriteExcel.getlabel("supervisor")
				,"Failed : On View 'Supervisor' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelStatus(driver).getText(),
				WriteExcel.getlabel("status"),"Failed : On View 'Status' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelActive(driver).getText(),
				WriteExcel.getlabel("astatus"),"Failed : On view 'Active' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelInActive(driver).getText(),
				WriteExcel.getlabel("inActivestatus"),"Failed: On View 'InActive' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelAssignWork(driver).getText(),
				WriteExcel.getlabel("assignWork")
				,"Failed : On View 'Assign work' label mismatch.");
		softAssert.assertEquals(ViewUserPage.labelSkill(driver).getText(),
				WriteExcel.getlabel("skills"),"Failed : On View 'Skills' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelTeam(driver).getText(),WriteExcel.getlabel("team"),"Failed : On View 'Team' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelLanguage(driver).getText(),
				WriteExcel.getlabel("language"),"Failed : On View 'Language' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelDialingTeam(driver).getText(),
				WriteExcel.getlabel("dialingteam")
				,"Failed : On View 'Dialing Team' label is mismatch.");
		softAssert.assertEquals(ViewUserPage.labelDialingMethod(driver).getText(),
				WriteExcel.getlabel("dialingMehod")
				,"Failed : On View 'Dialing Method' label is mismatch.");
		verifyassert(softAssert);
	}

	@Test // Title Of View User Page::tab Name
	public void verifyTitle() throws Exception {
		softAssert.assertEquals(WriteExcel.getlabel("UseradminviewUserTitle")
				, ViewUserPage.getTitle(driver),
				"Failed : View User Page title mismatch.");
		verifyassert(softAssert);
	}

	@Test(priority=2)
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
		verifyassert(softAssert);

	}
	@Test(priority=3)
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
		verifyassert(softAssert);
	}
	@Test(priority=4)
	//Cancel button on the View Action Page
	public void verifyViewCancelBtnNavigation() throws Exception {
		ViewUserPage.waitForPageLoad(driver); ViewUserPage.btnCancel(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcel.getlabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");
		verifyassert(softAssert);
	}


}
