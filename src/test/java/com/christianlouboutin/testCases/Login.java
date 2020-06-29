package com.christianlouboutin.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Menu;
import com.christianlouboutin.pageObjects.Registration;

public class Login extends BaseClass {

	Registration rg;
    Menu menu;
	@BeforeClass
	@DataProvider(name = "LoginData")
	public String[][] init() throws IOException {

		rg = new Registration();
        menu = new Menu();
		return dataSource.getLoginData();
	}

	@Test(dataProvider = "LoginData")
	public void login(String userMail, String password) {

		rg.loginEmail.sendKeys(userMail);
		logger.info("enter username");
		rg.loginPassword.sendKeys(password);
		logger.info("Enter password");
		rg.verifyLogin.click();
		logger.info("lick login button");
		menu.Continue.click();
		logger.info("click continue button");

	}
	
	
}
