package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageToggleOptions 
{
	WebDriver ldriver;
	
	public HomePageToggleOptions(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(xpath= "//i[@class='fa fa-bars']") WebElement toggleButton;
	@FindBy(xpath= "//a[normalize-space()='Home']") WebElement homeOption;
	@FindBy(xpath= "//a[normalize-space()='History']") WebElement historyOption;
	@FindBy(xpath= "//a[normalize-space()='Profile']") WebElement profileOption;
	@FindBy(xpath= "//a[normalize-space()='Logout']") WebElement logoutOption;
	
	
	
	//Interacting with WebElement
	
	public WebElement clickOnMenuButton()
	{
		return toggleButton;
	}
	
	
	public WebElement clickOnHomeOption()
	{
		return homeOption;
	}
	
	public WebElement clickOnHistoryOption()
	{
		return historyOption;
	}
	
	public WebElement clickOnProfileOption()
	{
		return profileOption;
	}
	
	public WebElement clickOnLogoutOption()
	{
		return logoutOption;
	}
	

}
