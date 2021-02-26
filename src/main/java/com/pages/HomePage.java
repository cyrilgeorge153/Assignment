package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Utilities;

public class HomePage {
	WebDriver driver;
	Utilities utility=new Utilities();

	public HomePage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "img[alt='OrangeHRM']")
	private WebElement orangehrmLogo;
	
	public String verifyHomePageTitle()
	{
		return Utilities.getTitleOfPage(driver);
	}
	
	public boolean verifyHomePageLogo()
	{
		return Utilities.isElementDisplayed(orangehrmLogo);
	}


}
