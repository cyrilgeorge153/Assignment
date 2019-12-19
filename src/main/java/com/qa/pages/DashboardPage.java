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
public class DashboardPage extends BaseClass {
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'text-center tours')]")
	@CacheLookup
	WebElement tours;
	
	@FindBy(xpath = "//div[@class='col-md-2 col-xs-12']//button[@class='btn btn-primary btn-block'][contains(text(),'Search')]")
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
	
	@FindBy(xpath = "//li[contains(text(),'Return Ferry Tickets')]")
	@CacheLookup
	WebElement rft;
	
	@FindBy(xpath = "//li[contains(text(),'Bike equipment')]")
	@CacheLookup
	WebElement bikeEqpmt;
	
	@FindBy(xpath = "//li[contains(text(),'Complimentary Breakfast')]")
	@CacheLookup
	WebElement complimentBrkfst;
	
	@FindBy(xpath = "//li[contains(text(),'Central Air/Heat')]")
	@CacheLookup
	WebElement cAH ;
	
	@FindBy(xpath = "//li[contains(text(),'Guides / Assistance')]")
	@CacheLookup
	WebElement guidesAssistance;
	
	@FindBy(xpath = "//li[contains(text(),'Dinner')]")
	@CacheLookup
	WebElement dinner;
	
	@FindBy(xpath = "//li[contains(text(),'Cruise')]")
	@CacheLookup
	WebElement cruise;
	
	@FindBy(xpath = "//li[contains(text(),'Professional tour escort')]")
	@CacheLookup
	WebElement pte;
	
	@FindBy(xpath = "//li[contains(text(),'Beach Access')]")
	@CacheLookup
	WebElement beachAccess;
	
	@FindBy(xpath = "//li[contains(text(),'Roundtrip Hotel Transfers')]")
	@CacheLookup
	WebElement rHT;
	
	@FindBy(xpath = "//li[contains(text(),'Amusement Park Nearby')]")
	@CacheLookup
	WebElement aPN;
	
	@FindBy(xpath = "//li[contains(text(),'Gratuities (optional)')]")
	@CacheLookup
	WebElement gratuities;
	
	@FindBy(xpath = "//li[contains(text(),'Safety deposit boxes')]")
	@CacheLookup
	WebElement sDB;
	
	@FindBy(xpath = "//li[contains(text(),'Lunch')]")
	@CacheLookup
	WebElement lunch;
	
	@FindBy(xpath = "//li[contains(text(),'Deck Furniture')]")
	@CacheLookup
	WebElement deckFurniture;
	
	@FindBy(xpath = "//li[contains(text(),'Security System')]")
	@CacheLookup
	WebElement securitySystem;
	
	@FindBy(xpath = "//li[contains(text(),'State/National Park Nearby')]")
	@CacheLookup
	WebElement sNPN;
	
	
	
	public void clickTours()
	{
		tours.click();
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
		System.out.println(map);
		Assert.assertEquals(map, "Show On Map");
		
	}
	
	public void verifyInclusions()
	{
		String inclusion=inclusions.getText();
		System.out.println(inclusion);
		Assert.assertEquals(inclusion, "Inclusions");
		
		String  returnFerryTickets=rft.getText();
		System.out.println(returnFerryTickets);
		Assert.assertEquals(returnFerryTickets, "Return Ferry Tickets");
		
		String  bikeEquipment=bikeEqpmt.getText();
		System.out.println(bikeEquipment);
		Assert.assertEquals(bikeEquipment, "Bike equipment");
		
		String  complimentaryBreakfast=complimentBrkfst.getText();
		System.out.println(complimentaryBreakfast);
		Assert.assertEquals(complimentaryBreakfast, "Complimentary Breakfast");
		
		String  centralAirHeat=cAH.getText();
		System.out.println(centralAirHeat);
		Assert.assertEquals(complimentaryBreakfast, "Central Air/Heat");
		
		String  guidesAssistances=guidesAssistance.getText();
		System.out.println(guidesAssistances);
		Assert.assertEquals(guidesAssistances, "Guides / Assistance");
		
		String  dinr=dinner.getText();
		System.out.println(dinr);
		Assert.assertEquals(dinr, "Dinner");
		
		
		
	}
}
