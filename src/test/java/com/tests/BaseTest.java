package com.tests;

import java.io.File;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.configuration.Base;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Log;
import com.utilities.Utilities;

public class BaseTest extends Base {

	LoginPage login;
	static HomePage home;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	Utilities util = new Utilities();

	@BeforeMethod
	public void setUp() throws IOException {

		Log.info("starting initialisation method from base class");
		initialisation();
		Log.info("completed initialisation method from base class");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Log.info("initialising login page object");

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report

			String screenshotPath = Utilities.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
																							// report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest);
		quitBrowser();
		}
	

	@BeforeTest
	public void setExtent() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Cyril Windows Machine");
		extent.addSystemInfo("User Name", "Cyril George");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("Application", "OrangeHRM");
		extent.loadConfig(new File("./src/test/resources/extent-config.xml"));

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();				
	}

}
