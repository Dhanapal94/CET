package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.manager.PageObject;

public class PHDSearch_TaskDetails_Page  extends PageObject{

	static WebElement element;
	
	public PHDSearch_TaskDetails_Page(WebDriver driver) {
		super(driver);
	}
	
	public static boolean launch(WebDriver driver) {
		System.out.println("********************Phd Task search::launch*********************");
		try {
		waitForPageLoad(driver);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return until.isEnabled();
	}
	
	public static  WebElement inputAgentId(WebDriver driver) {
		element =driver.findElement(By.id("tdAgentId"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentFirstName(WebDriver driver) {
		element =driver.findElement(By.id("tdFirstName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentLastName(WebDriver driver) {
		element =driver.findElement(By.id("tdLastName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputBad_DisconnectedNumber(WebDriver driver) {
		element =driver.findElement(By.id("tdPrimaryPhoneNumber"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputBad_DisconnectedNumber1(WebDriver driver) {
		element =driver.findElement(By.id("tdPhoneNumber1"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgencyName(WebDriver driver) {
		element =driver.findElement(By.id("tdAgencyName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputMarket(WebDriver driver) {
		element =driver.findElement(By.id("tdMarket"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentManagerEmail(WebDriver driver) {
		element =driver.findElement(By.id("tdAgentManagerEmail"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentManagerFirstName(WebDriver driver) {
		element =driver.findElement(By.id("tdAgentManagerFirstName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentManagerLastName(WebDriver driver) {
		element =driver.findElement(By.id("tdAgentManagerLastName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentManagerPhoneNumber(WebDriver driver) {
		element =driver.findElement(By.id("tdAgentManagerPhoneNumber"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentState(WebDriver driver) {
		element =driver.findElement(By.id("tdAgentState"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputLanguage(WebDriver driver) {
		element =driver.findElement(By.id("tdLanguage"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputSSRAssigned(WebDriver driver) {
		element =driver.findElement(By.id("tdAssignedTo"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputSSRSupervisor(WebDriver driver) {
		element =driver.findElement(By.id("tdSupervisorName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputOther(WebDriver driver) {
		element =driver.findElement(By.id("tdOther"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputTaskID(WebDriver driver) {
		element =driver.findElement(By.id("tdTaskId"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputTaskType(WebDriver driver) {
		element =driver.findElement(By.id("tdTaskType"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputCampaignDescription(WebDriver driver) {
		element =driver.findElement(By.id("tdCampaignDescription"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputJobName(WebDriver driver) {
		element =driver.findElement(By.id("tdJobName"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputCreatedDate(WebDriver driver) {
		element =driver.findElement(By.id("tdCreatedOn"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputTaskStatus(WebDriver driver) {
		element =driver.findElement(By.id("tdTaskStatus"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputScheduledDate(WebDriver driver) {
		element =driver.findElement(By.id("tdScheduleDate"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement selectMultipleLanguage(WebDriver driver) {
		element =driver.findElement(By.xpath("//select[@id='tdPHDLanguage']//following::button[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement selectDisposition(WebDriver driver) {
		element =driver.findElement(By.xpath("//select[@id='tdDispositionLkup']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputNotes(WebDriver driver) {
		element =driver.findElement(By.id("tdNotes"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement buttonCampaignScript(WebDriver driver) {
		element =driver.findElement(By.xpath("//a[text()='Campaign Script']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement buttonClose(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Close']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement buttonSaveClose(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Save & Close']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement table_taskHistory_JobName(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement table_taskHistory_Disposition(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement table_taskHistory_AttemptDate(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[3]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement table_taskHistory_AttemptCount(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[4]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement table_taskHistory_User(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[5]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement table_taskHistory_Notes(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[6]"));
		highLighterMethod(element, driver);
		return element;
	}
}
