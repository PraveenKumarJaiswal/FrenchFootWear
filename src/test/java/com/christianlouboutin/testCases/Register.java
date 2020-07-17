package com.christianlouboutin.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Registration;
import com.christianlouboutin.utilities.XLUtils;

public class Register extends BaseClass {

	Registration rg;

	@BeforeClass

	public void init() throws IOException {

		rg = new Registration();

	}

	@Test(dataProvider = "RegistrationData")
	public void register(String firstName, String LastName, String email, String addres, String city, String pin,
			String phone) {

		rg.firstname.sendKeys(firstName);
		rg.lastname.sendKeys(LastName);
		rg.email.sendKeys(email);
		rg.cemail.sendKeys(email);
		rg.address1.sendKeys(addres);
		rg.city.sendKeys(city);
		rg.postCode.sendKeys(pin);
		select.selectByVisibleText(rg.regionId, "Allier");
		rg.telephone.sendKeys(phone);
		rg.Continue.click();

	}

	@DataProvider(name = "RegistrationData")
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
}
