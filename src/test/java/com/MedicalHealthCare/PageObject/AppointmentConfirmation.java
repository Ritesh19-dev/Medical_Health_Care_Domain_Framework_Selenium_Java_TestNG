package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentConfirmation 
{
	WebDriver ldriver;
	
	public AppointmentConfirmation(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	//Interacting with WebElement
	@FindBy(xpath = "//h2[normalize-space()='Appointment Confirmation']") WebElement appointmentConfirmationText;
	@FindBy(xpath = "//p[@class='lead']") WebElement bookingConfirmationText;
	
	
	@FindBy(xpath = "//p[@id='facility']") WebElement facilityValue;
	@FindBy(xpath = "//p[@id='hospital_readmission']") WebElement applyForHospitalReAddmission;
	
	@FindBy(xpath = "//p[@id='program']") WebElement healthCareProgramValue;
	@FindBy(xpath = "//p[@id='visit_date']") WebElement visitDateValue;
	@FindBy(xpath = "//p[@id='comment']") WebElement commentValue;
	
	
	@FindBy(xpath = "//a[normalize-space()='Go to Homepage']") WebElement goToHomePageButton;
	
	
	
	
	//Performing Actions on WebElement
	
	public String verifyAppointmentConfirmationText()
	{
		return appointmentConfirmationText.getText();
		
	}
	
	
	public String verifyBookingConfirmationText()
	{
		return bookingConfirmationText.getText();
		
	}

	
	public String getFacilityValue()
	{
		return facilityValue.getText();
		
	}
	
	public String getApplyForHospitalReAddmissionValue()
	{
		return applyForHospitalReAddmission.getText();
		
	}
	
	public String gethealthCareProgramValue()
	{
		return healthCareProgramValue.getText();
		
	}
	
	
	public String getVisitDateValue()
	{
		return visitDateValue.getText();
		
	}
	
	public String getCommentValue()
	{
		return commentValue.getText();
		
	}
	
	public WebElement clickOnGoToHomePageButton()
	{
		return goToHomePageButton;
		
	}
}
