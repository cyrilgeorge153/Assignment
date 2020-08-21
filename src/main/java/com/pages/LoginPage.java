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

	public String verifyForgotPasswordButtonText() {
		return forgotPwdButton.getText();
	}

	public void enterUsername(String Email) {
		uname.sendKeys(Email);
	}

	public void enterPassword(String Password) {
		 pwd.sendKeys(Password);
	}

	public void clickLogin() {
		Utilities.clickWebElement(lgnBtn);
	}

	public String verifyErrorMsg() {
		return errorMsg.getText();
	}

}
