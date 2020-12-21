package com.cet.grpts;

import java.util.List;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.UserAdminEditUserPage;
import com.cet.pagerepositery.UserAdminPage;
import com.cet.pagerepositery.ViewUserPage;
import com.cet.utility.grpts.WriteExcelGRPTS;
import com.cet.utility.indts.GetDataFromExcel;



public class GrptsUserAdminEditUserTest extends Base{
	
	private static boolean initFlag=true;
	
	@BeforeClass
	public static void getData()throws Exception {
		WriteExcelGRPTS.editUserWriteTest();
		childTest=true;
		parentTest=extent.createTest("Grpts-User Admin Edit Test");
		team="Grpts";
	}

	@BeforeMethod
	public static void getViewUserInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, viewGrptsUserData.get("MS ID")));
			fopenBrowser=false;
			initFlag=false;
		}
		
	}

	@Test(priority=1)
	public void verifyEditUserInfo() throws Exception {
		softAssert.assertEquals(WriteExcelGRPTS.getGrptslabel("UseradminEditUserTitle"),UserAdminEditUserPage.getTitle(driver), "Failed : Text for text 'EditUser - CampaignManagement' is mismatch");
		softAssert.assertEquals(UserAdminEditUserPage.pageLabel(driver).getText(),UserAdminEditUserPage.expTxtTitle(), "Failed : Text for text 'Edit User' is mismatch");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputMsId(driver)),viewGrptsUserData.get("MS ID"),"Failed: Data not match for MS ID ");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputFName(driver)),viewGrptsUserData.get("First Name"),"Failed: Data not match for 'First Name'");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputLName(driver)),viewGrptsUserData.get("Last Name"),"Failed: Data not match for 'Last Name'");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputEmpId(driver)),viewGrptsUserData.get("Employee ID"),"Failed: Data not match for 'Employee ID'");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputEmailId(driver)),viewGrptsUserData.get("Email ID"),"Failed: Data not match for 'Email ID'");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputSupervisor(driver)),viewGrptsUserData.get("SupervisorF")+" "+viewGrptsUserData.get("SupervisorLasttName"),"Failed: Data not match for'Supervisor'");
		softAssert.assertEquals(UserAdminEditUserPage.getInputBoxValue(UserAdminEditUserPage.inputManager(driver)),viewGrptsUserData.get("Manager"),"Failed: Data not match for'Manager'");
		if(viewGrptsUserData.get("Status").contains("1"))
		{
			softAssert.assertTrue(UserAdminEditUserPage.inputActive(driver).isSelected()
					,"Failed:Status as 'Active' not selected");
		}else {
			softAssert.assertTrue(UserAdminEditUserPage.inputInActive(driver).isSelected()
					,"Failed:Status as 'InActive' not selected");

		}
		if(viewGrptsUserData.get("Assign Work").contentEquals("1"))
		{
			softAssert.assertEquals(UserAdminEditUserPage.inputAssignWork(driver).isSelected(),
					ViewUserPage.expAssignWorkStatus()
					,"Failed : Assign work inputbox is not selected.");
		}else {
			softAssert.assertFalse(UserAdminEditUserPage.inputAssignWork(driver).isSelected()
					,"Failed:Status as 'InActive' not selected");

		}
		//validate skills panel.
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputDialingTeam(driver),UserAdminEditUserPage.expDialingTeam(viewGrptsUserData.get("Dialing Team")))
				,"Failed : Dialing Team Selected option is not match as per input");
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputDialingMethod(driver), UserAdminEditUserPage.expDialingMethos(viewGrptsUserData.get("Dialing Method")))
				,"Failed : Dialing Methods Selected option is not match as per input");
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputLanguage(driver), UserAdminEditUserPage.expLanguage(viewGrptsUserData.get("language")))
				,"Failed : language Selected option is not match as per input");
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputTeam(driver), UserAdminEditUserPage.expTeam(viewGrptsUserData.get("TEAM")))
				,"Failed : Team Selected option is not match as per input");
		//Button on Edit page 
		softAssert.assertTrue(UserAdminEditUserPage.btnCancel(driver).isEnabled(),"Failed : Cancel button on Edit User not visible");
		softAssert.assertTrue(UserAdminEditUserPage.btnReset(driver).isEnabled(),"Failed : Reset button on Edit User not visible");
		softAssert.assertTrue(UserAdminEditUserPage.btnSave(driver).isEnabled(),"Failed : Save button on Edit not visible");
	}

	@Test(priority=2)
	public void verifyErrorTextForNoDialingTeam(){
		List<String> selectedInputDialingTeam = UserAdminEditUserPage.selectedInputDialingTeam(driver);
		//if same element click , it will be unchecked . 
		String[] array =  selectedInputDialingTeam.toArray(new String[0]);
		UserAdminEditUserPage.selectDialingTeam(driver,array);
		//after not selecting Dialing method click on Save
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expErrorMSGSave()),"Failed : Edit User Save error msg mismatch.");
			alert.accept();
		}
		UserAdminEditUserPage.btnReset(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGReset()),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
	}
	@Test(priority=3)
	public void verifyErrorTextForNoDialingMethod(){
		String[] array = UserAdminEditUserPage.selectedInputDialingMethod(driver).toArray(new String[0]);
		//if same element click , it will be unchecked . 
		UserAdminEditUserPage.selectDialingMethod(driver,array);
		//after not selecting Dialing method click on Save
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expErrorMSGSave()),"Failed : Edit User Save error msg mismatch.");
			alert.accept();
		}
		UserAdminEditUserPage.btnReset(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGReset()),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
	}
	@Test(priority=4)
	public void verifyErrorTextForNoLanguage(){
		String[] langArray = UserAdminEditUserPage.selectedInputLanguage(driver).toArray(new String[0]);
		UserAdminEditUserPage.selectLanguage(driver, langArray);
		//after not selecting Dialing method click on Save
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expErrorMSGSave()),"Failed : Edit User Save error msg mismatch.");
			alert.accept();
		}
		UserAdminEditUserPage.btnReset(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGReset()),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
	}
	//Reset language :Unchek and click Reset verify msg ,again verify old values 
	@Test(priority=5)
	public void verifyRestMsgLanguage(){
		String[] langArray = UserAdminEditUserPage.selectedInputLanguage(driver).toArray(new String[0]);
		UserAdminEditUserPage.selectLanguage(driver, langArray);
		//after not selecting Dialing method click on Reset
		UserAdminEditUserPage.btnReset(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGReset()),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
		//validate really data reset 
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputLanguage(driver), UserAdminEditUserPage.expLanguage(viewGrptsUserData.get("language")))
				,"Failed : language Selected option is not match as per input");

	}
	//Reset Dialing Method :Unchek and click Reset verify msg ,again verify old values 
	@Test(priority=6)
	public void verifyResetMsgDialingMethod(){
		String[] array = UserAdminEditUserPage.selectedInputDialingMethod(driver).toArray(new String[0]);
		//if same element click , it will be unchecked . 
		UserAdminEditUserPage.selectDialingMethod(driver,array);
		//after not selecting Dialing method click on Reset
		UserAdminEditUserPage.btnReset(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGReset()),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
		//validate really data reset 
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputDialingMethod(driver), UserAdminEditUserPage.expDialingMethos(viewGrptsUserData.get("Dialing Method")))
				,"Failed : Dialing Methods Selected option is not match as per input");
	}
	//Reset Dialing Team :Unchek and click Reset verify msg ,again verify old values 
	@Test(priority=7)
	public void verifyResetMsgDialingTeam(){
		String[] array = UserAdminEditUserPage.selectedInputDialingTeam(driver).toArray(new String[0]);
		//if same element click , it will be unchecked . 
		UserAdminEditUserPage.selectDialingTeam(driver,array);
		//after not selecting Dialing method click on Reset
		UserAdminEditUserPage.btnReset(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGReset()),"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
		//validate really data reset 
		softAssert.assertTrue(UserAdminEditUserPage.cheklistequal(ViewUserPage.
				selectedInputDialingTeam(driver),UserAdminEditUserPage.expDialingTeam(viewGrptsUserData.get("Dialing Team")))
				,"Failed : Dialing Team Selected option is not match as per input");
	}

	@Test(priority=8)
	public void editUncheckAssignWork() throws Exception{
		count++;
		String editUserMsId = GetDataFromExcel.getEditUserMsId(1);
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		softAssert.assertTrue(UserAdminEditUserPage.inputAssignWork(driver).isSelected(),
				"Failed : Assign work inputbox is not selected.");
		UserAdminEditUserPage.inputAssignWork(driver).click();
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGSave()),"Failed : Edit User Save msg mismatch.");
			alert.accept();
		}
		UserAdminPage.waitForPageLoad(driver);
		//Validate it is un-checked . 
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		softAssert.assertFalse(UserAdminEditUserPage.inputAssignWork(driver).isSelected(),
				"Failed : Assign work inputbox is not selected.");
	}

	@Test(priority=9)
	public void editcheckAssignWork() throws Exception{
		count++;
		String editUserMsId = GetDataFromExcel.getEditUserMsId(0);
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		Assert.assertFalse(UserAdminEditUserPage.inputAssignWork(driver).isSelected(),"Failed : Test data is not correct Assign Work is selected.");
		UserAdminEditUserPage.inputAssignWork(driver).click();
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGSave()),"Failed : Edit User Save msg mismatch.");
			alert.accept();
		}
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");
		//Validate it is checekd . 
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		softAssert.assertTrue(UserAdminEditUserPage.inputAssignWork(driver).isSelected(),
				"Failed : Assign work inputbox is not selected.");
	}

	@Test(priority=10)
	public void editSelectInactive() throws Exception {
		String editUserMsId = GetDataFromExcel.getEditUserMsId(2);
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		UserAdminEditUserPage.waitForPageLoad(driver);
		Assert.assertTrue(UserAdminEditUserPage.inputActive(driver).isSelected(),"Failed : Edit user page Test data as Status : Active not selected.");
		UserAdminEditUserPage.inputInActive(driver).click();
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGSave()),"Failed : Edit User Save msg mismatch.");
			alert.accept();
		}
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		//Validate it is Inactive is selected. 
		softAssert.assertTrue(UserAdminEditUserPage.inputInActive(driver).isSelected(),"Failed : Edit user page InActive not selected.");
	}
	@Test(priority=11)
	public void editSelectActive() throws Exception {
		String editUserMsId = GetDataFromExcel.getEditUserMsId(3);
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		UserAdminEditUserPage.waitForPageLoad(driver);
		Assert.assertTrue(UserAdminEditUserPage.inputInActive(driver).isSelected(),"Failed : Edit user page InActive not selected.");
		UserAdminEditUserPage.inputActive(driver).click();
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGSave()),"Failed : Edit User Save msg mismatch.");
			alert.accept();
		}
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		//Validate it is Active is selected. 
		softAssert.assertTrue(UserAdminEditUserPage.inputActive(driver).isSelected(),"Failed : Edit user page Active not selected.");
	}
	@Test(priority=12)
	public void editSelectLanguage() throws Exception {
		String editUserMsId = GetDataFromExcel.getEditUserMsId(4);
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		UserAdminEditUserPage.waitForPageLoad(driver);
		//verify given language not selected
		Assert.assertFalse(ViewUserPage.chekcontains(UserAdminEditUserPage.selectedInputLanguage(driver),"English"),"Failed :Edit action Language option is selected");
		//check new language 
		String arr []= {"English"};
		UserAdminEditUserPage.selectLanguage(driver,arr);
		UserAdminEditUserPage.btnSave(driver).click();
		if(UserAdminEditUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminEditUserPage.expMSGSave()),"Failed : Edit User Save msg mismatch.");
			alert.accept();
		}
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");
		Assert.assertTrue(UserAdminEditUserPage.editLaunch(driver, editUserMsId));
		//Validate it is Active is selected. 
		Assert.assertTrue(ViewUserPage.chekcontains(UserAdminEditUserPage.selectedInputLanguage(driver), "English"),"Failed :Edit action Language option is selected");

	}

	//Cancel button on the Edit Action Page 
	@Test(priority=13)
	public void verifyEditCancelBtnNavigation() throws Exception {
		UserAdminEditUserPage.btnCancel(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.getTitle(driver),WriteExcelGRPTS.getGrptslabel("UseradminTitle"), "Failed : Text for 'User Administration' is mismatch");

	}

}
