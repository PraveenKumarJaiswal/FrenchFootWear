package com.christianlouboutin.pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.christianlouboutin.helper.*;
import com.christianlouboutin.utilities.*;

/**
 * Base Class for Initial setup Before starting Test.
 */

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String org = readconfig.getOrganization();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static JavaScriptExecute js;
	public static SelectHelper select;
	public static DynamicName name;
	public static ActionHelper action;
	public static WebDriverWait wait;
	public static DataSource dataSource;
	public static Logger logger;

	/**
	 * 
	 * Setup method for initialize driver and common utilities.
	 * 
	 * @param br      {@link String} browser name.
	 * @param context {@link ITestContext}
	 */
	@Parameters("browser")
	@BeforeSuite
	public void setup(String br, ITestContext context) {
		System.out.println("In @BeforeSuite");
		logger = Logger.getLogger("messageStudio");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.acceptInsecureCerts();
			ChromeOptions co = new ChromeOptions();
			co.setPageLoadStrategy(PageLoadStrategy.EAGER);
			co.merge(capabilities);
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		context.setAttribute("WebDriver", driver);
		js = new JavaScriptExecute(driver);
		action = new ActionHelper(driver);
		select = new SelectHelper();
		wait = new WebDriverWait(driver, 30);
		dataSource = new DataSource();

	}

	/**
	 * Close Browser After Completing the test.
	 */
	@AfterSuite
	public void tearDown() {
		// driver.quit();
	}

}
