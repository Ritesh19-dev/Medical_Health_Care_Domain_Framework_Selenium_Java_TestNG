package com.MedicalHealthCare.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfigFile 
{
	Properties prop ;

	String path = "C:\\Users\\ritei\\eclipse-workspace\\MedicalHealthCare\\MedicalHealthCare\\Configuration\\Config.properties";


	//Constructor
	public readConfigFile()
	{

		try 
		{
			prop = new Properties();


			FileInputStream file = new FileInputStream(path);

			prop.load(file);
		} 

		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}


	//Read url value from Config file
	public String getBaseUrl()
	{
		String urlValue= prop.getProperty("baseUrl");

		if(urlValue !=null)
		{
			return urlValue;
		}

		else
		{
			throw new RuntimeException("URL not specified in Config file");
		}
	}

	//Read browser value from Config file
	public String getBrowser()
	{
		String browserValue= prop.getProperty("browser");

		if(browserValue !=null)
		{
			return browserValue;
		}

		else
		{
			throw new RuntimeException("Browser not specified in Config file");
		}
	}

}
