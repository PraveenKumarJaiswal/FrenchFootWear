package com.christianlouboutin.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BaseClass {

	public Registration() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * login-email {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='login-email']")
	public WebElement loginEmail;

	/**
	 * login-password {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='login-password']")
	public WebElement loginPassword;

	/**
	 * Open Login {@link WebElement}
	 */
	@FindBy(xpath = "//button[@data-trigger='authentication']")
	public WebElement openLogin;

	/**
	 * Verify Login {@link WebElement}
	 */
	@FindBy(xpath = "//button[@class='action action-login secondary']")
	public WebElement verifyLogin;
	
	
	
	/**
	 * Select Prefix {@link WebElement}
	 */
	@FindBy(xpath = "//select[@id='billing:prefix']")

	public WebElement selectPrfix;

	/**
	 * Input First Name {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:firstname']")

	public WebElement firstname;

	/**
	 * Input Last Name {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:lastname']")

	public WebElement lastname;

	/**
	 * Input Email {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:email']")

	public WebElement email;

	/**
	 * Input confirm Email {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:cemail']")

	public WebElement cemail;

	/**
	 * Input Address Line One {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:street1']")

	public WebElement address1;

	/**
	 * Input Address Line Two {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:street2']")

	public WebElement address2;

	/**
	 * Input Billing City {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:city']")

	public WebElement city;

	/**
	 * Input Post Code {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:postcode']")

	public WebElement postCode;

	/**
	 * Select Country {@link WebElement}
	 */
	@FindBy(xpath = "//select[@id='billing:country_id']")

	public WebElement country;

	/**
	 * Select Region Id {@link WebElement}
	 */
	@FindBy(xpath = "//select[@id='billing:region_id']")

	public WebElement regionId;

	/**
	 * input Telephone {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:telephone']")

	public WebElement telephone;

	/**
	 * input Secondary Telephone {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:contact_telephone']")

	public WebElement SecondaTelephone;

	/**
	 * input Password {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:customer_password']")

	public WebElement password;

	/**
	 * input Confirm Password {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:confirm_password']")

	public WebElement confirmPassword;

	/**
	 * input Radio button {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:use_for_shipping_yes']")

	public WebElement shipping;

	/**
	 * input Radio button Send to a different address {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:use_for_shipping_no']")

	public WebElement shippingNo;

	/**
	 * input PERSONALIZE YOUR GIFT WITH A MESSAGE {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='allow_gift_messages']")

	public WebElement gift;

	/**
	 * input Continue {@link WebElement}
	 */
	@FindBy(xpath = "//button[@onclick='billing.save()']//span[contains(text(),'Continuer')]")

	public WebElement Continue;

}
