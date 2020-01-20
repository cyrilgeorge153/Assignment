/**
 * 
 */
package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.qa.configuration.BaseClass;

/**
 * @author CYRIL
 *
 */
public class AdminDashboardPage extends BaseClass{
		
	@FindBy(xpath = "//p[@class='serverHeader__title']")
	@CacheLookup
	public WebElement dashboard;
	
	@FindBy(xpath = "//strong[contains(text(),\"Today's Booking\")]")
	@CacheLookup
	public WebElement todaybooking;
	
	@FindBy(css = "text.highcharts-title")
	@CacheLookup
	public WebElement thirtydayreport;
	
	@FindBy(xpath = "//td[contains(text(),'168')]")
	@CacheLookup
	public WebElement idvalue;
	
	@FindBy(xpath = "//tr[5]//td[12]//span[1]//a[1]//i[1]")
	@CacheLookup
	public WebElement viewinvoice;
	
}
