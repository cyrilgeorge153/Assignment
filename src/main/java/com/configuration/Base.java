package com.configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import com.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Logger logger;
	ChromeOptions options;
	FirefoxOptions option;

	@BeforeClass
	public void generateLog() throws URISyntaxException {
		logger = Logger.getLogger("Utility");
		PropertyConfigurator.configure("./src/main/resources//log4j/log4j.properties");
	}

	public void initialisation() throws IOException {
//		switch (Utilities.getPropertiesFileValue("browser"))
		String browser = System.getProperty("browsername"); //To take browser value 
		switch (browser) //using maven from cmd using command  
		 {
		case "chrome":
			Utilities.supressConsoleLogsChrome();
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			Utilities.supressConsoleLogsFirefox();
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "headlesschrome":
			Utilities.supressConsoleLogsChrome();
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			options = new ChromeOptions();
			options.addArguments("window-size=1400,800");// to drive headless mode
			options.addArguments("headless");// to drive headless mode
			driver = new ChromeDriver(options);// passing chrome options object reference
			break;
		case "headlessfirefox":
			Utilities.supressConsoleLogsFirefox();
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
			option = new FirefoxOptions();
			option.setHeadless(true);
			driver = new FirefoxDriver(option);
			break;
		case "aws":
			Utilities.supressConsoleLogsChrome();
			options = new ChromeOptions();
			options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
			driver = new ChromeDriver(options);
			break;
		default:
			System.out.println("Entered browser not present in config.properties file");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(Utilities.getPropertiesFileValue("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
