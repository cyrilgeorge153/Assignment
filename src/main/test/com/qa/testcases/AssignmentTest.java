package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.configuration.BaseClass;
import com.qa.pages.DashboardPage;

/**
 * 
 */

/**
 * @author CYRIL
 *
 */
public class AssignmentTest extends BaseClass {
	public static DashboardPage db;

	@BeforeMethod()
	public void setUp() throws IOException {
		startBrowser();
		browserConfig();
		readUrl();
		getCredentials();
		db = new DashboardPage(driver);
		db.clickTours();
		db.clickSearch();
		db.clickDetails();
	}
	
	@AfterMethod()
	public void tearDown() throws InterruptedException {
		closeBrowser();
	}
	
//	@Test(priority = 0)
	public void clickToursTest() throws IOException 
	{
		db.verifyImage();
		db.verifyFbShare();
		db.verifyTwitterShare();
		db.verifyPininterestShare();
		db.verifyNormalShare();
		db.verifyShowMap();
		db.verifyInclusions();
		db.verifyExclusions();
		db.verifyWriteReview();
		db.verifyChangeDate();
		db.clickBookNow();
		db.verifyPersonalDetails();
		db.verifyBookingDate();
		db.verifyAmount();
	}

//	@Test(priority = 1)
	public void verifyImageTest() throws IOException 
	{
		db.verifyImage();
	}

//	@Test(priority = 2)
	public void verifyFbShareTest() throws IOException 
	{
		db.verifyFbShare();
	}

//	@Test(priority = 3)
	public void verifyTwitterShareTest() throws IOException
	{
		db.verifyTwitterShare();
	}

//	@Test(priority = 4)
	public void verifyPininterestShareTest() throws IOException 
	{
		db.verifyPininterestShare();
	}

//	@Test(priority = 5)
	public void verifyNormalShareTest() throws IOException
	{
		db.verifyNormalShare();
	}

//	@Test(priority = 6)
	public void verifyShowMapTest() throws IOException 
	{
		db.verifyShowMap();
	}

//	@Test(priority = 7)
	public void verifyInclusionsTest() throws IOException 
	{
		db.verifyInclusions();
	}

//	@Test(priority = 8)
	public void verifyExclusionsTest() throws IOException 
	{
		db.verifyExclusions();
	}

//	@Test(priority = 9)
	public void verifyWriteReviewTest() throws IOException 
	{
		db.verifyWriteReview();
	}

//	@Test(priority = 10)
	public void verifyChangeDateTest() throws IOException 
	{
		db.verifyChangeDate();
	}

//	@Test(priority = 11)
	public void clickBookNowTest() throws IOException 
	{
		db.clickBookNow();
	}

//	@Test(priority = 12)
	public void verifyPersonalDetailsTest() throws IOException 
	{
		db.clickBookNow();
		db.verifyPersonalDetails();
	}

//	@Test(priority = 13)
	public void verifyBookingDateTest() throws IOException 
	{
		db.clickBookNow();
		db.verifyBookingDate();
	}

//	@Test(priority = 14)
	public void verifyAmountTest() throws IOException 
	{
		db.clickBookNow();
		db.verifyAmount();
	}
	
	@Test(priority = 15)
	public void verifyBookingDetailsTest() throws IOException 
	{
		db.clickBookNow();
		db.clickConfirmBooking();
		db.verifyBookingDetails();
	}
	
	

}
