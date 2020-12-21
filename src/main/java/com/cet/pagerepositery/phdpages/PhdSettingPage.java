package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class PhdSettingPage extends PageObject{
	static WebElement element;

	public PhdSettingPage(WebDriver driver) {
		super(driver);
	}
	
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
