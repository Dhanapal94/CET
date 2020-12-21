package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.manager.PageObject;

public class AdditionalHouseHoldPage  {

	static WebElement element;

	public static  WebElement inputAdditionalHouseHoldMembers(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='# of Additional Household Members']//following::input[1]"));
		PageObject.highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement inputMemberFirstName(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='First Name']//following::input[1]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement inputMemberLastName(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Last Name']//following::input[1]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement inputAdditionalHouseHoldMemberFirstName(WebDriver driver,String index) {
		element =driver.findElement(By.xpath("(//label[text()='Addl HH Member First Name']//following::input[1])["+index+"]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement inputAdditionalHouseHoldMemberLasttName(WebDriver driver,String index) {
		element =driver.findElement(By.xpath("(//label[text()='Addl HH Member Last Name']//following::input[1])["+index+"]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement dropDownDisposition(WebDriver driver) {
		element =driver.findElement(By.xpath("//label[text()='Disposition ']//following::select[1]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement buttonSaveGetHouseHold(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Save & Get House Hold']"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement buttonCloseDialogGetHouseHold(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[@class='close']"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement tableGetHouseHoldMemberFirstName(WebDriver driver,String index) {
		element =driver.findElement(By.xpath("(//table)[2]/tbody["+index+"]/tr/td[2]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

	public static  WebElement tableGetHouseHoldMemberLastName(WebDriver driver,String index) {
		element =driver.findElement(By.xpath("(//table)[2]/tbody["+index+"]/tr/td[3]"));
		PageObject.highLighterMethod(element, driver);
		return element;        
	}

}
