package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.manager.PageObject;
import com.cet.utility.Readconfig;



public class HomePage extends PageObject {

	public HomePage (WebDriver driver){
		super(driver);

	}

	public static HomePage initPage (WebDriver driver) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return homePage;
	}
	//Label Add user 
	public static WebElement labelHomePage(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='top-sctn']/label"));
	}

	public static String expTitle() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("HomePage", "txtTitle");
	}





}
