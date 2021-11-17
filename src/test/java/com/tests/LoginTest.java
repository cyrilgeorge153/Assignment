package com.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utilities.Log;

public class LoginTest extends BaseTest {

	@Test(description = "To check forgot password button is displayed or not")
	public void verifyForgotPasswordButtonTest() throws IOException {
		extentTest = extent.startTest("verifyForgotPasswordButtonTest");
		Log.info("starting extenttest");
		String actualText = login.verifyForgotPasswordButtonText();
		Log.info("storing button text value in String variable actualText");
		System.out.println(actualText);
		Assert.assertEquals(actualText, "Forgot your password?");
		Log.info("asserting expected and actual value");
	}

	@Test(dataProvider = "loginData1", dataProviderClass = com.testdata.TestData.class, description = "To check login with multiple sets of data")
	public void verifyLoginTest(String Email, String Password) throws IOException, InterruptedException {
		extentTest = extent.startTest("verifyLoginTest");
		Log.info("starting extenttest");
		login.enterUsername(Email);
		Log.info("entered email");
		login.enterPassword(Password);
		Log.info("entered password");
		login.clickLogin();
		Log.info("clicked login button");
		String actualErrorMsg = login.verifyErrorMsg();
		Log.info("getting error message after invalid login");
		System.out.println(actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, "Invalid credentials");
		Log.info("asserting expected and actual value");
	}

}
