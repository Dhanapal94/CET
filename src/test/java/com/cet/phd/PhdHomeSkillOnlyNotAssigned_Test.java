package com.cet.phd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PhdHomeSkillPage;
import com.cet.pagerepositery.phdpages.PhdSettingPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.utility.ExcelUtility;
import com.cet.utility.phd.PHDDBData;

public class PhdHomeSkillOnlyNotAssigned_Test extends Base{
	
	static String languageCount;
	static ArrayList<String> languageSkill = new ArrayList<String>();

	static int count=-1;

	@BeforeClass
	public void addLanguage_Skill() throws ClassNotFoundException, IOException, SQLException {
		languageSkill.add("English");
		languageSkill.add("Korean");
		languageSkill.add("Cantonese");
		languageSkill.add("French");
		languageSkill.add("Mandarin");
		languageSkill.add("Vietnamese");
		languageSkill.add("Spanish");
		languageSkill.add("Tagalog");

		//setUp();
		PhdHomeSkillPage.launch(driver);
		PhdSettingPage.onlyNotAssigned_Click(driver);
		fopenBrowser=false;
		team="Phd";
		childTest=true;
		parentTest=extent.createTest("Phd-Home Skill Only Not Assigned Test");
	}

	@BeforeMethod
	public void initializationPhd_HomeNotAssigned_Skill() throws Exception
	{
		count++;
		PHDDBData.writeHomeNotAssignedSkillData(languageSkill.get(count));
		ExcelUtility.setExcelFile(PHDDBData.excelPath, "phdHomeSkill");
		languageCount=ExcelUtility.getCellData(1, 0);
	}

	@AfterMethod
	public void closeBrowser() {
		if(count==7) {
			PhdSettingPage.Assigned_NotAssigned_Click(driver);
			LeftPanel.lnkLogOut(driver).click();
			fopenBrowser=true;
		}

	}

	@Test(priority=1)
	public void englishSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:English Skill Count");		
	}
	
	@Test(priority=2)
	public void koreanSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Korean Skill Count");		
	}
	
	@Test(priority=3)
	public void cantoneseSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Cantonese Skill Count");		
	}
	
	@Test(priority=4)
	public void frenchSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:French Skill Count");		
	}

	@Test(priority=5)
	public void mandarinSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Mandarin Skill Count");		
	}
	
	@Test(priority=6)
	public void vietnameseSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Vietnamese Skill Count");		
	}
	
	@Test(priority=7)
	public void spanishSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:spanish Skill Count");		
	}
	
	@Test(priority=8)
	public void tagalogSkillCount_OnlyNotAssigned_Test() throws Exception {		
		Assert.assertEquals(PhdHomeSkillPage.languageSkillCount(driver, languageSkill.get(count)).getText(),languageCount,
				"Failed:Tagalog Skill Count");		
	}

}
