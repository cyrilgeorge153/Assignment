package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configuration.Base;
import com.utilities.Utilities;

public class HomePage {

	public HomePage() throws IOException {
		PageFactory.initElements(Base.driver, this);
	}
	@FindBy(css = "img[alt='OrangeHRM']")
	private WebElement orangehrmLogo;
	
	public String verifyHomePageTitle()
	{
		return Utilities.getTitleOfPage();
	}
	
	public boolean verifyHomePageLogo()
	{
		return Utilities.isElementDisplayed(orangehrmLogo);
	}


}
