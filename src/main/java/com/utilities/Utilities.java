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
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Utilities {

	public static String getPropertiesFileValue(String propertyName) throws IOException {
		String propertyValue;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/java/com/configuration/config.properties");
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

	public static void sendCommonsEmailAfterExecution() throws EmailException {
		System.out.println("===Test for Sending CommonsEmail started===");
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("./test-output/index.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of bad indentation");
		attachment.setName("BadIndentation");
		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("seleniumtester153@gmail.com", "Welcomeseleniumtester"));
		email.setSSLOnConnect(true);
		email.setFrom("CommonsEmail@gmail.com");
		email.setSubject("CommonsEmail Test");
		email.setMsg("CommonsEmail test mail ... :-)");
		email.addTo("cyrilgeorge153@gmail.com");
		// add the attachment
		email.attach(attachment);
		// send the email
		email.send();
		System.out.println("===Test for Sending CommonsEmail ended===");
	}

	public static void sendJavaMailAfterExecution() {

		final String username = "seleniumtester153@gmail.com";
		final String password = "Welcomeseleniumtester";
		final String email = "cyrilgeorge153@gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Session session = Session.getDefaultInstance(props, null);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("seleniumtester153@gmail.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("cyrilgeorge153@gmail.com"));
			msg.setSubject("Automation Results");

			Multipart multipart = new MimeMultipart();

			MimeBodyPart textBodyPart = new MimeBodyPart();
//	        textBodyPart.setContent("content", "text/html");
			textBodyPart.setContent(email.getBytes(), "text/html; charset=ISO-8859-1");
			textBodyPart.setHeader("Content-Type", "text/html");
			textBodyPart.setText("Please find the attachment");

			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("./test-output/emailable-report.html"); // ex : "C:\\test.pdf"
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName("Result.html"); // ex : "test.pdf"

			multipart.addBodyPart(textBodyPart); // add the text part
			multipart.addBodyPart(attachmentBodyPart); // add the attachement part

			msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Mail sent successfully");
		} catch (MessagingException e) {

			System.out.println("Exception");
		}
	}

	public static void supressConsoleLogsChrome() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
	}

	public static void supressConsoleLogsFirefox() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	}

	public static void disableFirefoxPopup(FirefoxProfile profile1) {

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

	public static String getTitle(WebElement element) {
		return element.getText();
	}

}
