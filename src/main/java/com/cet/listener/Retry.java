/*import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;

import com.cet.intit.Base;
import com.cet.utility.GetLogger;
import com.cet.utility.extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

package com.cet.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.cet.intit.Base;
import com.cet.utility.extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;


public class Retry implements IRetryAnalyzer {




	public void extendReportsFailOperations(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();

	}
}

public void onFinish(ITestContext context) {
		
		
	    Set<ITestResult> allResults = context.getPassedTests().getAllResults();
	      
		
		ITestNGMethod[] allTestMethods = context.getAllTestMethods();
		for(ITestNGMethod method :allTestMethods ) {
			for(ITestResult result :allResults){
				if(result.getMethod()==method) {
					if (method.isTest()) {
						ExtentTestManager.startTest(method.getMethodName());
						softAssert = Base.getSoftAssert();
						err = null;
						try {
							softAssert.assertAll();

						} catch (AssertionError e) {
							err = e;

						}

						if(err !=null) {
							result.setThrowable(err);
							result.setStatus(TestResult.FAILURE);
							
						}
				}
			}
			}
		}
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod methods = temp.getMethod();
			if (context.getFailedTests().getResults(methods).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(methods).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
	}

	public void onTestStart(ITestResult testResult) { 
		softAssert= new SoftAssert();
		mainLogger = GetLogger.getMainLogger(testResult.getName().toString().trim());

	}

	public void onTestSuccess(ITestResult result) { 
		mainLogger.info("Test pass");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");

	}

	public void onTestFailure(ITestResult testResult) { 
		testResult.setStatus(TestResult.FAILURE);
		testResult.setThrowable(err);
		mainLogger.info("Test Failed"+err);
		//assertion failed 
		String sErrorText=err.toString();
		extendReportsFailOperations(testResult,sErrorText); 

	}

	public void onTestSkipped(ITestResult testResult) {  
		if(testResult.getStatus() == ITestResult.SKIP){
			mainLogger.info("Test skip");
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skiped");
			//ExtentTestManager
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

	public void onStart(ITestContext context) {  
		
			
		}
		
*//*	
	 int SUCCESS = 1;
	  int FAILURE = 2;
	  int SKIP = 3;
	public boolean retry(ITestResult iTestResult) {
		//retry(iTestResult);//if (!(iTestResult.isSuccess())) {  
		if((!(iTestResult.getStatus()==1))) {   //Check if test not succeed
			if (count < maxTry) {                            //Check if maxTry count is reached
				count++;                                     //Increase the maxTry count by 1
				iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed and take base64Screenshot
				return true;                                 //Tells TestNG to re-run the test
			}
		}
		else {
			iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
		}
		return false;
	}*/