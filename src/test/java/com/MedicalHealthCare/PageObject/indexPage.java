package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage 
{
	WebDriver ldriver;
	
	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	// identify web elements 
	
	@FindBy(xpath= "//h1[normalize-space()='CURA Healthcare Service']") WebElement pageTitle;
	@FindBy(xpath= "//h3[normalize-space()='We Care About Your Health']") WebElement pageTile_2;
	@FindBy(xpath= "//a[@id='btn-make-appointment']") WebElement makeAppointmentButton;
	@FindBy(xpath= "//i[@class='fa fa-bars']") WebElement toggleButton;
	
	
	//Contact WebElements
	@FindBy(xpath= "\"//div[@class='col-lg-10 col-lg-offset-1 text-center']//h4//strong") WebElement advitisement;
	@FindBy(xpath= "//i[@class='fa fa-phone fa-fw']") WebElement phoneNumberContact;
	@FindBy(xpath= "//a[normalize-space()='info@katalon.com']") WebElement emailContact;
	
	
	//Logo WebElements
	@FindBy(xpath= "//i[@class='fa fa-facebook fa-fw fa-3x']") WebElement facbookLogo;
	@FindBy(xpath= "//i[@class='fa fa-twitter fa-fw fa-3x']") WebElement twitterLogo;
	@FindBy(xpath= "//i[@class='fa fa-dribbble fa-fw fa-3x']") WebElement dribbleLogo;
	
	@FindBy(xpath= "//a[@id='to-top']") WebElement goToTopButton;
	
	//Toggle Menu Options
	@FindBy(xpath= "//a[normalize-space()='Home']") WebElement homeOption;
	@FindBy(xpath= "//a[normalize-space()='Login']") WebElement loginOption;
	
	

	
	
	//perform action on WebElement
	
	public String verifyPageTitle()
	{
		return pageTitle.getText();
		
	}
	
	public String verifyPageTitle_2()
	{
		return pageTile_2.getText();
		
	}
	
	public WebElement clickOnMakeAppointmentButton()
	{
		return makeAppointmentButton;
		
	}
	
	
	
	
	
	public String verifyAdvitisementText()
	{
		return advitisement.getText();
		
	}
	
	
	public boolean verifyphoneNumberIcon()
	{
		return phoneNumberContact.isDisplayed();
		
	}
	
	
	public String verifyEmailContact()
	{
		return emailContact.getText();
		
	}
	
	
	//verifying Social Media Logo's
	
	
	public boolean verifyFacbookLogo()
	{
		return facbookLogo.isDisplayed();
		
	}
	
	
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
		
	}
	
	public boolean verifyDribbleLogo()
	{
		return dribbleLogo.isDisplayed();
		
	}
	
	public void clickOnMenuButton()
	{
		toggleButton.click();	
	}
	
	//Click on Home Button
	
	public void clickOnHomeButton()
	{
		toggleButton.click();
		
		homeOption.click();	
	}
	
	public void loginFromMenuButton()
	{
		toggleButton.click();
		
		loginOption.click();
		
	}
	
	
	
}
