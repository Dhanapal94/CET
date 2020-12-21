package com.cet.utility.indts;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cet.pagerepositery.UserAdminPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.phdpages.PhdUserAdminAddNewUserPage;
import com.cet.utility.DBConnection;

public class IndtsHelper {

	// ********* Indts Team Assign ************ 

	public static void setIndtsTeam(WebDriver driver) throws ClassNotFoundException, IOException, SQLException {
		UserAdminPage.launch(driver);
		DBConnection.getuserName();
		UserAdminPage.inputMsId(driver).sendKeys(DBConnection.userID);
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.lnkEdit(driver).click();

		if(!PhdUserAdminAddNewUserPage.radioTeamINDTS(driver).isSelected()) {
			PhdUserAdminAddNewUserPage.radioTeamINDTS(driver).click();

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


			//DialingTeam
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamTSA(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamTSA(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamDIGITAL(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamDIGITAL(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamBilingual(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamBilingual(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamTSNonSNP(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamTSNonSNP(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamTSSNP(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamTSSNP(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamVendorSNP(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamVendorSNP(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamVendorNonSNP(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamVendorNonSNP(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamVendorNL(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingTeamVendorNL(driver).click();
			}

			//Dialing Method
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingMethodManual(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingMethodManual(driver).click();
			}
			if(!PhdUserAdminAddNewUserPage.checkBoxDialingMethod2StepManual(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.checkBoxDialingMethod2StepManual(driver).click();
			}

			PhdUserAdminAddNewUserPage.buttonSave(driver).click();
			PhdUserAdminAddNewUserPage.alertText(driver);

			LeftPanel.lnkLogOut(driver).click();
			driver.findElement(By.xpath("//button[@id='btnCET']")).click();
			//driver.close();
		}	
		else {
			System.out.println("INDTS Team already selected");
			LeftPanel.lnkHome(driver).click();
		}

		driver.close();

	}

}
