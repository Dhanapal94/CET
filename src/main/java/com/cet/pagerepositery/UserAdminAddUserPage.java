package com.cet.pagerepositery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.utility.Readconfig;


public class UserAdminAddUserPage extends UserAdminPage {
	static WebElement element;
	
	public UserAdminAddUserPage(WebDriver driver) {
		super(driver);	
	}
	public static boolean launch(WebDriver driver) {
		if(UserAdminPage.launch(driver)) {
			UserAdminPage.btnAddUser(driver).click();
		}
		waitForPageLoad(driver);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		waitForPageLoad(driver);
		return title.isEnabled();
	}

	public static boolean enterMsID(WebDriver driver,String MsID) {
		boolean flag=false;
		UserAdminAddUserPage.inputMsId(driver).sendKeys(MsID);
		UserAdminAddUserPage.btnValidate(driver).click();
		UserAdminAddUserPage.waitForPageLoad(driver);
		if(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputMsId(driver)).equals(MsID)) {
			flag=true;
		}
		return flag;
	}

	/*
	 * //return title of page public static String getTitle(WebDriver driver) {
	 * return driver.getTitle();
	 * 
	 * }
	 */
	@SuppressWarnings("deprecation")
	public static boolean wiatForPopUp(WebDriver driver) {
		boolean flag=false;
		WebDriverWait wait = new WebDriverWait(driver, 300);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{System.out.println("alert was not present");
		}
		else {
			System.out.println("alert was present");
			flag=true;
		}
		return flag;
	}

	//Label Add user 
	public static WebElement pageLabel(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[@class='page-name']"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label User Info
	public static WebElement labelUserInfo(WebDriver driver) {
		element= driver.findElement(By.xpath(".//h6[contains(text(),'User Info')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Inputbox MS ID
	public static WebElement inputMsId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'MS ID')]/following::div[1]/input"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Email ID
	public static WebElement labelEmailId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Email ID')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Supervisor
	public static WebElement labelSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//input Email ID
	public static WebElement inputEmailId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Email ID')]//following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	//input Supervisor
	public static WebElement inputSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]//following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	/* added on 05-10-2020 new field added :: @nayna *///input Manager
	public static WebElement inputManager(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Manager')]//following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Status
	public static WebElement labelStatus(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Status')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Active
	public static WebElement labelActive(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Active')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Active
	public static WebElement labelInActive(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Inactive')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Checkbox Active
	public static WebElement inputActive(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='active']"));
		highLighterMethod(element,driver);
		return element;
	}
	//Checkbox InActive
	public static WebElement inputInActive(WebDriver driver) {
		element= driver.findElement(By.xpath(".//input[@id='inactive']"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Assign Work
	public static WebElement labelAssignWork(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Assign Work')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Checkbox Assign Work
	public static WebElement inputAssignWork(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Assign Work')]/parent::div/input"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Skill
	public static WebElement labelSkill(WebDriver driver) {
		element= driver.findElement(By.xpath(".//h6[contains(text(),'Skills')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Team 
	public static WebElement labelTeam(WebDriver driver) {
		element= driver.findElement(By.xpath("(.//div[@class='skill-hdr'][contains(text(),'Team')])[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Team list
	public static List<WebElement> listLabelTeam(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[1]//label"));
	}
	//Label Language
	public static WebElement labelLanguage(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='skill-hdr'][contains(text(),'Language')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Language list
	public static List<WebElement> listLabelLanguage(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[2]//label"));
	}
	//Label  Dialing Team
	public static WebElement labelDialingTeam(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='skill-hdr'][contains(text(),'Dialing Team')]"));
		highLighterMethod(element,driver);
		return element;
	}
	// Dialing Team list
	public static List<WebElement> listLabelDialingTeam(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[3]//label"));
	}
	//Label  Dialing Team Method
	public static WebElement labelDialingMethod(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='skill-hdr'][contains(text(),'Dialing Method')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Dialing Method list
	public static List<WebElement> listLabelDialingMethod(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[4]//label"));
	}
	//Button Cancel
	public static WebElement btnCancel(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Cancel')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Reset
	public static  WebElement btnReset(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Reset')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Save
	public static WebElement btnSave(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Save')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Validate
	public static WebElement btnValidate(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Validate')]"));
		highLighterMethod(element,driver);
		return element;
	}
	// compare ArrayList with ListArray 
	public static boolean cheklistequal(List<String> arrayList, String [] list) {

		List<String> asList = Arrays.asList(list);
		Collections.sort(arrayList);
		Collections.sort(asList);
		//checekcontains 
		System.out.println("CheckContains");
		arrayList.stream().forEach(S -> System.out.println(S));
		asList.stream().forEach(S -> System.out.println(S));
		boolean equals = asList.equals(arrayList);
		System.out.println("list are equals"+equals);
		return equals;
	}

	public static boolean chekcontains(List<String> arrayList, String list) {
		boolean flag= false;
		Collections.sort(arrayList);

		//checekcontains 
		System.out.println("CheckContains");
		for(String listItem: arrayList) {
			if(listItem.contains(list)) {
				flag=true;
				break;
			}

		}

		return flag;
	}

	//get selected option of Dialing Team 
	public static List<String> selectedInputDialingTeam(WebDriver driver) {
		List<String> selectedOption = new ArrayList<String>();
		List<WebElement> listLabelDialingTeam = listLabelDialingTeam(driver);
		for(WebElement label: listLabelDialingTeam) {
			WebElement inputDialingTeam = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputDialingTeam.isSelected()) {
				selectedOption.add(label.getText());
			}
		}
		//System.out.println("selectedOption"+selectedOption);
		return selectedOption;
	}

	//get selected option of Dialing Methods 
	public static List<String> selectedInputDialingMethod(WebDriver driver) {
		List<String> selectedOption = new ArrayList<String>();
		List<WebElement> listLabelDialingMethod = listLabelDialingMethod(driver);
		for(WebElement label: listLabelDialingMethod) {
			WebElement inputDialingMethod = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputDialingMethod.isSelected()) {
				selectedOption.add(label.getText());
			}
		}
		//System.out.println("selectedOption"+selectedOption);
		return selectedOption;
	}

	//get selected option of Language 
	public static List<String> selectedInputLanguage(WebDriver driver) {
		List<String> selectedOption = new ArrayList<String>();
		List<WebElement> listLabelLanguage = listLabelLanguage(driver);
		for(WebElement label: listLabelLanguage) {
			WebElement inputLanguage = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputLanguage.isSelected()) {
				selectedOption.add(label.getText());
			}
		}
		//System.out.println("selectedOption"+selectedOption);
		return selectedOption;
	}
	//get selected option of Team 
	public static List<String> selectedInputTeam(WebDriver driver) {
		List<String> selectedOption = new ArrayList<String>();
		List<WebElement> listLabelTeam = listLabelTeam(driver);
		for(WebElement label: listLabelTeam) {
			WebElement inputTeam = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputTeam.isSelected()) {
				selectedOption.add(label.getText());
			}
		}
		//System.out.println("selectedOption"+selectedOption);
		return selectedOption;
	}


	public static boolean isTeamEditable(WebDriver driver) {
		boolean flag=false;
		List<WebElement> listLabelTeam = UserAdminAddUserPage.listLabelTeam(driver);
		for(WebElement label: listLabelTeam) {
			WebElement inputTeam = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputTeam.isEnabled()) {
				flag=true;
			}
		}
		return flag;
	}

	//Validate option of Language Enabled or disabled 
	public static boolean isLanguageEditable(WebDriver driver) {
		boolean flag=false;
		List<WebElement> listLabelLanguage = UserAdminAddUserPage.listLabelLanguage(driver);
		for(WebElement label: listLabelLanguage) {
			WebElement inputLanguage = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputLanguage.isEnabled()) {
				flag=true;
			}
		}
		return flag;
	}

	//Validate option of Dialing Methods Enabled or disabled .
	public static boolean isDialingMethodEditable(WebDriver driver) {
		boolean flag=false;
		List<WebElement> listLabelDialingMethod = UserAdminAddUserPage.listLabelDialingMethod(driver);
		for(WebElement label: listLabelDialingMethod) {
			WebElement inputDialingMethod = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputDialingMethod.isEnabled()) {
				flag=true;
			}
		}
		return flag;
	}

	//Validate option  of Dialing Team  Enabled or disabled .
	public static boolean isDialingTeamEditable(WebDriver driver) {
		boolean flag=false;

		List<WebElement> listLabelDialingTeam = listLabelDialingTeam(driver);
		for(WebElement label: listLabelDialingTeam) {
			WebElement inputDialingTeam = label.findElement(By.xpath("./preceding-sibling::input[1]"));
			if(inputDialingTeam.isEnabled()) {
				flag=true;
			}
		}
		return flag;
	}

	public static boolean chekStatus(WebDriver driver, String Status) {
		// TODO Auto-generated method stub
		boolean flag=false;
		switch(Status) {
		case "Active":
			flag = UserAdminAddUserPage.inputActive(driver).isSelected();
			System.out.println("Flag: Active"+flag);
			break;

		case "Inactive" :
			flag = UserAdminAddUserPage.inputInActive(driver).isSelected();
			System.out.println("Flag: InActive"+flag);
			break;
		}
		return flag;
	}
	public static boolean selectStatus(WebDriver driver, String Status) {

		boolean flag=false;
		switch(Status){

		case "Active" :
			UserAdminAddUserPage.inputActive(driver).click();
			flag = UserAdminAddUserPage.inputActive(driver).isSelected();
			break ; 
		case "InActive" :
			UserAdminAddUserPage.inputInActive(driver).click();
			flag =UserAdminAddUserPage.inputInActive(driver).isSelected();
			break ;
		}
		return flag;
	}

	public static boolean getAssignWork(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag = UserAdminAddUserPage.inputAssignWork(driver).isSelected();
		return flag;
	}

	public static boolean chekAssignWork(WebDriver driver, String expValueAssignWork) {
		// TODO Auto-generated method stub
		boolean flag=false;
		switch(expValueAssignWork) {
		case "true":
			flag = UserAdminAddUserPage.inputAssignWork(driver).isSelected();
			break;
		case "false" :
			flag = (!UserAdminAddUserPage.inputAssignWork(driver).isSelected());
			break;
		}
		return flag;
	}
	//Select Work Status 
	public static boolean selectAssignWork(WebDriver driver, String expValueAssignWork) {
		boolean flag= false;
		switch (expValueAssignWork){

		case "true" : 
			UserAdminAddUserPage.inputAssignWork(driver).click();
			flag = Boolean.parseBoolean(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputAssignWork(driver)));
			if(!flag) {
				UserAdminAddUserPage.inputAssignWork(driver).click();
				flag=true;
			}
			break ;
		case "false": 
			flag = Boolean.parseBoolean(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputAssignWork(driver)));
			if(flag) {
				UserAdminAddUserPage.inputAssignWork(driver).click();
				flag=true;
			}
			break ;
		case "default" : 
			flag = Boolean.parseBoolean(UserAdminAddUserPage.getInputBoxValue(UserAdminAddUserPage.inputAssignWork(driver)));
			break;
		}
		return flag;
	}


	public static boolean selectTeam(WebDriver driver , String team[]){

		boolean flag=false;
		List<WebElement> listLabelTeam = UserAdminAddUserPage.listLabelTeam(driver);
		for(WebElement label: listLabelTeam) {
			for(String t : team ) {
				if(label.getText().contains(t))
				{
					WebElement inputTeam = label.findElement(By.xpath("./preceding-sibling::input[1]"));
					inputTeam.click();
					flag=true;
				}
			}
		}

		return flag;
	}
	public static boolean selectLanguage(WebDriver driver, String[] expAddLanguage) {
		// TODO Auto-generated method stub
		boolean flag=false;
		List<WebElement> listLabelLanguage = UserAdminAddUserPage.listLabelLanguage(driver);
		for(WebElement label: listLabelLanguage) {
			for(String l:expAddLanguage) {
				if(label.getText().contains(l)) {
					WebElement inputLang = label.findElement(By.xpath("./preceding-sibling::input[1]"));
					inputLang.click();
					flag=true;
				}
			}
		}
		return flag;
	}
	public static boolean selectDialingTeam(WebDriver driver, String[] expAddDialingTeam) {
		// TODO Auto-generated method stub
		boolean flag=false;
		List<WebElement> listLabelDialingTeam = listLabelDialingTeam(driver);
		for(WebElement label: listLabelDialingTeam) {
			for(String t : expAddDialingTeam) {
				if(label.getText().contains(t)) {
					WebElement inputDTeam = label.findElement(By.xpath("./preceding-sibling::input[1]"));
					inputDTeam.click();
					flag=true;

				}
			}

		}

		return flag;
	}


	public static boolean selectDialingMethod(WebDriver driver, String[] expAddMethod) {
		// TODO Auto-generated method stub
		boolean flag=false;
		List<WebElement> listLabelDialingMethod = UserAdminAddUserPage.listLabelDialingMethod(driver);
		for(WebElement label: listLabelDialingMethod) {
			for(String m :expAddMethod) {
				if(label.getText().equals(m)) {
					WebElement inputMethod = label.findElement(By.xpath("./preceding-sibling::input[1]"));
					inputMethod.click();
					flag=true;
				}
			}
		}
		return flag;
	}
	//Reading value from the configaration file ::AddUser
	public static String expPageTitle() {
		return Readconfig.getValue("addUser", "title");
	}
	public static String expTitle() {
		return Readconfig.getValue("addUser", "txtTitle");
	}
	public static String expTxtUserInfo() {
		return Readconfig.getValue("addUser","txtuserInfo");
	}
	public static String expTxtEmailId() {
		return Readconfig.getValue("addUser","textEmailId");
	}
	public static String expTxtSupervisor() {
		return Readconfig.getValue("addUser","textSupervisor");
	}
	public static String expTxtStatus() {
		return Readconfig.getValue("addUser","textStatus");
	}
	public static String expTxtActive() {
		return Readconfig.getValue("addUser","textActive");
	}
	public static String expTxtInActive() {
		return Readconfig.getValue("addUser","textInActive");
	}
	public static String expTxtAssignWork() {
		return Readconfig.getValue("addUser","textAssignWork");
	}
	public static String expTxtBtnValidate() {
		return Readconfig.getValue("addUser","textBtnValidate");
	}
	public static String expTxtSkills() {
		return Readconfig.getValue("addUser","textSkill");
	}
	public static String expTxtTeam() {
		return Readconfig.getValue("addUser","textTeam");
	}
	public static String expTxtLan() {
		return Readconfig.getValue("addUser","textLanguage");
	}
	public static String expTxtDialingTeam() {
		return Readconfig.getValue("addUser","textDialingTeam");
	}
	public static String expTxtDialingMethod() {
		return Readconfig.getValue("addUser","textDialingMethod");
	}
	public static String expAddMSID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueMSID");
	}
	public static String expAddFirstName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueFName");
	}
	public static String expAddLastName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueLName");
	}
	public static String expAddEMPID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueEMPID");
	}
	public static String expAddEmailID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueEmailID");
	}
	public static String expAddSupervisor() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueSupervisor");
	}
	public static String expAddStatus() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueStatus");
	}
	public static String expAddAssignWork() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","valueAssignWork");
	}
	public static String expTxtBtnSave() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","textBtnSave");
	}
	public static String expValueExistMsID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","txtExistMSID");
	}
	public static String expValueInvalidMsID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","txtInvalidMSID");
	}
	public static String expMSGExistMsID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","txtExistsMSID");
	}
	public static String expMSGInvalidMsID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","txtExistsMSID");
	}
	public static String expMsgReset() {
		return Readconfig.getValue("addUser","textResetMsg");
	}
	public static String[] expAddDialingTeam() {
		String values = Readconfig.getValue("addUser","valueDialingTeam");
		String[] list = values.split(",");
		System.out.println("Dialing Team list"+list.toString());
		return list;
	}
	public static String[] expAddDialingMethos() {
		String values = Readconfig.getValue("addUser","valueDialingMethod");
		String[] list = values.split(",");
		System.out.println("Method list"+list.toString());
		return list;
	}
	public static String[] expAddLanguage() {
		String values = Readconfig.getValue("addUser","valueLanguage");
		String[] list = values.split(",");
		System.out.println("Language exp list"+list.toString());
		return list;
	}
	public static String[] expAddTeam() {
		String values = Readconfig.getValue("addUser","valueTeam");
		String[] list = values.split(",");
		System.out.println("Team Exp list"+list.toString());
		return list;
	}
	public static String expMSGSave() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser","ValueMsgSave");
	}



}
