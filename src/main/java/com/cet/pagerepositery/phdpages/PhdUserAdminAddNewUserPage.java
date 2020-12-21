package com.cet.pagerepositery.phdpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.manager.PageObject;

public class PhdUserAdminAddNewUserPage extends PageObject{

	static WebElement element;

	public PhdUserAdminAddNewUserPage(WebDriver driver)  {
		super(driver);
	}

	public static boolean launch(WebDriver driver) {
		System.out.println("********************UserAdminPage::Add New User launch*********************");
		//LeftPanel.lnkUseradmin(driver).click();
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

	public  static WebElement inputMsid(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='MS ID']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}	
	public  static WebElement buttonValidate(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='MS ID']//following::button[1]"));
		highLighterMethod(element,driver);
		return element;	
	}	
	public  static WebElement inputFirstName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='First Name']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputLastName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Last Name']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputEmployeeId(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Employee ID']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputEmailId(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Email ID']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Supervisor']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputManager(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Manager']//following::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputAssignWork(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Assign Work']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputStatusActive(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Active']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement inputStatusInActive(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Inactive']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}

	//SKILLS
	//TEAM

	public  static WebElement radioTeamINDTS(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='INDTS']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement radioTeamGPRTS(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='GRPTS']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement radioTeamRetention(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Retention']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement radioTeamPHD(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='PHD']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}

	//Language
	public  static WebElement checkBoxLanguageEnglish(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='English']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLangauageSpanish(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Spanish']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageKorean(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Korean']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLangaugeVietnamese(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Vietnamese']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageCantonese(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Cantonese']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageFrench(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='French']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageMandarin(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Mandarin']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageTagalog(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Tagalog']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageRussian(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Russian']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxLanguageChinese(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Chinese']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}

	//DialingTeam
	public  static WebElement checkBoxDialingTeamTSA(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='TSA']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamDIGITAL(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='DIGITAL']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamBilingual(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Bilingual']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamTSNonSNP(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='TS-NonSNP']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamTSSNP(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='TS-SNP']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamVendorNonSNP(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Vendor-NonSNP']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamVendorSNP(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Vendor-SNP']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamVendorNL(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Vendor-NL']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamGroupVendor(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Group-Vendor']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamGroupInternal(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Group-Internal']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingTeamGroupVendorNL(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Group-Vendor NL']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}

	//Dialing Method
	public  static WebElement checkBoxDialingMethodManual(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='Manual']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement checkBoxDialingMethod2StepManual(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[text()='2 STEP Manual']//preceding::input[1]"));
		highLighterMethod(element,driver);
		return element;	
	}
	public  static WebElement buttonSave(WebDriver driver) {
		element= driver.findElement(By.xpath("//button[text()='Save']"));
		highLighterMethod(element,driver);
		return element;	
	}
}
