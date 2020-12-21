package com.cet.retention;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.RetentionHomePage;
import com.cet.utility.ExcelUtility;
import com.cet.utility.retention.RetentionDBData;

public class RetentionHomeSkillAssignedTestCases extends Base{

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
		//setUp();              // wanna run this case individually? Then enable both line !
		//fopenBrowser=true;
		RetentionHomePage.launch(driver);
		childTest=true;
		parentTest=extent.createTest("Retention-Home Skill Assigned Test");
		team="Retention";
	}

	@BeforeMethod
	public void initializationRetention_HomeSkill() throws Exception
	{
		softAssert=new SoftAssert();
		count++;
		RetentionDBData.writeHomeSkillData(languageSkill.get(count));
		ExcelUtility.setExcelFile(RetentionDBData.excelPath, "homeSkill");
		languageCount=ExcelUtility.getCellData(1, 0);
	}

	

	@Test(priority=1)
	public void englishSkillCount_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:English Skill Count");		
	}

	@Test(priority=2)
	public void koreanSkillCount_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Korean Skill Count");		
	}

	@Test(priority=3)
	public void cantoneseSkillCount_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Russian Skill Count");		
	}

	@Test(priority=4)
	public void frenchSkillCount_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Chinese Skill Count");		
	}
	@Test(priority=6)
	public void vietnameseSkillCount_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Vietnamese Skill Count");		
	}

	@Test(priority=7)
	public void spanishSkillCount_Test() throws Exception {		
		softAssert.assertEquals(RetentionHomePage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:spanish Skill Count");		
	}

}
