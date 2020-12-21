package com.cet.utility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;

import com.cet.intit.Base;
import com.cet.pagerepositery.AssignmentPage;
import com.cet.pagerepositery.phdpages.PhdHomePage;
import com.cet.pagerepositery.phdpages.PhdUserAdminAddNewUserPage;
import com.cet.pagerepositery.phdpages.PhdUserAdminPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class AdditionalHouseHold_Helper extends Base {

	public static void assignTask(String taskId,String dialingTeam) throws Exception
	{
		//setUp();
		PhdHomePage.launch(driver);
		LeftPanel.lnkAssignment(driver).click();
		AssignmentPage.inputTaskid(driver).sendKeys(taskId);
		PageObject.selectByVisibleText(AssignmentPage.dropDownDialingTeam(driver), dialingTeam, driver);
		AssignmentPage.buttonSearch(driver).click();
		AssignmentPage.searchResultCheckBox(driver).click();
		AssignmentPage.buttonAssign(driver).click();
		PageObject.selectByVisibleText(AssignmentPage.dropDownAssignUserList(driver),DBConnection.assignName,driver);
		AssignmentPage.buttonAssignUserList(driver).click();
		PageObject.alertAccept(driver);
	}

	// ********* INDTS TEAM ASSIGN ************ //
	public static void setINDTSTeam() throws ClassNotFoundException, IOException, SQLException {
		setUp();
		PhdUserAdminPage.launch(driver);
		DBConnection.getuserName();
		PhdUserAdminPage.inputMsId(driver).sendKeys(DBConnection.userID);
		PhdUserAdminPage.btnSearch(driver).click();
		PhdUserAdminPage.lnkEdit(driver).click();
		PhdUserAdminAddNewUserPage.launch(driver);
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

	}
	
	// ********* GPRTS TEAM ASSIGN ************ //
		public static void setGPRTSTeam() throws ClassNotFoundException, IOException, SQLException {
			setUp();
			PhdUserAdminPage.launch(driver);
			DBConnection.getuserName();
			PhdUserAdminPage.inputMsId(driver).sendKeys(DBConnection.userID);
			PhdUserAdminPage.btnSearch(driver).click();
			PhdUserAdminPage.lnkEdit(driver).click();
			PhdUserAdminAddNewUserPage.launch(driver);
			if(!PhdUserAdminAddNewUserPage.radioTeamGPRTS(driver).isSelected()) {
				PhdUserAdminAddNewUserPage.radioTeamGPRTS(driver).click();

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
				if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamGroupVendor(driver).isSelected()) {
					PhdUserAdminAddNewUserPage.checkBoxDialingTeamGroupVendor(driver).click();
				}
				if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamGroupInternal(driver).isSelected()) {
					PhdUserAdminAddNewUserPage.checkBoxDialingTeamGroupInternal(driver).click();
				}
				if(!PhdUserAdminAddNewUserPage.checkBoxDialingTeamGroupVendorNL(driver).isSelected()) {
					PhdUserAdminAddNewUserPage.checkBoxDialingTeamGroupVendorNL(driver).click();
				}

				PhdUserAdminAddNewUserPage.buttonSave(driver).click();
				PhdUserAdminAddNewUserPage.alertText(driver);

				LeftPanel.lnkLogOut(driver).click();
				driver.findElement(By.xpath("//button[@id='btnCET']")).click();
				//driver.close();
			}	
			else {
				System.out.println("GPRTS Team already selected");
				LeftPanel.lnkHome(driver).click();
			}

		}


}
