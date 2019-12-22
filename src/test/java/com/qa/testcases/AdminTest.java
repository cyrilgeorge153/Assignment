/**
 * 
 */
package com.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.configuration.BaseClass;
import com.qa.pages.AdminDashboardPage;

/**
 * @author CYRIL
 *
 */
public class AdminTest extends BaseClass {
	
	public static AdminDashboardPage adb;
	Logger logger=Logger.getLogger(BaseClass.class);
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		logger.info("*******************starting before method**************************");
		startBrowser();
		browserConfig();
		readUrlAdmin();
		getCredentialsAdmin();
		adb = new AdminDashboardPage(driver);
		logger.info("*******************ending before method**************************");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		logger.info("*******************starting after method**************************");
		closeBrowser();
		logger.info("*******************ending after method**************************");
	}
	
//	@Test(priority = 0,groups = "smoke",enabled = true,description = " To verifyAdminDashboardTest")
//	public void verifyAdminDashboardTest()
//	{
//		logger.info("*******************starting verifyAdminDashboardTest**************************");
//		adb.verifyAdminDashboard();
//		logger.info("*******************ending verifyAdminDashboardTest**************************");
//	}
//	
//	@Test(priority = 1,groups = "smoke",enabled = true,description = " To verifyTodayBookingTest")
//	public void verifyTodayBookingTest()
//	{
//		logger.info("*******************starting verifyTodayBookingTest**************************");
//		adb.verifyTodayBooking();
//		logger.info("*******************ending verifyTodayBookingTest**************************");
//	}
//	
//	@Test(priority = 2,groups = "smoke",enabled = true,description = " To verifyThirtyDayBookingTest")
//	public void verifyThirtyDayBookingTest()
//	{
//		logger.info("*******************starting verifyThirtyDayBookingTest**************************");
//	    adb.verifyThirtyDayBooking();
//	    logger.info("*******************ending verifyThirtyDayBookingTest**************************");
//	}
	
//	@Test(priority = 3,groups = "smoke",enabled = true,description = " To verifyIdValueTest")
//	public void verifyIdValueTest()
//	{
//		logger.info("*******************starting verifyIdValueTest**************************");
//	    adb.verifyIdValue();
//	    logger.info("*******************ending verifyIdValueTest**************************");
//	}
	
	@Test(priority = 4,groups = "smoke",enabled = true,description = " To verifyBookingDetailsTest")
	public void verifyBookingDetailsTest()
	{
		logger.info("*******************starting verifyBookingDetailsTest**************************");
	    adb.verifyBookingDetails();
	    driver.navigate().back();
	    logger.info("*******************ending verifyBookingDetailsTest**************************");
	}

}
