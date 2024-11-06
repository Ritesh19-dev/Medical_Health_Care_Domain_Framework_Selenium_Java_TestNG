package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage 
{
	WebDriver ldriver;

	public UserProfilePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}


	@FindBy(xpath ="//h2[normalize-space()='Profile']")WebElement userProfileText;

	@FindBy(xpath = "//a[@class='btn btn-default']") WebElement logOutButton;
	
	
	public String verifyUserProfileText()
	{
		return userProfileText.getText();
	}
	
	
	public WebElement clickOnLogOutButton()
	{
		return logOutButton;
	}

}
