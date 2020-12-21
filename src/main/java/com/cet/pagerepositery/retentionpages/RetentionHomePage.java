package com.cet.pagerepositery.retentionpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;
import com.cet.pagerepositery.phdpages.PhdHomeSkillPage;
import com.cet.pagerepositery.phdpages.PhdSettingPage;

public class RetentionHomePage extends PageObject{
	static WebElement element;

	public RetentionHomePage(WebDriver driver) {
		super(driver);
	}

	public static boolean launch(WebDriver driver) {
		System.out.println("********************Retention Home::launch*********************");
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
	
	/*
	 * "********************Retention Home Skill::launch*********************
	 */	
	
	public static  WebElement languageSkillCount(WebDriver driver,String language) {
		element =driver.findElement(By.xpath("//label[contains(text(),'"+language+"')]//following::span[1]"));
		highLighterMethod(element, driver);
		return element;
	}
	
	/*
	 * "********************Retention Home Setting::launch*********************
	 */	
	public static  WebElement tableCampaignFocusHeader(WebDriver driver) {
		element =driver.findElement(By.xpath("//h2/span[text()='Campaign Focus']"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement tableCampaignFocus(WebDriver driver,String row) {
		element =driver.findElement(By.xpath("(//table)[2]/tbody/tr["+row+"]/td[2]"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement tableAssigned_NonAssignedHeader(WebDriver driver) {
		element =driver.findElement(By.xpath("//h2/span[text()='Assigned/Non Assigned']"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement tableOnlyAssigned_Text(WebDriver driver) {
		element =driver.findElement(By.xpath("//h2/span[text()='Assigned/Non Assigned']//following::label[1]"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement tableOnlyNotAssigned_Text(WebDriver driver) {
		element =driver.findElement(By.xpath("//h2/span[text()='Assigned/Non Assigned']//following::label[2]"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement inputOnlyAssigned(WebDriver driver) {
		element =driver.findElement(By.xpath("//h2/span[text()='Assigned/Non Assigned']//following::input[1]"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement inputOnlyNotAssigned(WebDriver driver) {
		element =driver.findElement(By.xpath("//h2/span[text()='Assigned/Non Assigned']//following::input[2]"));
		highLighterMethod(element, driver);
		return element;
	}

	public static  WebElement buttonSave(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[text()='Save']"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement inputNewAgenWelcomeCampaign(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[text()='New Agent Welcome Campaign']//preceding::td[1]/input"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement inputReadytoSellCampaign(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[text()='Ready to Sell']//preceding::td[1]/input"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement inputNotReadytoSellCampaign(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[text()='Not ready to Sell']//preceding::td[1]/input"));
		highLighterMethod(element, driver);
		return element;
	}
	
	public static  WebElement inputNotReadytoSell_DSNPCampaign(WebDriver driver) {
		element =driver.findElement(By.xpath("//table/tbody/tr/td[text()='Not Ready to Sell – DSNP Campaign']//preceding::td[1]/input"));
		highLighterMethod(element, driver);
		return element;
	}
	
	//*********** Methods ****************//
	public static void onlyNotAssigned_Click(WebDriver driver) {
		driver.findElement(By.xpath("//img[contains(@src,'setting')]")).click();
		if(inputOnlyAssigned(driver).isSelected()){
			inputOnlyAssigned(driver).click(); // To unselect		
		}
		if(!inputOnlyNotAssigned(driver).isSelected()) {
			inputOnlyNotAssigned(driver).click(); // To select only Not assigned
		}
		buttonSave(driver).click();
		PhdSettingPage.alertAccept(driver);
		//PhdHomeSkillPage.launch(driver);
		LeftPanel.lnkLogOut(driver).click();
		driver.findElement(By.xpath("//button[@id='btnCET']")).click();
		PhdHomeSkillPage.launch(driver);	
	}
	
	
	public static void Assigned_NotAssigned_Click(WebDriver driver) {
		driver.findElement(By.xpath("//img[contains(@src,'setting')]")).click();
		if(!inputOnlyAssigned(driver).isSelected()){
			inputOnlyAssigned(driver).click(); 	
		}
		if(!inputOnlyNotAssigned(driver).isSelected()) {
			inputOnlyNotAssigned(driver).click();
		}
		buttonSave(driver).click();
		PhdSettingPage.alertAccept(driver);
		PhdHomeSkillPage.launch(driver);
	}

}
