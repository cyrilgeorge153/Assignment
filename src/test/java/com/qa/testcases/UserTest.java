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
	
	@Test(priority = 0,groups = "smoke",enabled = true,description = " To test the full flow of demo user")
	public void verifyDemoUserFullFlowTest() throws IOException 
	{
		logger.info("*******************starting verifyDemoUserFullFlowTest**************************");
//		db.verifyImage();
		Assert.assertEquals(generic.webElementIsDisplayed(db.img),true);
//		db.verifyFbShare();
		Assert.assertEquals(generic.webElementIsDisplayed(db.fbShare),true);
//		db.verifyTwitterShare();
		Assert.assertEquals(generic.webElementIsDisplayed(db.twitterShare),true);
//		db.verifyPininterestShare();
		Assert.assertEquals(generic.webElementIsDisplayed(db.pininterestShare),true);
//		db.verifyNormalShare();
		Assert.assertEquals(generic.webElementIsDisplayed(db.mailShare),true);
//		db.verifyShowMap();
		Assert.assertEquals(generic.getTextWebElement(db.showMap),"Show On Map");
//		db.verifyInclusions();
		Assert.assertEquals(generic.getTextWebElement(db.inclusions),"Inclusions");
//		db.verifyExclusions();
		Assert.assertEquals(generic.getTextWebElement(db.exclusions),"Exclusions");
//		db.verifyWriteReview();
		Assert.assertEquals(generic.webElementIsDisplayed(db.review),true);
//		db.verifyChangeDate();
		Assert.assertEquals(generic.webElementIsDisplayed(db.changedate),true);
//		db.clickBookNow();
		generic.clickWebElement(db.booknow, driver);
		db.verifyPersonalDetails();
//		db.verifyBookingDate();
		Assert.assertEquals(generic.getTextWebElement(db.bookingdate),"Booking Date");
//		db.verifyAmount();
		Assert.assertEquals(generic.getTextWebElement(db.amount),"$82.50");
//		db.clickConfirmBooking();
		generic.clickWebElement(db.confirmbooking, driver);
		db.verifyBookingDetails();
		db.verifyTotalAmount();
		logger.info("*******************ending verifyDemoUserFullFlowTest**************************");
	}

