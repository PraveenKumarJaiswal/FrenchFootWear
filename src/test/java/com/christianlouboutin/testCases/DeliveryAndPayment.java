package com.christianlouboutin.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.DeliveryAddressAndPayment;

import com.christianlouboutin.utilities.XLUtils;

public class DeliveryAndPayment extends BaseClass {

	DeliveryAddressAndPayment dlp;
	Robot robot;

	@BeforeClass

	public void init() throws IOException, AWTException {

		dlp = new DeliveryAddressAndPayment();
		robot = new Robot();
	}

//	@Test(dataProvider = "RegistrationData")
//	public void deliveryAddress(String firstName, String LastName, String email, String addres, String city, String pin,
//			String phone) {
//
//	}

	@Test(dataProvider = "CardDetails")

	public void payment(String cardnumber, String cardExpMonth, String cardExpYear, String cvv, String cardHolderName)
			throws InterruptedException {
		js.click(dlp.credit);
		logger.info("Clicked credit card Radio button");
		Thread.sleep(5000);
		driver.switchTo().frame(0);

		dlp.cardNumber.sendKeys(cardnumber);
		logger.info("Entered Card number " + cardnumber);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);

		// dlp.CardExpiryDate.sendKeys(cardExpDate);
		logger.info("Entered Card Expiry Date " + cardExpMonth);
		dlp.CardExpiryDate.sendKeys(cardExpMonth + cardExpYear);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);

		// js.sendKeys(cardExpMonth,
		// driver.findElement(By.xpath("//input[@id='expiryMonth']")));
		logger.info("Entered Card Expiry Date " + cardExpMonth);
		// js.sendKeys(cardExpYear,
		// driver.findElement(By.xpath("//input[@id='expiryYear']")));

		dlp.CVVcode.sendKeys(cvv);
		logger.info("Entered CVV " + cvv);

		/*
		 * dlp.cardNumber.sendKeys(Keys.TAB); robot.keyPress(KeyEvent.VK_ENTER);
		 */
		driver.switchTo().defaultContent();
		dlp.cardHolderName.sendKeys(cardHolderName);
		logger.info("Entered card holder Name " + cardHolderName);
		dlp.checkBox1.click();
		logger.info("Clicked on checkBox One");
		dlp.checkBox2.click();
		logger.info("Clicked on checkBox two");
		dlp.placeOrder.click();
		logger.info("Clicked on place order");
	}

	@DataProvider(name = "RegistrationData")
	public String[][] getRegistrationData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/christianlouboutin/testData/christianlouboutin.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Registration");
		int colcount = XLUtils.getCellCount(path, "Registration", 1);
		String registrationData[][] = new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				registrationData[i - 1][j] = XLUtils.getCellData(path, "Registration", i, j);
			}
		}
		return registrationData;
	}

	@DataProvider(name = "CardDetails")
	public String[][] getCardDetails() throws IOException {

		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/christianlouboutin/testData/christianlouboutin.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Payment info");
		int colcount = XLUtils.getCellCount(path, "Payment info", 1);
		String registrationData[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				registrationData[i - 1][j] = XLUtils.getCellData(path, "Payment info", i, j);

			}
		}

		return registrationData;
	}

}
