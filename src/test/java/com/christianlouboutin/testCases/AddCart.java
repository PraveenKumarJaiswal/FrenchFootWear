package com.christianlouboutin.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Menu;
import com.christianlouboutin.utilities.XLUtils;

public class AddCart extends BaseClass {

	Menu menu;
	Login lg;

	@BeforeClass

	public void init() throws IOException {
		menu = new Menu();

	}

	@Test(dataProvider = "ProductDataDetails", priority = 0)
	public void addToCart(String mainmenu, String subMenu, String pid, String description, String size) {

		menu.selectMenu(mainmenu);
		logger.info("Clicked Main menu " + mainmenu);
		menu.selectSubMenu(subMenu);
		logger.info("Clicked sub menu " + subMenu);
		menu.selectProduct(pid,description);
		logger.info("Selected product with ID " + pid +" And "+description);
	
		
		
		js.scrollTilElement(menu.retour);
		menu.selectSize(size);
		js.click(menu.addToCart);
		try {
			menu.acceptCookies.click();
			menu.closeAsk.click();

		} catch (Exception e) {
			
		}
		
		
		
		// menu.home.click();

	}

	@Test

	public void checkOut() throws InterruptedException {

		// menu.cart.click();
		// menu.closeAsk.click();
		// Thread.sleep(2000);
		// menu.checkout.click();
		js.click(menu.checkout);
		// menu.acceptCookies.click();
		// js.scrollTilElement(menu.payment);
		js.click(menu.payment);
		// menu.Continue.click();

	}

	@DataProvider(name = "ProductDataDetails")
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

}
