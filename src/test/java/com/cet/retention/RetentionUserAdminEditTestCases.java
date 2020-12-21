package com.cet.retention;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.RetentionUserAdminPage;
import com.cet.utility.retention.RetentionDBData;


public class RetentionUserAdminEditTestCases extends Base {
	static HashMap<String, String> viewUserData;
	static String  sAssignTask,sMSId,sFirstName,sLastName,sEmpId,sSupervisorName,sEmail,sManagerName,sStatus,expValuesTEAM, slanguage;
	private static boolean initFlag=true;
	
	@BeforeClass
	public static void getData()throws Exception {
		viewUserData= RetentionDBData.viewAdminUserData();
		sMSId=viewUserData.get("msid");
		sFirstName=viewUserData.get("firstname");
		sLastName=viewUserData.get("lastname");
		sEmpId=viewUserData.get("EmpId");
		sEmail=viewUserData.get("Email");
		sSupervisorName= viewUserData.get("SupervisorFirstName")+" "+viewUserData.get("SupervisorLastName");
		sManagerName= viewUserData.get("ManagerFirstName")+" "+viewUserData.get("ManagerLastName");
		sStatus=viewUserData.get("status");
		sAssignTask=viewUserData.get("IsAssignTask");
		expValuesTEAM= viewUserData.get("TEAM");
		slanguage=viewUserData.get("language");
		childTest=true;
		parentTest=extent.createTest("Retention-User Admin Edit Test");
	}

	@BeforeMethod
	public static void getViewUserInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp(); // enable for individual
			Assert.assertTrue(RetentionUserAdminPage.editlaunch(driver, sMSId));
			RetentionUserAdminPage.waitForPageLoad(driver);
			initFlag=false;
			fopenBrowser = false; // true for individual
			team="Retention";
		}
	}	

	@Test(priority=1)
	public void verifyEditUserInfo() throws Exception {
	softAssert.assertEquals(RetentionUserAdminPage.getTitle(driver),"EditUser - CampaignManagement", "Failed : Text for text 'EditUser - CampaignManagement' is mismatch");
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
	softAssert.assertTrue(RetentionUserAdminPage.inputActive(driver).isEnabled());
	softAssert.assertTrue(RetentionUserAdminPage.inputInActive(driver).isEnabled());
	softAssert.assertTrue(RetentionUserAdminPage.inputAssignWork(driver).isEnabled());
	softAssert.assertTrue(RetentionUserAdminPage.isTeamEditable(driver));
	softAssert.assertTrue(RetentionUserAdminPage.isLanguageEditable(driver));
	softAssert.assertFalse(RetentionUserAdminPage.isDialingMethodEditable(driver));
	softAssert.assertFalse(RetentionUserAdminPage.isDialingTeamEditable(driver));
	softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnCancel(driver), driver),"Cancel");
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

	if(sStatus.contains("1"))
	{
	softAssert.assertTrue(RetentionUserAdminPage.inputActive(driver).isSelected()
	,"Failed:Status as 'Active' not selected");
	}else {
	softAssert.assertTrue(RetentionUserAdminPage.inputInActive(driver).isSelected()
	,"Failed:Status as 'InActive' not selected");

	}
	System.out.println("Boolean.parseBoolean(sAssignTask)"+sAssignTask.contains("1"));
	if(sAssignTask.contains("1"))
	{
	softAssert.assertTrue(RetentionUserAdminPage.inputAssignWork(driver).isSelected(),
	"Failed : Assign inputbox is not selected.");
	}else {
	softAssert.assertFalse(RetentionUserAdminPage.inputAssignWork(driver).isSelected()
	,"Failed:Assign inputbox is  selected");

	}
	//Button on Edit page 
	softAssert.assertTrue(RetentionUserAdminPage.btnCancel(driver).isEnabled(),"Failed : Cancel button on Edit User not visible");
	softAssert.assertTrue(RetentionUserAdminPage.btnReset(driver).isEnabled(),"Failed : Reset button on Edit User not visible");
	softAssert.assertTrue(RetentionUserAdminPage.btnSave(driver).isEnabled(),"Failed : Save button on Edit not visible");
	verifyassert(softAssert);

	}



	@Test(priority=2)
	public void verifyErrorTextForNoLanguage(){
		String[] langArray = RetentionUserAdminPage.selectedInputLanguage(driver).toArray(new String[0]);
		softAssert.assertTrue(RetentionUserAdminPage.selectLanguage(driver, langArray));
		//after not selecting Dialing method click on Save
		RetentionUserAdminPage.btnSave(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			Assert.assertTrue(alert.getText().contains("Please select Team, Language, Dialing team and Dialing Method"),"Failed : Edit User Save error msg mismatch.");
			alert.accept();
		}
		RetentionUserAdminPage.btnReset(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			Assert.assertTrue(alert.getText().contains("Data reseted sucessfully !"),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
		String[] splitLanguge = slanguage.split(",");
		softAssert.assertTrue(RetentionUserAdminPage.cheklistequal(RetentionUserAdminPage.selectedInputLanguage(driver),splitLanguge),"Fail : Language not matching");
		verifyassert(softAssert);
	}

	//Cancel button on the Edit Action Page 
	@Test(priority=3)
	public static void verifyViewCancelBtnNavigation() throws Exception {
		RetentionUserAdminPage.waitForPageLoad(driver); 
		RetentionUserAdminPage.btnCancel(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getTitle(driver),"User Administrator - CampaignManagement", "Failed : Text for 'User Administration' is mismatch"); 
		verifyassert(softAssert);
	}
}
