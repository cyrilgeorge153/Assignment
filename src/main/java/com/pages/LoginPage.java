package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configuration.Base;
import com.utilities.Utilities;

public final class LoginPage {

	public LoginPage() throws IOException {
		PageFactory.initElements(Base.driver, this);

	}

	@FindBy(css = "[href='/index.php/auth/requestPasswordResetCode']")
	private WebElement forgotPwdButton;

	@FindBy(id = "txtUsername")
	private WebElement uname;

	@FindBy(id = "txtPassword")
	private WebElement pwd;

	@FindBy(id = "btnLogin")
	private WebElement lgnBtn;

	@FindBy(id = "spanMessage")
	private WebElement errorMsg;

	public String verifyForgotPasswordButtonText() {
		return forgotPwdButton.getText();
	}

	public void enterUsername(String Email) {
		Utilities.enterValuesWebElement(uname, Email);
	}

	public void enterPassword(String Password) {
		Utilities.enterValuesWebElement(pwd, Password);
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
