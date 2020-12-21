package com.cet.utility.phd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cet.pagerepositery.phdpages.PhdAssignmentResultPage;
import com.cet.pagerepositery.phdpages.PhdHomePage;
import com.cet.pagerepositery.phdpages.PhdHomeSkillPage;
import com.cet.pagerepositery.phdpages.PhdSearchResultPage;
import com.cet.pagerepositery.phdpages.PhdSettingPage;
import com.cet.pagerepositery.phdpages.PhdUserAdminAddNewUserPage;
import com.cet.pagerepositery.phdpages.PhdUserAdminPage;
import com.cet.utility.DBConnection;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class PHD_Helper {
	public static HashMap<String,String> searchActual = new HashMap<String,String>();
	public static HashMap<String,String> searchExpected = new HashMap<String,String>();

	public static void searchActual_PHD(WebDriver driver) 
	{	
		searchActual.clear();
		searchActual.put("TaskID", 	PageObject.getText(PhdSearchResultPage.tableTaskId(driver)));
		searchActual.put("AgentID", PageObject.getText(PhdSearchResultPage.tableAgentId(driver)));
		searchActual.put("AgentFirstName", PageObject.getText(PhdSearchResultPage.tableAgentFirstName(driver)));
		searchActual.put("AgentLastName", PageObject.getText(PhdSearchResultPage.tableAgentLastName(driver)));
		searchActual.put("AgentState", PageObject.getText(PhdSearchResultPage.tableAgentState(driver)));
		searchActual.put("TaskType", PageObject.getText(PhdSearchResultPage.tableTaskType(driver)));
		searchActual.put("CampaignFocus", PageObject.getText(PhdSearchResultPage.tableCampaignFocus(driver)));
		searchActual.put("JobName", PageObject.getText(PhdSearchResultPage.tableJobName(driver)));
		searchActual.put("CreatedDate", changeDateFormat(PageObject.getText(PhdSearchResultPage.tableCreatedDate(driver))));
		searchActual.put("TaskStatus", PageObject.getText(PhdSearchResultPage.tableTaskStatus(driver)));
		searchActual.put("DialingMethod", PageObject.getText(PhdSearchResultPage.tableDialingMethod(driver)));
		searchActual.put("FinalDisposition", PageObject.getText(PhdSearchResultPage.tableFinalDisposition(driver)));
		if(PageObject.getText(PhdSearchResultPage.tableFinalAttemptDate(driver)).length()>0)
		{
			String finalAttemptDate = PageObject.getText(PhdSearchResultPage.tableFinalAttemptDate(driver));
			searchActual.put("FinalAttemptDate", changeDateFormat(finalAttemptDate.substring(0,finalAttemptDate.indexOf(' '))));
		}
		else
		{
			searchActual.put("FinalAttemptDate", PageObject.getText(PhdSearchResultPage.tableFinalAttemptDate(driver)));
		}
		searchActual.put("AssignedTo", PageObject.getText(PhdSearchResultPage.tableAssignedTo(driver)));

		//System.out.println("Search Application :"+searchActual);
	}

	public static void searchExpected_PHD(String taskid,String agentid,String agentfirstname,String agentlastname,String agentstate,
			String tasktype,String campaignfocus,String jobname,String createddate,String taskstatus,String dialingmethod,String finaldisposition,
			String finalattemptdate,String assignedto)
	{	
		searchExpected.clear();
		searchExpected.put("TaskID", taskid);
		searchExpected.put("AgentID",agentid);
		searchExpected.put("AgentFirstName",agentfirstname);
		searchExpected.put("AgentLastName", agentlastname);
		searchExpected.put("AgentState", agentstate);
		searchExpected.put("TaskType", tasktype);
		searchExpected.put("CampaignFocus",campaignfocus);
		searchExpected.put("JobName", jobname);
		searchExpected.put("CreatedDate", createddate);
		searchExpected.put("TaskStatus", taskstatus);
		searchExpected.put("DialingMethod", dialingmethod);
		searchExpected.put("FinalDisposition", finaldisposition);
		searchExpected.put("FinalAttemptDate", finalattemptdate);
		searchExpected.put("AssignedTo", assignedto);

		//System.out.println("Search DB :"+searchExpected);
	}

	public static boolean searchResultValidation(WebDriver driver,String taskid,String agentid,String agentfirstname,String agentlastname,String agentstate,
			String tasktype,String campaignfocus,String jobname,String createddate,String taskstatus,String dialingmethod,String finaldisposition,
			String finalattemptdate,String assignedto)
	{
		boolean flag=false;
		searchExpected_PHD(taskid ,agentid, agentfirstname, agentlastname, agentstate, tasktype, campaignfocus, jobname, createddate, taskstatus, dialingmethod, finaldisposition,finalattemptdate, assignedto);
		searchActual_PHD(driver);
		flag=searchExpected.equals(searchActual);
		return flag;		
	}


	public static String changeDateFormat(String dateApp)
	{
		String modifiedDate="";
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<String> original = new ArrayList<String>();
		ArrayList<String> modified = new ArrayList<String>();
		map.put(0, 2);
		map.put(1, 0);
		map.put(2, 1);

		for(String dateexp:dateApp.split("/"))
		{
			original.add(dateexp);
		}

		for(int i=0;i<original.size();i++)
		{	
			modified.add(original.get(map.get(i)));
		}

		for(int j=0;j<modified.size();j++)
		{	
			if(modified.get(j).length()==1)
			{
				modifiedDate+="0"+modified.get(j)+"-";
			}
			else
			{
				modifiedDate+=modified.get(j)+"-";
			}
		}
		modifiedDate= modifiedDate.substring(0, modifiedDate.length() - 1);
		return modifiedDate;
	}

	//********* Assignement Search ***************

	public static void searchActual_Assignement_PHD(WebDriver driver) 
	{	
		searchActual.clear();
		searchActual.put("TaskID", 	PageObject.getText(PhdAssignmentResultPage.tableTaskId(driver)));
		searchActual.put("TaskType", PageObject.getText(PhdAssignmentResultPage.tableTaskType(driver)));
		searchActual.put("CampaignFocus", PageObject.getText(PhdAssignmentResultPage.tableCampaignFocus(driver)));
		searchActual.put("JobName", PageObject.getText(PhdAssignmentResultPage.tableJobName(driver)));
		searchActual.put("CreatedDate", changeDateFormat(PhdAssignmentResultPage.getText(PhdAssignmentResultPage.tableCreatedDate(driver))));
		searchActual.put("TaskStatus", PageObject.getText(PhdAssignmentResultPage.tableTaskStatus(driver)));
		searchActual.put("DialingMethod", PageObject.getText(PhdAssignmentResultPage.tableDialingMethod(driver)));
		searchActual.put("FinalDisposition", PageObject.getText(PhdAssignmentResultPage.tableFinalDisposition(driver)));
		if(PageObject.getText(PhdAssignmentResultPage.tableFinalAttemptDate(driver)).length()>0)
		{
			String finalAttemptDate = PageObject.getText(PhdAssignmentResultPage.tableFinalAttemptDate(driver));
			searchActual.put("FinalAttemptDate", changeDateFormat(finalAttemptDate.substring(0,finalAttemptDate.indexOf(' '))));
		}
		else
		{
			searchActual.put("FinalAttemptDate", PageObject.getText(PhdAssignmentResultPage.tableFinalAttemptDate(driver)));
		}
		searchActual.put("AssignedTo", PageObject.getText(PhdAssignmentResultPage.tableAssignedTo(driver)));

		//System.out.println("Search Application :"+searchActual);
	}

	public static void searchExpected_Assignement_PHD(String taskId,String taskType,String campaignFocus,String jobName,
			String createdDate,String taskStatus,String dialingMethod,String finalDisposition,String finalAttemptDate,String assignedTo)
	{	
		searchExpected.clear();
		searchExpected.put("TaskID", taskId);
		searchExpected.put("TaskType", taskType);
		searchExpected.put("CampaignFocus",campaignFocus);
		searchExpected.put("JobName", jobName);
		searchExpected.put("CreatedDate", createdDate);
		searchExpected.put("TaskStatus", taskStatus);
		searchExpected.put("DialingMethod", dialingMethod);
		searchExpected.put("FinalDisposition", finalDisposition);
		searchExpected.put("FinalAttemptDate", finalAttemptDate);
		searchExpected.put("AssignedTo", assignedTo);

		//System.out.println("Search DB :"+searchExpected);
	}

	public static boolean searchResultValidation__Assignement_Phd(WebDriver driver,String taskId,String taskType,String campaignFocus,String jobName,
			String createdDate,String taskStatus,String dialingMethod,String finalDisposition,String finalAttemptDate,String assignedTo)
	{
		boolean flag=false;
		searchExpected_Assignement_PHD(taskId,taskType, campaignFocus, jobName, createdDate, taskStatus, dialingMethod, finalDisposition,finalAttemptDate, assignedTo);
		searchActual_Assignement_PHD(driver);
		flag=searchExpected.equals(searchActual);
		return flag;		
	}

	// ********* PHD TEAM ASSIGN ************ //
	public static void setPhdTeam(WebDriver driver) throws ClassNotFoundException, IOException, SQLException {
		PhdUserAdminPage.launch(driver);
		DBConnection.getuserName();
		PhdUserAdminPage.inputMsId(driver).sendKeys(DBConnection.userID);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.lnkEdit(driver).click();
		PhdUserAdminAddNewUserPage.launch(driver);
		if(!PhdUserAdminAddNewUserPage.radioTeamPHD(driver).isSelected()) {
			PhdUserAdminAddNewUserPage.radioTeamPHD(driver).click();

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageEnglish(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageEnglish(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLangauageSpanish(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLangauageSpanish(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageKorean(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageKorean(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLangaugeVietnamese(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLangaugeVietnamese(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageCantonese(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageCantonese(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageFrench(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageFrench(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageMandarin(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageMandarin(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageTagalog(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageTagalog(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageRussian(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageRussian(driver).click();
			}

			if(!PhdUserAdminAddNewUserPage.checkBoxLanguageChinese(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxLanguageChinese(driver).click();
			}

			PhdUserAdminAddNewUserPage.buttonSave(driver).click();
			PhdUserAdminAddNewUserPage.alertText(driver);

			LeftPanel.lnkLogOut(driver).click();
			driver.findElement(By.xpath("//button[@id='btnCET']")).click();
			//driver.close();
		}	
		else {
			System.out.println("PHD Team already selected");
			LeftPanel.lnkHome(driver).click();
		}
		
		//settings 
		//Campaign Focus
		PhdHomePage.launch(driver);
		driver.findElement(By.xpath("//img[contains(@src,'setting')]")).click();
		
		if(!PhdSettingPage.inputNewAgenWelcomeCampaign(driver).isSelected()) {
			PhdSettingPage.inputNewAgenWelcomeCampaign(driver).click();
		}
		
		if(!PhdSettingPage.inputReadytoSellCampaign(driver).isSelected()) {
			PhdSettingPage.inputReadytoSellCampaign(driver).click();
		}
		
		if(!PhdSettingPage.inputNotReadytoSellCampaign(driver).isSelected()) {
			PhdSettingPage.inputNotReadytoSellCampaign(driver).click();
		}
		
		if(!PhdSettingPage.inputNotReadytoSell_DSNPCampaign(driver).isSelected()) {
			PhdSettingPage.inputNotReadytoSell_DSNPCampaign(driver).click();
		}
		
		//Assigned/Not Assigned
		if(!PhdSettingPage.inputOnlyAssigned(driver).isSelected()) {
			PhdSettingPage.inputOnlyAssigned(driver).click();
		}
		
		if(!PhdSettingPage.inputOnlyNotAssigned(driver).isSelected()) {
			PhdSettingPage.inputOnlyNotAssigned(driver).click();
		}
		
		PhdSettingPage.buttonSave(driver).click();
		PhdSettingPage.alertAccept(driver);
		PhdHomeSkillPage.launch(driver);
		LeftPanel.lnkLogOut(driver).click();
		driver.close();

	}
}
