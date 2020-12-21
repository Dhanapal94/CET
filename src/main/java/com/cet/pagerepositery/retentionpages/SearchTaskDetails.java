package com.cet.pagerepositery.retentionpages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class SearchTaskDetails  extends PageObject
{

	public SearchTaskDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**********************************Object*****************************/

	public static WebElement txtApplicationDetails(WebDriver driver) {
		return driver.findElement(By.xpath(".//h6[contains(text(),'Application Details')]"));
	}
	public static WebElement inputMBI(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'MBI')]//following::input[1]"));
	}
	public static WebElement labelMBI(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'MBI')]"));
	}
	public static WebElement labelCurrentPlan(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Current Plan')]"));
	}
	public static WebElement inputCurrentPlan(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Current Plan')]//following::input[1]"));
	}
	public static WebElement labelPreviousPlan(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Previous Plan')]"));
	}
	public static WebElement inputPreviousPlan(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Previous Plan')]//following::input[1]"));
	}
	public static WebElement labelAgentofRecord(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Agent of Record')]"));
	}
	public static WebElement inputAgentofRecord(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Agent of Record')]//following::input[1]"));
	}
	public static WebElement labelApplicationDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Application Date')]"));
	}
	public static WebElement inputApplicationDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Application Date')]//following::input[1]"));
	}
	public static WebElement labelFirstName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'First Name')]"));
	}
	public static WebElement inputFirstName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'First Name')]//following::input[1]"));
	}
	public static WebElement labelLastName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Last Name')]"));
	}
	public static WebElement inputLastName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Last Name')]//following::input[1]"));
	}
	public static WebElement labelMemberDOB(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Member Date of Birth')]"));
	}
	public static WebElement inputMemberDOB(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Member Date of Birth')]//following::input[1]"));
	}
	public static WebElement labelAge(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@id='tdAge']//parent::div[1]/label[1]"));
	}
	public static WebElement inputAge(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@id='tdAge']"));
	}
	public static WebElement labelGender(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Gender')]"));
	}
	public static WebElement inputGender(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Gender')]//following::input[1]"));
	}
	public static WebElement labelAddress(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Address')]"));
	}
	public static WebElement inputAddress(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Address')]//following::input[1]"));
	}
	public static WebElement labelCity(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'City')]"));
	}
	public static WebElement inputCity(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'City')]//following::input[1]"));
	}
	public static WebElement labelState(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'State')]"));
	}
	public static WebElement inputState(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'State')]//following::input[1]"));
	}
	public static WebElement labelCode(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Code')]"));
	}
	public static WebElement inputCode(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Code')]//following::input[1]"));
	}
	public static WebElement labelCounty(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'County')]"));
	}
	public static WebElement inputCounty(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'County')]//following::input[1]"));
	}
	public static WebElement labelPhone(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Phone')]"));
	}
	public static WebElement inputWrongPhone(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Phone')]//following::input[1]"));
	}
	public static WebElement inputDisconnected(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Phone')]//following::input[2]"));
	}
	public static WebElement inputLanguage(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Language')]//following::input[1]"));
	}
	public static WebElement labelLanguage(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Language')]"));
	}
	public static WebElement inputRetentionName(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdAssignedTo']"));
	}
	public static WebElement labelRetentionName(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdAssignedTo']//parent::div/label[1]"));
	}
	public static WebElement inputRetentionSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdSupervisorName']"));
	}
	public static WebElement labelRetentionSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdSupervisorName']//parent::div[1]/label[1]"));
	}
	public static WebElement txtTaskHistory(WebDriver driver) {
		return driver.findElement(By.xpath(".//h6[contains(text(),'Task History')]"));
	}
	public static WebElement inputTaskID(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdTaskId']"));
	}
	public static WebElement labelTaskID(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdTaskId']//parent::div[1]/label[1]"));
	}
	public static WebElement inputTaskType(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdTaskType']"));
	}
	public static WebElement labelTaskType(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdTaskType']//parent::div[1]/label[1]"));
	}
	public static WebElement inputCampaignDescription(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdCampaignDescription']"));
	}
	public static WebElement labelCampaignDescription(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdCampaignDescription']//parent::div[1]/label[1]"));
	}
	public static WebElement inputJobname(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdJobName']"));
	}
	public static WebElement labelJobname(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdJobName']//parent::div[1]/label[1]"));
	}
	public static WebElement inputCreatedDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdCreatedOn']"));
	}
	public static WebElement labelCreatedDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdCreatedOn']//parent::div[1]/label[1]"));
	}
	public static WebElement inputTaskStatus(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdTaskStatus']"));
	}
	public static WebElement labelTaskStatus(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdTaskStatus']//parent::div[1]/label[1]"));
	}
	public static WebElement inputScheduleDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdScheduleDate']"));
	}
	public static WebElement labelScheduleDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='tdScheduleDate']//parent::div[1]/label[1]"));
	}
	public static WebElement selectDisposition (WebDriver driver) {
		return driver.findElement(By.xpath(".//select[@id='tdDispositionLkup']"));
	}
	public static WebElement labelDisposition(WebDriver driver) {
		return driver.findElement(By.xpath(".//select[@id='tdDispositionLkup']//parent::div[1]/label[1]"));
	}
	public static WebElement labelNotes(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@id='tdNotes']//parent::div[1]/label[1]"));
	}
	public static WebElement txtAreaNotes(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@id='tdNotes']"));
	}
	public static WebElement btncampaignScript(WebDriver driver) {
		return  scrollIntoView(driver,driver.findElement(By.xpath(".//a[contains(text(),'Campaign Script')]")));
	}
	public static WebElement btnClose(WebDriver driver) {
		return  scrollIntoView(driver,driver.findElement(By.xpath(".//button[contains(text(),'Close')][1]")));
	}
	public static WebElement btnSave(WebDriver driver) {
		return  scrollIntoView(driver,driver.findElement(By.xpath(".//button[contains(text(),'Save ')][1]")));
	}
	public static WebElement btnSavenClose(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(By.xpath(".//button[contains(text(),'Save & Close')]")));
	}
	/**********************************Methods
	 * @throws InterruptedException *****************************/
	public static boolean viewLaunch(WebDriver driver, String id) throws InterruptedException {
		LeftPanel.lnkSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(id);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		String parentWindow=driver.getWindowHandle();
		SearchRetentionPage.jsClick(SearchRetentionPage.lnkView(driver), driver);
		SearchRetentionPage.waitForPageLoad(driver);
		Set<String> windowHandles = driver.getWindowHandles();
		for(String s:windowHandles) {
			if(!(s.equals(parentWindow)))
			{
				WebDriver window = driver.switchTo().window(s);
				driver=window;
				driver.manage().window().maximize();
				break;
			}
		}
		
		return SearchTaskDetails.txtApplicationDetails(driver).isEnabled();
	}
	public static boolean editLaunch(WebDriver driver, String id) {
		LeftPanel.lnkSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(id);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.lnkEdit(driver).click();
		SearchTaskDetails.waitForPageLoad(driver);
		return SearchTaskDetails.txtApplicationDetails(driver).isEnabled();
	}
}
