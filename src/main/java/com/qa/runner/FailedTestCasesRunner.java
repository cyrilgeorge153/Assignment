/**
 * 
 */
package com.qa.runner;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;

/**
 * @author CYRIL
 *
 */
public class FailedTestCasesRunner {
	public static void main(String[] args) {
		TestNG runner = new TestNG();
		List<String> list = new ArrayList<String>();
		list.add(".//test-output//testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
	}
}
