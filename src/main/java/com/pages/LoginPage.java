package com.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import static com.utilities.Utilities.*;

public final class LoginPage {

	private By forgotPwdButton = By.xpath("//p[text()='Forgot your password? ']");
	private By uname = By.name("username");
	private By pwd = By.name("password");
	private By lgnBtn = By.xpath("//button[text()=' Login ']");
	private By errorMsg = By.xpath("//p[text()='Invalid credentials']");

	public String verifyForgotPasswordButtonText() {
		return getText(forgotPwdButton);
	}
	public LoginPage enterUsername(String email) {
		enterValuesWebElement(uname, email);
		return this;
	}
	public LoginPage enterPassword(String password) {
		enterValuesWebElement(pwd, password);
		return this;
	}
	public LoginPage clickLogin() {
		clickWebElement(lgnBtn);
		return this;
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
