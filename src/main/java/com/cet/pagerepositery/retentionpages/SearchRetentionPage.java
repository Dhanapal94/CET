package com.cet.pagerepositery.retentionpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;

public class SearchRetentionPage extends PageObject {
	// Constructor
	public SearchRetentionPage(WebDriver driver) {
		super(driver);

	}


	/**********************************Object*****************************/

	// Label Search
	public static WebElement labelSearchPage(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='top-sctn']/label"));
	}
	public static WebElement inputMBI(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'#MBI')]//following::input[1]"));
	}
	public static WebElement selectTaskType(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Task Type')]//following::select[1]"));
	}
	public static WebElement selectCampaignFocus(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Campaign Focus')]//following::select[1]"));
	}
	public static WebElement selectTaskStatus(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Task Status')]//following::select[1]"));
	}
	public static WebElement selectDialingMethod(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Dialing Method')]//following::select[1]"));
	}
	public static WebElement inputJobName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Job Name')]//following::input[1]"));
	}
	public static WebElement inputMemberFirstName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Member First Name')]//following::input[1]"));
	}
	public static WebElement inputMemberLastName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Member Last Name')]//following::input[1]"));
	}
	public static WebElement inputPhoneNumber(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Phone Number')]//following::input[1]"));
	}
	public static WebElement inputCreatedDateFrom(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Created Date From')]//following::input[1]"));
	}
	public static WebElement inputCreatedDateTo(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Created Date To')]//following::input[1]"));
	}
	public static WebElement inputAgentName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Agent Name')]//following::input[1]"));
	}
	// Button Cancel
	public static WebElement btnCancel(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Cancel')]"));
	}
	// Button Reset
	public static WebElement btnReset(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Reset')]")));
	}
	// Button Search
	public static WebElement btnSearch(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[@type='button'][contains(text(),'Search')]"));
	}
	// label Search Result
	public static WebElement labelSearchResult(WebDriver driver) {
		return driver.findElement(By.xpath(".//h6[contains(text(),'Search Result')]"));
	}

	// Result set header Actions
	public static WebElement headerActions(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Action')]"));
	}
	// Result set header Task ID
	public static WebElement headerTaskId(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Task ID')]"));
	}
	// Result set header Task ID
	public static WebElement headerMBI(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'#MBI')]"));
	}
	// Result set header Task ID
	public static WebElement headerFirstName(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'First Name')]"));
	}
	// Result set header Task ID
	public static WebElement headerLastName(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Last Name')]"));
	}
	// Result set header Task ID
	public static WebElement headerMState(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'State')]"));
	}
	// Result set header Task Type
	public static WebElement headerTasktype(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Task Type')]"));
	}
	// Result set header Campaign Focus
	public static WebElement headerCampaignFocus(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Campaign Focus')]"));
	}
	// Result set header Job Name
	public static WebElement headerJobName(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Job Name')]"));
	}
	// Result set header Created Date
	public static WebElement headerCreatedDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Created Date')]"));
	}
	// Result set header Task Status
	public static WebElement headerTaskStatus(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Task Status')]"));
	}
	// Result set header Dialing Method
	public static WebElement headerDialingMethod(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Dialing Method')]"));
	}
	// Result set header Final Disposition
	public static WebElement headerFinalDisposition(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Final Disposition')]"));
	}
	// Result set header Final Attempt Date
	public static WebElement headerFinalAttemptDate(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Final Attempt Date')]"));
	}
	// Result set header Final Attempt Date
	public static WebElement headerFinalAssignedTo(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@class='table-responsive']//th[contains(text(),'Assigned To')]"));
	}
	// Link First
	public static WebElement linkFirst(WebDriver driver) {
		return scrollIntoView(driver,
				driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button first')]")));
	}
	// Link Previous
	public static WebElement linkPrevious(WebDriver driver) {
		return scrollIntoView(driver,
				driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button previous')]")));
	}
	// Link Next
	public static WebElement linkNext(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button next')]")));
	}
	// link Last
	public static WebElement linkLast(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(By.xpath(".//a[starts-with(@class,'paginate_button last')]")));
	}
	// table first row in search result
	public static WebElement tableRow(WebDriver driver) {
		return	driver.findElement(By.xpath(".//table[@id='taskTable']//tbody/tr[1]"));
	}

	// first row in search result Edit Link
	public static WebElement lnkEdit(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(By.xpath(".//a[@title='Edit']")));
	}
	// first row in search result View Link
	public static WebElement lnkView(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath("//a[@title='View']"));
	}
	// table first row in search result
	public static WebElement colTaskId(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[2]"));
	}
	// table first row in search result
	public static WebElement colMBI(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath("//td[3]"));
	}
	// table first row in search result
	public static WebElement colMemberFirstName(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath("//td[4]"));
	}
	// table first row in search result
	public static WebElement colMemberLastName(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[5]"));
	}
	// table first row in search result
	public static WebElement colState(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[6]"));
	}
	// table first row in search result
	public static WebElement colTaskType(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[7]"));
	}
	// table first row in search result
	public static WebElement colCreatedDate(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[10]"));
	}
	// table first row in search result
	public static WebElement colTaskStatus(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[11]"));
	}
	// table first row in search result
	public static WebElement colCampaignFocus(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath("//td[8]"));
	}
	// table first row in search result
	public static WebElement colJobName(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[9]"));
	}
	// table first row in search result
	public static WebElement colFinalDisposition(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[13]"));
	}
	// table first row in search result
	public static WebElement colAssignedTo(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[11]"));
	}
	// table first row in search result
	public static WebElement colDialingMethod(WebDriver driver) {
		return tableRow(driver).findElement(By.xpath(".//td[12]"));
	}
	// empty row msg
	public static WebElement txtNoDataFound(WebDriver driver) {
		return driver
				.findElement(By.xpath(".//td[contains(text(),'No ')]"));
	}
	public static WebElement labelMBI(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'MBI')]"));
	}
	public static WebElement labelCampaignFocus(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Campaign Focus')]"));
	}
	public static WebElement labelTaskType(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),' Task Type')]"));
	}
	public static WebElement labelTaskStatus(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Task Status')]"));
	}
	public static WebElement labelJobName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Job Name')]"));
	}
	public static WebElement labelDialingMethod(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Dialing Method')]"));
	}
	public static WebElement labelMemberFName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Member First Name')]"));
	}
	public static WebElement labelMemberLName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Member Last Name')]"));
	}
	public static WebElement labelPhoneNumber(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Phone Number')]"));
	}
	public static WebElement labelCreatedDateFrom(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Created Date From  ')]"));
	}
	public static WebElement labelCreatedDateTo(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Created Date To  ')]"));
	}
	public static WebElement labelAgentName(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Agent Name ')]"));
	}
	/**********************************AssignmentObject*****************************/
	public static WebElement btnAssign(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(By.xpath(".//button[contains(text(),'Assign')]")));
	}
	public static WebElement firstrowcheckBox(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
	}
	public static WebElement secondrowcheckBox(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
	}
	public static WebElement txtAssignment(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[contains(text(),'Assignment')][@class='page-name']"));
	}
	public static WebElement labelTaskID(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Task ID')]"));
	}
	public static WebElement inputTaskID(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Task ID')]//following::input[1]"));
	}
	public static WebElement labelSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]"));
	}
	public static WebElement selectSupervisor(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Supervisor')]//following::select[1]"));
	}
	public static WebElement labelManager(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Manager')]"));
	}
	public static WebElement selectManager(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'Manager')]//following::select[1]"));
	}

	public static String txtPleaseCorrect(WebDriver driver) {
		String s,str="";
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@class='validationErrors']"));
		for(WebElement e: findElements) {
			s=e.getText();
			str=str+s;
		}
		System.out.println("str"+str);
		return str;
	}
	// table first row in search result
	public static WebElement retentiontableRow(WebDriver driver) {
		return	driver.findElement(By.xpath(".//table[@class='table table-bordered table-striped mydatatable']//tbody/tr[1]"));
	}
	public static WebElement modelAssignText(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='modal-header wdgt-hdr']//h5[contains(text(),'Assign')]"));
	}
	public static WebElement modelSelectUserList(WebDriver driver) {
		return driver.findElement(By.xpath(".//label[contains(text(),'User List')]//following::select[1]"));
	}
	public static WebElement nodelbtnAssign(WebDriver driver) {
		return driver.findElement(By.xpath(".//div[@id='reAssignModal']//button[contains(text(),'Assign')]"));
	}
	public static WebElement firstRowtaskID(WebDriver driver) {
		return driver.findElement(By.xpath("//tbody[1]//td[2]"));
	} 
	public static WebElement secondRowtaskID(WebDriver driver) {
		return driver.findElement(By.xpath("//tbody[2]//td[2]"));
	} 
	/**********************************Methods*****************************/


	public static boolean launch(WebDriver driver) {
		LeftPanel.lnkSearch(driver).click();
		return labelSearchPage(driver).isEnabled();

	}
	public static boolean Assignmentlaunch(WebDriver driver) {
		LeftPanel.lnkAssignment(driver).click();
		return labelSearchPage(driver).isEnabled();

	}

}
