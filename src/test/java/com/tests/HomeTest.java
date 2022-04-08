package com.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
	
	@Test(description = "To verify orange hrm home page Dashboard menu",retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void homePageDashboardMenuTest() throws IOException {
		logger.info("starting homePageDashboardMenuTest");
		login.validLogin();
		Assert.assertEquals(home.verifyDashboardMenu(), true);
		logger.info("ending homePageDashboardMenuTest");
	}
	@Test(description = "To verify orange hrm home page logo",retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void homePageLogoTest() throws IOException {
		logger.info("starting homePageLogoTest");
		login.validLogin();
		Assert.assertEquals(home.verifyHomePageLogo(), true);
		logger.info("ending homePageLogoTest");
	}
}
