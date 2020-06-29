package com.christianlouboutin.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Registration;

public class Register extends BaseClass {

	Registration rg;

	@BeforeClass
	@DataProvider(name = "RegistrationData")
	public String[][] init() throws IOException {

		rg = new Registration();

		return dataSource.getRegistrationData();

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

}
