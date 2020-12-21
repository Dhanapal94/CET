package com.cet.pagerepositery.retentionpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cet.pagerepositery.UserAdminAddUserPage;
import com.cet.pagerepositery.UserAdminPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;


public class RetentionUserAdminPage  extends PageObject{

	//Constructor
	public RetentionUserAdminPage(WebDriver driver)  {
		super(driver);

	}
	public static boolean launch(WebDriver driver) {
		System.out.println("********************UserAdminPage::launch*********************");
		LeftPanel.lnkUseradmin(driver).click();
		waitForPageLoad(driver);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return until.isEnabled();
	}
	public static boolean editlaunch(WebDriver driver,String msid) {
		System.out.println("********************UserAdminPage::launch*********************");
		Assert.assertTrue(RetentionUserAdminPage.launch(driver));
		RetentionUserAdminPage.inputMsId(driver).sendKeys(msid);
		RetentionUserAdminPage.btnSearch(driver).click();
		Assert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled());
		RetentionUserAdminPage.lnkEdit(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return RetentionUserAdminPage.getText(until, driver).contentEquals("Edit User");

	}
	public static boolean AddUserlaunch(WebDriver driver) {
		System.out.println("********************UserAdminPage::Add User launch*********************");
		Assert.assertTrue(RetentionUserAdminPage.launch(driver));
		RetentionUserAdminPage.btnAddUser(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return RetentionUserAdminPage.getText(until, driver).contentEquals("Add User");

	}

	//click on view link from search result 
	public static boolean viewLaunch(WebDriver driver ,String expValueMSID) {
		Assert.assertTrue( RetentionUserAdminPage.launch(driver));
		System.out.println("********************ViewUserPage::viewLaunch*********************");
		RetentionUserAdminPage.inputMsId(driver).sendKeys(expValueMSID);
		RetentionUserAdminPage.btnSearch(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		Assert.assertTrue(RetentionUserAdminPage.tableRow(driver).isEnabled(),"Failed: row not displayed");
		Assert.assertEquals(UserAdminPage.lnkView(driver).isEnabled(),true,"Failed: View link not displayed in search result");
		RetentionUserAdminPage.lnkView(driver).click();
		RetentionUserAdminPage.waitForPageLoad(driver);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return RetentionUserAdminPage.getText(until, driver).contentEquals("View User");
	}

	//return title of page 
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	//Label Add user 
	public  static WebElement labelUserAdmin(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
	}
	//Label Search Panel
	public static WebElement labelSearchPanel(WebDriver driver) throws InterruptedException {
		return driver.findElement(By.xpath("(.//h6[@class='wdgt-hdr'])[1]"));
	}
	//Label Ms ID
	public static WebElement labelMsId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'MS ID')]"));
	}
	// Label First Name
	public static WebElement labelFName(WebDriver driver) {
		return driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));
	}
	//Label Last Name
	public static WebElement labelLName(WebDriver driver) {
		return driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));
	}
	//Label Employee ID
	public static WebElement labelEmpId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Employee ID')]"));
	}
	//Label Dialing Team 
	public static WebElement labelSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]"));
	}
	//Label Dialing Team 
	public static WebElement labelManager(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Manager')]"));
	}
	//Input field MS ID
	public static WebElement inputMsId(WebDriver driver) {
		return  scrollIntoView(driver,driver.findElement(By.xpath("//label[contains(text(),'MS ID')]//following::input[1]")));
	}
	//Input field First Name
	public static WebElement inputFName(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'First Name')]//following::input[1]")));
	}
	//Input field Last Name
	public static WebElement inputLName(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'Last Name')]//following::input[1]")));
	}
	//Input field Employee ID
	public static WebElement inputEmpId(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'Employee ID')]//following::input[1]")));
	}
	//select field Dialing Team  :: added on 30-09-2020 
	public static WebElement selectDialingTeam(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Dialing Team')]//following-sibling::select"));
	}
	//select field Supervisor :: added on 30-09-2020 
	public static WebElement selectSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]//following-sibling::select"));
	}
	//select field Manager  :: added on 30-09-2020 
	public static WebElement selectManager(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Manager')]//following-sibling::select"));
	}
	//Button Cancel
	public static WebElement btnCancel(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Cancel')]"));
	}
	//Button Reset
	public static WebElement btnReset(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Reset')]"));
	}
	//Button Add user
	public static WebElement btnAddUser(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button']/following-sibling::a"));
	}
	//Button Search
	public static WebElement btnSearch(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Search')]"));
	}
	//label Search Result 
	public static WebElement labelSearchResult(WebDriver driver) {
		return driver.findElement(By.xpath(".//h6[contains(text(),'Search Result')]"));
	}
	//Result set header Action
	public static WebElement headertext(WebDriver driver, String value) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'"+value+"')]"));
	}
	//Link First
	public static WebElement linkFirst(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button first')]")));
	}
	//Link Previous
	public static WebElement linkPrevious(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button previous')]")));
	}
	//Link Next
	public static WebElement linkNext(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button next')]")));
	}
	//link Last
	public static WebElement linkLast(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button last')]")));
	}
	//table first row in serach result 
	@SuppressWarnings("deprecation")
	public static WebElement tableRow(WebDriver driver) {
		WebElement row = new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//table[@id='DataTables_Table_0']//tbody/tr[1]")));
		return row; //driver.findElement(By.xpath("//*[@id='DataTables_Table_0']//tbody/tr[1]"));
	}
	//table first row in search result 
	public static WebElement colValue(WebDriver driver,String value) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//td[contains(text(),'"+value+"')]")));
	}
	//first row in search result Edit Link
	public static WebElement lnkEdit(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//a[@title='Edit']"));
	}
	//first row in search result View Link
	public static WebElement lnkView(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath("//i[@class='fa fa-eye']/parent::a"));
	}
	//empty row msg 
	public static WebElement txtNoDataFound(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[@class='dataTables_empty']"));
	}
	/*******************************UserAdminPage::Add User Object *********************************/
	//input Email ID
	public static WebElement inputEmailId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Email ID')]//following::input[1]"));
	}
	//Label Email ID
	public static WebElement labelEmailId(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Email ID')]"));
	}
	/* added on 05-10-2020 new field added :: @nayna *///input Manager
	public static WebElement inputManager(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Manager')]//following::input[1]"));
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
		return driver.findElement(By.xpath(".//label[contains(text(),'Inactive')]"));
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
	//Button Save
	public static WebElement btnSave(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Save')]"));
	}
	//Button Validate
	public static WebElement btnValidate(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Validate')]"));
	}
	//input Supervisor
	public static WebElement inputSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]//following::input[1]"));
	}

	//get selected option of Dialing Team 
	public static List<String> selectedInputDialingTeam(WebDriver driver) {
		List<String> selectedOption = new ArrayList<String>();
		List<WebElement> listLabelDialingTeam = listLabelDialingTeam(driver);
		for(WebElement label: listLabelDialingTeam) {
			WebElement inputDialingTeam = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
			WebElement inputDialingMethod = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
			scrollIntoView(driver, label);
			WebElement sinputlanguage = scrollIntoView(driver,label.findElement(By.xpath(".//preceding-sibling::input[1]")));
			if(sinputlanguage.isSelected()) {
				selectedOption.add(label.getText());
			}
		}
		System.out.println("selectedOption"+selectedOption);
		return selectedOption;
	}
	//get selected option of Team 
	public static List<String> selectedInputTeam(WebDriver driver) {
		List<String> selectedOption = new ArrayList<String>();
		List<WebElement> listLabelTeam = listLabelTeam(driver);
		for(WebElement label: listLabelTeam) {
			scrollIntoView(driver, label);
			WebElement inputTeam = scrollIntoView(driver, label.findElement(By.xpath(".//preceding-sibling::input[1]")));
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
			WebElement inputTeam = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
			WebElement inputLanguage = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
			WebElement inputDialingMethod = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
			WebElement inputDialingTeam = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
					WebElement inputTeam = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
					scrollIntoView(driver, inputTeam).click();
					flag=true;
				}
			}
		}

		return flag;
	}
	public static boolean selectLanguage(WebDriver driver, String[] expAddLanguage) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for(String l:expAddLanguage) {
			WebElement label=scrollIntoView(driver, driver.findElement(By.xpath("(//div[@class='skill-box nice-scroll'])[2]//div//label[contains(text(),'"+l+"')]//parent::div[1]/input[1]")));
			if(label.isSelected()) {
				scrollIntoView(driver, label).click();
				flag=true;
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
					WebElement inputDTeam = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
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
					WebElement inputMethod = label.findElement(By.xpath(".//preceding-sibling::input[1]"));
					inputMethod.click();
					flag=true;
				}
			}
		}
		return flag;
	}






	public static String[] expValues(String value) {
		String[] list = value.split(",");
		System.out.println("Dialing Team list"+list.toString());
		return list;
	}

}
