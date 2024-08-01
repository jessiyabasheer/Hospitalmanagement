package testClasses;

import org.testng.annotations.Test;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "unsuccessfull")
	public Object[][] dp() throws IOException {
		return new Object[][] {
				new Object[] { ExcelReadClass.readStringData(1, 4), ExcelReadClass.readStringData(1, 5) },
				new Object[] { ExcelReadClass.readStringData(1, 7), ExcelReadClass.readStringData(1, 8) },
				new Object[] { ExcelReadClass.readStringData(1, 10), ExcelReadClass.readIntegerData(1, 11) }, };
	}
}
