package com.MedicalHealthCare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Appointment 
{
	WebDriver ldriver;
	
	public Appointment(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	//locating WebElement
	
	
	//Drop down WebElement
	@FindBy(xpath = "//select[@id='combo_facility']") WebElement facility;
	
	@FindBy(xpath = "//input[@id='chk_hospotal_readmission']") WebElement applyForHospitalReadmission;
	
	//radio button WebElements
	@FindBy(xpath = "//input[@id='radio_program_medicare']") WebElement medicare;
	@FindBy(xpath = "//input[@id='radio_program_medicaid']") WebElement medicaid;
	@FindBy(xpath = "//input[@id='radio_program_none']") WebElement None;
	
	
	//Calendar WebElement
	@FindBy(xpath = "//input[@id='txt_visit_date']") WebElement visitDate;
	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']") WebElement forwardButton;
	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']") WebElement backwardButton;
	@FindBy(xpath = "//div[@class='datepicker-months']//th[@class='next'][normalize-space()='»']") WebElement forwardButtonYear;
	@FindBy(xpath = "//div[@class='datepicker-months']//th[@class='prev'][normalize-space()='«']") WebElement backwardButtonYear;
	
	@FindBy(xpath = "//input[@id='radio_program_none']") WebElement actualMonth;
	@FindBy(xpath = "//input[@id='radio_program_none']") WebElement actualYear;
	@FindBy(xpath = "//input[@id='radio_program_none']") WebElement date;
	
	
	
	
	@FindBy(xpath = "//textarea[@id='txt_comment']") WebElement comment;
	
	
	@FindBy(xpath = "//button[@id='btn-book-appointment']") WebElement bookAppointmentButton;
	
	
	//interacting with DropDown WebElement
	
	
	public WebElement dropDownListOfFacility()
	{
		return facility;
		 
	}
	
	
	public WebElement applyForHospitalReadmissionCheckBox()
	{
		return applyForHospitalReadmission;
	}
	
	public WebElement medicareRadioButton()
	{
		return medicare;
	}
	
	public WebElement medicaidRadioButton()
	{
		return medicaid;
	}
	
	public WebElement NoneRadioButton()
	{
		return None;
	}
	
	public WebElement enterVisitDate()
	{
		return visitDate;
	}
	
	
	
	public WebElement commentBox()
	{
		return comment;
	}
	
	
	public WebElement ClickOnBookAppointmentButton()
	{
		return bookAppointmentButton;
	}
	
	
}
