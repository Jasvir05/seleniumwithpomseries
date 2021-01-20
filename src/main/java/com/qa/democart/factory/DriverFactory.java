package com.qa.democart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class DriverFactory {
	public WebDriver driver;

	/**
	 * 
	 * @param browserName
	 * @return this returns WebDriver reference on the basis of given browser
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is : " + browserName);

		switch (browserName.trim()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Please pass the correct browser name : " + browserName);
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		return driver;
	}
	
	/**
	 * This method will initialize the properties from config.properties file
	 * @return prop
	 */
	public Properties init_prop() {
		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	

}