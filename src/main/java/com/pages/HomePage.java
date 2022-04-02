package com.pages;

import org.openqa.selenium.By;
import static com.utilities.Utilities.*;

public class HomePage {

	By dashboardMenu = By.xpath("//b[text()='Dashboard']");
	By orangehrmLogo = By.cssSelector("img[alt='OrangeHRM']");

	public boolean verifyDashboardMenu() {
		return isElementDisplayed(dashboardMenu);
	}
	public boolean verifyHomePageLogo() {
		return isElementDisplayed(orangehrmLogo);
	}
}
