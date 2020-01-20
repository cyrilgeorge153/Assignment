/**
 * 
 */
package com.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.configuration.BaseClass;
import com.qa.pages.AdminDashboardPage;
import com.qa.utilities.GenericMethods;
import com.qa.utilities.MyScreenRecorder;

/**
 * @author CYRIL
 *
 */
public class AdminTest extends BaseClass {
	
    AdminDashboardPage adb;
	Logger logger=Logger.getLogger(BaseClass.class);
	GenericMethods generic=new GenericMethods(); 
	    
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		startBrowser();
		logger.info("*******************starting before method**************************");
		browserConfig();
		readUrlAdmin();
		getCredentialsAdmin();
		adb =  PageFactory.initElements(driver, AdminDashboardPage.class); 
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
		Assert.assertEquals(generic.webElementIsDisplayed(adb.dashboard), true);
		MyScreenRecorder.stopRecording();
		logger.info("*******************ending verifyAdminDashboardTest**************************");
	}
	
	@Test(priority = 1,groups = "smoke",enabled = true,description = " To verifyTodayBookingTest")
	public void verifyTodayBookingTest() throws Exception
	{
		logger.info("*******************starting verifyTodayBookingTest**************************");
		MyScreenRecorder.startRecording("verifyTodayBookingTest");
		Assert.assertEquals(generic.webElementIsDisplayed(adb.todaybooking), true);
		MyScreenRecorder.stopRecording();
		logger.info("*******************ending verifyTodayBookingTest**************************");
	}
	
	@Test(priority = 2,groups = "smoke",enabled = true,description = " To verifyThirtyDayBookingTest")
	public void verifyThirtyDayBookingTest() throws Exception
	{
		logger.info("*******************starting verifyThirtyDayBookingTest**************************");
		MyScreenRecorder.startRecording("verifyThirtyDayBookingTest");
		Assert.assertEquals(generic.webElementIsDisplayed(adb.thirtydayreport), true);
	    MyScreenRecorder.stopRecording();
	    logger.info("*******************ending verifyThirtyDayBookingTest**************************");
	}
	
	@Test(priority = 3,groups = "smoke",enabled = true,description = " To verifyIdValueTest")
	public void verifyIdValueTest() throws Exception
	{
		logger.info("*******************starting verifyIdValueTest**************************");
		MyScreenRecorder.startRecording("verifyIdValueTest");
		Assert.assertEquals(generic.webElementIsDisplayed(adb.idvalue), true);
	    logger.info("*******************ending verifyIdValueTest**************************");
	}
	
	@Test(priority = 4,groups = "smoke",enabled = true,description = " To verifyBookingDetailsTest")
	public void verifyBookingDetailsTest() throws Exception
	{
		logger.info("*******************starting verifyBookingDetailsTest**************************");
		MyScreenRecorder.startRecording("verifyBookingDetailsTest");
        generic.clickWebElement(adb.viewinvoice, driver);
	    driver.navigate().back();
	    MyScreenRecorder.stopRecording();
	    logger.info("*******************ending verifyBookingDetailsTest**************************");
	}

}
