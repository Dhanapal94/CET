package com.cet.pagerepositery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cet.utility.Readconfig;

public class UserAdminEditUserPage extends UserAdminAddUserPage {

	public UserAdminEditUserPage(WebDriver driver) {
		super(driver);

	}

	//click on Edit link from search result 
	public static boolean editLaunch(WebDriver driver,String msID) {
		Assert.assertTrue( UserAdminPage.launch(driver));
		UserAdminPage.inputMsId(driver).sendKeys(msID);
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		Assert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		Assert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),true,"Failed: View link not displayed in search result");
		UserAdminPage.lnkEdit(driver).click();
		UserAdminEditUserPage.waitForPageLoad(driver);
		boolean contains = UserAdminEditUserPage.pageLabel(driver).getText().contains("Edit User");
		return contains;
	}

	/*
	 * public static boolean editLaunch(WebDriver driver , String editMSID) {
	 * Assert.assertTrue( UserAdminPage.launch(driver));
	 * UserAdminPage.inputMsId(driver).sendKeys(editMSID);
	 * UserAdminPage.btnSearch(driver).click();
	 * UserAdminPage.waitForPageLoad(driver);
	 * Assert.assertTrue(UserAdminPage.tableRow(driver).isEnabled()
	 * ,"Failed: row not displayed");
	 * Assert.assertEquals(UserAdminPage.lnkEdit(driver).isEnabled(),
	 * true,"Failed: View link not displayed in search result");
	 * UserAdminPage.lnkEdit(driver).click();
	 * UserAdminEditUserPage.waitForPageLoad(driver); boolean contains =
	 * UserAdminEditUserPage.pageLabel(driver).getText().contains("Edit User");
	 * return contains; }
	 */
	//read from config file 
	public static String expPageTitle() {
		// TODO Auto-gereturn nunerated method stub
		return Readconfig.getValue("edituser","title");
	}
	public static String expTxtTitle() {
		return Readconfig.getValue("edituser","labelTitle");
	}

	/*
	 * public static String expEditMSID() { // TODO Auto-gereturn nunerated method
	 * stub return Readconfig.getValue("edituser","editMSID"); }
	 */
	public static String editMSID() {
		// TODO Auto-gereturn nunerated method stub
		return Readconfig.getValue("edituser","newEditMSID");
	}
	public static String expEditFirstName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","txtFName");
	}
	public static String expEditLastName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","txtLName");
	}
	public static String expEditEMPID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","txtEMPID");
	}
	public static String expEditEmailId() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","txtEmailID");
	}
	public static String expEditSupervisor() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","txtSupervisor");
	}
	public static String expEditAssignWorkStatus() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","flagAssignWork");
	}

	public static String expEditStatus() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","valueStatus");

	}
	
	public static String[] expDialingTeam(String values) {
		System.out.println("expDialingTeam"+values);
		String[] list = values.split(",");
		System.out.println("Dialing Team list"+list);
		return list;
	}
	public static String[] expDialingMethos(String values) {
		System.out.println("expDialingMethos"+values);
		String[] list = values.split(",");
		System.out.println("Method list"+list);
		return list;
	}
	public static String[] expLanguage(String values) {
		System.out.println("expLanguage"+values);
		String[] list = values.split(",");
		System.out.println("Language exp list"+list);
		return list;
	}
	public static String[] expTeam(String values) {
		//String values = Readconfig.getValue("viewuser","listTeam");
		String[] list = values.split(",");
		System.out.println("Team Exp list"+list);
		return list;
	}

	
	

	public static String[] expEditDialingTeam() {
		String values = Readconfig.getValue("edituser","listDialingTeam");
		String[] list = values.split(",");
		System.out.println("Dialing Team list"+list);
		return list;
	}
	public static String[] expEditDialingMethos() {
		String values = Readconfig.getValue("edituser","listDialingMethod");
		String[] list = values.split(",");
		System.out.println("Method list"+list);
		return list;
	}
	public static String[] expEditLanguage() {
		String values = Readconfig.getValue("edituser","listLanguage");
		String[] list = values.split(",");
		System.out.println("Language exp list"+list);
		return list;
	}
	public static String[] expEditTeam() {
		String values = Readconfig.getValue("edituser","listTeam");
		String[] list = values.split(",");
		System.out.println("Team Exp list"+list);
		return list;
	}

	public static String expErrorMSGSave() {
		// TODO Auto-generated method stub
		return  Readconfig.getValue("edituser","errorTxtSave");
	}
	public static String expMSGReset() {
		// TODO Auto-generated method stub
		return  Readconfig.getValue("edituser","resetTxt");
	}

	public static String expMSGSave() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("edituser","savemsg");
	}
	public static String newEditLanguage() {
		return Readconfig.getValue("edituser","newLanguage");
	}

}
