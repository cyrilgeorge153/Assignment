package com.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import com.utilities.Utilities;

public final class LoginPage {

	By forgotPwdButton = By.cssSelector("[href='/index.php/auth/requestPasswordResetCode']");
	By uname = By.id("txtUsername");
	By pwd = By.id("txtPassword");
	By lgnBtn = By.id("btnLogin");
	By errorMsg = By.id("spanMessage");

	public String verifyForgotPasswordButtonText() {
		return Utilities.getText(forgotPwdButton);
	}
	public void enterUsername(String email) {
		Utilities.enterValuesWebElement(uname, email);
	}
	public void enterPassword(String password) {
		Utilities.enterValuesWebElement(pwd, password);
	}
	public void clickLogin() {
		Utilities.clickWebElement(lgnBtn);
	}
	public String verifyErrorMsg() {
		return Utilities.getText(errorMsg);
	}
	public HomePage validLogin() throws IOException {
		Utilities.enterValuesWebElement(uname, Utilities.getPropertiesFileValue("username"));
		Utilities.enterValuesWebElement(pwd, Utilities.getPropertiesFileValue("password"));
		Utilities.clickWebElement(lgnBtn);
		return new HomePage();
	}
}
