package browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.ResourcePathHelper;

/* Setting the FireFox capabilities and driver */
public class FireFoxBroswer {

	public Capabilities getFireFoxCapabilities() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		return firefox;
		}
	
	public WebDriver getFireFoxDriver() {
		
		if (System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.gecko.driver", ResourcePathHelper.getResourcePath("\\src\\main\\resources\\driver\\geckodriver.exe"));
			return new FirefoxDriver();
		}
		else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.gecko.driver", ResourcePathHelper.getResourcePath("\\src\\main\\resources\\driver\\geckodriver.exe"));
			return new FirefoxDriver();
		}
		return null;
	}

}
