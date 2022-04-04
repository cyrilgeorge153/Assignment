package com.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import static com.utilities.Utilities.*;

public final class LoginPage {

	private By forgotPwdButton = By.cssSelector("[href='/index.php/auth/requestPasswordResetCode']");
	private By uname = By.id("txtUsername");
	private By pwd = By.id("txtPassword");
	private By lgnBtn = By.id("btnLogin");
	private By errorMsg = By.id("spanMessage");

	public String verifyForgotPasswordButtonText() {
		return getText(forgotPwdButton);
	}
	public void enterUsername(String email) {
		enterValuesWebElement(uname, email);
	}
	public void enterPassword(String password) {
		enterValuesWebElement(pwd, password);
	}
	public void clickLogin() {
		clickWebElement(lgnBtn);
	}
	public String verifyErrorMsg() {
		return getText(errorMsg);
	}
	public HomePage validLogin() throws IOException {
		enterValuesWebElement(uname, getPropertiesFileValue("username"));
		enterValuesWebElement(pwd, getPropertiesFileValue("password"));
		clickWebElement(lgnBtn);
		return new HomePage();
	}
}
