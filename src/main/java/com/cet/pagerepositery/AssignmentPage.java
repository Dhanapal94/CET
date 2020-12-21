package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.manager.PageObject;

public class AssignmentPage extends PageObject {
	
	static WebElement element;
	
	public AssignmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	// ************** Additional HouseHold ******************** //
	
	public static WebElement inputTaskid(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Task ID']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static WebElement dropDownDialingTeam(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Dialing Team']//following::select[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static WebElement buttonSearch(WebDriver driver) {
		element= driver.findElement(By.id("btnAssign"));
		highLighterMethod(element,driver);
		return element;
	}

	public static WebElement searchResultCheckBox(WebDriver driver) {
		element= driver.findElement(By.xpath("//table/tbody/tr/td/input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	
	public static WebElement buttonAssign(WebDriver driver) {
		element= driver.findElement(By.xpath("//button[text()='Assign']"));
		highLighterMethod(element,driver);
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

	
	

}
