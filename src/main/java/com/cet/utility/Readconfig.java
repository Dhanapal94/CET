package com.cet.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.cet.intit.Base;			

public class Readconfig  extends Base{
	//static Logger mainLogger;
	public static Properties prop;

	public static String getIEDriverPath() throws IOException
	{
		String sPath = System.getProperty("user.dir")+ File.separatorChar+getValue("cet","IEDriverPath");//prop.getProperty("IEDriverPath");
		return sPath;
	}

	public static String getAppURL()
	{
		String sURL = getValue("cet","url");//prop.getProperty("url");
		return sURL;
	}
	
	public static String getMailToRecipients() {
		String toRecipents =getValue("cet","MailRecipientsTo");		
		return toRecipents;

	}

	
	// Properties object as per file name 
	public static  Properties getconfigFile(String fileName) {
		BufferedReader reader;
		String fname =fileName+".properties";
		String filepath="./Configuration\\"+fname;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			prop = new Properties();
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			mainLogger.error("Error at configaration file Reading ", e);
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + filepath);
		} 
		return prop;
	}


	public static String getValue(String FileName ,String key)
	{
		prop = getconfigFile(FileName);
		String value = prop.getProperty(key);
		System.out.println("Data File name :: "+FileName +" Value :: "+value);
		//mainLogger.info("Data File name :: "+FileName +" Value :: "+value);
		return value;
	}


}
