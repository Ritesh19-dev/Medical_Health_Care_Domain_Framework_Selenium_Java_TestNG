package com.MedicalHealthCare.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.MedicalHealthCare.PageObject.indexPage;
import com.MedicalHealthCare.PageObject.userLogin;

import junit.framework.Assert;

public class TC_userLoginWithInvalidCredentials extends BaseClass
{
	@Test(groups= {"smokeTest"})

	public void userLoginWithInvalidCredentials() throws IOException
	{


		logger.info("\n********************TEST CASE USER LOGIN WITH INVALID CREDENTIALS STARTED*********************");

		Properties prop = new Properties();
		File file = new File("C:\\Users\\ritei\\eclipse-workspace\\MedicalHealthCare\\MedicalHealthCare\\Configuration\\negativeLoginCredentials.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		String loginUserName = prop.getProperty("Username");
		String loginUserPassword = prop.getProperty("Password");


		indexPage ip = new indexPage(driver);
		WebElement makeApponitmentButton = ip.clickOnMakeAppointmentButton();
		makeApponitmentButton.click();
		logger.info("CLICKED ON MAKE APPOINTMENT BUTTON");



		userLogin ul = new userLogin(driver);
		WebElement username= ul.loginUserName();
		username.sendKeys(loginUserName);
		logger.info("USERNAME ENTERED");


		WebElement userpass= ul.loginUserPassword();
		userpass.sendKeys(loginUserPassword);
		logger.info("USER PASSWORD ENTERED");


		WebElement login = ul.ClickOnLoginButton();
		login.click();
		logger.info("CLICKED ON LOGIN BUTTON");

		String verify = ul.getInvalidLoginMessage();
		Assert.assertEquals("Login failed! Please ensure the username and password are valid.", verify);
		logger.info("USER SUCCESSFULLY LOGGED IN");

		logger.info("\n********************TEST CASE USER LOGIN WITH INVALID CREDENTIALS ENDS*********************");

	}

}


