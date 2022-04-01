package com.tests;

import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.configuration.Base;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.Utilities;

public class BaseTest extends Base {

	LoginPage login;
	HomePage home;
//	Logger logger = LogManager.getLogger(Base.class);
//	Logger logger = Logger.getLogger(Base.class);

	@BeforeMethod()
	public void setUp() throws IOException, IOException {
		logger.info("starting setUp");
		initialisation();
		login = new LoginPage();
		home = new HomePage();
		logger.info("ending setUp");
	}

	@AfterMethod
	public void tearDown() {
		logger.info("starting tearDown");
		Base.getDriver().close();
		logger.info("ending tearDown");
	}

	@AfterSuite
	public void sendEmailWithExtentReport(ITestContext testContext) throws IOException {
		logger.info("starting sendEmailWithExtentReport");
		if (!testContext.getSuite().getName().equalsIgnoreCase("Default Suite")) {
			Utilities.sendJavaMailAfterExecution();
			File fileName = Utilities.getLastModified(System.getProperty("user.dir") + "/TestReport/");
			try {
				Utilities.openAnyFile(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
//			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe /T");
//			Runtime.getRuntime().exec("TASKKILL /F /IM geckodriver.exe /T");
			logger.info("ending sendEmailWithExtentReport");
		}
	}
}
