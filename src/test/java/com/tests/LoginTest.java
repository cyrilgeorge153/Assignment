package com.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(description = "To check landing page is displayed or not")
	public void verifyForgotPasswordButtonTextTest() throws IOException {
		extentTest = extent.startTest("verifyForgotPasswordButtonTextTest");
		logger.info("starting extenttest");
		String actualText = login.verifyForgotPasswordButtonText();
		logger.info("storing button text value in String variable actualText");
		System.out.println(actualText);
		Assert.assertEquals(actualText, "Forgot your password?");
		logger.info("asserting expected and actual value");
	}

	@Test(dataProvider = "loginData1", dataProviderClass = com.testdata.TestData.class, description = "To check login with multiple sets of data")
	public void verifyLoginTest(String Email, String Password) throws IOException, InterruptedException {
		extentTest = extent.startTest("verifyLoginTest");
		logger.info("starting extenttest");
		login.enterUsername(Email);
		logger.info("entered email");
		login.enterPassword(Password);
		logger.info("entered password");
		login.clickLogin();
		logger.info("clicked login button");
		String actualErrorMsg = login.verifyErrorMsg();
		logger.info("getting error message after invalid login");
		System.out.println(actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, "Invalid credentials");
		logger.info("asserting expected and actual value");
	}

}
