package com.configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import com.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
//	protected WebDriver driver;
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	ChromeOptions options;
	FirefoxOptions option;
	EdgeOptions opt;
	public static Logger logger;

	@BeforeClass
	public void generateLog() throws URISyntaxException {
		logger = Logger.getLogger("Utility");
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
	public void initialisation() throws IOException {
		String browser = System.getProperty("browsername","chrome"); // To take browser value
		switch (browser) // using maven from cmd using command
		{
		case "chrome":
			Utilities.supressConsoleLogsChrome();
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			Utilities.supressConsoleLogsFirefox();
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver.set(new OperaDriver());
			break;
		case "headlesschrome":
			Utilities.supressConsoleLogsChrome();
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("window-size=1400,800");// to drive headless mode
			options.addArguments("headless");// to drive headless mode
			driver.set(new ChromeDriver(options));
			break;
		case "headlessfirefox":
			Utilities.supressConsoleLogsFirefox();
			WebDriverManager.firefoxdriver().setup();
			option = new FirefoxOptions();
			option.setHeadless(true);
			driver.set(new FirefoxDriver(option));
			break;
		case "headlessedge":
			WebDriverManager.edgedriver().setup();
			opt=new EdgeOptions();
			opt.addArguments("headless");
			driver.set(new EdgeDriver(opt));
			break;
		default:
			System.out.println("Entered browser not present in config.properties file");
			break;
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		getDriver().manage().deleteAllCookies();
		getDriver().get(Utilities.getPropertiesFileValue("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		logger.info("ending initialisation");
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
}
