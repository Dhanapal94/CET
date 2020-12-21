package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.manager.PageObject;

public class PhdAssignmentResultPage extends PageObject {

	static WebElement element;

	public PhdAssignmentResultPage(WebDriver driver) {
		super(driver);
	}

	public static  WebElement tableTaskId(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableTaskType(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[3]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableCampaignFocus(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[4]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableJobName(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[5]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableCreatedDate(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[6]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableTaskStatus(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[7]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableDialingMethod(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[8]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableFinalDisposition(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[9]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableFinalAttemptDate(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[10]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAssignedTo(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[11]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableInputAction(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[1]/input[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement buttonAssign(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Assign']"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static WebElement dropDownAssignUserList(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='User List']//following::select[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static WebElement buttonAssignUserList(WebDriver driver) {
		element= driver.findElement(By.xpath("//button[text()='Close']//following::button[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static WebElement tableNoResults(WebDriver driver) {
		element= driver.findElement(By.xpath("//table/tfoot/tr/td[1]"));
		highLighterMethod(element,driver);
		return element;
	}



}
