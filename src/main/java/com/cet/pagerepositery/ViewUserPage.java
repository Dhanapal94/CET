package com.cet.pagerepositery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cet.utility.Readconfig;


public class ViewUserPage extends UserAdminAddUserPage {
	public ViewUserPage(WebDriver driver) {
		super(driver);	
	}
	//click on view link from search result 
	public static boolean viewLaunch(WebDriver driver ,String expValueMSID) {
		Assert.assertTrue( UserAdminPage.launch(driver));
		System.out.println("********************ViewUserPage::viewLaunch*********************");
		UserAdminPage.inputMsId(driver).sendKeys(expValueMSID);
		UserAdminPage.btnSearch(driver).click();
		UserAdminPage.waitForPageLoad(driver);
		Assert.assertTrue(UserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		Assert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
		UserAdminPage.lnkView(driver).click();
		ViewUserPage.waitForPageLoad(driver);
		boolean contains = ViewUserPage.pageLabel(driver).getText().contains("View User");
		return contains;
	}

	//Read from ViewUserConfig Methods 
	public static String expTitle() {
		return Readconfig.getValue("viewuser", "title");
	}

	public static String expValueMSID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("viewuser","txtMSID");
	}
	public static String expValueFirstName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("viewuser","txtFName");
	}
	public static String expValueLastName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("viewuser","txtLName");
	}
	public static String expValueEMPID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("viewuser","txtEMPID");
	}
	public static String expValueEmailId() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("viewuser","txtEmailID");
	}
	public static String expValueSupervisor() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("viewuser","txtSupervisor");
	}
	public static boolean expAssignWorkStatus() {
		// TODO Auto-generated method stub
		return Boolean.parseBoolean(Readconfig.getValue("viewuser","flagAssignWork"));
	}

	public static String[] expDialingTeam(String values) {
		System.out.println("expDialingTeam"+values);
		String[] list = values.split(",");
		System.out.println("Dialing Team list"+list);
		return list;
	}
	public static String[] expDialingMethos(String values) {
		System.out.println("expDialingMethos"+values);
		String[] list = values.split(",");
		System.out.println("Method list"+list);
		return list;
	}
	public static String[] expLanguage(String values) {
		System.out.println("expLanguage"+values);
		String[] list = values.split(",");
		System.out.println("Language exp list"+list);
		return list;
	}
	public static String[] expTeam(String values) {
		//String values = Readconfig.getValue("viewuser","listTeam");
		String[] list = values.split(",");
		System.out.println("Team Exp list"+list);
		return list;
	}


	/*//return title of page 
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();

	}
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
	}*/
	/*
	//Label Add user 
	public static WebElement pageLabel(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[@class='page-name']"));
	}
	//Label User Info
	public static WebElement labelUserInfo(WebDriver driver) {
		return driver.findElement(By.xpath(".//h6[contains(text(),'User Info')]"));
	}
	//Label MS ID
	public static WebElement labelMsId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'MS ID')]"));
	}
	//Inputbox MS ID
	public static WebElement inputMsId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'MS ID')]/following::div[1]/input"));
	}
	//Label First Name
	public static WebElement labelFname(WebDriver driver) {
		return driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));
	}
	//Label Last Name
	public static WebElement labelLname(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Last Name')]"));
	}
	//Label Employee ID
	public static WebElement labelEmpId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Employee ID')]"));
	}
	//Label Email ID
	public static WebElement labelEmailId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Email ID')]"));
	}
	//Label Supervisor
	public static WebElement labelSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]"));
	}

	//input First Name
	public static WebElement inputFname(WebDriver driver) {
		return driver.findElement(By.xpath("//label[contains(text(),'First Name')]//following::input[1]"));
	}
	//input Last Name
	public static WebElement inputLname(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Last Name')]//following::input[1]"));
	}
	//input Employee ID
	public static WebElement inputEmpId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Employee ID')]//following::input[1]"));
	}
	//input Email ID
	public static WebElement inputEmailId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Email ID')]//following::input[1]"));
	}
	//input Supervisor
	public static WebElement inputSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]//following::input[1]"));
	}
	//Label Status
	public static WebElement labelStatus(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Status')]"));
	}
	//Label Active
	public static WebElement labelActive(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Active')]"));
	}
	//Label Active
	public static WebElement labelInActive(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'InActive')]"));
	}
	//Checkbox Active
	public static WebElement inputActive(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='active']"));
	}
	//Checkbox InActive
	public static WebElement inputInActive(WebDriver driver) {
		return driver.findElement(By.xpath(".//input[@id='inactive']"));
	}
	//Label Assign Work
	public static WebElement labelAssignWork(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Assign Work')]"));
	}
	//Checkbox Assign Work
	public static WebElement inputAssignWork(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Assign Work')]/parent::div/input"));
	}
	//Label Skill
	public static WebElement labelSkill(WebDriver driver) {
		return driver.findElement(By.xpath(".//h6[contains(text(),'Skills')]"));
	}
	//Label Team 
	public static WebElement labelTeam(WebDriver driver) {
		return driver.findElement(By.xpath("(.//div[@class='skill-hdr'][contains(text(),'Team')])[1]"));
	}
	//Label Team list
	public static List<WebElement> listLabelTeam(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[1]//label"));
	}
	//Label Language
	public static WebElement labelLanguage(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='skill-hdr'][contains(text(),'Language')]"));
	}
	//Label Language list
	public static List<WebElement> listLabelLanguage(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[2]//label"));
	}
	//Label  Dialing Team
	public static WebElement labelDialingTeam(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='skill-hdr'][contains(text(),'Dialing Team')]"));
	}
	// Dialing Team list
	public static List<WebElement> listLabelDialingTeam(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[3]//label"));
	}
	//Label  Dialing Team Method
	public static WebElement labelDialingMethod(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='skill-hdr'][contains(text(),'Dialing Method')]"));
	}
	//Label Dialing Method list
	public static List<WebElement> listLabelDialingMethod(WebDriver driver) {
		return driver.findElements(By.xpath("(//div[@class='skill-box nice-scroll'])[4]//label"));
	}
	//Button Cancel
	public static WebElement btnCancel(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Cancel')]"));
	}
	//Button Reset
	public static  WebElement btnReset(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Reset')]"));
	}
	//Button Save
	public static WebElement btnSave(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Save')]"));
	}
	//Button Validate
	public static WebElement btnValidate(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Validate')]"));
	}
	// compare ArrayList with ListArray 

	public static boolean chekContains(List<String> arrayList, String [] list) {

		List<String> asList = Arrays.asList(list);
		Collections.sort(arrayList);
		Collections.sort(asList);
		boolean equals = arrayList.equals(asList);
		return equals;
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

	//Reading value from the configaration file ::AddUser
	public static String expTitle() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("addUser", "txtTitle");
	}

	public static String expValueMSID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtMSID");
	}
	public static String expValueFirstName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtFName");
	}
	public static String expValueLastName() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtLName");
	}
	public static String expValueEMPID() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtEMPID");
	}
	 */
}
