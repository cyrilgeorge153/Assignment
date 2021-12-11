/**
 *
 */
package com.qa.utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
import com.configuration.Base;


/**
 * @author CYRIL
 *
 */
public class GenericMethods extends Base {
	public boolean webElementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public void clickWebElement(WebElement element, WebDriver driver) {
		try {
			element.click();
		} catch (WebDriverException e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}
	public String getTextWebElement(WebElement element) {
		return element.getText();
	}
	public void navigateToEveryLinkInPage() throws InterruptedException {
		List<WebElement> linksize = getDriver().findElements(By.tagName("a"));
		int linksCount = linksize.size();
		System.out.println("Total no of links Available:" + linksCount);
		String[] links = new String[linksCount];
		System.out.println("List of links Available:");
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			getDriver().navigate().to(links[i]);
			Thread.sleep(3000);
			System.out.println(getDriver().getTitle());
		}
	}
	public static void clickCheckboxFromList(String xpathOfElement, String valueToSelect,WebDriver driver) {
		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) {
			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
			for (WebElement f : dr) {
				System.out.println("value in the list : " + f.getText());
				if (valueToSelect.equals(f.getText())) {
					f.click();
					break;
				}
			}
		}
	}
	public void selectElementByNameMethod(WebElement element, String Name) {
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
	}
	public void selectElementByValueMethod(WebElement element, String value) {
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
	}
	public void selectElementByIndexMethod(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
	}
	public void dragAndDrop(WebElement fromWebElement, WebElement toWebElement) {
		Actions builder = new Actions(getDriver());
		builder.dragAndDrop(fromWebElement, toWebElement);
	}
	public void dragAndDrop_Method2(WebElement fromWebElement, WebElement toWebElement) {
		Actions builder = new Actions(getDriver());
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();
		dragAndDrop.perform();
	}
	public void dragAndDrop_Method3(WebElement fromWebElement, WebElement toWebElement) throws InterruptedException {
		Actions builder = new Actions(getDriver());
		builder.clickAndHold(fromWebElement).moveToElement(toWebElement).perform();
		Thread.sleep(2000);
		builder.release(toWebElement).build().perform();
	}
	public void hoverWebelement(WebElement HovertoWebElement) throws InterruptedException {
		Actions builder = new Actions(getDriver());
		builder.moveToElement(HovertoWebElement).perform();
		Thread.sleep(2000);
	}
	public void doubleClickWebelement(WebElement doubleclickonWebElement) throws InterruptedException {
		Actions builder = new Actions(getDriver());
		builder.doubleClick(doubleclickonWebElement).perform();
		Thread.sleep(2000);
	}
	public String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {
		String tooltip = toolTipofWebElement.getAttribute("title");
		System.out.println("Tool text : " + tooltip);
		return tooltip;
	}
	public void clickMultipleElements(WebElement someElement, WebElement someOtherElement) {
		Actions builder = new Actions(getDriver());
		builder.keyDown(Keys.CONTROL).click(someElement).click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	}
	public void highlightelement(WebElement element) {
		for (int i = 0; i < 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: solid red; border: 6px solid yellow;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}
	public boolean checkAlert_Accept() {
		try {
			Alert a = getDriver().switchTo().alert();
			String str = a.getText();
			System.out.println(str);
			a.accept();
			return true;
		} catch (Exception e) {
			System.out.println("no alert");
			return false;
		}
	}
	public boolean checkAlert_Dismiss() {
		try {
			Alert a = getDriver().switchTo().alert();
			String str = a.getText();
			System.out.println(str);
			a.dismiss();
			return true;
		} catch (Exception e) {
			System.out.println("no alert ");
			return false;
		}
	}
	public void scrolltoElement(WebElement ScrolltoThisElement) {
		Coordinates coordinate = ((Locatable) ScrolltoThisElement).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
	}
	public void checkbox_Checking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			System.out.println("Checkbox is already checked");
		} else {
			checkbox.click();
			System.out.println("Checked the checkbox");
		}
	}
	public void radiobutton_Select(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			Radio.click();
			System.out.println("Selected the Radiobutton");
		}
	}
	// Unchecking
	public void checkbox_Unchecking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
	}
	public void radioButton_Deselect(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Radio.click();
			System.out.println("Radio Button is deselected");
		} else {
			System.out.println("Radio Button was already Deselected");
		}
	}
	public void switchToNewWindow() {
		Set s = getDriver().getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		getDriver().switchTo().window(w2);
	}
	public void switchToOldWindow() {
		Set s = getDriver().getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		getDriver().switchTo().window(w1);
	}
	public void switchToParentWindow() {
		getDriver().switchTo().defaultContent();
	}
	public void hoverOverElement(WebElement element,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
