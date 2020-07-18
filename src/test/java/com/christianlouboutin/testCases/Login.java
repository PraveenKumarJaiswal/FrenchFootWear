package com.christianlouboutin.testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.DeliveryAddressAndPayment;
import com.christianlouboutin.pageObjects.Menu;
import com.christianlouboutin.pageObjects.Registration;
import com.christianlouboutin.utilities.XLUtils;

public class Login extends BaseClass {

	Registration rg;
	Menu menu;
	DeliveryAddressAndPayment dlp;

	@BeforeClass
	public void init() throws IOException {

		rg = new Registration();
		menu = new Menu();
		dlp = new DeliveryAddressAndPayment();

	}

	@Test(dataProvider = "LoginData")
	public void login(String userMail, String password) throws InterruptedException {

		js.click(rg.openLogin);
		logger.info("Clicked on Open Login");
		rg.loginEmail.sendKeys(userMail);
		logger.info("Entered Email " + userMail);
		rg.loginPassword.sendKeys(password);
		logger.info("Entered Password " + password);
		rg.verifyLogin.click();
		logger.info("Clicked on Verify Login");
		Thread.sleep(5000);
		js.scrollTilElement(dlp.Suivant);
		wait.until(ExpectedConditions.visibilityOf(dlp.UPS_Express));
		System.out.println(dlp.UPS_Express.isDisplayed());
		// js.clickByXLocation(dlp.UPS_Standard);
		// action.clickOnByOffSet(dlp.UPS_Standard);
		// Thread.sleep(5000);
		// Thread.sleep(10000);
		// wait.until(ExpectedConditions.elementToBeClickable(dlp.UPS_Express));
		// dlp.UPS_Express.click();
		js.click(dlp.UPS_Express);
		logger.info("Clicked on UPS Express");
		js.click(dlp.Suivant);
		// dlp.Suivant.click();
		logger.info("Clicked on Follow(Suivant)");

	}

	@DataProvider(name = "LoginData")
	public String[][] getLoginData() throws IOException {

		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/christianlouboutin/testData/christianlouboutin.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Login");
		int colcount = XLUtils.getCellCount(path, "Login", 1);
		String LoginData[][] = new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				LoginData[i - 1][j] = XLUtils.getCellData(path, "Login", i, j);

			}
		}

		return LoginData;
	}

}
