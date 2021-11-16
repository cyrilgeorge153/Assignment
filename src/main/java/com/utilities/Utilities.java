package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities {

	public static String getPropertiesFileValue(String propertyName) throws IOException {
		String propertyValue;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
		prop.load(fis);
		propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String getBase64Screenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String encodedBase64 = null;
		FileInputStream fileInputStream = null;
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		try {
			fileInputStream = new FileInputStream(finalDestination);
			byte[] bytes = new byte[(int) finalDestination.length()];
			fileInputStream.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return encodedBase64;
	}
	public static void supressConsoleLogsChrome() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
	}

	public static void supressConsoleLogsFirefox() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	}

	public static void disableChromeImages() {
		ChromeOptions chromeOptions = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.images", 2);
		chromeOptions.setExperimentalOption("prefs", prefs);
	}

	public static void clickWebElement(WebElement element) {
		element.click();
	}

	public static void enterValuesWebElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getText(WebElement element) {
		return element.getText();
	}
	
	public static String getTitleOfPage(WebDriver driver) {
		
		return driver.getTitle();
	}
	
    public static boolean isElementDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}

}
