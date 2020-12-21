package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.manager.PageObject;

public class PhdHomePage extends PageObject{
	static WebElement element;

	public PhdHomePage(WebDriver driver) {
		super(driver);
	}

	public static boolean launch(WebDriver driver) {
		System.out.println("********************Phd Home::launch*********************");
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

	public static  WebElement tableHeader(WebDriver driver) {
		element =driver.findElement(By.xpath("//h6[@class='wdgt-hdr']"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement tableJobName(WebDriver driver,String row) {
		element =driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableTaskType(WebDriver driver,String row) {
		element =driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[2]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableScheduledDate(WebDriver driver,String row) {
		element =driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[3]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableLastAttemptDate(WebDriver driver,String row) {
		element =driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[4]"));
		highLighterMethod(element, driver);
		return element;
	}
	public static  WebElement tableAttemptCount(WebDriver driver,String row) {
		element =driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[5]"));
		highLighterMethod(element, driver);
		return element;
	}

}
