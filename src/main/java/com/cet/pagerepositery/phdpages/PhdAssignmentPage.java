package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class PhdAssignmentPage extends PageObject{
	static WebElement element;
	
	public PhdAssignmentPage(WebDriver driver) {
		super(driver);
	}
	
	public static boolean launch(WebDriver driver) {
		System.out.println("********************Phd Assignment::launch*********************");
		LeftPanel.lnkAssignment(driver).click();
		try{
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
	
	public static  WebElement inputTaskId(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Task ID']//following::input[1]"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement dropDownTaskType(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()=' Task Type']//following::select[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement dropDownCampaignFocus(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Campaign Focus']//following::select[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement dropDownTaskStatus(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Task Status']//following::select[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputJobName(WebDriver driver) {
		element =driver.findElement(By.id("jobNameId"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement dropDownDialingMethod(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Dialing Method']//following::select[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement inputCreatedDateFrom(WebDriver driver) {
		element =driver.findElement(By.id("CreatedDateFrom"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputCreatedDateTo(WebDriver driver) {
		element =driver.findElement(By.id("CreatedDateTo"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement inputAgentName(WebDriver driver) {
		element =driver.findElement(By.id("demoAutoComplete"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement dropDownSupervisor(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Supervisor']//following::select[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement dropDownManager(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Manager']//following::select[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement buttonCancel(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Cancel']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement buttonReset(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Reset']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement buttonSearch(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Search']"));
		highLighterMethod(element, driver);
		return element;
	}

}