//	@Test(priority = 1,groups = "regression",enabled = true,description = "To verifyImageTest")
//	public void verifyImageTest() throws IOException 
//	{
//		logger.info("*******************starting verifyImageTest**************************");
//		db.verifyImage();
//		logger.info("*******************ending verifyImageTest**************************");
//	}
//
//	@Test(priority = 2,groups = "regression",enabled = true,description = "To verifyFbShareTest")
//	public void verifyFbShareTest() throws IOException 
//	{
//		logger.info("*******************starting verifyFbShareTest**************************");
//		db.verifyFbShare();
//		logger.info("*******************ending verifyFbShareTest**************************");
//	}
//
//	@Test(priority = 3,groups = "regression",enabled = true,description = "To verifyTwitterShareTest")
//	public void verifyTwitterShareTest() throws IOException
//	{
//		logger.info("*******************starting verifyTwitterShareTest**************************");
//		db.verifyTwitterShare();
//		logger.info("*******************ending verifyTwitterShareTest**************************");
//	}
//
//	@Test(priority = 4,groups = "regression",enabled = true,description = "To verifyPininterestShareTest")
//	public void verifyPininterestShareTest() throws IOException 
//	{
//		logger.info("*******************starting verifyPininterestShareTest**************************");
//		db.verifyPininterestShare();
//		logger.info("*******************ending verifyPininterestShareTest**************************");
//	}
//
//	@Test(priority = 5,groups = "regression",enabled = true,description = "To verifyNormalShareTest")
//	public void verifyNormalShareTest() throws IOException
//	{
//		logger.info("*******************starting verifyNormalShareTest**************************");
//		db.verifyNormalShare();
//		logger.info("*******************ending verifyNormalShareTest**************************");
//	}
//
//	@Test(priority = 6,groups = "regression",enabled = true,description = "To verifyShowMapTest")
//	public void verifyShowMapTest() throws IOException 
//	{
//		logger.info("*******************starting verifyShowMapTest**************************");
//		db.verifyShowMap();
//		logger.info("*******************ending verifyShowMapTest**************************");
//	}
//
//	@Test(priority = 7,groups = "regression",enabled = true,description = "To verifyInclusionsTest")
//	public void verifyInclusionsTest() throws IOException 
//	{
//		logger.info("*******************starting verifyInclusionsTest**************************");
//		db.verifyInclusions();
//		logger.info("*******************ending verifyInclusionsTest**************************");
//	}
//
//	@Test(priority = 8,groups = "regression",enabled = true,description = "To verifyExclusionsTest")
//	public void verifyExclusionsTest() throws IOException 
//	{
//		logger.info("*******************starting verifyExclusionsTest**************************");
//		db.verifyExclusions();
//		logger.info("*******************ending verifyExclusionsTest**************************");
//	}
//
//	@Test(priority = 9,groups = "regression",enabled = true,description = "To verifyWriteReviewTest")
//	public void verifyWriteReviewTest() throws IOException 
//	{
//		logger.info("*******************starting verifyWriteReviewTest**************************");
//		db.verifyWriteReview();
//		logger.info("*******************ending verifyWriteReviewTest**************************");
//	}
//
//	@Test(priority = 10,groups = "regression",enabled = true,description = "To verifyChangeDateTest")
//	public void verifyChangeDateTest() throws IOException 
//	{
//		logger.info("*******************starting verifyChangeDateTest**************************");
//		db.verifyChangeDate();
//		logger.info("*******************ending verifyChangeDateTest**************************");
//	}
//
//	@Test(priority = 11,groups = "smoke",enabled = true,description = "To clickBookNowTest")
//	public void clickBookNowTest() throws IOException 
//	{
//		logger.info("*******************starting clickBookNowTest**************************");
//		db.clickBookNow();
//		logger.info("*******************ending clickBookNowTest**************************");
//	}
//
//	@Test(priority = 12,groups = "regression",enabled = true,description = "To verifyPersonalDetailsTest")
//	public void verifyPersonalDetailsTest() throws IOException 
//	{
//		logger.info("*******************starting verifyPersonalDetailsTest**************************");
//		db.clickBookNow();
//		db.verifyPersonalDetails();
//		logger.info("*******************ending verifyPersonalDetailsTest**************************");
//	}
//
//	@Test(priority = 13,groups = "regression",enabled = true,description = "To verifyBookingDateTest")
//	public void verifyBookingDateTest() throws IOException 
//	{
//		logger.info("*******************starting verifyBookingDateTest**************************");
//		db.clickBookNow();
//		db.verifyBookingDate();
//		logger.info("*******************ending verifyBookingDateTest**************************");
//	}
//
//	@Test(priority = 14,groups = "regression",enabled = true,description = "To verifyAmountTest")
//	public void verifyAmountTest() throws IOException 
//	{
//		logger.info("*******************starting verifyAmountTest**************************");
//		db.clickBookNow();
//		db.verifyAmount();
//		logger.info("*******************ending verifyAmountTest**************************");
//	}
//	
//	@Test(priority = 15,groups = "regression",enabled = true,description = "To verifyBookingDetailsTest")
//	public void verifyBookingDetailsTest() throws IOException 
//	{
//		logger.info("*******************starting verifyBookingDetailsTest**************************");
//		db.clickBookNow();
//		db.clickConfirmBooking();
//		db.verifyBookingDetails();
//		logger.info("*******************ending verifyBookingDetailsTest**************************");
//	}
//	
//	@Test(priority = 16,groups = "regression",enabled = true,description = "To verifyTotalAmountTest")
//	public void verifyTotalAmountTest() throws IOException 
//	{
//		logger.info("*******************starting verifyTotalAmountTest**************************");
//		db.clickBookNow();
//		db.clickConfirmBooking();
//		db.verifyTotalAmount();
//		logger.info("*******************ending verifyTotalAmountTest**************************");
//	}
//	
//	

}
