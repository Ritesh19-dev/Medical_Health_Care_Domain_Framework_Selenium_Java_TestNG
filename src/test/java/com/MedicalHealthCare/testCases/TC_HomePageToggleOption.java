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

public class TC_HomePageToggleOption extends BaseClass
{
	@Test(groups = {"sanityTest","regressionTest"})
	public void homePageToggle() throws IOException
	{
		logger.info("\n********************TEST CASE HOME PAGE TOGGLE  STARTED*********************");

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
		Assert.assertTrue(menuButton.isDisplayed());
		logger.info("MENU OPTION IS DISPLAYED");
		
		menuButton.click();
		logger.info("MENU OPTION IS CLICKED");
		
		
		WebElement homeOption = hpto.clickOnHomeOption();
		Assert.assertTrue(homeOption.isDisplayed());
		logger.info("HOME OPTION IS DISPLAYED");
		
		
		WebElement historyOption = hpto.clickOnHomeOption();
		Assert.assertTrue(historyOption.isDisplayed());
		logger.info("HISTORY OPTION IS DISPLAYED");
		
		
		WebElement profileOption = hpto.clickOnHomeOption();
		Assert.assertTrue(profileOption.isDisplayed());
		logger.info("PROFILE OPTION IS DISPLAYED");
		
		
		WebElement logoutOption = hpto.clickOnHomeOption();
		Assert.assertTrue(logoutOption.isDisplayed());
		logger.info("LOGOUT OPTION IS DISPLAYED");
		

		WebElement closeMenuButton = hpto.clickOnMenuButton();
		closeMenuButton.click();
		logger.info("MENU OPTION IS CLOSED");

		
		logger.info("\n********************TEST CASE HOME PAGE TOGGLE  ENDED*********************");
	}

}
