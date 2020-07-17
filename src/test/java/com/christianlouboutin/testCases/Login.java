package com.christianlouboutin.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Menu;
import com.christianlouboutin.pageObjects.Registration;
import com.christianlouboutin.utilities.XLUtils;

public class Login extends BaseClass {

	Registration rg;
    Menu menu;
    
	@BeforeClass
	public void init() throws IOException {

		rg = new Registration();
        menu = new Menu();
		
	}

	@Test(dataProvider = "LoginData")
	public void login(String userMail, String password) {

		js.click(rg.openLogin);
		logger.info("Clicked on Open Login");
		rg.loginEmail.sendKeys(userMail);
		logger.info("Entered Email "+userMail);
		rg.loginPassword.sendKeys(password);
		logger.info("Entered Password "+password);
		rg.verifyLogin.click();
		logger.info("Clicked on Verify Login");
	

	}
	
	@DataProvider(name = "LoginData")
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
