package com.christianlouboutin.helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.utilities.XLUtils;

public class DataSource {

	public String[][] getshoppingData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/christianlouboutin/testData/christianlouboutin.xlsx";

		int rowcount = XLUtils.getRowCount(path, "Product details");
		int colcount = XLUtils.getCellCount(path, "Product details", 1);
		String shoppingData[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				shoppingData[i - 1][j] = XLUtils.getCellData(path, "Product details", i, j);

			}
		}

		return shoppingData;
	}

//	@Test(dataProvider= "ProductDataDetails")
//	public void data(String a, String b) {
//		
//		System.out.println(a);
//		System.out.println(b);
////		System.out.println(c);
////		System.out.println(d);
////		System.out.println(e);
////		System.out.println(f);
////		System.out.println(g);
//		
//	}

	public String[][] getRegistrationData() throws IOException {

		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/christianlouboutin/testData/christianlouboutin.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Registration");
		int colcount = XLUtils.getCellCount(path, "Registration", 1);

		System.out.println("rowcount: " + rowcount + " colcount: " + colcount);
		String registrationData[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				registrationData[i - 1][j] = XLUtils.getCellData(path, "Registration", i, j);

			}
		}

		return registrationData;
	}

	// @DataProvider(name = "ProductDataDetails")
	public String[][] getLoginData() throws IOException {

		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/christianlouboutin/testData/christianlouboutin.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Login");
		int colcount = XLUtils.getCellCount(path, "Login", 1);
		System.out.println("rowcount: " + rowcount + " colcount: " + colcount);
		String LoginData[][] = new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				LoginData[i - 1][j] = XLUtils.getCellData(path, "Login", i, j);

			}
		}

		return LoginData;
	}
}
