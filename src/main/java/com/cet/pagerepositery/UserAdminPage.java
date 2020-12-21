package com.cet.pagerepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;
import com.cet.utility.Readconfig;


public class UserAdminPage  extends PageObject{

	static WebElement element;
	
	//Constructor
	public UserAdminPage(WebDriver driver)  {
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


	//return title of page 
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();

	}
	//Label Add user 
	public  static WebElement labelUserAdmin(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Search Panel
	public static WebElement labelSearchPanel(WebDriver driver) throws InterruptedException {
		element= driver.findElement(By.xpath(".//h6[@class='wdgt-hdr']"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Ms ID
	public static WebElement labelMsId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'MS ID')]"));
		highLighterMethod(element,driver);
		return element;
	}
	// Label First Name
	public static WebElement labelFName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Last Name
	public static WebElement labelLName(WebDriver driver) {
		element= driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Employee ID
	public static WebElement labelEmpId(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Employee ID')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Dialing Team 
	public static WebElement labelDialingTeam(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Dialing Team')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Dialing Team 
	public static WebElement labelSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Label Dialing Team 
	public static WebElement labelManager(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Manager')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Input field MS ID
	public static WebElement inputMsId(WebDriver driver) {
		element=  scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'MS ID')]/following-sibling::input[1]")));
		highLighterMethod(element,driver);
		return element;
	}
	//Input field First Name
	public static WebElement inputFName(WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'First Name')]/following-sibling::input[1]")));
		highLighterMethod(element,driver);
		return element;
	}
	//Input field Last Name
	public static WebElement inputLName(WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'Last Name')]/following-sibling::input[1]")));
		highLighterMethod(element,driver);
		return element;
	}
	//Input field Email ID
	public static WebElement inputEmpId(WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(By.xpath(".//label[contains(text(),'Employee ID')]/following-sibling::input")));
		highLighterMethod(element,driver);
		return element;
	}
	//select field Dialing Team  :: added on 30-09-2020 
	public static WebElement selectDialingTeam(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Dialing Team')]/following-sibling::select"));
		highLighterMethod(element,driver);
		return element;
	}
	//select field Supervisor :: added on 30-09-2020 
	public static WebElement selectSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]/following-sibling::select"));
		highLighterMethod(element,driver);
		return element;
	}
	//select field Manager  :: added on 30-09-2020 
	public static WebElement selectManager(WebDriver driver) {
		element= driver.findElement(By.xpath(".//label[contains(text(),'Manager')]/following-sibling::select"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Cancel
	public static WebElement btnCancel(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Cancel')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Reset
	public static WebElement btnReset(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Reset')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Add user
	public static WebElement btnAddUser(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button']/following-sibling::a"));
		highLighterMethod(element,driver);
		return element;
	}
	//Button Search
	public static WebElement btnSearch(WebDriver driver) {
		element= driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Search')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//label Search Result 
	public static WebElement labelSearchResult(WebDriver driver) {
		element= driver.findElement(By.xpath(".//h6[contains(text(),'Search Result')]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header MS ID 
	public static WebElement headerMSID(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header First Name
	public static WebElement headerFname(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[2]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header Last Name
	public static WebElement headerLName(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[3]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header Employee ID
	public static WebElement headerEmpID(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[4]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header Supervisor
	public static WebElement headerSupervisor(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[5]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header Manager
	public static WebElement headerManager(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[6]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Result set header Action
	public static WebElement headerAction(WebDriver driver) {
		element= driver.findElement(By.xpath(".//div[@class='table-responsive']//th[7]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Link First
	public static WebElement linkFirst(WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button first')]")));
		highLighterMethod(element,driver);
		return element;
	}
	//Link Previous
	public static WebElement linkPrevious(WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button previous')]")));
		highLighterMethod(element,driver);
		return element;
	}
	//Link Next
	public static WebElement linkNext(WebDriver driver) {
		element= scrollIntoView(driver, driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button next')]")));
		highLighterMethod(element,driver);
		return element;
	}
	//link Last
	public static WebElement linkLast(WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button last')]")));
		highLighterMethod(element,driver);
		return element;
	}
	//table first row in serach result 
	@SuppressWarnings("deprecation")
	public static WebElement tableRow(WebDriver driver) {
		element= new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//table[@id='DataTables_Table_0']//tbody/tr[1]")));
		highLighterMethod(element,driver);
		return element;
	}
	//table first row MS ID value in serach result 
	public static WebElement colMSID(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	//table first row in search result 
	public static WebElement colFName(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[2]"));
		highLighterMethod(element,driver);
		return element;
	}
	//table first row in search result 
	public static WebElement colLName(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[3]"));
		highLighterMethod(element,driver);
		return element;
	}
	//table first row in search result 
	public static WebElement colEMPID(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[4]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Added on 1 -OCt-2020
	public static WebElement colSupervisor(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[5]"));
		highLighterMethod(element,driver);
		return element;
	}
	//Added on 1 -OCt-2020
	public static WebElement colManager(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[6]"));
		highLighterMethod(element,driver);
		return element;
	}
	//first row in search result Edit Link
	public static WebElement lnkEdit(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//a[@title='Edit']"));
		highLighterMethod(element,driver);
		return element;
	}
	//first row in search result View Link
	public static WebElement lnkView(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath("//i[@class='fa fa-eye']/parent::a"));
		highLighterMethod(element,driver);
		return element;
	}
	//empty row msg 
	public static WebElement txtNoDataFound(WebDriver driver) {
		element= tableRow(driver).findElement(By.xpath(".//td[@class='dataTables_empty']"));
		highLighterMethod(element,driver);
		return element;
	}

	//read from config file methods 

	public static String expTitle() {
		return Readconfig.getValue("useradmin","title");
	}

	public static String expTxtTitle() {
		return Readconfig.getValue("useradmin","labelTitle");
	}
	public static String expTxtSearchPanel() {
		return Readconfig.getValue("useradmin","txtSearchPanel");
	}
	public static String expTxtMsId() {
		return Readconfig.getValue("useradmin","textMsId");
	}
	public static String expTxtFname() {
		return Readconfig.getValue("useradmin","textFname");
	}
	public static String expTxtLname() {
		return Readconfig.getValue("useradmin","textLname");
	}
	public static String expTxtEmpID() {
		return Readconfig.getValue("useradmin","textEmpId");
	}
	public static String expTxtBtnCancel() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textBtnCancel");
	}
	public static String expTxtBtnReset() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textBtnReset");
	}
	public static String expTxtBtnSearch() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textBtnSearch");
	}
	public static String expTxtBtnAddUser() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textBtnAddUser");
	}
	public static String expTxtSearchResult() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textSearchResult");
	}
	public static String expTxtHeaderAction() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textheaderAction");
	}
	public static String expTxtNavFirst() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textNavFirst");
	}
	public static String expTxtNavPrevious() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textNavPrevious");
	}
	public static String expTxtNavNext() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","textNavNext");
	}
	public static String expTxtNavLast() {
		// TODO Auto-generated method stub
		return  Readconfig.getValue("useradmin","textNavLast");
	}
	public static String expTxtJunk() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","junkvalue");
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
	public static String expValueEmailId() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtEmailID");
	}
	public static String expValueSupervisor() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtSupervisor");
	}
	public static String expTxtNoDataFound() {
		// TODO Auto-generated method stub
		return Readconfig.getValue("useradmin","txtNoDataFound");
	}

}
