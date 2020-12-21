package com.cet.intit;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cet.utility.DBConnection;
import com.cet.utility.GetLogger;
import com.cet.utility.Mail;
import com.cet.utility.Readconfig;


import com.cet.utility.extentreports.ExtentReport;


public class Base {

	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest test;
	public static boolean childTest=false;
	public static String reportname;
	public static int totoalTestCount = 0;
	public static int totoalFailCount = 0;
	public static int totoalPassCount = 0;
	public static int totoalSkipCount = 0;
	public static WebDriver driver;
	protected static  SoftAssert softAssert ;
	public static Logger mainLogger;
	public static boolean fopenBrowser=true;
	public static HashMap<String, String> viewUserData ;
	public static HashMap<String, String> indtsedit ;
	public static HashMap<String, String> newCampaign ;
	public static HashMap<String, String> indtstasksearch;
	public static HashMap<String, String> viewGrptsUserData ;
	public static HashMap<String, String> grptsedit ;
	public static HashMap<String, String> grptstasksearch ;
	public static HashMap<String, String> newGrptsCampaign;
	public static int count=0;
	public static boolean dataProviderView=false;
	public static String team;
	
	@SuppressWarnings("restriction")
	public static String sMSID=new com.sun.security.auth.module.NTSystem().getName();

	public SoftAssert getSoftAssert() {
		return Base.softAssert;
	}
	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return Base.driver;
	}

	public static void setUp() throws IOException, ClassNotFoundException, SQLException{
		mainLogger=GetLogger.getMainLogger(Base.class.getSimpleName());
		driver = InitBase.setIEDriverProperty();
		driver.manage().window().maximize();
		// Press CTRL + 0 keys of keyboard to set IEDriver Instance zoom level to 100%.
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		driver.get(Readconfig.getAppURL());
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if(!DBConnection.getClickCMT().contentEquals("0")) {
			driver.findElement(By.xpath("//button[@id='btnCET']")).click();
		}
	}

	@AfterClass
	public static void tearDown(){
		if(fopenBrowser)
		{
			fopenBrowser=true;
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		else
		{
			fopenBrowser=false;
		}
	}
	
	@BeforeSuite(alwaysRun = true)
	public void setExtent() throws Exception
	{
		System.out.println("Im before suite");
		ExtentReport.setExtentReport();

	}

	@AfterSuite(alwaysRun = true)
	public void removeExtent()
	{
		extent.flush();
		Mail.getMail();
	}

	
	public static void verifyassert(SoftAssert softAssert) {
		try { 
			softAssert.assertAll(); 
		}catch (AssertionError e) { 
			throw e;
		}
	}



}
