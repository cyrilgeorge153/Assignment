/**
 * 
 */
package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.configuration.BaseClass;
import com.qa.pages.AdminDashboardPage;
import com.qa.utilities.MyScreenRecorder;

/**
 * @author CYRIL
 *
 */
public class AdminTest extends BaseClass {
	
	public static AdminDashboardPage adb;
	Logger logger=Logger.getLogger(BaseClass.class);
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		startBrowser();
		logger.info("*******************starting before method**************************");
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
	
	@Test(priority = 0,groups = "smoke",enabled = true,description = " To verifyAdminDashboardTest")
	public void verifyAdminDashboardTest() throws Exception
	{
		logger.info("*******************starting verifyAdminDashboardTest**************************");
		MyScreenRecorder.startRecording("verifyAdminDashboardTest");
		adb.verifyAdminDashboard();
		MyScreenRecorder.stopRecording();
		logger.info("*******************ending verifyAdminDashboardTest**************************");
	}
	
	@Test(priority = 1,groups = "smoke",enabled = true,description = " To verifyTodayBookingTest")
	public void verifyTodayBookingTest() throws Exception
	{
		logger.info("*******************starting verifyTodayBookingTest**************************");
		MyScreenRecorder.startRecording("verifyTodayBookingTest");
		adb.verifyTodayBooking();
		MyScreenRecorder.stopRecording();
		logger.info("*******************ending verifyTodayBookingTest**************************");
	}
	
	@Test(priority = 2,groups = "smoke",enabled = true,description = " To verifyThirtyDayBookingTest")
	public void verifyThirtyDayBookingTest() throws Exception
	{
		logger.info("*******************starting verifyThirtyDayBookingTest**************************");
		MyScreenRecorder.startRecording("verifyThirtyDayBookingTest");
	    adb.verifyThirtyDayBooking();
	    MyScreenRecorder.stopRecording();
	    logger.info("*******************ending verifyThirtyDayBookingTest**************************");
	}
	
	@Test(priority = 3,groups = "smoke",enabled = true,description = " To verifyIdValueTest")
	public void verifyIdValueTest() throws Exception
	{
		logger.info("*******************starting verifyIdValueTest**************************");
		MyScreenRecorder.startRecording("verifyIdValueTest");
	    adb.verifyIdValue();
	    logger.info("*******************ending verifyIdValueTest**************************");
	}
	
//	@Test(priority = 4,groups = "smoke",enabled = true,description = " To verifyBookingDetailsTest")
	public void verifyBookingDetailsTest() throws Exception
	{
		logger.info("*******************starting verifyBookingDetailsTest**************************");
		MyScreenRecorder.startRecording("verifyBookingDetailsTest");
	    adb.verifyBookingDetails();
	    driver.navigate().back();
	    MyScreenRecorder.stopRecording();
	    logger.info("*******************ending verifyBookingDetailsTest**************************");
	}

}
