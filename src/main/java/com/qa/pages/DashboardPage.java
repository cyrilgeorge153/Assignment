/**
 * 
 */
package com.qa.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.configuration.BaseClass;
/**
 * @author CYRIL
 *
 */
public class DashboardPage extends BaseClass {
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(@class,'text-center tours')]")
	WebElement tours;
	
	@FindBy(xpath = "//div[@class='col-md-2 col-xs-12']//button[@class='btn btn-primary btn-block'][contains(text(),'Search')]")
	WebElement search;
	
	@FindBy(xpath = "//div[@class='content-wrapper']//div[1]//div[1]//div[2]//div[1]//div[3]//div[1]//div[2]//a[1]")
	WebElement details;
	
	@FindBy(xpath = "//div[@class='slick-slide slick-current slick-active']//img")
	WebElement img;
	
	@FindBy(xpath = "//div[@class='st-btn st-first']//span[@class='st-label'][contains(text(),'Share')]")
	WebElement fbShare;
	
	@FindBy(xpath = "//span[contains(text(),'Tweet')]")
	WebElement twitterShare;
	
	@FindBy(xpath = "//span[contains(text(),'Pin')]")
	WebElement pininterestShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[4]")
	WebElement mailShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[5]//img[1]")
	WebElement whatsappShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[6]//img[1]")
	WebElement linkedinShare;
	
	@FindBy(xpath = "//div[contains(@class,'blog-media mt-10')]//div[6]//img[1]")
	WebElement normalShare;
	
	@FindBy(xpath = "//span[contains(text(),'Show on Map')]")
	WebElement showMap;
	
	@FindBy(xpath = "//h4[contains(text(),'Inclusions')]")
	WebElement inclusions;
	
	@FindBy(xpath = "//h4[contains(text(),'Exclusions')]")
	WebElement exclusions;
	
	@FindBy(css = "button[class='writeReview btn btn-primary btn-block mb-10']")
	WebElement review;
	
	@FindBy(css = ".btn.btn-block.btn-success.btn-sm.loader.mt-5.date")
	WebElement changedate;
	
	@FindBy(css = "button[class='btn btn-secondary btn-block mt-20 btn-action btn-lg loader']")
	WebElement booknow;
	
	@FindBy(css = ".form-control.form-bg-light")
	WebElement firstname;
	
	@FindBy(xpath = "//div[@class='col-md-6']//div[contains(@class,'form-group')]//input[@class='form-control']")
	WebElement lastname;
	
	@FindBy(xpath = "//div[@class='col-md-12']//input[@class='form-control form-bg-light']")
	WebElement email;
	
	@FindBy(xpath = "//h6[contains(text(),'Booking Date')]")
	WebElement bookingdate;
	
	@FindBy(css = "span[id='displaytotal']")
	WebElement totalamount;
	
	
	
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
		search.click();
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
		Assert.assertEquals(pininterestShare.isDisplayed(),true);
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
		String firstName=firstname.getAttribute("value");
		Assert.assertEquals(firstName, "Demo");
		String lastName=lastname.getAttribute("value");
		Assert.assertEquals(lastName, "User");
		String emailID=email.getAttribute("value");
		Assert.assertEquals(emailID, "user@phptravels.com");
		
	}
	
	public void verifyBookingDate()
	{
		String bd=bookingdate.getText();
		Assert.assertEquals(bd, "Booking Date");	
	}
	
	public void verifyTotalAmount()
	{
		String totalAmount=totalamount.getText();
		System.out.println(totalAmount);
		Assert.assertEquals(totalAmount, "$82.50");	
	}
}
