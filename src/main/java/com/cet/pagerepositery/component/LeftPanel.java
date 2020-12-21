package com.cet.pagerepositery.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.manager.PageObject;


public class LeftPanel {

	//Left panel object.
	public static WebElement leftPanel(WebDriver driver) {
		WebElement leftPanel = driver.findElement(By.xpath("//nav[@class='sidebar-nav']"));
		return leftPanel;
	}
	//Home link 
	public static WebElement lnkHome(WebDriver driver) {
		WebElement lnkHome=leftPanel(driver).findElement(By.xpath("(//a[contains(@href,'Home')])[2]"));
		return lnkHome;
	}
	//User Administration.
	public static WebElement lnkUseradmin(WebDriver driver) {
		System.out.println("lnkUseradmin");
		//return driver.findElement(By.xpath(".//nav[@class='sidebar-nav']//a[starts-with(@href,'/UserAdmin/Admin')]"));
		WebElement element = driver.findElement(By.xpath("//a[contains(@href,'Admin')]"));
		PageObject.highLighterMethod(element, driver);
		return element;
	}
	//Search link. 
	public static  WebElement lnkSearch(WebDriver driver) {
		WebElement lnkSearch =leftPanel(driver).findElement(By.xpath("//a[starts-with(@href, \"/TaskSearch/TaskSearch?\")]"));
		PageObject.highLighterMethod(lnkSearch, driver);
		return lnkSearch;
	}

	//Assignment
	public static  WebElement lnkAssignment(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//a[contains(@href,'Assignment')]"));
		PageObject.highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement lnkLogOut(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//a[contains(@href,'Logout')]"));
		PageObject.highLighterMethod(element, driver);
		return element;
	}
	
	// Configuration link.
		public static WebElement lnkConfiguration(WebDriver driver) {
			WebElement lnkconfiguration = leftPanel(driver)
					.findElement(By.xpath("//a[contains(@href,'Configuration')]"));
			return lnkconfiguration;
		}



}
