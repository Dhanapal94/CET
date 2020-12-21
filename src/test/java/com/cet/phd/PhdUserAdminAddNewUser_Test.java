package com.cet.phd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PhdUserAdminAddNewUserPage;
import com.cet.pagerepositery.phdpages.PhdUserAdminPage;
import com.cet.utility.ExcelUtility;
import com.cet.utility.phd.PHDDBData;

public class PhdUserAdminAddNewUser_Test extends Base{

	static String msid,firstName,lastName,empid,email,supervisor,manager;
	static ArrayList<String> languageSkill = new ArrayList<String>();
	static boolean initializationFlag=true;

	static int count=-1;

	@BeforeClass
	public void addLanguage_Skill() throws ClassNotFoundException, IOException, SQLException {
		setUp();
		PhdUserAdminPage.launch(driver);
		softAssert=new SoftAssert();
		fopenBrowser=false;
		childTest=true;
		parentTest=extent.createTest("Phd-User Admin Add New User Test ");
		team="Phd";
}

@BeforeMethod
public void initializationPhd_UAAddNew() throws Exception
{
	if(initializationFlag) {
		PHDDBData.writeUserAdminAddNewUserData();
		ExcelUtility.setExcelFile(PHDDBData.excelPath, "phdUserAdminAddNew");
		msid=ExcelUtility.getCellData(1, 0);
		firstName=ExcelUtility.getCellData(1, 1);
		lastName=ExcelUtility.getCellData(1, 2);
		empid=ExcelUtility.getCellData(1, 3);
		email=ExcelUtility.getCellData(1, 4);
		supervisor=ExcelUtility.getCellData(1, 5);
		manager=ExcelUtility.getCellData(1, 6);
		PhdUserAdminPage.btnAddUser(driver).click();
		PhdUserAdminAddNewUserPage.launch(driver);
		initializationFlag=false;
	}
}

@AfterMethod
public void closeBrowser() throws Exception {
	if(initializationFlag) {
		fopenBrowser=true;
		PHDDBData.deleteAppUser(msid);
	}

}

@Test(priority=1)
public void addNewUserValidate_Test() throws Exception {
	PhdUserAdminAddNewUserPage.inputMsid(driver).sendKeys(msid);
	PhdUserAdminAddNewUserPage.buttonValidate(driver).click();		
}
@Test(priority=2)
public void addNewUserFirstNameDisabled_Test() throws Exception {		
	Assert.assertTrue(!PhdUserAdminAddNewUserPage.inputFirstName(driver).isEnabled(), "Failed:First Name Enabled in Add User");
}
@Test(priority=3)
public void addNewUserFirstNameDB_Test() throws Exception {			
	Assert.assertEquals(PhdUserAdminAddNewUserPage.getInputBoxValue(PhdUserAdminAddNewUserPage.inputFirstName(driver)), 
			firstName,"Failed:First Name DB Value mismatched - Add User");
}
@Test(priority=4)
public void addNewUserLastNameDisabled_Test() throws Exception {		
	Assert.assertTrue(!PhdUserAdminAddNewUserPage.inputLastName(driver).isEnabled(), "Failed:Last Name Enabled in Add User");
}
@Test(priority=5)
public void addNewUserLastNameDB_Test() throws Exception {			
	Assert.assertEquals(PhdUserAdminAddNewUserPage.getInputBoxValue(PhdUserAdminAddNewUserPage.inputLastName(driver)), 
			lastName,"Failed:Last Name DB Value mismatched - Add User");
}
@Test(priority=6)
public void addNewUserEmployeeIDDisabled_Test() throws Exception {		
	Assert.assertTrue(!PhdUserAdminAddNewUserPage.inputEmployeeId(driver).isEnabled(), "Failed:Employee ID Enabled in Add User");
}
@Test(priority=7)
public void addNewUserEmployeeIDDB_Test() throws Exception {			
	Assert.assertEquals(PhdUserAdminAddNewUserPage.getInputBoxValue(PhdUserAdminAddNewUserPage.inputEmployeeId(driver)), 
			empid,"Failed:EmployeeID DB Value mismatched - Add User");
}
@Test(priority=8)
public void addNewUserEmailIDDisabled_Test() throws Exception {		
	Assert.assertTrue(!PhdUserAdminAddNewUserPage.inputEmailId(driver).isEnabled(), "Failed:Email ID Enabled in Add User");
}
@Test(priority=7)
public void addNewUserEmailIDDB_Test() throws Exception {			
	Assert.assertEquals(PhdUserAdminAddNewUserPage.getInputBoxValue(PhdUserAdminAddNewUserPage.inputEmailId(driver)), 
			email,"Failed:EmailID DB Value mismatched - Add User");
}
@Test(priority=9)
public void addNewUserSupervisorDisabled_Test() throws Exception {		
	Assert.assertTrue(!PhdUserAdminAddNewUserPage.inputSupervisor(driver).isEnabled(), "Failed:Supervisor Enabled in Add User");
}
@Test(priority=10)
public void addNewUserSupervisorDB_Test() throws Exception {			
	Assert.assertEquals(PhdUserAdminAddNewUserPage.getInputBoxValue(PhdUserAdminAddNewUserPage.inputSupervisor(driver)), 
			supervisor,"Failed:Supervisor DB Value mismatched - Add User");
}
@Test(priority=11)
public void addNewUserManagerDisabled_Test() throws Exception {		
	Assert.assertTrue(!PhdUserAdminAddNewUserPage.inputManager(driver).isEnabled(), "Failed:Manager Enabled in Add User");
}
@Test(priority=12)
public void addNewUserManagerDB_Test() throws Exception {			
	Assert.assertEquals(PhdUserAdminAddNewUserPage.getInputBoxValue(PhdUserAdminAddNewUserPage.inputManager(driver)), 
			manager,"Failed:Manager DB Value mismatched - Add User");
}
@Test(priority=12)
public void assignWorkStatus_Test() throws Exception {		
	softAssert.assertTrue(PhdUserAdminAddNewUserPage.inputAssignWork(driver).isEnabled());
	softAssert.assertTrue(!PhdUserAdminAddNewUserPage.inputAssignWork(driver).isSelected());
	verifyassert(softAssert); 
}
@Test(priority=13)
public void activeStatus_Test() throws Exception {		
	softAssert.assertTrue(PhdUserAdminAddNewUserPage.inputStatusActive(driver).isEnabled());
	softAssert.assertTrue(PhdUserAdminAddNewUserPage.inputStatusActive(driver).isSelected());
	verifyassert(softAssert); 
}
@Test(priority=14)
public void inActiveStatus_Test() throws Exception {
	softAssert.assertTrue(PhdUserAdminAddNewUserPage.inputStatusInActive(driver).isEnabled());
	softAssert.assertTrue(!PhdUserAdminAddNewUserPage.inputStatusInActive(driver).isSelected());
	verifyassert(softAssert); 
}
@Test(priority=15)
public void selectTeamPHD_Test()throws Exception {
	PhdUserAdminAddNewUserPage.radioTeamPHD(driver).click();	
	Assert.assertTrue(PhdUserAdminAddNewUserPage.radioTeamPHD(driver).isSelected(),"Failed:PHD Team is not selected!");
}
@Test(priority=16)
public void selectLanguagePHD_Test()throws Exception {
	initializationFlag=true;
	PhdUserAdminAddNewUserPage.checkBoxLanguageEnglish(driver).click();	
	PhdUserAdminAddNewUserPage.checkBoxLanguageChinese(driver).click();
	softAssert.assertTrue(PhdUserAdminAddNewUserPage.checkBoxLanguageEnglish(driver).isSelected(),"Failed:PHD English Languaage  is not selected!");
	softAssert.assertTrue(PhdUserAdminAddNewUserPage.checkBoxLanguageChinese(driver).isSelected(),"Failed:PHD Chinese Languaage  is not selected!");
	verifyassert(softAssert); 
}
@Test(priority=17,enabled=false)
public void saveAddNewUser_Test()throws Exception {
	initializationFlag=true;
	PhdUserAdminAddNewUserPage.buttonSave(driver).click();	   
	Assert.assertEquals(PhdUserAdminAddNewUserPage.alertText(driver)," User profile has been created for User "+firstName+" "+lastName,
			"Failed:Add New User is not saved Successfully!");
}
}
