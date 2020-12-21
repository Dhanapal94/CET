package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.manager.PageObject;

public class PhdHomeSkillPage extends PageObject{
	static WebElement element;

	public PhdHomeSkillPage(WebDriver driver) {
		super(driver);
	}

	public static boolean launch(WebDriver driver) {
		System.out.println("********************Phd Home Skill::launch*********************");
		//LeftPanel.lnkHome(driver).click();
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

	public static  WebElement languageSkillCount(WebDriver driver,String language) {
		element =driver.findElement(By.xpath("//label[contains(text(),'"+language+"')]//following::span[1]"));
		highLighterMethod(element, driver);
		return element;
	}

}
