/**
 * 
 */
package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.configuration.BaseClass;

/**
 * @author CYRIL
 *
 */
public class AdminDashboardPage extends BaseClass{
	
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@class='serverHeader__title']")
	@CacheLookup
	WebElement dashboard;
	
	@FindBy(xpath = "//strong[contains(text(),\"Today's Booking\")]")
	@CacheLookup
	WebElement todaybooking;
	
	@FindBy(css = "text.highcharts-title")
	@CacheLookup
	WebElement thirtydayreport;
	
	@FindBy(xpath = "//td[contains(text(),'168')]")
	@CacheLookup
	WebElement idvalue;
	
	@FindBy(xpath = "//tr[5]//td[12]//span[1]//a[1]//i[1]")
	@CacheLookup
	WebElement viewinvoice;
	
	public void verifyAdminDashboard() {
		Assert.assertEquals(dashboard.isDisplayed(), true);
	}
	
	public void verifyTodayBooking() {
		Assert.assertEquals(todaybooking.isDisplayed(), true);
	}
	
	public void verifyThirtyDayBooking() {
		Assert.assertEquals(thirtydayreport.isDisplayed(), true);
	}
	
	public void verifyIdValue() {
		Assert.assertEquals(idvalue.isDisplayed(), true);
	}
	
	public void verifyBookingDetails() {
		viewinvoice.click();
	}

}
