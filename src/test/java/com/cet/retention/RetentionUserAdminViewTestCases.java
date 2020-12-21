package com.cet.retention;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.RetentionUserAdminPage;
import com.cet.utility.retention.RetentionDBData;


public class RetentionUserAdminViewTestCases  extends Base  {
	static HashMap<String, String> viewUserData ;
	static String  sMSId,sFirstName,sLastName,sEmpId,sSupervisorName,sEmail,sManagerName,sStatus,expValuesTEAM, slanguage;
	private static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {
		viewUserData= RetentionDBData.viewAdminUserData();
		sMSId=viewUserData.get("msid");
		sFirstName=viewUserData.get("firstname");
		sLastName=viewUserData.get("lastname");
		sEmpId=viewUserData.get("EmpId");
		sEmail=viewUserData.get("Email");
		sSupervisorName= viewUserData.get("SupervisorFirstName")+" "+viewUserData.get("SupervisorLastName");
		sManagerName= viewUserData.get("ManagerFirstName")+" "+viewUserData.get("ManagerLastName");
		sStatus=viewUserData.get("Status");
		expValuesTEAM= viewUserData.get("TEAM");
		slanguage=viewUserData.get("language");
		childTest=true;
		parentTest=extent.createTest("Retention-User Admin View Test");
	}



	@BeforeMethod
	public static void getViewUserInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp();
			Assert.assertTrue(RetentionUserAdminPage.viewLaunch(driver, viewUserData.get("msid")));
			fopenBrowser=true;
			initFlag=false;
			team="Retention";
		}
	}

	@Test(priority=1)
	public static void verifyDefaultPage() throws InterruptedException {
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelUserAdmin(driver), driver),"View User");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSearchPanel(driver), driver),"User Info");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelMsId(driver), driver),"MS ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelFName(driver), driver),"First Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelLName(driver), driver),"Last Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelEmpId(driver), driver),"Employee ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSupervisor(driver), driver),"Supervisor");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelManager(driver), driver),"Manager");
		softAssert.assertFalse(RetentionUserAdminPage.inputMsId(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputFName(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputLName(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputEmpId(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputSupervisor(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputManager(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputActive(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputInActive(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.inputAssignWork(driver).isEnabled());
		softAssert.assertFalse(RetentionUserAdminPage.isTeamEditable(driver));
		softAssert.assertFalse(RetentionUserAdminPage.isLanguageEditable(driver));
		softAssert.assertFalse(RetentionUserAdminPage.isDialingMethodEditable(driver));
		softAssert.assertFalse(RetentionUserAdminPage.isDialingTeamEditable(driver));
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnCancel(driver), driver),"Cancel");
		verifyassert(softAssert);  
	}
	@Test(priority=2)
	public static void verifyValue() {
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputMsId(driver)),sMSId,"Fail : MSID fail");
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputFName(driver)),sFirstName,"Fail : First name value");
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputLName(driver)),sLastName,"Fail : Last name value");
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputEmpId(driver)),sEmpId);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputEmailId(driver)),sEmail);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputSupervisor(driver)),sSupervisorName);
		String[] splitTeam = expValuesTEAM.split(",");
		softAssert.assertTrue(RetentionUserAdminPage.cheklistequal(RetentionUserAdminPage.selectedInputTeam(driver),splitTeam),"Fail : Team not matching");
		List<String> selectedInputDialingMethod = RetentionUserAdminPage.selectedInputDialingMethod(driver);
		softAssert.assertTrue(RetentionUserAdminPage.cheklistequal(selectedInputDialingMethod, RetentionUserAdminPage.expValues("Manual")),"Fail : DialingMethod not matching");
		String[] splitLanguge = slanguage.split(",");
		softAssert.assertTrue(RetentionUserAdminPage.cheklistequal(RetentionUserAdminPage.selectedInputLanguage(driver),splitLanguge),"Fail : Language not matching");
		verifyassert(softAssert);
	}

	@Test (priority=3)//Cancel button on the View Action Page public void
	public static void verifyViewCancelBtnNavigation() throws Exception {
		RetentionUserAdminPage.waitForPageLoad(driver); 
		RetentionUserAdminPage.btnCancel(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getTitle(driver),"User Administrator - CampaignManagement", "Failed : Text for 'User Administration' is mismatch"); 
		verifyassert(softAssert);
	}

}
