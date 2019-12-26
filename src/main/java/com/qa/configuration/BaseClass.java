package com.qa.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties prop;
	public static FileInputStream ip;
	public static DesiredCapabilities cap;
	public static Logger logger;

	/**
	 * @return
	 * @throws IOException 
	 */
	
@BeforeClass
	public  void generateLog() {
		 logger=Logger.getLogger("Utility");
		PropertyConfigurator.configure(".//src//main//resources//log4j.properties");
//		 PropertyConfigurator.configure(System.getProperty("user.dir"	, "/log4j.properties"));
	}
	
	public static void readPropertiesFile() throws IOException
	{
		prop = new Properties();
		ip = new FileInputStream(".//src//main//java//com//qa//configuration//config.properties");
		prop.load(ip);
	}
	
	public static WebDriver browserConfig()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver readUrl() throws IOException {
		String Url = prop.getProperty("url");
		driver.get(Url);
		return driver;
	}
	
	public static WebDriver readUrlAdmin() throws IOException {
		String Url = prop.getProperty("url1");
		driver.get(Url);
		return driver;
	}
	public static WebDriver startBrowser() throws IOException {
		readPropertiesFile();
		String browser=prop.getProperty("Browser");
		
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();  
				supressConsoleLogsChrome();
				driver=new ChromeDriver();	
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup(); 
				supressConsoleLogsFirefox();
				driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) 
			{
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("IE")) 
			{
				System.setProperty("webdriver.ie.driver", ".//Drivers//IEDriver//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else if(browser.equalsIgnoreCase("headlesschrome")) 
			{
				WebDriverManager.chromedriver().clearPreferences();
				WebDriverManager.chromedriver().setup();  
				supressConsoleLogsChrome();
				options = new ChromeOptions();
				options.addArguments("window-size=1400,800");// to drive headless mode
				options.addArguments("headless");// to drive headless mode
				driver=new ChromeDriver(options);//passing chrome options object reference
			}
			else if(browser.equalsIgnoreCase("headlessfirefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
			    driver = new FirefoxDriver(options);
			}
			
		return driver;
			}
	
	public static WebDriver closeBrowser() throws InterruptedException {
		driver.close();
		return driver;
		
		
	}
	
public static WebDriver headlessChrome() {
		options = new ChromeOptions();
		options.addArguments("window-size=1400,800");// to drive headless mode
		options.addArguments("headless");// to drive headless mode
		driver=new ChromeDriver(options);//passing chrome options object reference
		return driver;
	}

public static WebDriver headlessFirefox() {
	WebDriverManager.firefoxdriver().setup();
	FirefoxOptions options = new FirefoxOptions();
	options.setHeadless(true);
    driver = new FirefoxDriver(options);
	return driver;
}
	public static WebDriver getCredentials() throws IOException {
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']")).click();
		return driver;
	}
	
	public static WebDriver getCredentialsAdmin() throws IOException {
		String Username = prop.getProperty("username1");
		String Password = prop.getProperty("password1");
		driver.findElement(By.name("email")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		return driver;
	}
	public static WebDriver disableImages() {
		options = new ChromeOptions();
		options.addArguments("--blink-settings=imagesEnabled=false");
		return driver;
		
	}
	
	public static WebDriver disableChromeImages()
    {
		options=new ChromeOptions();
        HashMap<String, Object> images = new HashMap<String, Object>();
        images.put("images", 2);

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values", images);

        options.setExperimentalOption("prefs", prefs);
		return driver;

    }
	
	public static WebDriver disableFirefoxImages()
    {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		capabilities.setCapability("firefox_profile", profile);
		WebDriver driver = new FirefoxDriver(capabilities);
		return driver;

    }
	
	public static WebDriver supressConsoleLogsChrome()
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		return driver;
	}
	
	public static WebDriver supressConsoleLogsFirefox()
	{
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		return driver;

	}
	
	
	public boolean handlePopups() {

		  boolean presentFlag = false;

		  try {

		   // Check the presence of alert
		   Alert alert = driver.switchTo().alert();
		   // Alert present; set the flag
		   presentFlag = true;
		   // if present consume the alert
		   alert.accept();

		  } catch (NoAlertPresentException ex) {
		   // Alert not present
		   ex.printStackTrace();
		  }

		  return presentFlag;

		 }
	}
