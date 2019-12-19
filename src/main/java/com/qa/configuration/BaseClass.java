package com.qa.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver=null;
	public static ChromeOptions options;
	public static Properties prop;
	public static FileInputStream ip;
	public static DesiredCapabilities cap;

	/**
	 * @return
	 * @throws IOException 
	 */
	
	
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
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver readUrl() throws IOException {
		String Url = prop.getProperty("url");
		driver.get(Url);
		return driver;
	}
	public static WebDriver startBrowser() throws IOException {
		readPropertiesFile();
		String browser=prop.getProperty("Browser");
		
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();  
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup(); 
				driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("headless")) 
			{
				WebDriverManager.chromedriver().clearPreferences();
				WebDriverManager.chromedriver().setup();  
				options = new ChromeOptions();
				options.addArguments("window-size=1400,800");// to drive headless mode
				options.addArguments("headless");// to drive headless mode
				driver=new ChromeDriver(options);//passing chrome options object reference
				return driver;
			}
			
		return driver;
			}
	
	public static WebDriver closeBrowser() throws InterruptedException {
		driver.close();
		return driver;
		
		
	}
	
public static WebDriver headless() {
		
		options = new ChromeOptions();
		options.addArguments("window-size=1400,800");// to drive headless mode
		options.addArguments("headless");// to drive headless mode
		driver=new ChromeDriver(options);//passing chrome options object reference
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
	}
