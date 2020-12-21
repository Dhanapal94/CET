package com.cet.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.cet.intit.Base;
import com.cet.utility.GetLogger;
import com.cet.utility.TakeScreenShot;


public class Reporting extends Base implements ITestListener {

	public static int count=0;
	public static String screenPath;

	public void onTestStart(ITestResult result) {
		//totoalTestCount++;
		softAssert = new SoftAssert();
		mainLogger = GetLogger.getMainLogger(result.getName().toString().trim());
		System.out.println(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		totoalTestCount++;
		totoalPassCount++;
		if(!childTest)
		{
			test = extent.createTest(result.getName().toUpperCase());
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}

		else
		{
			test = parentTest.createNode(result.getName().toUpperCase());
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			test.log(Status.PASS, "Test case passed");
		}

	}

	public void onTestFailure(ITestResult result) {
		totoalTestCount++;
		totoalFailCount++;
		try {
			screenPath = TakeScreenShot.getScreenshot(result.getName().toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(!childTest)
		{

			test = extent.createTest(result.getName().toUpperCase());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.log(Status.FAIL, "Test case Failed due to - " + result.getThrowable());
			try {
				test.addScreenCaptureFromPath(screenPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else
		{
			test = parentTest.createNode(result.getName().toUpperCase());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.log(Status.FAIL, "Test case Failed due to - " + result.getThrowable());
			try {
				test.addScreenCaptureFromPath(screenPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void onTestSkipped(ITestResult result) {
		totoalTestCount++;
		totoalSkipCount++;
		if(!childTest)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
			test.log(Status.SKIP, "Test case skipped due to - " + result.getThrowable());
		}
		else
		{
			test = parentTest.createNode(result.getName().toUpperCase());
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
			test.log(Status.SKIP, "Test case skipped due to - " + result.getThrowable());

		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}