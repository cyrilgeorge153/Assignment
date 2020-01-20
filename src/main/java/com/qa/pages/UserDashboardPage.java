/**
 * 
 */
package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.configuration.BaseClass;
/**
 * @author CYRIL
 *
 */
public class UserDashboardPage extends BaseClass {
	public UserDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Tours')]")
//	@FindBy(xpath = "//a[contains(@class,'text-center tours')]")
//	@CacheLookup
	public WebElement tours;
	

//	@FindBy(xpath = "(//button[normalize-space(.)='Search'])[1]")
//	@FindBy(xpath = "(//button[contains(text(),'Search')])[1]")
//	@FindBy(xpath = "//div[@class='col-md-2 col-xs-12']//button[@class='btn btn-primary btn-block'][contains(text(),'Search')]")
	@FindBy(xpath = "//div[contains(@class,'ftab-inner menu-horizontal-content')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]")
	@CacheLookup
	public WebElement search;
	
	@FindBy(xpath = "//div[@class='content-wrapper']//div[1]//div[1]//div[2]//div[1]//div[3]//div[1]//div[2]//a[1]")
	@CacheLookup
	public WebElement details;
	
	@FindBy(xpath = "//div[@class='slick-slide slick-current slick-active']//img")
	@CacheLookup
	public WebElement img;
	
	@FindBy(xpath = "//div[@class='st-btn st-first']//span[@class='st-label'][contains(text(),'Share')]")
	@CacheLookup
	public WebElement fbShare;
	
	@FindBy(xpath = "//span[contains(text(),'Tweet')]")
	@CacheLookup
	public WebElement twitterShare;
	
	@FindBy(xpath = "//span[contains(text(),'Pin')]")
	@CacheLookup
	public WebElement pininterestShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[4]")
	@CacheLookup
	public WebElement mailShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[5]//img[1]")
	@CacheLookup
	public WebElement whatsappShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[6]//img[1]")
	@CacheLookup
	public WebElement linkedinShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[6]//img[1]")
	@CacheLookup
	public WebElement normalShare;
	
	@FindBy(xpath = "//span[contains(text(),'Show on Map')]")
	@CacheLookup
	public WebElement showMap;
	
	@FindBy(xpath = "//h4[contains(text(),'Inclusions')]")
	@CacheLookup
	public WebElement inclusions;
	
	@FindBy(xpath = "//h4[contains(text(),'Exclusions')]")
	@CacheLookup
	public WebElement exclusions;
	
	@FindBy(css = "button[class='writeReview btn btn-primary btn-block mb-10']")
	@CacheLookup
	public WebElement review;
	
	@FindBy(css = ".btn.btn-block.btn-success.btn-sm.loader.mt-5.date")
	@CacheLookup
	public WebElement changedate;
	
	@FindBy(css = "button[class='btn btn-secondary btn-block mt-20 btn-action btn-lg loader']")
	@CacheLookup
	public WebElement booknow;
	
	@FindBy(css = ".form-control.form-bg-light")
//	@FindBy(xpath = "//div[@class='col-md-6']//input[@class='form-control form-bg-light']")
	@CacheLookup
	public WebElement firstname;
	
	@FindBy(xpath = "//div[@class='col-md-6']//div[contains(@class,'form-group')]//input[@class='form-control']")
	@CacheLookup
	public WebElement lastname;
	
	@FindBy(xpath = "//div[@class='col-md-12']//input[@class='form-control form-bg-light']")
	@CacheLookup
	public WebElement email;
	
	@FindBy(xpath = "//h6[contains(text(),'Booking Date')]")
	@CacheLookup
	public WebElement bookingdate;
	
	@FindBy(css = "span[id='displaytotal']")
	@CacheLookup
	public WebElement amount;
	
	@FindBy(css = "button[name='logged']")
	@CacheLookup
	public WebElement confirmbooking;
	
	@FindBy(xpath = "//span[contains(text(),'Invoice Number')]")
	@CacheLookup
	public WebElement invoiceno;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/ul[1]/li[1]/span[2]")
	@CacheLookup
	public WebElement invoicenovalue;
	
	@FindBy(xpath = "//span[@class='text-main text-secondary']")
	@CacheLookup
	public WebElement totalamt;
	
	@FindBy(xpath = "//h4[contains(text(),'Please read the terms before proceed')]")
	@CacheLookup
	public WebElement terms;
	
	public void verifyPersonalDetails()
	{
		WebDriverWait some_element = new WebDriverWait(driver,100); 
		some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-6']//input[@class='form-control form-bg-light']")));
		//do anything you want with some_element
		String firstName=firstname.getAttribute("value");
		Assert.assertEquals(firstName, "Demo");
		String lastName=lastname.getAttribute("value");
		Assert.assertEquals(lastName, "User");
		String emailID=email.getAttribute("value");
		Assert.assertEquals(emailID, "user@phptravels.com");
		
	}
	
	public void clickConfirmBooking()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", confirmbooking);
	}
	
	public void verifyBookingDetails()
	{
		String invoicenumber=invoiceno.getText();
		String invoicenumbervalue=invoicenovalue.getText();
		System.out.println(invoicenumber);
		System.out.println(invoicenumbervalue);
		Assert.assertEquals(invoicenumber, "Invoice Number");
	}
	
	public void verifyTotalAmount()
	{
		String totalamount=totalamt.getText();
		System.out.println(totalamount);
	}
}
