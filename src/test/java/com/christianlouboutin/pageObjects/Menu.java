package com.christianlouboutin.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu extends BaseClass {

	public Menu() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='header-logo-minimal']//img")

	public WebElement home;

	@FindBy(xpath = "//button[@id='product-addtocart-button']")

	public WebElement addToCart;

	/**
	 * Accept Cookies {@link WebElement}
	 * 
	 */

	@FindBy(xpath = "//input[@id='consentAllowAllCookies']")

	public WebElement acceptCookies;

	/**
	 * Retour {@link WebElement}
	 * 
	 */

	@FindBy(xpath = "//a[@href=\"#product.info.returns\" and contains(text(),'Retour')]")

	public WebElement retour;

	/**
	 * cart {@link WebElement}
	 * 
	 */

	@FindBy(xpath = "//a[@class='opt icon-i81 icon-bag bag-counter']")

	public WebElement cart;

	/**
	 * checkout {@link WebElement}
	 * 
	 */

	@FindBy(xpath = "//button[text()='Commander']")

	public WebElement checkout;

	/**
	 * continue to payment {@link WebElement}
	 * 
	 */

	@FindBy(xpath = "//span[text()='Continuer le paiement']")

	public WebElement payment;

	@FindBy(xpath = "//span[contains(text(),'Mettre à jour le panier')]")
	public WebElement refreshSignForScroll;

	@FindBy(xpath = "//button[@class='btn btn-main-action button']//span[text()='Continuer']")

	public WebElement Continue;

	/**
	 * close Asking notification {@link WebElement}
	 * 
	 */

	@FindBy(xpath = "//aside[@class='modal-popup popup-newsletter                modal-slide                _inner-scroll _show']//button[@data-role='closeBtn']")

	public WebElement closeAsk;

	
	public void selectProduct(String pid, String description) throws Throwable {
		Thread.sleep(3000);
		js.click(driver.findElement(
				By.xpath("//li[@data-product-id='" + pid + "']//a[contains(text(),'" + description + "')]")));

	}

	
	public void selectMenu(String mainMenu) throws Throwable {
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath(
				"//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']//following-sibling::span[contains(text(),'"
						+ mainMenu + "')]")));

	}


	public void selectSubMenu(String SubMenu) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='" + SubMenu + "']")).click();

	}


	public void selectSize(String size) throws Throwable {
		Thread.sleep(3000);
		js.click(driver.findElement(By.xpath("//li[@class='in-stock' and contains(text(),'" + size + "')]")));
		// driver.findElement(By.xpath("//li[@class='attribute-option']//a[contains(text(),'"
		// + size + "')]")).click();;

	}

}
