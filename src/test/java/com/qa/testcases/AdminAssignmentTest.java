/**
 * 
 */
package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.configuration.BaseClass;
import com.qa.pages.AdminDashboardPage;

/**
 * @author CYRIL
 *
 */
public class AdminAssignmentTest extends BaseClass {
	
	public static AdminDashboardPage adb;
	
	@BeforeMethod()
	public void setUp() throws IOException {
		startBrowser();
		browserConfig();
		readUrlAdmin();
		getCredentialsAdmin();
		adb = new AdminDashboardPage(driver);
		
	}
	
	@AfterMethod()
	public void tearDown() throws InterruptedException {
		closeBrowser();
	}
	
//	@Test(priority = 0)
	public void verrifyAdminDashboardTest()
	{
		adb.verifyAdminDashboard();
	}
	
//	@Test(priority = 1)
	public void verrifyTodayBookingTest()
	{
		adb.verifyTodayBooking();;
	}
	
	@Test(priority = 2)
	public void verifyThirtyDayBookingTest()
	{
	adb.verifyThirtyDayBooking();
	}

}
