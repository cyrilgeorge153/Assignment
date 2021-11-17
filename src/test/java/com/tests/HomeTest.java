package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utilities.Log;

public class HomeTest extends BaseTest{
	
	
	@Test(description = "To verify orange hrm home page title")
	public void homePageTitleTest() throws IOException {
		extentTest = extent.startTest("homePageTitleTest");
		Log.info("starting extenttest");
		login.validLogin();
		Log.info("completed login");
		String actualTitle = home.verifyHomePageTitle();
		Log.info("storing button text value in String variable actualText");
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
		Log.info("asserting expected and actual title");
	}
	
	@Test(description = "To verify orange hrm home page logo")
	public void homePageLogoTest() throws IOException {
		extentTest = extent.startTest("homePageLogoTest");
		Log.info("starting extenttest");
		login.validLogin();
		Log.info("completed login");
		boolean actualValue = home.verifyHomePageLogo();
		Log.info("storing button text value in String variable actualText");
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, true);
		Log.info("asserting expected and actual value");
	}
}
