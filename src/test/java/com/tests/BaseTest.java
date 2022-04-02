package com.tests;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.configuration.Base;
import com.pages.HomePage;
import com.pages.LoginPage;
import static com.utilities.Utilities.*;

public class BaseTest extends Base {

	LoginPage login;
	HomePage home;

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
		getDriver().close();
		logger.info("ending tearDown");
	}
	@AfterSuite
	public void sendEmailWithExtentReport(ITestContext testContext) {
		logger.info("starting sendEmailWithExtentReport");
		if (!testContext.getSuite().getName().equalsIgnoreCase("Default Suite")) {
			try {
				sendJavaMailAfterExecution();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.info("ending sendEmailWithExtentReport");
			try {
				logger.info("starting openAnyFile");
				openAnyFile(getLastModified(System.getProperty("user.dir") + "/TestReport/"));
				logger.info("ending openAnyFile");
			} catch (IOException e) {
				e.printStackTrace();
			}
//			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe /T");
//			Runtime.getRuntime().exec("TASKKILL /F /IM geckodriver.exe /T");		
		}
	}
}
