package com.cet.intit;

import java.io.IOException;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cet.utility.Readconfig;

public class InitBase {

	public static InternetExplorerDriver setIEDriverProperty() throws IOException{
		System.setProperty("webdriver.ie.driver",Readconfig.getIEDriverPath());
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		caps.setCapability("requireWindowFocus", true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		@SuppressWarnings("deprecation")
		InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(caps);
		return internetExplorerDriver;
	}

}
