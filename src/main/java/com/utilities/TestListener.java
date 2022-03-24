package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.configuration.Base;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Extent Reports Version 5 Test Suite started!");
	}
	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Extent Reports Version 5  Test Suite is ending!"));
		extent.flush();
	}
	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
		test.get().pass("Test executed in browser:"+Utilities.getBrowser()+" and version:"+Utilities.getVersion());
	}
	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass(result.getMethod().getMethodName()+" passed");
	}
	@Override
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		test.get().fail(result.getThrowable());
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				String imgPath = Utilities.getScreenshot(Base.getDriver(), result.getName());
				byte[] file=FileUtils.readFileToByteArray(new File(imgPath));
				String base64Img=Base64.encodeBase64String(file);
				test.get().addScreenCaptureFromBase64String(base64Img);
//				test.get().addScreenCaptureFromPath(imgPath);	
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}
}
