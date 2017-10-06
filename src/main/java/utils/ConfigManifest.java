package utils;

import org.openqa.selenium.WebDriver;

import browser.ChromeBrowser;
import browser.FireFoxBroswer;
import browser.SupportedBrowser;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class ConfigManifest {
	
	public static WebDriver driver;
	
	public static WebDriver getBrowserHandle(SupportedBrowser type) {
		
		try {
			
			switch(type) {
				case Chrome:
					ChromeBrowser chrome = ChromeBrowser.class.newInstance();
					return chrome.getChromeDriver();
					
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
