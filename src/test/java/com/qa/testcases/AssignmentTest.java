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
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		startBrowser();
		browserConfig();
		readUrl();
		getCredentials();
		db=new DashboardPage(driver);
		db.clickTours();
		db.clickSearch();
		db.clickDetails();
	}
//	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		closeBrowser();
	}

	@Test(priority = 0)
	public void clickToursTest() throws IOException
	{
//		db.clickTours();
//		db.clickSearch();
//		db.clickDetails();
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
	}
	
}
