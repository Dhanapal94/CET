package com.cet.grpts;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.SearchEditPage;
import com.cet.pagerepositery.configurationpages.ConfigurationPage;
import com.cet.utility.grpts.GetDataFromExcelGRPTS;


public class GrptsConfigurationAddNewCampaignTest extends Base {
	
	private static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {
		childTest=true;
		parentTest=extent.createTest("GRPTS-Configuration Add New Campaign Test");
		team="Grpts";
		newGrptsCampaign = GetDataFromExcelGRPTS.newGrptsCampaign();	
	}

	@BeforeMethod
	public static void getGrptsConfigurationPageInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			ConfigurationPage.launch(driver);
			initFlag=false;
			fopenBrowser=true;

		}
	}

	// Title Of Add new Campaign Page
	@Test(priority = 1)
	public void verifyNewCampaignPageTitle() throws Exception {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		softAssert.assertEquals(ConfigurationPage.pageTitleAddNewCampaign(driver),
				ConfigurationPage.getAddCampaignLabels("newcampaignpagetitle"),
				"Failed : Add New Campaign Page title mismatch.");
		ConfigurationPage.buttonCancel(driver).click();
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Top Section Of Add New Campaign Page
	@Test(priority = 2)
	public void verifyCampaignLabel() throws Exception {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		softAssert.assertEquals(ConfigurationPage.labelTopSectionNewCampaign(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("topsectionaddcampaign"),
				"Failed : Add New Campaign Page top section title mismatch.");
		ConfigurationPage.buttonCancel(driver).click();
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Add New Campaign Panel
	@Test(priority = 3)
	public void verifyAddNewCampaignPanelLabel() throws Exception {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		softAssert.assertEquals(ConfigurationPage.labelAddNewCampaignPanel(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("addnewcampaignpanel"),
				"Failed : Configuration Page top section title mismatch.");
		ConfigurationPage.buttonCancel(driver).click();
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Add New Campaign Labels Validation
	@Test(priority = 4)
	public void verifyAddNewCampaignFieldLabels() throws Exception {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		softAssert.assertEquals(ConfigurationPage.labelNewCampaignFocus(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("addnewcampaignfocus"),
				"Failed : New Campaign Focus Label mismatch");
		softAssert.assertEquals(ConfigurationPage.labelNewCampaignTeam(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("addcampaignteam"), "Failed : New Campaign Team Label mismatch");
		softAssert.assertEquals(ConfigurationPage.labelNewCampaignDescription(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("addcampaigndescription"),
				"Failed : New Campaign Description Label mismatch");
		softAssert.assertEquals(ConfigurationPage.labelCloneCampaignFocus(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("addclonecampaignfocus"),
				"Failed : New Clone Campaign Focus Label mismatch");
		softAssert.assertEquals(ConfigurationPage.labelNewCampaignAttempt(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("addcampaignattempt"),
				"Failed : New Campaign Attempt Label mismatch");
		ConfigurationPage.buttonCancel(driver).click();
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Validation of Enable/Disabled fields in Add New Campaign
	@Test(priority = 5)
	public void verifyNewCampaignDisabledFields() {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		softAssert.assertTrue(ConfigurationPage.inputCampaignFocus(driver).isEnabled(),
				"Failed : Campaign Focus is not editable in Add New Campaign");
		softAssert.assertFalse(ConfigurationPage.inputNewCampaignTeam(driver).isEnabled(),
				"Failed : Team is editable in Add New Campaign");
		softAssert.assertTrue(ConfigurationPage.inputCampaignDescription(driver).isEnabled(),
				"Failed : Campaign Description is not editable in Add New Campaign");
		softAssert.assertTrue(ConfigurationPage.dropDownCloneCampaignFocus(driver).isEnabled(),
				"Failed : Campaign Description is not editable in Add New Campaign");
		softAssert.assertFalse(ConfigurationPage.inputNewCampaignAttempt(driver).isEnabled(),
				"Failed : Attempt is editable in Add New Campaign");
		ConfigurationPage.buttonCancel(driver).click();
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Add New Campaign in Configuration Page
	@Test(priority = 6)
	public void verifyAddNewCampaign() throws Exception {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.inputCampaignFocus(driver).sendKeys(newGrptsCampaign.get("newcampaignfocus"));
		ConfigurationPage.inputCampaignDescription(driver).sendKeys(newGrptsCampaign.get("campaigndescription"));
		SearchEditPage.setDropDownValue(ConfigurationPage.dropDownCloneCampaignFocus(driver),
				newGrptsCampaign.get("clonecampaignfocus"));
		ConfigurationPage.buttonAddCampaignSubmit(driver).click();
		if (ConfigurationPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(ConfigurationPage.getAddCampaignLabels("addcampaign")),
					"Failed : Add New Campaign Failed.");
			alert.accept();
		}
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Campaign already exists in Configuration Page
	@Test(priority = 7)
	public void verifyExistingCampaign() throws Exception {
		ConfigurationPage.buttonAddSearchNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.buttonAddNewCampaign(driver).click();
		ConfigurationPage.waitForPageLoad(driver);
		ConfigurationPage.inputCampaignFocus(driver).sendKeys(newGrptsCampaign.get("newcampaignfocus"));
		ConfigurationPage.inputCampaignDescription(driver).sendKeys(newGrptsCampaign.get("campaigndescription"));
		SearchEditPage.setDropDownValue(ConfigurationPage.dropDownCloneCampaignFocus(driver),
				newGrptsCampaign.get("clonecampaignfocus"));
		ConfigurationPage.buttonAddCampaignSubmit(driver).click();
		if (ConfigurationPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(
					alert.getText().contains(ConfigurationPage.getAddCampaignLabels("addexistingcampaign")),
					"Failed : Add New Campaign Failed.");
			alert.accept();
			ConfigurationPage.buttonCancel(driver).click();
		}
		ConfigurationPage.buttonCancel(driver).click();
		ConfigurationPage.buttonBackToConfiguration(driver).click();
	}

	// Cancel button in Add New Campaign Page
	@Test(priority = 8)
	public void verifyCancelButton() throws Exception {
		ConfigurationPage.buttonCancel(driver).click();
		softAssert.assertEquals(ConfigurationPage.labelSearchCampaign(driver).getText(),
				ConfigurationPage.getAddCampaignLabels("searchcampaignlabel"),
				"Falied : Redirect to Search Campaign failed on Cancel button click");

	}

	// @AfterMethod
	// public void redirectToConfiguration() {
	// ConfigurationPage.buttonCancel(driver);
	// }

}
