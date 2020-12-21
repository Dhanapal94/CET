package com.cet.utility.retention;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cet.pagerepositery.phdpages.PhdUserAdminAddNewUserPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.retentionpages.RetentionUserAdminPage;
import com.cet.utility.DBConnection;

public class RetentionHelper {

	// ********* Retention Team Assign ************ 

	public static void setRetentionTeam(WebDriver driver) throws ClassNotFoundException, IOException, SQLException {
		RetentionUserAdminPage.launch(driver);
		DBConnection.getuserName();
		RetentionUserAdminPage.inputMsId(driver).sendKeys(DBConnection.userID);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.lnkEdit(driver).click();
		//RetentionUserAdminPage.launch(driver);
		if(!PhdUserAdminAddNewUserPage.radioTeamRetention(driver).isSelected()) {
			PhdUserAdminAddNewUserPage.radioTeamRetention(driver).click();

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
			System.out.println("Reteantion Team already selected");
			LeftPanel.lnkHome(driver).click();
		}

		driver.close();

	}

}
