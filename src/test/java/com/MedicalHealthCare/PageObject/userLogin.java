package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userLogin 
{
	WebDriver ldriver;

	public userLogin(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}



	@FindBy(xpath= "//h2[normalize-space()='Login']") WebElement loginTitle;
	@FindBy(xpath= "//p[@class='lead']") WebElement loginText;


	//user Name and Password WebElement
	@FindBy(xpath= "//input[@id='txt-username']") WebElement userName;
	@FindBy(xpath= "//input[@id='txt-password']") WebElement userPassword;
	@FindBy(xpath= "//button[@id='btn-login']") WebElement loginButton;


	@FindBy(xpath= "//h2[normalize-space()='Make Appointment']") WebElement verifyLogin;
	@FindBy(xpath= "//p[@class='lead text-danger']") WebElement verifyInvalidLoginMessage;
	
	


	//interacting with the webElements

	public WebElement loginUserName()
	{
		return userName;
	}

	public WebElement loginUserPassword()
	{
		return userPassword;
	}

	public WebElement ClickOnLoginButton()
	{
		return loginButton;
	}

	public String verifyUserLogin()
	{
		return verifyLogin.getText();
	}

	public String getInvalidLoginMessage() 
	{
		return verifyInvalidLoginMessage.getText();
	}




}
