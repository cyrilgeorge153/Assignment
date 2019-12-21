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
	@FindBy(css = ".text-center.tours ")
//	@CacheLookup
	WebElement tours;
	
//	@FindBy(css = ".btn.btn-primary.btn-block")
//	@FindBy(css = ".icon_set_1_icon-66")
	@FindBy(css = ".col-md-2.col-xs-12.o1")
	@CacheLookup
	WebElement search;
	
	@FindBy(xpath = "//div[@class='content-wrapper']//div[1]//div[1]//div[2]//div[1]//div[3]//div[1]//div[2]//a[1]")
	@CacheLookup
	WebElement details;
	
	@FindBy(xpath = "//div[@class='slick-slide slick-current slick-active']//img")
	@CacheLookup
	WebElement img;
	
	@FindBy(xpath = "//div[@class='st-btn st-first']//span[@class='st-label'][contains(text(),'Share')]")
	@CacheLookup
	WebElement fbShare;
	
	@FindBy(xpath = "//span[contains(text(),'Tweet')]")
	@CacheLookup
	WebElement twitterShare;
	
	@FindBy(xpath = "//span[contains(text(),'Pin')]")
	@CacheLookup
	WebElement pininterestShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[4]")
	@CacheLookup
	WebElement mailShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[5]//img[1]")
	@CacheLookup
	WebElement whatsappShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[6]//img[1]")
	@CacheLookup
	WebElement linkedinShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[6]//img[1]")
	@CacheLookup
	WebElement normalShare;
	
	@FindBy(xpath = "//span[contains(text(),'Show on Map')]")
	@CacheLookup
	WebElement showMap;
	
	@FindBy(xpath = "//h4[contains(text(),'Inclusions')]")
	@CacheLookup
	WebElement inclusions;
	
	@FindBy(xpath = "//h4[contains(text(),'Exclusions')]")
	@CacheLookup
	WebElement exclusions;
	
	@FindBy(css = "button[class='writeReview btn btn-primary btn-block mb-10']")
	@CacheLookup
	WebElement review;
	
	@FindBy(css = ".btn.btn-block.btn-success.btn-sm.loader.mt-5.date")
	@CacheLookup
	WebElement changedate;
	
	@FindBy(css = "button[class='btn btn-secondary btn-block mt-20 btn-action btn-lg loader']")
	@CacheLookup
	WebElement booknow;
	
	@FindBy(css = ".form-control.form-bg-light")
//	@FindBy(xpath = "//div[@class='col-md-6']//input[@class='form-control form-bg-light']")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(xpath = "//div[@class='col-md-6']//div[contains(@class,'form-group')]//input[@class='form-control']")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(xpath = "//div[@class='col-md-12']//input[@class='form-control form-bg-light']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//h6[contains(text(),'Booking Date')]")
	@CacheLookup
	WebElement bookingdate;
	
	@FindBy(css = "span[id='displaytotal']")
	@CacheLookup
	WebElement amount;
	
	@FindBy(css = "button[name='logged']")
	@CacheLookup
	WebElement confirmbooking;
	
	@FindBy(xpath = "//span[contains(text(),'Invoice Number')]")
	@CacheLookup
	WebElement invoiceno;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/ul[1]/li[1]/span[2]")
	@CacheLookup
	WebElement invoicenovalue;
	
	@FindBy(css = "span[id='displaytotal']")
	@CacheLookup
	WebElement totalamt;
	
	
	
	/*
	 * @FindBy(xpath = "//li[contains(text(),'Return Ferry Tickets')]")
	 * 
	 *  WebElement rft;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Bike equipment')]")
	 * 
	 *  WebElement bikeEqpmt;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Complimentary Breakfast')]")
	 * 
	 *  WebElement complimentBrkfst;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Central Air/Heat')]")
	 * 
	 *  WebElement cAH ;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Guides / Assistance')]")
	 * 
	 *  WebElement guidesAssistance;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Dinner')]")
	 * 
	 *  WebElement dinner;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Cruise')]")
	 * 
	 *  WebElement cruise;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Professional tour escort')]")
	 * 
	 *  WebElement pte;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Beach Access')]")
	 * 
	 *  WebElement beachAccess;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Roundtrip Hotel Transfers')]")
	 * 
	 *  WebElement rHT;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Amusement Park Nearby')]")
	 * 
	 *  WebElement aPN;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Gratuities (optional)')]")
	 * 
	 *  WebElement gratuities;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Safety deposit boxes')]")
	 * 
	 *  WebElement sDB;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Lunch')]")
	 * 
	 *  WebElement lunch;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Deck Furniture')]")
	 * 
	 *  WebElement deckFurniture;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'Security System')]")
	 * 
	 *  WebElement securitySystem;
	 * 
	 * @FindBy(xpath = "//li[contains(text(),'State/National Park Nearby')]")
	 * 
	 *  WebElement sNPN;
	 */
	
	public void clickTours()
	{
		try {
		    
		    tours.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{

		    tours.click();
		}
	}
	
	public void clickSearch()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", search);
	}
	
	public void clickDetails()
	{
		details.click();
	}
	
	public void verifyImage()
	{
		Assert.assertEquals(img.isDisplayed(),true);
	}
	
	public void verifyFbShare()
	{
		Assert.assertEquals(fbShare.isDisplayed(),true);
	}
	
	public void verifyTwitterShare()
	{
		Assert.assertEquals(twitterShare.isDisplayed(),true);
	}
	
	public void verifyPininterestShare()
	{
try {
		    
	  Assert.assertEquals(pininterestShare.isDisplayed(),true);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{

			Assert.assertEquals(pininterestShare.isDisplayed(),true);
		}
		
	}
	
	public void verifyMailShare()
	{
		Assert.assertEquals(mailShare.isDisplayed(),true);
	}
	
	public void verifyWhatsppShare()
	{
		Assert.assertEquals(whatsappShare.isDisplayed(),true);
	}
	
	public void verifyLinkedinShare()
	{
		Assert.assertEquals(linkedinShare.isDisplayed(),true);
	}
	
	public void verifyNormalShare()
	{
		Assert.assertEquals(normalShare.isDisplayed(),true);
	}
	
	public void verifyShowMap()
	{
		String map=showMap.getText();
		Assert.assertEquals(map, "Show On Map");
	}
	
	public void verifyInclusions()
	{
		String inclusion=inclusions.getText();
		Assert.assertEquals(inclusion, "Inclusions");
	}
	
	public void verifyExclusions()
	{
		String exclusion=exclusions.getText();
		Assert.assertEquals(exclusion, "Exclusions");
	}
	
	public void verifyWriteReview()
	{
		Assert.assertEquals(review.isDisplayed(), true);
	}
	
	public void verifyChangeDate()
	{
		Assert.assertEquals(changedate.isDisplayed(), true);
	}
	
	public void clickBookNow()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", booknow);
	}
	
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
	
	public void verifyBookingDate()
	{
//		WebElement dynamicWebelement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[contains(text(),'Booking Date')]")));
		String bd= bookingdate.getText();
		Assert.assertEquals(bd, "Booking Date");	
	}
	
	public void verifyAmount()
	{
		String amountvalue=amount.getText();
		System.out.println(amountvalue);
		Assert.assertEquals(amountvalue, "$82.50");	
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
