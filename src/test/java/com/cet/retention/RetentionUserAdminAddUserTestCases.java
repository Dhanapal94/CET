package com.cet.retention;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.RetentionUserAdminPage;
import com.cet.utility.retention.RetentionDBData;	


public class RetentionUserAdminAddUserTestCases  extends Base  {
	static String  sMSId,sFirstName,sLastName,sEmpId,sSupervisorName,sEmail,sManagerName,sStatus;
	private static boolean initFlag=true;

	/*
	 * static String[] team= {"Retention"};static String[] lang=
	 * {"Mandarin","English"}; static String[] methodlist= {"Manual"};
	 */	
	@BeforeClass
	public static void getData() throws Exception {
		HashMap<String, String> searchData = RetentionDBData.getAddUserAdminSearchData();
		sMSId=searchData.get("msid");
		sFirstName=searchData.get("FirstName");
		sLastName=searchData.get("LastName");
		sEmpId=searchData.get("EmpId");
		sEmail=searchData.get("Email");
		sSupervisorName= searchData.get("SupervisorFirstName")+" "+searchData.get("SupervisorLastName");
		sManagerName= searchData.get("ManagerFirstName")+" "+searchData.get("ManagerLastName");
		sStatus=searchData.get("Status");
		childTest=true;
		parentTest=extent.createTest("Retention-User Admin Add New User Test");
	}

	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue(RetentionUserAdminPage.AddUserlaunch(driver));
			initFlag=false;
			fopenBrowser = true; // set to true for individuall run
			team="Retention";
		}
		
	}

	@Test(priority=1)
	public static void verifyDefaultPage() throws InterruptedException {
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getTitle(driver),"AddUser - CampaignManagement","Failed : On Add User Page Title is mismatch.");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelUserAdmin(driver), driver),"Add User","Fail : Add User");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSearchPanel(driver), driver),"User Info","Fail : User Info");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelMsId(driver), driver),"MS ID","Fail : MSID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelFName(driver), driver),"First Name","Fail : First Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelLName(driver), driver),"Last Name","Fail : Last Name");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelEmpId(driver), driver),"Employee ID","Fail : Employee ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelEmailId(driver), driver),"Email ID","Fail : Email ID");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSupervisor(driver), driver),"Supervisor","Fail : Supervisor");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelManager(driver), driver),"Manager","Fail : Manager");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelStatus(driver), driver),"Status","Fail : Status");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelAssignWork(driver), driver),"Assign Work","Fail : Assign Work");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelActive(driver), driver),"Active","Fail : Active");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelInActive(driver), driver),"Inactive","Fail : Inactive");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelSkill(driver), driver),"Skills","Fail : Skills");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelLanguage(driver), driver),"Language","Fail : Language");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelTeam(driver), driver),"Team","Fail : Team");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelDialingTeam(driver), driver),"Dialing Team","Fail : Dialing Team");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.labelDialingMethod(driver), driver),"Dialing Method","Fail : Dialing Method");
		softAssert.assertTrue(RetentionUserAdminPage.inputMsId(driver).isEnabled(),"Fail : MSID enabled");
		softAssert.assertFalse(RetentionUserAdminPage.inputFName(driver).isEnabled(),"Fail : First Name enabled");
		softAssert.assertFalse(RetentionUserAdminPage.inputLName(driver).isEnabled(),"Fail : Last Name enabled");
		softAssert.assertFalse(RetentionUserAdminPage.inputEmpId(driver).isEnabled(),"Fail : EmpID enabeled");
		softAssert.assertFalse(RetentionUserAdminPage.inputEmailId(driver).isEnabled(),"Fail : EmailID enabeled");
		softAssert.assertFalse(RetentionUserAdminPage.inputSupervisor(driver).isEnabled(),"Fail : Supervisor enabeled");
		softAssert.assertFalse(RetentionUserAdminPage.inputManager(driver).isEnabled(),"Fail : Manager enabeled");
		softAssert.assertTrue(RetentionUserAdminPage.inputActive(driver).isSelected(),"Fail : Active enabeled");
		softAssert.assertTrue(RetentionUserAdminPage.btnSave(driver).isEnabled(),"Fail : Save enabeled");	
		softAssert.assertTrue(RetentionUserAdminPage.btnValidate(driver).isEnabled(),"Fail : Validate enabeled");
		softAssert.assertTrue(RetentionUserAdminPage.btnCancel(driver).isEnabled(),"Fail : Cancel enabeled");
		softAssert.assertTrue(RetentionUserAdminPage.btnReset(driver).isEnabled(),"Fail : Reset enabeled");
		softAssert.assertTrue(RetentionUserAdminPage.isDialingTeamEditable(driver),"Fail : Dialing Team editable");
		softAssert.assertTrue(RetentionUserAdminPage.isDialingMethodEditable(driver),"Fail : DialingMethod editable");
		softAssert.assertTrue(RetentionUserAdminPage.isLanguageEditable(driver),"Fail : Language editable");
		softAssert.assertTrue(RetentionUserAdminPage.isTeamEditable(driver),"Fail: Team editable");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnSave(driver), driver),"Save");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnValidate(driver), driver),"Validate");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnCancel(driver), driver),"Cancel");
		softAssert.assertEquals(RetentionUserAdminPage.getText(RetentionUserAdminPage.btnReset(driver), driver),"Reset");
		verifyassert(softAssert);  
	}

	@Test(priority=2)
	public void verifInvalidMSID() throws InterruptedException {
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).sendKeys("0001111");
		RetentionUserAdminPage.btnValidate(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),"User does not exist for MS Id:  0001111");
			alert.accept();
		}
		verifyassert(softAssert); 
	}

	@Test(priority=3)
	public void verifSaveError() throws InterruptedException {
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).clear();
		RetentionUserAdminPage.btnSave(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),"Please Enter MSID");
			alert.accept();
		}
		verifyassert(softAssert); 
	}
	@Test(priority=4)
	public void verifValidateError() throws InterruptedException {
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).clear();
		RetentionUserAdminPage.btnValidate(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),"User does not exist for MS Id:  ");
			alert.accept();
		}
		verifyassert(softAssert); 
	}
	@Test(priority=5)
	public void verifExistMSID() throws InterruptedException {
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).clear();
		RetentionUserAdminPage.inputMsId(driver).sendKeys(Base.sMSID);
		RetentionUserAdminPage.btnValidate(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),"User Already exists for MS ID: "+Base.sMSID);
			alert.accept();
		}
		verifyassert(softAssert); 
	}

	@Test(priority=6)
	public static void SaveUser() throws Exception {
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).clear();
		RetentionUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		RetentionUserAdminPage.btnValidate(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputMsId(driver)),sMSId);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputFName(driver)),sFirstName);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputLName(driver)),sLastName);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputEmpId(driver)),sEmpId);
		//softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputEmailId(driver)),sEmail);
		softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputSupervisor(driver)),sSupervisorName);
		//softAssert.assertEquals(RetentionUserAdminPage.getInputBoxValue(RetentionUserAdminPage.inputManager(driver)),sManagerName);
		//Select AssignWork 
		softAssert.assertTrue(RetentionUserAdminPage.selectAssignWork(driver,"true"),"Fail : Assign Work selected");
		//Select Team 
		softAssert.assertTrue(RetentionUserAdminPage.selectTeam(driver,RetentionUserAdminPage.expValues("Retention")),"Fail : team as retention not able to select");
		//Select Dialing Language
		softAssert.assertTrue(RetentionUserAdminPage.selectLanguage(driver, RetentionUserAdminPage.expValues("Mandarin,Russian")),"Fail : Given languge not selected");
		softAssert.assertFalse(RetentionUserAdminPage.isDialingTeamEditable(driver),"Fail :DialingTeam editable");
		softAssert.assertFalse(RetentionUserAdminPage.isDialingMethodEditable(driver),"Fail :DialingMethod editable");
		List<String> selectedInputDialingMethod = RetentionUserAdminPage.selectedInputDialingMethod(driver);
		softAssert.assertTrue(RetentionUserAdminPage.cheklistequal(selectedInputDialingMethod, RetentionUserAdminPage.expValues("Manual")));
		//Click On Save Button . 
		RetentionUserAdminPage.btnSave(driver).click();
		if(RetentionUserAdminPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains("User profile has been created for User "));
			alert.accept();
		}
		verifyassert(softAssert);  
	}

	@Test(priority=6,dependsOnMethods={"SaveUser"})
	public static void VerifyUserSaved() throws Exception {
		Assert.assertTrue(RetentionUserAdminPage.launch(driver));
		RetentionUserAdminPage.waitForPageLoad(driver);
		RetentionUserAdminPage.inputMsId(driver).sendKeys(sMSId);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		softAssert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		verifyassert(softAssert);  
	}

	@AfterClass(alwaysRun=true)
	public static void removeuser() throws ClassNotFoundException, SQLException
	{
		RetentionDBData.deletUser(sMSId);
	}
}
