package com.cet.utility;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class GetLogger {
	
	public static Logger logger;
	
	public static Logger getMainLogger(String className) {
		logger = Logger.getLogger(className);
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure(System.getProperty("user.dir")+ File.separatorChar+"log4j.properties");
        logger.fatal("Log4j XML configuration is successful !!");
        return logger;
	}
	
	public static Logger getMainLogger() {
		logger = Logger.getRootLogger();
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure(System.getProperty("user.dir")+ File.separatorChar+"log4j.properties");
        logger.fatal("Log4j XML configuration is successful !!");
        return logger;
	}
}
