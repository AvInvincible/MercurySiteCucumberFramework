package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import browser.ChromeBrowser;
import browser.FireFoxBroswer;
import browser.SupportedBrowser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.logger.LoggerHelper;

/* Created on 10 Oct, 2017, Author- Ajit Vijayee Yadav, This class file 
 * Initialize the browser driver
 */
public class ConfigManifest {
	
	private final Logger log = LoggerHelper.getLogger(ConfigManifest.class);
	
	public static WebDriver driver;
	
	
	public static WebDriver getBrowserHandle(SupportedBrowser type) {
		
		try {
			
			switch(type) {
				case Chrome:
					ChromeBrowser chrome = ChromeBrowser.class.newInstance();
					return chrome.getChromeDriver(chrome.getChromeCapabilities());
					
				case FireFox:
					FireFoxBroswer firefox = FireFoxBroswer.class.newInstance();
					return firefox.getFireFoxDriver();
				
				default:
					System.out.print("AJ3"+type);
					System.out.println("Some thing went wrong!");
				}
			} 
			catch (InstantiationException e) { e.printStackTrace();} 
			catch (IllegalAccessException e) { e.printStackTrace(); }
		
		return null;
	}
	
	public void setUpDriver(SupportedBrowser type) throws Exception {
		driver = getBrowserHandle(type);
		driver.manage().window().maximize();
	}
	
	@Before()
	public void before(){
		PropertiesReader reader = new PropertiesReader();
		try {
			setUpDriver(reader.getBrowser());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After()
	public void after(){
		driver.quit();
	}

}
