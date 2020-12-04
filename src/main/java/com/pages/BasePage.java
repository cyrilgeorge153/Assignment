package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.configuration.Base;

public class BasePage {

	public BasePage(WebDriver driver) throws IOException {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
