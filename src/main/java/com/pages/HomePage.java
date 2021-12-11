package com.pages;

import org.openqa.selenium.By;
import com.utilities.Utilities;

public class HomePage {

	By orangehrmLogo = By.cssSelector("img[alt='OrangeHRM']");

	public String verifyHomePageTitle() {
		return Utilities.getTitleOfPage();
	}
	public boolean verifyHomePageLogo() {
		return Utilities.isElementDisplayed(orangehrmLogo);
	}
}
