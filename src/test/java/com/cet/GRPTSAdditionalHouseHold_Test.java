package com.cet;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.AdditionalHouseHoldPage;
import com.cet.pagerepositery.SearchTaskPage;
import com.cet.pagerepositery.manager.PageObject;
import com.cet.pagerepositery.phdpages.PHDSearch_TaskDetails_Page;
import com.cet.utility.AdditionalHouseHold_Helper;
import com.cet.utility.DBConnection;
import com.cet.utility.DataProviderTest;

public class GRPTSAdditionalHouseHold_Test extends Base{

	static boolean initializationFlag=true;
	String bconnid,firstName,lastName,id;
	static String searchBconnid,searchFirstName,searchLastName;
	static int initCount=0,parentTestCount=1;

	@Factory(dataProvider="GPRTSAdditionalHouseHoldData", dataProviderClass=DataProviderTest.class)
	public GRPTSAdditionalHouseHold_Test(Hashtable<String,String> data) throws Exception {

		try {
			if(initCount==0)
			{
				this.id=data.get("Id");
				searchBconnid = data.get("bconnid");
				searchFirstName = data.get("firstname");
				searchLastName=data.get("lastname");	
				initCount++;
			}
			else
			{
				this.id=data.get("Id");
				this.bconnid = data.get("bconnid");
				this.firstName = data.get("firstname");
				this.lastName=data.get("lastname");	
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+e.getMessage());
		}
	}

	@BeforeClass
	public void createTest() {
		childTest=true;
		parentTest=extent.createTest("Grpts Additional Household Test "+parentTestCount);
		parentTestCount++;
	}
	
	@BeforeTest
	public void setGrptsTeam() throws Exception
	{
		team="Additional Household";
		AdditionalHouseHold_Helper.setGPRTSTeam();
		AdditionalHouseHold_Helper.assignTask(DBConnection.grptstaskid,DBConnection.grptsdialingteam);
	}

	@BeforeMethod
	public void initializationAddHouseHold() throws Exception
	{
		if(initializationFlag)
		{
			System.out.println(searchBconnid);
			SearchTaskPage.launch(driver);
			SearchTaskPage.inputBconnId(driver).sendKeys(searchBconnid);
			SearchTaskPage.btnSearch(driver).click();
			SearchTaskPage.lnkEdit(driver).click();
			PHDSearch_TaskDetails_Page.launch(driver);
			initializationFlag=false;
			fopenBrowser=false;
		}
	}

	@Test(priority=1)
	public void additionalHouseHoldMembersCount_GPRTSTest() throws Exception {
		if(initCount==1)
		{
			for(int i=0;i<=2;i++) // Avoid Exception
			{
				try
				{
					String addHouseHoldCount = PageObject.getInputBoxValue(AdditionalHouseHoldPage.inputAdditionalHouseHoldMembers(driver));
					Assert.assertEquals(Integer.parseInt(addHouseHoldCount),DataProviderTest.gprtsTotalAdditionalHouseHoldCount-1, "Failed : Additional count is mismatched!");		
					initCount++;
					break;
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}

		}
	}

	@Test(priority=2)
	public void additionalHouseHoldMembersFirstName_GPRTSTest() throws Exception {
		if(id.equals("0"))
		{
			String firstName = PageObject.getInputBoxValue(AdditionalHouseHoldPage.inputMemberFirstName(driver));
			Assert.assertEquals(firstName, searchFirstName,"Failed "+initCount+":First Name is Mismatched!");
		}
		else
		{
			String firstname = PageObject.getInputBoxValue(AdditionalHouseHoldPage.inputAdditionalHouseHoldMemberFirstName(driver,id));
			Assert.assertEquals(firstname, firstName,"Failed "+id+":Additional First Name is Mismatched!");
		}

	}

	@Test(priority=3)
	public void additionalHouseHoldMembersLasttName_GPRTSTest() throws Exception {
		if(id.equals("0"))
		{
			String lastName = PageObject.getInputBoxValue(AdditionalHouseHoldPage.inputMemberLastName(driver));
			Assert.assertEquals(lastName, searchLastName,"Failed "+initCount+":Last Name is Mismatched!");
		}
		else
		{
			String lastname = PageObject.getInputBoxValue(AdditionalHouseHoldPage.inputAdditionalHouseHoldMemberLasttName(driver, id));
			Assert.assertEquals(lastname, lastName,"Failed "+id+":Additional Last Name is Mismatched!");
		}
	}


}
