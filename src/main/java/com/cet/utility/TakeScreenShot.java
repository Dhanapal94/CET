package com.cet.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cet.intit.Base;

public class TakeScreenShot {
	public static String getScreenshot(String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)Base.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String datename = d.toString().replaceAll(":", "-");
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+tname+" " +datename+"-screenshot.png";
		File dest = new File(destination);
		FileUtils.copyFile(src, dest);		
		return destination;
	}
}
