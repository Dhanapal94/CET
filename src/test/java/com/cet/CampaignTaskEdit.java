package com.cet;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.HomePage;
import com.cet.pagerepositery.SearchEditPage;


public class CampaignTaskEdit extends Base {

	// Verify bconnId Value
	@Test
	public void verifyvalueBconnId() throws InterruptedException {
		Assert.assertTrue(SearchEditPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getBconnId(driver)),
				SearchEditPage.expTxtBconnId(), "Failed : On Task Edit Page bConn ID value is mismatch");
	}

	// Verify Current Plan Value
	@Test
	public void verifyvalueCurrentPlan() {
		Assert.assertTrue(SearchEditPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCurrentPlan(driver)),
				SearchEditPage.expCurrentPlan(), "Failed : On Task Edit Page Current plan value is mismatch");
	}

	// Verify Plan To Promote Value
	@Test
	public void verifyvaluePlanToPromote() {
		Assert.assertTrue(SearchEditPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPlanToPromote(driver)),
				SearchEditPage.expPlanToPromote(), "Failed : On Task Edit Page Plan to Promote value is mismatch");
	}

	// Verify First Name Value
	@Test
	public void verifyvalueFirstName() {
		Assert.assertTrue(SearchEditPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getFirstName(driver)),
				SearchEditPage.expFirstName(), "Failed : On Task Edit Page First Name value is mismatch");
	}

	// Verify Last Name Value
	@Test
	public void verifyvalueLastName() {
		Assert.assertTrue(SearchEditPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getLastName(driver)),
				SearchEditPage.expLastName(), "Failed : On Task Edit Page Last Name value is mismatch");
	}

	// Verify Task Save
	@Test(priority=6)
	public void setDisposition() {
		Assert.assertTrue(SearchEditPage.launch(driver));
		SearchEditPage.setDropDownValue(SearchEditPage.dropDownDispositionLkup(driver),
				SearchEditPage.expDispositionLkup());
		SearchEditPage.btnSaveAndClose(driver).click();
		if (SearchEditPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains(SearchEditPage.expMsgSaveAndClose()),
					"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
		softAssert.assertEquals(HomePage.labelHomePage(driver).getText(), HomePage.expTitle(),
				"Failed : Text for 'Home Page' is mismatch");
	}

}
