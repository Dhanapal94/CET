package com.cet.indts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.UserAdminAddUserPage;
import com.cet.pagerepositery.UserAdminPage;

public class UserAdminAddUserTest extends Base  {

	//private static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {
		childTest=true;
		parentTest=extent.createTest("Indts-User Admin Add New User Test");
		team="Indts";
	}

	@BeforeMethod
	public void initialize() {
		softAssert=new SoftAssert();
	}

	@Test(priority=1)
	public void verifyTitle() throws InterruptedException {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.expPageTitle(),UserAdminAddUserPage.getTitle(driver),"Failed : On Add User Page Title is mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=2)
	public void verifyPageTitle() throws InterruptedException {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.pageLabel(driver),UserAdminAddUserPage.expTitle(),"Failed : On Add User Label Title is mismatch");
		verifyassert(softAssert);
	}
	@Test(priority=3)
	public void verifyLabelMsID() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelMsId(driver).getText(),UserAdminAddUserPage.expTxtMsId(),"Failed : On Add User 'Ms Id ' label is mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=4)
	public void verifyLabelFName() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelFName(driver).getText(),UserAdminAddUserPage.expTxtFname(),"Failed : on Add User 'First Name' label is mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=5)
	public void verifyLabelLName() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelLName(driver).getText(),UserAdminAddUserPage.expTxtLname(),"Failed : on Add User 'Last Name' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=6)
	public void verifyLabelEmpId() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelEmpId(driver).getText(),UserAdminAddUserPage.expTxtEmpID(),"Failed : On Add User 'Employee Id' is mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=7)
	public void verifyLabelEmailId() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelEmailId(driver).getText(),UserAdminAddUserPage.expTxtEmailId(),"Failed : On Add User 'Email ID ' label is mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=8)
	public void verifyLabelSupervisor() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelSupervisor(driver).getText(),UserAdminAddUserPage.expTxtSupervisor(),"Failed : Add User 'Supervisor' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=9)
	public void verifyLabelStatus() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelStatus(driver).getText(),UserAdminAddUserPage.expTxtStatus(),"Failed : Add User 'Status' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=10)
	public void verifyLabelActive() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelActive(driver).getText(),UserAdminAddUserPage.expTxtActive(),"Failed: On Add User 'Active' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=11)
	public void verifyLabelInActive() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelInActive(driver).getText(),UserAdminAddUserPage.expTxtInActive(),"Failed : Add User 'InActive' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=12)
	public void verifyLabelAssignWork() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelAssignWork(driver).getText(),UserAdminAddUserPage.expTxtAssignWork(),"Failed : Add User 'Assign work ' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=13)
	public void verifyInputFName() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertFalse(UserAdminAddUserPage.inputFName(driver).isEnabled(),"Failed : on Add User 'First Name' Inputbox is enabled");
		UserAdminAddUserPage.waitForPageLoad(driver);
		Assert.assertTrue(UserAdminAddUserPage.enterMsID(driver,UserAdminAddUserPage.expAddMSID()));
		softAssert.assertFalse(UserAdminAddUserPage.inputFName(driver).isEnabled(),"Failed : on Add User 'First Name' Inputbox is enabled");
		verifyassert(softAssert);
	}
	@Test(priority=14)
	public void verifyInputLName() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertFalse(UserAdminAddUserPage.inputLName(driver).isEnabled(),"Failed : On Add User 'Last Name' is enbled.");
		verifyassert(softAssert);
	}
	@Test(priority=15)
	public void verifyInputEmpId() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertFalse(UserAdminAddUserPage.inputEmpId(driver).isEnabled(),"Failed : On Add User 'Employee Id ' inputBox enabled.");
		verifyassert(softAssert);
	}
	@Test(priority=16)
	public void verifyInputEmailId() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertFalse(UserAdminAddUserPage.inputEmailId(driver).isEnabled(),"Failed : On Add User 'Email ID' InputBox is enabled.");
		verifyassert(softAssert);
	}
	@Test(priority=17)
	public void verifyInputSupervisor() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertFalse(UserAdminAddUserPage.inputSupervisor(driver).isEnabled(),"Failed : Add User 'Supervisor' InputBox is enbled.");
		verifyassert(softAssert);
	}
	@Test(priority=18)
	public void verifyInputActive() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.inputActive(driver).isSelected(),true);
		verifyassert(softAssert);
	}
	@Test(priority=19)
	public void verifyBtnValidate() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.btnValidate(driver).getText(),UserAdminAddUserPage.expTxtBtnValidate(),"Failed : On Add User 'Validate' text mismatch.");
		softAssert.assertTrue(UserAdminAddUserPage.btnValidate(driver).isEnabled(),"Failed : On Add User 'Validate' button is not dispaly.");
		verifyassert(softAssert);
	}
	@Test(priority=20)
	public void verifyLabelSkills() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.labelSkill(driver).getText(),UserAdminAddUserPage.expTxtSkills(),"Failed : On Add user 'Skill' label mismatch.");
		verifyassert(softAssert);
	}
	@Test(priority=21)
	public void verifyBtnCancel() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.btnCancel(driver).getText(),UserAdminAddUserPage.expTxtBtnCancel(), "Failed : Text for 'Cancel' is mismatch");
		softAssert.assertTrue(UserAdminAddUserPage.btnCancel(driver).isEnabled(),"Failed : On Add User Button 'Cancel' not Enabled");	
		verifyassert(softAssert);
	}
	@Test(priority=22)
	public void verifyCancelBtnNavigation() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		UserAdminAddUserPage.btnCancel(driver).click();
		UserAdminAddUserPage.waitForPageLoad(driver);
		softAssert.assertEquals(UserAdminPage.labelUserAdmin(driver).getText(),UserAdminPage.expTxtTitle(), "Failed : Text for 'User Admin' is mismatch");
		verifyassert(softAssert);
	}
	@Test(priority=23)
	public void verifyBtnReset() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.btnReset(driver).getText(),UserAdminAddUserPage.expTxtBtnReset(), "Failed : Text for 'Reset' is mismatch");
		softAssert.assertTrue(UserAdminAddUserPage.btnReset(driver).isEnabled(),"Failed :On Add User Button 'Reset' not enabled");	
		verifyassert(softAssert);
	}
	@Test(priority=24)
	public void verifyResetAction() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		UserAdminAddUserPage.inputMsId(driver).sendKeys(UserAdminAddUserPage.expValueMSID());
		UserAdminAddUserPage.btnReset(driver).click();
		if(UserAdminAddUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),UserAdminAddUserPage.expMsgReset());
			alert.accept();
			UserAdminAddUserPage.waitForPageLoad(driver);
			//It is defect it is selecting IsInactive 
			//softAssert.assertEquals(UserAdminAddUserPage.launch(driver).inputActive(driver).isSelected(),true);
		}
		verifyassert(softAssert);
	}
	@Test(priority=25)
	public void verifyBtnSave() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertEquals(UserAdminAddUserPage.btnSave(driver).getText(),UserAdminAddUserPage.expTxtBtnSave(), "Failed : Text for 'Save' is mismatch");
		softAssert.assertEquals(UserAdminAddUserPage.btnSave(driver).isEnabled(),true,"Failed : Button 'Save' not Enabled");	
		verifyassert(softAssert);
	}
	@Test(priority=26)
	public void verifExistMSID() throws InterruptedException {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		UserAdminAddUserPage.inputMsId(driver).sendKeys(UserAdminAddUserPage.expValueExistMsID());
		UserAdminAddUserPage.btnValidate(driver).click();
		if(UserAdminAddUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),UserAdminAddUserPage.expMSGExistMsID(),"Failed : Add User MS ID Exist msg mismatch.");
			alert.accept();
		}
		verifyassert(softAssert);
	}
	@Test(priority=27)
	public void verifInvalidMSID() throws InterruptedException {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		UserAdminAddUserPage.inputMsId(driver).sendKeys(UserAdminAddUserPage.expValueInvalidMsID());
		UserAdminAddUserPage.btnValidate(driver).click();
		if(UserAdminAddUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertEquals(alert.getText(),UserAdminAddUserPage.expMSGInvalidMsID(),"Failed : Add User MS ID Invalid msg mismatch.");
			alert.accept();
		}
		verifyassert(softAssert);
	}
	@Test(priority=28)  //Team is Disabled.
	public void verifyTeamListEnbled() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertTrue(UserAdminAddUserPage.isTeamEditable(driver),"Failed : on Add User 'Team' panel is not editable.");
		verifyassert(softAssert);
	}
	@Test(priority=29) //Team is Disabled.
	public void verifyLanguageListEnbled() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertTrue(UserAdminAddUserPage.isLanguageEditable(driver),"Failed : on Add User 'Language' panel is not editable.");
		verifyassert(softAssert);
	}
	@Test(priority=30)  //Dialing Method is Disabled.
	public void verifyDialingMethodEnbled() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertTrue(UserAdminAddUserPage.isDialingMethodEditable(driver),"Failed : on Add User 'Dialing Method' panel is not editable.");
		verifyassert(softAssert);
	}
	@Test(priority=31)  //Dialing Team is Disabled.
	public void verifyDialinTeamEnabled() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		softAssert.assertTrue(UserAdminAddUserPage.isDialingTeamEditable(driver),"Failed : on Add User 'Dialing Team' panel is not editable.");
		verifyassert(softAssert);
	}
	@Test(priority=32)
	//Add User Function 
	public static void AddUser() {
		Assert.assertTrue(UserAdminAddUserPage.launch(driver));
		UserAdminAddUserPage.enterMsID(driver,UserAdminAddUserPage.expAddMSID());
		UserAdminAddUserPage.waitForPageLoad(driver);
		//Verify pre-poulated Data 
		softAssert.assertEquals(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputMsId(driver)),UserAdminAddUserPage.expAddMSID(),"Failed  : Add User 'MSID' vlaue not correct");
		softAssert.assertEquals(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputFName(driver)),UserAdminAddUserPage.expAddFirstName(),"Failed  : Add User 'First Name' vlaue not correct");
		softAssert.assertEquals(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputLName(driver)),UserAdminAddUserPage.expAddLastName(),"Failed  : Add User 'Last Name' vlaue not correct");
		softAssert.assertEquals(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputEmailId(driver)),UserAdminAddUserPage.expAddEmailID(),"Failed  : Add User 'Email ID' vlaue not correct");
		softAssert.assertEquals(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputEmpId(driver)),UserAdminAddUserPage.expAddEMPID(),"Failed  : Add User 'Employee Id' vlaue not correct");
		softAssert.assertEquals(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputSupervisor(driver)),UserAdminAddUserPage.expAddSupervisor(),"Failed  : Add User 'Supervisor' vlaue not correct");
		//Select Status 
		softAssert.assertTrue(UserAdminAddUserPage.selectStatus(driver,UserAdminAddUserPage.expAddStatus()),"Failed : Add user not able to select Status.");
		//Select AssignWork 
		softAssert.assertTrue(UserAdminAddUserPage.selectAssignWork(driver,UserAdminAddUserPage.expAddAssignWork()),"Failed : Add User not able to select Assign Work");
		//Select Team 
		softAssert.assertTrue(UserAdminAddUserPage.selectTeam(driver, UserAdminAddUserPage.expAddTeam()),"Failed : Add User not able to Select Team");
		//Select Dialing Language
		softAssert.assertTrue(UserAdminAddUserPage.selectLanguage(driver, UserAdminAddUserPage.expAddLanguage()),"Failed : Add user not able to select Language");
		//Select Dialing Team
		softAssert.assertTrue(UserAdminAddUserPage.selectDialingTeam(driver, UserAdminAddUserPage.expAddDialingTeam()),"Failed : Add User not able to select Dialing Team");
		//Select Dialing Method
		softAssert.assertTrue(UserAdminAddUserPage.selectDialingMethod(driver, UserAdminAddUserPage.expAddDialingMethos()),"Failed : Add User not able to select Dailing Method");
		//Click On Save Button . 
		UserAdminAddUserPage.btnSave(driver).click();
		if(UserAdminAddUserPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(UserAdminAddUserPage.expMSGSave()),"Failed : Add User Save msg mismatch.");
			alert.accept();
			verifyassert(softAssert);
		}
	}
}	








