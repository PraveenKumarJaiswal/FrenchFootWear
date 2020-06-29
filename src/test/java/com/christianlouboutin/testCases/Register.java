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
		logger.info("entered FN");
		rg.lastname.sendKeys(LastName);
		logger.info("entered LN");
		rg.email.sendKeys(email);
		logger.info("entered email");
		rg.cemail.sendKeys(email);
		logger.info("entered conf email");
		rg.address1.sendKeys(addres);
		logger.info("entered address");
		rg.city.sendKeys(city);
		logger.info("entered city");
		rg.postCode.sendKeys(pin);
		logger.info("entered pin");
		select.selectByVisibleText(rg.regionId, "Allier");
		logger.info("entered region id");
		rg.telephone.sendKeys(phone);
		logger.info("entered phone no.");
		rg.Continue.click();
		logger.info("user click on register button");

	}

}
