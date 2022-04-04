package com.configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import static com.utilities.Utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class Base {
//	protected WebDriver driver;
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	private static ChromeOptions options;
	private static FirefoxOptions option;
	private static EdgeOptions opt;
	protected static Logger logger;

	@BeforeClass
	public void generateLog() throws URISyntaxException {
		logger = LogManager.getLogger(Base.class);
//		logger = Logger.getLogger("Utility");
//		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
	public static void initialisation() throws IOException {
		String browser = System.getProperty("browsername", getPropertiesFileValue("browser")); // To take browser value
		switch (browser) // using maven from cmd using command
		{
		case "chrome":
			supressConsoleLogsChrome();
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			supressConsoleLogsFirefox();
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
			supressConsoleLogsChrome();
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.setHeadless(true);
			driver.set(new ChromeDriver(options));
			break;
		case "headlessfirefox":
			supressConsoleLogsFirefox();
			WebDriverManager.firefoxdriver().setup();
			option = new FirefoxOptions();
			option.setHeadless(true);
			driver.set(new FirefoxDriver(option));
			break;
		case "headlessedge":
			WebDriverManager.edgedriver().setup();
			opt = new EdgeOptions();
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
		getDriver().get(getPropertiesFileValue("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		logger.info("ending initialisation");
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
}
