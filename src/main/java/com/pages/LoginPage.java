package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.utilities.Utilities;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) throws IOException {
		super(driver);

	}

	@FindBy(css = "[href='/index.php/auth/requestPasswordResetCode']")
	WebElement forgotPwdButton;

	@FindBy(id = "txtUsername")
	WebElement uname;

	@FindBy(id = "txtPassword")
	WebElement pwd;

	@FindBy(id = "btnLogin")
	WebElement lgnBtn;

	@FindBy(id = "spanMessage")
	WebElement errorMsg;

	public WebElement verifyForgotPasswordButtonText() {
		return forgotPwdButton;
	}

	public WebElement enterUsername() {
		return uname;
	}

	public WebElement enterPassword() {
		return pwd;
	}

	public void clickLogin() {
		Utilities.clickWebElement(lgnBtn);
	}

	public WebElement verifyErrorMsg() {
		return errorMsg;
	}

}
