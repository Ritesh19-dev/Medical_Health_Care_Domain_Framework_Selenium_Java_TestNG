package com.MedicalHealthCare.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.MedicalHealthCare.PageObject.Appointment;
import com.MedicalHealthCare.PageObject.AppointmentConfirmation;
import com.MedicalHealthCare.PageObject.HomePageToggleOptions;
import com.MedicalHealthCare.PageObject.indexPage;
import com.MedicalHealthCare.PageObject.userLogin;

import junit.framework.Assert;

public class TC_EndToEndAppointmentBooking extends BaseClass
{
	@Test(groups = {"smokeTest"})
	
	public void EndToEndAppointmentBooking() throws IOException
	{

		logger.info("\n********************TEST CASE END TO END APPOINTMENT BOOKING STARTED*********************");
		Properties prop = new Properties();
		File file = new File("C:\\Users\\ritei\\eclipse-workspace\\MedicalHealthCare\\MedicalHealthCare\\Configuration\\loginCredentials.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		String loginUserName = prop.getProperty("Username");
		String loginUserPassword = prop.getProperty("Password");


		indexPage ip = new indexPage(driver);
		WebElement makeAppointment =ip.clickOnMakeAppointmentButton();
		makeAppointment.click();
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

		String verify = ul.verifyUserLogin();
		Assert.assertEquals("Make Appointment", verify);
		logger.info("USER SUCCESSFULLY LOGGED IN");


		//Read the makeAppointment properties file
		logger.info("READING THE MAKE APPOINTMENT PROPERTIES FILE");
		Properties propfile = new Properties();
		File appointmentFile = new File("C:\\Users\\ritei\\eclipse-workspace\\MedicalHealthCare\\MedicalHealthCare\\Configuration\\makeAppointment.properties");
		FileInputStream appfile = new FileInputStream(appointmentFile);
		propfile.load(appfile);

		logger.info("MAKE APPOINTMENT PROPERTIES FILE READ SUCCESSFULLY");

		Appointment ma = new Appointment(driver);
		WebElement value = ma.dropDownListOfFacility();

		value.click();
		Select obj = new Select(value);

		obj.selectByValue(propfile.getProperty("facility"));

		logger.info("FACILITY OF VALUE SELECTED");


		//Interacting with the Check BOX WebElement
		WebElement checkBox = ma.applyForHospitalReadmissionCheckBox();
		String option = propfile.getProperty("applyForHospitalReAdmission");
		if(option.equals("Yes"))
		{
			Assert.assertTrue(checkBox.isEnabled());
			logger.info("APPLY FOR HOSPITAL READMISSION CHECKBOX IS ENABLED");
			checkBox.click();
			logger.info("APPLY FOR HOSPITAL READMISSION CHECKBOX SELECTED");

		}


		//Interacting with the Radio button WebElement
		WebElement radioButton_1= ma.medicareRadioButton();
		String radioButtonText_1=radioButton_1.getText();

		WebElement radioButton_2= ma.medicaidRadioButton();
		String radioButtonText_2=radioButton_2.getText();

		WebElement radioButton_3= ma.NoneRadioButton();
		String radioButtonText_3=radioButton_3.getText();


		String radioButtonValue = propfile.getProperty("healthProgram");


		//Interacting with the 1st Radio button 
		if(radioButtonValue.equals(radioButtonText_1))
		{
			Assert.assertTrue(radioButton_1.isEnabled());
			logger.info("MEDICARE RADIO BUTTON IS ENABLED");
			radioButton_1.click();
			logger.info("MEDICARE RADIO BUTTON IS SELECTED");
		}

		//Interacting with the 2nd Radio button 
		else if(radioButtonValue.equals(radioButtonText_2))
		{
			Assert.assertTrue(radioButton_2.isEnabled());
			logger.info("MEDICAID RADIO BUTTON IS ENABLED");
			radioButton_2.click();
			logger.info("MEDICAID RADIO BUTTON IS SELECTED");

		}

		//Interacting with the 3rd Radio button 
		else if(radioButtonValue.equals(radioButtonText_3))
		{
			Assert.assertTrue(radioButton_3.isEnabled());
			logger.info("NONE RADIO BUTTON IS ENABLED");
			radioButton_3.click();
			logger.info("NONE RADIO BUTTON IS SELECTED");
		}


		//Interacting with the Calendar 
		WebElement calendarDate = ma.enterVisitDate();
		calendarDate.sendKeys(propfile.getProperty("visitDate"));
		logger.info("APPOINTMENT VISIT DATE IS ENTERED");


		//writing Comment 
		WebElement text = ma.commentBox();
		text.sendKeys(propfile.getProperty("comment"));
		logger.info("COMMENT ADDED SUCCESSFULLY");


		//clicking on Book Appointment Button

		WebElement book = ma.ClickOnBookAppointmentButton();
		book.click();


		AppointmentConfirmation ac = new AppointmentConfirmation(driver);
		String textConfirmation = ac.verifyAppointmentConfirmationText();
		Assert.assertEquals("Appointment Confirmation", textConfirmation);
		logger.info("BOOKING APPOITMENT CONFIRMED");
		
		
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


		logger.info("\n********************TEST CASE END TO END APPOINTMENT BOOKINGT ENDED*********************");

	}
}
