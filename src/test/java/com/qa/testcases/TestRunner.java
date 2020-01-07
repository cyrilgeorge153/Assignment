/**
 * 
 */
package com.qa.testcases;

import org.testng.TestNG;

/**
 * @author CYRIL
 *
 */
public class TestRunner {
	
	static TestNG testNG;
	public static void main(String[] args) 
	{
		
		testNG=new TestNG();
		testNG.setTestClasses(new Class[] {AdminTest.class});
		testNG.run();
	}

}
