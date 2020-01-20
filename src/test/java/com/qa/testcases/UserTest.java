package com.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.configuration.BaseClass;
import com.qa.pages.AdminDashboardPage;
import com.qa.pages.UserDashboardPage;
import com.qa.utilities.GenericMethods;

/**
 * 
 */

/**
 * @author CYRIL
 *
 */
public class UserTest extends BaseClass {
	UserDashboardPage db;
	Logger logger=Logger.getLogger(BaseClass.class);
	GenericMethods generic=new GenericMethods(); 

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		startBrowser();
		logger.info("*******************starting before method**************************");
		browserConfig();
		readUrl();
		getCredentials();
		db =  PageFactory.initElements(driver, UserDashboardPage.class); 
		generic.clickWebElement(db.tours, driver);
		generic.clickWebElement(db.search, driver);
		generic.clickWebElement(db.details, driver);
		logger.info("*******************ending before method**************************");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		closeBrowser();
	}
	
	@Test(priority = 5,groups = "smoke",enabled = true,description = " To test the full flow of demo user")
	public void verifyDemoUserFullFlowTest() throws IOException 
	{
		logger.info("*******************starting verifyDemoUserFullFlowTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.img),true);
		Assert.assertEquals(generic.webElementIsDisplayed(db.fbShare),true);
		Assert.assertEquals(generic.webElementIsDisplayed(db.twitterShare),true);
		Assert.assertEquals(generic.webElementIsDisplayed(db.pininterestShare),true);
		Assert.assertEquals(generic.webElementIsDisplayed(db.mailShare),true);
		Assert.assertEquals(generic.getTextWebElement(db.showMap),"Show On Map");
		Assert.assertEquals(generic.getTextWebElement(db.inclusions),"Inclusions");
		Assert.assertEquals(generic.getTextWebElement(db.exclusions),"Exclusions");
		Assert.assertEquals(generic.webElementIsDisplayed(db.review),true);
		Assert.assertEquals(generic.webElementIsDisplayed(db.changedate),true);
		generic.clickWebElement(db.booknow, driver);
		db.verifyPersonalDetails();
		Assert.assertEquals(generic.getTextWebElement(db.bookingdate),"Booking Date");
		Assert.assertEquals(generic.getTextWebElement(db.amount),"$82.50");
		generic.clickWebElement(db.confirmbooking, driver);
		db.verifyBookingDetails();
		db.verifyTotalAmount();
		logger.info("*******************ending verifyDemoUserFullFlowTest**************************");
	}

	@Test(priority = 6,groups = "regression",enabled = true,description = "To verifyImageTest")
	public void verifyImageTest() throws IOException 
	{
		logger.info("*******************starting verifyImageTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.img),true);
		logger.info("*******************ending verifyImageTest**************************");
	}

	@Test(priority = 7,groups = "regression",enabled = true,description = "To verifyFbShareTest")
	public void verifyFbShareTest() throws IOException 
	{
		logger.info("*******************starting verifyFbShareTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.fbShare),true);
		logger.info("*******************ending verifyFbShareTest**************************");
	}

	@Test(priority = 8,groups = "regression",enabled = true,description = "To verifyTwitterShareTest")
	public void verifyTwitterShareTest() throws IOException
	{
		logger.info("*******************starting verifyTwitterShareTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.twitterShare),true);
		logger.info("*******************ending verifyTwitterShareTest**************************");
	}

	@Test(priority = 9,groups = "regression",enabled = true,description = "To verifyPininterestShareTest")
	public void verifyPininterestShareTest() throws IOException 
	{
		logger.info("*******************starting verifyPininterestShareTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.pininterestShare),true);
		logger.info("*******************ending verifyPininterestShareTest**************************");
	}

	@Test(priority = 10,groups = "regression",enabled = true,description = "To verifyNormalShareTest")
	public void verifyNormalShareTest() throws IOException
	{
		logger.info("*******************starting verifyNormalShareTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.mailShare),true);
		logger.info("*******************ending verifyNormalShareTest**************************");
	}

	@Test(priority = 11,groups = "regression",enabled = true,description = "To verifyShowMapTest")
	public void verifyShowMapTest() throws IOException 
	{
		logger.info("*******************starting verifyShowMapTest**************************");
		Assert.assertEquals(generic.getTextWebElement(db.showMap),"Show On Map");
		logger.info("*******************ending verifyShowMapTest**************************");
	}

	@Test(priority = 12,groups = "regression",enabled = true,description = "To verifyInclusionsTest")
	public void verifyInclusionsTest() throws IOException 
	{
		logger.info("*******************starting verifyInclusionsTest**************************");
		Assert.assertEquals(generic.getTextWebElement(db.inclusions),"Inclusions");
		logger.info("*******************ending verifyInclusionsTest**************************");
	}

	@Test(priority = 13,groups = "regression",enabled = true,description = "To verifyExclusionsTest")
	public void verifyExclusionsTest() throws IOException 
	{
		logger.info("*******************starting verifyExclusionsTest**************************");
		Assert.assertEquals(generic.getTextWebElement(db.exclusions),"Exclusions");
		logger.info("*******************ending verifyExclusionsTest**************************");
	}

	@Test(priority = 14,groups = "regression",enabled = true,description = "To verifyWriteReviewTest")
	public void verifyWriteReviewTest() throws IOException 
	{
		logger.info("*******************starting verifyWriteReviewTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.review),true);
		logger.info("*******************ending verifyWriteReviewTest**************************");
	}

	@Test(priority = 15,groups = "regression",enabled = true,description = "To verifyChangeDateTest")
	public void verifyChangeDateTest() throws IOException 
	{
		logger.info("*******************starting verifyChangeDateTest**************************");
		Assert.assertEquals(generic.webElementIsDisplayed(db.changedate),true);
		logger.info("*******************ending verifyChangeDateTest**************************");
	}

	@Test(priority = 16,groups = "smoke",enabled = true,description = "To clickBookNowTest")
	public void clickBookNowTest() throws IOException 
	{
		logger.info("*******************starting clickBookNowTest**************************");
		generic.clickWebElement(db.booknow, driver);
		Assert.assertEquals(generic.webElementIsDisplayed(db.terms),true);
		logger.info("*******************ending clickBookNowTest**************************");
	}

	@Test(priority = 17,groups = "regression",enabled = true,description = "To verifyPersonalDetailsTest")
	public void verifyPersonalDetailsTest() throws IOException 
	{
		logger.info("*******************starting verifyPersonalDetailsTest**************************");
		generic.clickWebElement(db.booknow, driver);
		db.verifyPersonalDetails();
		logger.info("*******************ending verifyPersonalDetailsTest**************************");
	}

	@Test(priority = 18,groups = "regression",enabled = true,description = "To verifyBookingDateTest")
	public void verifyBookingDateTest() throws IOException 
	{
		logger.info("*******************starting verifyBookingDateTest**************************");
		generic.clickWebElement(db.booknow, driver);
		Assert.assertEquals(generic.getTextWebElement(db.bookingdate),"Booking Date");
		logger.info("*******************ending verifyBookingDateTest**************************");
	}

	@Test(priority = 19,groups = "regression",enabled = true,description = "To verifyAmountTest")
	public void verifyAmountTest() throws IOException 
	{
		logger.info("*******************starting verifyAmountTest**************************");
		generic.clickWebElement(db.booknow, driver);
		Assert.assertEquals(generic.getTextWebElement(db.amount),"$82.50");
		logger.info("*******************ending verifyAmountTest**************************");
	}
	
	@Test(priority = 20,groups = "regression",enabled = true,description = "To verifyBookingDetailsTest")
	public void verifyBookingDetailsTest() throws IOException 
	{
		logger.info("*******************starting verifyBookingDetailsTest**************************");
		generic.clickWebElement(db.booknow, driver);
		db.clickConfirmBooking();
		db.verifyBookingDetails();
		logger.info("*******************ending verifyBookingDetailsTest**************************");
	}
	
	@Test(priority = 21,groups = "regression",enabled = true,description = "To verifyTotalAmountTest")
	public void verifyTotalAmountTest() throws IOException 
	{
		logger.info("*******************starting verifyTotalAmountTest**************************");
		generic.clickWebElement(db.booknow, driver);
		db.clickConfirmBooking();
		db.verifyTotalAmount();
		logger.info("*******************ending verifyTotalAmountTest**************************");
	}
	
	

}
