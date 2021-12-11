package com.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
	
	@Test(description = "To verify orange hrm home page title")
	public void homePageTitleTest() throws IOException {
		logger.info("starting homePageTitleTest");
		login.validLogin();
		String actualTitle = home.verifyHomePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		logger.info("ending homePageTitleTest");
	}
	@Test(description = "To verify orange hrm home page logo")
	public void homePageLogoTest() throws IOException {
		logger.info("starting homePageLogoTest");
		login.validLogin();
		boolean actualValue = home.verifyHomePageLogo();
		Assert.assertEquals(actualValue, true);
		logger.info("ending homePageLogoTest");
	}
}
