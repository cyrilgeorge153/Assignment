package com.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(description = "To check forgot password button is displayed or not",retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void verifyForgotPasswordButtonTest() throws IOException {
		logger.info("starting verifyForgotPasswordButtonTest");
		Assert.assertEquals(login.verifyForgotPasswordButtonText(), "Forgot your password?");
		logger.info("ending verifyForgotPasswordButtonTest");
	}
	@Test(dataProvider = "loginData1", dataProviderClass = com.testdata.TestData.class, description = "To check login with invalid data",retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void verifyLoginTest(String email, String password) throws IOException, InterruptedException {
		logger.info("starting verifyLoginTest");
		login.enterUsername(email).enterPassword(password).clickLogin();
		Assert.assertEquals(login.verifyErrorMsg(), "Invalid credentials");
		logger.info("ending verifyLoginTest");
	}
}
