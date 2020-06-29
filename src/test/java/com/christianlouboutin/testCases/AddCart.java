package com.christianlouboutin.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Menu;

public class AddCart extends BaseClass {

	Menu menu;
	Login lg;

	@BeforeClass
	@DataProvider(name = "ProductDataDetails")
	public String[][] init() throws IOException {
		menu = new Menu();
		return dataSource.getshoppingData();

	}

	@Test(dataProvider = "ProductDataDetails", priority = 0)
	public void addToCart(String mainmenu, String subMenu, String pid, String description, String size)
			throws InterruptedException {

		menu.selectMenu(mainmenu);
		menu.selectSubMenu(subMenu);
		menu.selectProduct(pid, description);
		System.out.println(menu.addToCart.isDisplayed());
		js.scrollTilElement(menu.retour);
		System.out.println(menu.addToCart.isDisplayed());
		menu.selectSize(size);
		js.click(menu.addToCart);
		// menu.home.click();

	}

	@Test

	public void checkOut() throws InterruptedException {

		// menu.cart.click();
		js.click(menu.closeAsk);
		// menu.closeAsk.click();
		// Thread.sleep(2000);
		// menu.checkout.click();
		js.click(menu.checkout);
		menu.acceptCookies.click();
		// js.scrollTilElement(menu.payment);
		js.click(menu.payment);
		// menu.Continue.click();

	}
}
