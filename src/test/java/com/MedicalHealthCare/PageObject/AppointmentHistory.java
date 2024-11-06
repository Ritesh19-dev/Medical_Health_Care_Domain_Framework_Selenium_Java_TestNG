package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistory 
{
	
	WebDriver ldriver;
	
	public AppointmentHistory(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver,this);;
	}
	
	
	//Interactions 
	
	@FindBy(xpath ="//h2[normalize-space()='History']")WebElement historyText;
	
	@FindBy(xpath = "//a[normalize-space()='Go to Homepage']") WebElement goToHomePageButton;
	
	public String verifyHistoryText()
	{
		return historyText.getText();
	}
	
	
	public WebElement clickOnGoToHomePage()
	{
		return historyText;
	}

}
