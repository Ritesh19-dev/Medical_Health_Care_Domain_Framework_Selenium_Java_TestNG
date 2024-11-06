package com.MedicalHealthCare.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.MedicalHealthCare.PageObject.HomePageToggleOptions;
import com.MedicalHealthCare.PageObject.indexPage;
import com.MedicalHealthCare.PageObject.userLogin;

import junit.framework.Assert;

public class TC_LogOut extends BaseClass
{
	@Test(groups = {"smokeTest"})
	public void logOut() throws IOException
	{
		logger.info("\n********************TEST CASE VERIFY LOG OUT OPTION STARTED*********************");

		Properties prop = new Properties();
		File file = new File("C:\\Users\\ritei\\eclipse-workspace\\MedicalHealthCare\\MedicalHealthCare\\Configuration\\loginCredentials.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		indexPage ip = new indexPage(driver);

		ip.loginFromMenuButton();
		logger.info("CLICKED ON MENU BUTTON");
		logger.info("CLICKED ON LOGIN BUTTON");


		userLogin ul = new userLogin(driver);

		WebElement userLogin = ul.loginUserName();
		userLogin.sendKeys(prop.getProperty("Username"));
		logger.info("USERNAME ENTERED");


		WebElement userPass = ul.loginUserPassword();
		userPass.sendKeys(prop.getProperty("Password"));
		logger.info("USER PASSWORD ENTERED");


		WebElement login = ul.ClickOnLoginButton();
		login.click();
		logger.info("CLICKED ON LOGIN BUTTON");


		String verify = ul.verifyUserLogin();
		Assert.assertEquals("Make Appointment", verify);
		logger.info("USER SUCCESSFULLY LOGGED IN");


		HomePageToggleOptions hpto = new HomePageToggleOptions(driver);
		WebElement menuButton = hpto.clickOnMenuButton();
		menuButton.click();
		logger.info("MENU OPTION IS CLICKED");
		
		WebElement userLogOut = hpto.clickOnLogoutOption();
		userLogOut.click();
		logger.info("LOG OUT OPTION IS CLICKED");
		
		
		
		
		String homePageTitle = ip.verifyPageTitle();
		Assert.assertEquals("CURA Healthcare Service", homePageTitle);
		logger.info("LOGGED OUT SUCCESSFULLY");

		logger.info("\n********************TEST CASE VERIFY LOG OUT OPTION ENDED*********************");
	}
}
