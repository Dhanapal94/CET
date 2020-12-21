package com.cet.utility.extentreports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.cet.intit.Base;


public class ExtentReport extends Base{
	
	public static void setExtentReport()
	{
		String timeStamp = new  SimpleDateFormat("M/d/yyyy hh:mm:ss").format(new Date());
		timeStamp= timeStamp.replaceAll(":", "-");
		reportname = "CET Report "+timeStamp.replaceAll("/", "-")+".html";
		System.out.println(reportname);
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\"+reportname);
		htmlreporter.config().setDocumentTitle("CET Automation Report");//Title of the report
		htmlreporter.config().setReportName("Functional CET Report");//Name of the report
		htmlreporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("OS", "WINDOWS10");
		extent.setSystemInfo("Tester Name", "Dhanapal,Nayna");
		extent.setSystemInfo("Browser", "InternetBrowser");	

	}	
	

}
