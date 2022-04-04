package com.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import static com.configuration.Base.*;

public class Utilities {
	
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
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
	public static void clickWebElement(By byLocator) {
		getDriver().findElement(byLocator).click();
	}
	public static void enterValuesWebElement(By byLocator, String value) {
		getDriver().findElement(byLocator).clear();
		getDriver().findElement(byLocator).sendKeys(value);
	}
	public static String getText(By byLocator) {
		return getDriver().findElement(byLocator).getText();
	}
	public static String getTitleOfPage() {
		return getDriver().getTitle();
	}
    public static boolean isElementDisplayed(By byLocator) {
    	return getDriver().findElement(byLocator).isDisplayed();
	}
    public static String createCurrentTimeStamp()
	{
		String pattern = "dd-MM-yyyy-HH-mm";
		String timeStamp = new SimpleDateFormat(pattern).format(new Date());
		return timeStamp;
	}
    public static String getBrowser() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        return StringUtils.capitalize(browserName);
    }
	public static String getVersion() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String version = cap.getBrowserVersion().toString();
        return version;
    }
	public static File getLastModified(String directoryFilePath)
	{
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;
	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }
	    return chosenFile;
	}
	public static void openAnyFile(File fileName) throws IOException
	{
		Desktop.getDesktop().browse((fileName).toURI());
	}
	public static void sendJavaMailAfterExecution() throws IOException {
		final String username = getPropertiesFileValue("email");
		final String password = getDecodedString(getPropertiesFileValue("pwd"));
		final String email = getPropertiesFileValue("recipient1");
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(getPropertiesFileValue("email")));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(getPropertiesFileValue("recipient1")));
			msg.addRecipients(Message.RecipientType.CC, 
                    InternetAddress.parse(getPropertiesFileValue("recipient2")));
			msg.setSubject("Automation Results");
			Multipart multipart = new MimeMultipart();
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setContent(email.getBytes(), "text/html; charset=ISO-8859-1");
			textBodyPart.setHeader("Content-Type", "text/html");
			textBodyPart.setText("Please find the attachment");
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			File fileName=getLastModified(System.getProperty("user.dir")+"/TestReport/");
			DataSource source = new FileDataSource(fileName); // ex																											// :																											// "C:\\test.pdf"
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName("ExtentReport.html"); 
			multipart.addBodyPart(textBodyPart); 
			multipart.addBodyPart(attachmentBodyPart); 
			msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Mail sent successfully");
		} catch (MessagingException e) {
			System.out.println("Exception");
			System.out.println(e.getMessage());
		}
	}	
}
