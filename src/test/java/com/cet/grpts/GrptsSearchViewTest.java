package com.cet.grpts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.SearchEditPage;
import com.cet.utility.grpts.GetDataFromExcelGRPTS;

public class GrptsSearchViewTest extends Base {
	private static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {	
		fopenBrowser = true;
		childTest=true;
		parentTest=extent.createTest("Grpts-Search View Test");
		team="Grpts";
		grptsedit = GetDataFromExcelGRPTS.grptsedit();
	}

	@BeforeMethod
	public static void getGrptsTaskEdit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp();
			System.out.println("bconnid is:" + SearchEditPage.launch(driver, grptsedit.get("bConnID")));
			Assert.assertTrue(SearchEditPage.launch(driver, grptsedit.get("bConnID")));
			initFlag=false;
		}
	}
}
