package com.cet;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.AdditionalHouseHoldPage;
import com.cet.pagerepositery.manager.PageObject;
import com.cet.utility.DataProviderTest;

public class GRPTSNextAdditionalHouseHold_Test extends Base {
	
	static boolean initializationFlag=true;
	static int tempCount;
	String bconnid,firstName,lastName,id;
	static int initCount=0,parentTestCount=1;

	@Factory(dataProvider="GPRTSNextAdditionalHouseHoldData", dataProviderClass=DataProviderTest.class)
	public GRPTSNextAdditionalHouseHold_Test(Hashtable<String,String> data) throws Exception {
		try {		
			this.id=data.get("Id");
			this.firstName = data.get("firstname");
			this.lastName=data.get("lastname");	
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+e.getMessage());
		}
	}

	@BeforeClass
	public void createTest() {
		childTest=true;
		parentTest=extent.createTest("Grpts Next Additional Household Test "+parentTestCount);
		parentTestCount++;
	}

	@BeforeMethod
	public void initializationAddHouseHold() throws Exception
	{
		if(initializationFlag)
		{	
			PageObject.selectByVisibleText(AdditionalHouseHoldPage.dropDownDisposition(driver), "No Answer", driver);
			AdditionalHouseHoldPage.buttonSaveGetHouseHold(driver).click();
			PageObject.alertAccept(driver);
			initializationFlag=false;
		}
	}

	@AfterMethod
	public void tear() throws Exception
	{
		if(tempCount==DataProviderTest.gprtsTotalAdditionalHouseHoldCount)
		{
			AdditionalHouseHoldPage.buttonCloseDialogGetHouseHold(driver).click();
			fopenBrowser=true;
		}
	}



	@Test(priority=1)
	public void nextAdditionalHouseHoldMembersFirstName_GPRTSTest() throws Exception {
		if(Integer.parseInt(id)>0)
		{
			String firstname = PageObject.getText(AdditionalHouseHoldPage.tableGetHouseHoldMemberFirstName(driver, id));
			System.out.println(firstname);
			Assert.assertEquals(firstname, firstName,"Failed "+id+":Additional First Name is Mismatched!");
		}
	}

	@Test(priority=2)
	public void nextAdditionalHouseHoldMembersLastName_GPRTSTest() throws Exception {
		tempCount++;
		if(Integer.parseInt(id)>0)
		{
			String lastname = PageObject.getText(AdditionalHouseHoldPage.tableGetHouseHoldMemberLastName(driver,id));
			Assert.assertEquals(lastname, lastName,"Failed "+id+":Additional last Name is Mismatched!");
		}
	}

}
