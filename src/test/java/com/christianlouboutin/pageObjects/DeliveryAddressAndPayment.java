package com.christianlouboutin.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAddressAndPayment extends BaseClass {

	public DeliveryAddressAndPayment() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Select Prefix {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.prefix']//select[@name='prefix']")

	public WebElement selectPrfix;

	/**
	 * Input First Name {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.firstname']//input[@name='firstname']")

	public WebElement firstname;

	/**
	 * Input Last Name {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.prefix']//select[@name='prefix']")

	public WebElement lastname;

	/**
	 * Input Email {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:email']")

	public WebElement email;

	/**
	 * Input Address Line One {@link WebElement}
	 */
	@FindBy(xpath = "//div[@class='control _with-tooltip']//input[@name='street[0]']")

	public WebElement address1;

	/**
	 * Input Address Line Two {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='billing:street2']")

	public WebElement address2;

	/**
	 * Input Billing City {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.city']//input[@name='city']")

	public WebElement city;

	/**
	 * Input Post Code {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.postcode']//input[@name='postcode']")

	public WebElement postCode;

	/**
	 * Select Country {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.postcode']//input[@name='postcode']")

	public WebElement country;

	/**
	 * Select Region Id {@link WebElement}
	 */
	@FindBy(xpath = "//select[@id='billing:region_id']")

	public WebElement regionId;

	/**
	 * input Telephone {@link WebElement}
	 */
	@FindBy(xpath = "//div[@name='shippingAddress.telephone']//input[@name='telephone']")

	public WebElement telephone;

	/**
	 * input Radio Delivery methods UPS Standard: Delivery within 3 to 4 working
	 * days following acceptance of your order {@link WebElement}
	 */
	@FindBy(xpath = "//input[@name='ko_unique_1']")

	public WebElement UPS_Standard;

	/**
	 * input Radio Delivery methods UPS Express before 10:30 am: Next day delivery
	 * before 10:30 am (Mon-Fri).{@link WebElement}
	 */
	@FindBy(xpath = "//td//input[@name='ko_unique_2']")

	public WebElement UPS_Express;

	/**
	 * input Radio Delivery methods UPS Express Saver: Next day delivery
	 * (Mon-Fri).{@link WebElement}
	 */
	@FindBy(xpath = "//input[@name='ko_unique_3']")

	public WebElement UPS_ExpressSaver;

	/**
	 * Suivant(Following).{@link WebElement}
	 */
	@FindBy(xpath = "//button[@class='button action continue primary']")

	public WebElement Suivant;

	/**
	 * Radio button Check / Money order {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='checkmo']//input[@id='checkmo']")

	public WebElement checkAndMoney;

	/**
	 * Radio button Credit card {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='adyen_cc']")

	public WebElement credit;

	/**
	 * Radio button paypal {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='paypal']")

	public WebElement paypal;
	
	/**
	 * Input card Number {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='encryptedCardNumber']")

	public WebElement cardNumber;
	
	/**
	 * Input Encrypted Expiry Date {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='encryptedExpiryDate']")

	public WebElement CardExpiryDate;
	
	
	/**
	 * Input CVV Code {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='encryptedSecurityCode']")

	public WebElement CVVcode;
	
	
	/**
	 * Input cardHolderName {@link WebElement}
	 */
	@FindBy(xpath = "//input[contains(@placeholder,'J. Smith')]")

	public WebElement cardHolderName;
	
	/**
	 * accept the general conditions of sale Check Box  {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='agreement_adyen_cc_6']")

	public WebElement checkBox1;
	

	/**
	 * accept the return conditions Check Box {@link WebElement}
	 */
	@FindBy(xpath = "//input[@id='agreement_adyen_cc_60']")

	public WebElement checkBox2;
	
	/**
	 *Place Order Button {@link WebElement}
	 */
	@FindBy(xpath = "//div[@class='payment-method _active']//button[@class='action primary checkout']")

	public WebElement placeOrder;
	
	
	
}
