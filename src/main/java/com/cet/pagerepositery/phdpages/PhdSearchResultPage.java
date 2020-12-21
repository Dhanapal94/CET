package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.manager.PageObject;

public class PhdSearchResultPage extends PageObject {
	
	static WebElement element;
	
public PhdSearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static  WebElement tableTaskId(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAgentId(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[3]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAgentFirstName(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[4]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAgentLastName(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[5]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAgentState(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[6]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableTaskType(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[7]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableCampaignFocus(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[8]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableJobName(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[9]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableCreatedDate(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[10]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableTaskStatus(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[11]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableDialingMethod(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[12]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableFinalDisposition(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[13]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableFinalAttemptDate(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[14]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAssignedTo(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[15]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableEditLink(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[1]/a[@title='Edit']"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableViewLink(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[1]/a[@title='View']"));
		highLighterMethod(element, driver);
		return element;
	}
	

}
