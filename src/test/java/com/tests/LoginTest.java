package com.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(description = "To check forgot password button is displayed or not")
	public void verifyForgotPasswordButtonTest() throws IOException {
		logger.info("starting verifyForgotPasswordButtonTest");
		String actualText = login.verifyForgotPasswordButtonText();
		Assert.assertEquals(actualText, "Forgot your password?");
		logger.info("ending verifyForgotPasswordButtonTest");
	}
	@Test(dataProvider = "loginData1", dataProviderClass = com.testdata.TestData.class, description = "To check login with multiple sets of data")
	public void verifyLoginTest(String email, String password) throws IOException, InterruptedException {
		logger.info("starting verifyLoginTest");
		login.enterUsername(email);
		login.enterPassword(password);
		login.clickLogin();
		String actualErrorMsg = login.verifyErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Invalid credentials");
		logger.info("ending verifyLoginTest");
	}
}
