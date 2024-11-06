package com.MedicalHealthCare.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.MedicalHealthCare.PageObject.indexPage;

import junit.framework.Assert;

public class TC_HomePage extends BaseClass
{
	@Test(groups = {"smokeTest"})
	public void Homepage()
	{
		logger.info("\n********************TEST CASE HOMEPAGE  STARTED*********************");
		//Verifying the page title
		
		indexPage ip = new indexPage(driver);
		String title = ip.verifyPageTitle();
		Assert.assertEquals("CURA Healthcare Service", title);
		logger.info("PAGE TITLE VERIFIED");
		
		
		
		//Verifying the second title
		
		String title_2 = ip.verifyPageTitle_2();
		Assert.assertEquals("We Care About Your Health", title_2);
		logger.info("PAGE SECOND TITLE VERIFIED");
		
		
		//Verifying All Social Media Logo's
		Boolean flag= ip.verifyFacbookLogo();
		Assert.assertTrue(flag);
		logger.info("FACEBOOK LOGO VERIFIED");
		
		
		Boolean twi= ip.verifyTwitterLogo();
		Assert.assertTrue(twi);
		logger.info("TWITTER LOGO VERIFIED");
		
		
		Boolean drr= ip.verifyDribbleLogo();
		Assert.assertTrue(drr);
		logger.info("DRIBBLE LOGO VERIFIED");
		
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)");
		logger.info("PAGE SCROLL DOWN");
		
		jse.executeScript("window.scrollBy(0,-600)");
		logger.info("PAGE SCROLL UP");
		
		
		ip.clickOnHomeButton();
		logger.info("CLICKED ON HOME BUTTON");
		
		
		
		
		
		logger.info("\n********************TEST CASE HOMEPAGE  ENDED*********************");
		
		
	}
	

}
