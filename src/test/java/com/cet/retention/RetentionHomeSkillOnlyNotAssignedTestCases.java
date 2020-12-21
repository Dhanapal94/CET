package com.cet.retention;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.retentionpages.RetentionHomePage;
import com.cet.utility.ExcelUtility;
import com.cet.utility.retention.RetentionDBData;

public class RetentionHomeSkillOnlyNotAssignedTestCases extends Base{

	static String languageCount;
	static ArrayList<String> languageSkill = new ArrayList<String>();

	static int count=-1;

	@BeforeClass
	public void addLanguage_Skill() throws ClassNotFoundException, IOException, SQLException {
		languageSkill.add("English");
		languageSkill.add("Korean");
		languageSkill.add("Russian");
		languageSkill.add("Chinese");
		languageSkill.add("Vietnamese");
		languageSkill.add("Spanish");
		//setUp(); // wanna run this case individually? Then enable both line !
		//fopenBrowser=true;
		RetentionHomePage.launch(driver);
		RetentionHomePage.onlyNotAssigned_Click(driver);
		childTest=true;
		parentTest=extent.createTest("Retention-Home Skill Only Not Assigned Test");
		team="Retention";
	}

	@BeforeMethod
	public void initializationRetention_HomeNotAssigned_Skill() throws Exception
	{
		softAssert=new SoftAssert();
		count++;
		RetentionDBData.writeHomeNotAssignedSkillData(languageSkill.get(count));
		ExcelUtility.setExcelFile(RetentionDBData.excelPath, "homeSkill");
		languageCount=ExcelUtility.getCellData(1, 0);
	}

	@AfterClass
	public void closeBrowser() {
		RetentionHomePage.Assigned_NotAssigned_Click(driver);
		LeftPanel.lnkLogOut(driver).click();
		fopenBrowser=true;
	}

	@Test(priority=1)
	public void englishSkillCount_OnlyNotAssigned_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:English Skill Count");	
		verifyassert(softAssert);
	}

	@Test(priority=2)
	public void koreanSkillCount_OnlyNotAssigned_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Korean Skill Count");	
		verifyassert(softAssert);
	}
	@Test(priority=5) public void chineseSkillCount_OnlyNotAssigned_Test()
			throws Exception {
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver,
				languageSkill.get(count)).getText(),languageCount,
				"chinese Skill Count"); verifyassert(softAssert); }


	@Test(priority=6)
	public void vietnameseSkillCount_OnlyNotAssigned_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Vietnamese Skill Count");
		verifyassert(softAssert);
	}

	@Test(priority=7)
	public void spanishSkillCount_OnlyNotAssigned_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:spanish Skill Count");	
		verifyassert(softAssert);
	}

	@Test(priority=8)
	public void russianSkillCount_OnlyNotAssigned_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Tagalog Skill Count");		
		verifyassert(softAssert);
	}

}
