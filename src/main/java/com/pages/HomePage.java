package com.pages;

import org.openqa.selenium.By;
import static com.utilities.Utilities.*;

public class HomePage {

	private By dashboardMenu = By.xpath("//span[text()='Dashboard']");
	private By orangehrmLogo = By.xpath("//img[@alt='client brand banner']");

	public boolean verifyDashboardMenu() {
		return isElementDisplayed(dashboardMenu);
	}
	public boolean verifyHomePageLogo() {
		return isElementDisplayed(orangehrmLogo);
	}
}
