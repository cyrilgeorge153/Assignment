package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
	
	
	@Test(description = "To verify orange hrm home page title")
	public void homePageTitleTest() throws IOException {
		extentTest = extent.startTest("homePageTitleTest");
		logger.info("starting extenttest");
		login.validLogin();
		logger.info("completed login");
		String actualTitle = home.verifyHomePageTitle();
		logger.info("storing button text value in String variable actualText");
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
		logger.info("asserting expected and actual title");
	}
	
	@Test(description = "To verify orange hrm home page logo")
	public void homePageLogoTest() throws IOException {
		extentTest = extent.startTest("homePageLogoTest");
		logger.info("starting extenttest");
		login.validLogin();
		logger.info("completed login");
		boolean actualValue = home.verifyHomePageLogo();
		logger.info("storing button text value in String variable actualText");
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, true);
		logger.info("asserting expected and actual value");
	}
}
