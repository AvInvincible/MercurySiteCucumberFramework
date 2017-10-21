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
	
	private final static Logger log = LoggerHelper.getLogger(ConfigManifest.class);
	
	public static WebDriver driver;
	
	
	public static WebDriver getBrowserHandle(SupportedBrowser type) {
		
		try {
			
			switch(type) {
				case Chrome:
					log.info("Initilizing Chrome browser");
					ChromeBrowser chrome = ChromeBrowser.class.newInstance();
					return chrome.getChromeDriver(chrome.getChromeCapabilities());
					
				case FireFox:
					log.info("Initilizing FireFox browser");
					FireFoxBroswer firefox = FireFoxBroswer.class.newInstance();
					return firefox.getFireFoxDriver();
				
				default:
					System.out.print("AJ3"+type);
					log.info("Initilizing Problem, Something went wrong");
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
			log.info("Starting Testing");
			setUpDriver(reader.getBrowser());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After()
	public void after(){
		log.info("Testing done, closing the driver");
		driver.quit();
	}

}
