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
	
	@BeforeMethod()
	public void setUp() throws IOException {
		logger.info("*******************starting before method**************************");
		startBrowser();
		browserConfig();
		readUrlAdmin();
		getCredentialsAdmin();
		adb = new AdminDashboardPage(driver);
		logger.info("*******************ending before method**************************");
		
	}
	
	@AfterMethod()
	public void tearDown() throws InterruptedException {
		logger.info("*******************starting after method**************************");
		closeBrowser();
		logger.info("*******************ending after method**************************");
	}
	
	@Test(priority = 0)
	public void verifyAdminDashboardTest()
	{
		logger.info("*******************starting AdminDashboardTest**************************");
		adb.verifyAdminDashboard();
		logger.info("*******************ending AdminDashboardTest**************************");
	}
	
	@Test(priority = 1)
	public void verifyTodayBookingTest()
	{
		logger.info("*******************starting TodayBookingTest**************************");
		adb.verifyTodayBooking();
		logger.info("*******************ending TodayBookingTest**************************");
	}
	
	@Test(priority = 2)
	public void verifyThirtyDayBookingTest()
	{
		logger.info("*******************starting ThirtyDayBookingTest**************************");
	    adb.verifyThirtyDayBooking();
	    logger.info("*******************ending ThirtyDayBookingTest**************************");
	}

}
