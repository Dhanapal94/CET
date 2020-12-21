package com.cet.pagerepositery.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class PageObject {

	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;
	private static WebDriver driver;
	private WebDriverWait wait;

	@SuppressWarnings("deprecation")
	public PageObject(WebDriver driver) {
		PageObject.setDriver(driver);
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);

		PageFactory.initElements(driver, this);
	}

	// compare ArrayList with ListArray 
	public static boolean cheklistequal(List<String> arrayList, String [] list) {

		List<String> asList = Arrays.asList(list);
		Collections.sort(arrayList);
		Collections.sort(asList);
		//checekcontains 
		System.out.println("CheckContains");
		arrayList.stream().forEach(S -> System.out.println("arrayList  "+S));
		asList.stream().forEach(S -> System.out.println("asList  "+S));
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
	public static String gatDate(int day) {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		Date time = cal.getTime();
		String sDate = new SimpleDateFormat("MM/dd/yyyy").format(time).toString();
		return sDate;
	}
	//return title of page 
	public static String getTitle(WebDriver driver) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-sctn']/label")));
		return driver.getTitle();

	}
	public static String getDate(String sDate) throws ParseException {
		//TimeZone timezone = TimeZone.getTimeZone("UTC");
		//String sDate="2020-12-31 00:00:00.0";
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat expectedFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse(sDate);
		String string = expectedFormat.format(date).toString();
		System.out.println("string"+string);
		return  string; //11/05/2020
	}
	public static void  jsClick(WebElement element,WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	@SuppressWarnings("deprecation")
	public static boolean wiatForPopUp(WebDriver driver) {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(driver, 300);
		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("alert was not present");
		} else {
			System.out.println("alert was present");
			flag = true;
		}
		return flag;
	}

	public static WebElement scrollIntoView(WebDriver driver, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		js.executeScript("arguments[0].scrollIntoView(true);", e);
		highLighterMethod(e,driver);
		return e;
	}

	public static void waitForPageLoad(WebDriver driver) {

		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new WebDriverWait(driver, 120);
		try {
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					System.out.println("Current Window State       : "
							+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
					return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
							.equals("complete");
				}
			});
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static WebElement waitforElement(WebDriver driver,WebElement e) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(e));
		return until;
	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		PageObject.driver = driver;
	}

	public static String getInputBoxValue(WebElement e) {
		String attribute = e.getText();
		if(attribute==null||attribute.contains("")) {
			attribute = e.getAttribute("value");
		}
		System.out.println("getInputBoxValue" +attribute);
		return attribute;
	}

	public static String getInputBoxPlaceHolder(WebElement e) {
		String attribute = e.getAttribute("placeholder");
		System.out.println("getInputBoxPlaceHolder" +attribute);
		return attribute;
	}

	public static String getText(WebElement e , WebDriver driver) {
		scrollIntoView(driver, e);
		String text=e.getText();
		if(text.equals(null)||text.equals("")) {
			text=e.getAttribute("innerHTML");
		}
		System.out.println("getText"+text);
		return text;
	}

	protected static void waitForElementToAppear(WebDriverWait wait, By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void waitForElementToDisappear(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void waitForTextToDisappear(By locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
	}

	public static void switchToWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			//driver.manage().window().maximize();
			System.out.println("Page Loaded is: " + driver.getTitle());
			if (driver.getTitle().contains("Task View")) {
				return;
			}
		}
	}

	public static void switchToParentWindow(WebDriver driver) {
		String parentWindowContact = driver.getWindowHandle();
		driver.close();
		driver.switchTo().window(parentWindowContact);
	}

	//****ScrollintoView*****


	public static void scrollElement(WebElement element,WebDriver driver) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static String  selectText(WebElement element,String value,WebDriver driver) throws Exception {

		scrollElement(element,driver);
		highLighterMethod(element,driver);
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
		String selectedOption= sel.getFirstSelectedOption().getText();
		return selectedOption;
	}

	public static void selectTextByIndex(WebDriver driver , WebElement element,int index) throws Exception {

		scrollElement(element,driver);
		highLighterMethod(element,driver);
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public static void sendDate(String StartDate,WebDriver driver,WebElement e) throws ParseException {
		String sDate =getDate(StartDate); 
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+sDate+"'", e);  
		e.sendKeys(Keys.ENTER);

	}
	public static void setInputvalue(String value,WebDriver driver,WebElement e) {
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+value+"'", e);  
		e.sendKeys(Keys.TAB);
	}

	public static void selectByVisibleText(WebElement element,String value,WebDriver driver) throws Exception {
		element.click();
		scrollElement(element,driver);
		highLighterMethod(element,driver);
		//Select sel = new Select(element);
		driver.findElement(By.xpath("//option[contains(text(),'"+value+"')]")).click();
	}
	public static String getSelectedtext(WebDriver driver,WebElement element) {
		Select sel = new Select(element);
		return sel.getFirstSelectedOption().getText();

	}

	// *********** Dhanapal ********
	public static void highLighterMethod( WebElement element,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView();", element);
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void alertAccept(WebDriver driver){
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if(wait.until(ExpectedConditions.alertIsPresent()) != null)
		{	
			driver.switchTo().alert().accept();
		}

	}

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getTitleText(WebElement e) {
		String text = e.getAttribute("title");
		return text;
	}

	public static String handleWindows(WebDriver driver) throws Exception{
		PageObject.waitForPageLoad(driver);
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		while(it.hasNext())
		{
			String child = it.next();
			if(!mainWindow.equals(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();
			}
		}
		System.out.println("Main window:"+mainWindow);
		return mainWindow;
	}

	public static String alertText(WebDriver driver){
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String alertText =null;
		if(wait.until(ExpectedConditions.alertIsPresent()) != null)
		{
			alertText=driver.switchTo().alert().getText();
			System.out.println("ALERT TEXT ===>"+alertText);
			driver.switchTo().alert().accept();
		}

		return alertText;
	}

	public static String getHomePageDate( String str) throws ParseException { 
		//String sDate="12/05/2020 00:00:00 AM";
		str=str.replaceAll("\"", "");
		str=str.replaceAll("AM", "");
		str=str.replaceAll("PM", "");
		str=str.trim();
		System.out.println(str);
		SimpleDateFormat formatter =new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SimpleDateFormat expectedFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(str);
		String string = expectedFormat.format(date).toString();
		System.out.println("string"+string);
		return  string; //2020-05-11
	}


}
