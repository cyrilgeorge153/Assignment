/**
 * 
 */
package com.qa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * @author CYRIL
 *
 */
public class GenericMethods {
	
	public boolean webElementIsDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public void clickWebElement(WebElement element,WebDriver driver)
	{
		try {
			element.click();
		} catch (WebDriverException e) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public String getTextWebElement(WebElement element)
	{
		return element.getText();
	}

}
