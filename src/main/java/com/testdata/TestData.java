package com.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "loginData")
	public Object[][] testdata() {
		Object[][] data = new Object[2][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "admin";
		data[1][1] = "admin123";
		return data;
	}
	@DataProvider(name = "loginData1")
	public Object[][] valuestoTest() {
		Object[][] values = new Object[][] { { "dsgd", "admin123" }};
		return values;
	}
}
