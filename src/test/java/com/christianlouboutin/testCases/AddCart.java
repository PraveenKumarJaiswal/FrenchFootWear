package com.christianlouboutin.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.christianlouboutin.pageObjects.BaseClass;
import com.christianlouboutin.pageObjects.Menu;
import com.christianlouboutin.utilities.XLUtils;
import com.mongodb.diagnostics.logging.Logger;

public class AddCart extends BaseClass {

	Menu menu;
	Login lg;
	XLUtils util = new XLUtils();
	
	
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
		logger.info("menu selected: "+menu);
		//util.closeLocationPopUp();
		//Thread.sleep(3000);
		menu.selectSubMenu(subMenu);
		logger.info("sub menu selected: "+subMenu);
		menu.selectProduct(pid, description);
		logger.info("producted selected: "+pid+ "and "+description);
		
		logger.info("Lets wait for location popup");
		//util.closeLocationPopUp();
			
		System.out.println(menu.addToCart.isDisplayed());
		js.scrollTilElement(menu.retour);
		
		System.out.println(menu.addToCart.isDisplayed());
		//Thread.sleep(2000);
		menu.selectSize(size);
		logger.info("Selecting size:"+size);
		//Thread.sleep(2000);
		js.click(menu.addToCart);
		logger.info("clicking on add to cart button");
		// menu.home.click();

	}

	@Test

	public void checkOut() throws InterruptedException {

		// menu.cart.click();
		
		try {
			menu.acceptCookies.click();
			js.click(menu.closeAsk);

		} catch (Exception e) {
			
		}
		
		
		// menu.closeAsk.click();
		// //Thread.sleep(2000);
		// menu.checkout.click();
		js.click(menu.checkout);
		//menu.acceptCookies.click();
		// js.scrollTilElement(menu.payment);
		js.click(menu.payment);
		// menu.Continue.click();

	}
}
