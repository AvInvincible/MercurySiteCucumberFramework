package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.ResourcePathHelper;

public class ChromeBrowser {

	public ChromeOptions getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		return option;
	}

	public WebDriver getChromeDriver(ChromeOptions ops) {
		if (System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.chrome.driver", ResourcePathHelper.getResourcePath("\\src\\main\\resources\\driver\\chromedriver"));
			return new ChromeDriver(ops);
		}
		else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.chrome.driver", ResourcePathHelper.getResourcePath("\\src\\main\\resources\\driver\\chromedriver.exe"));
			return new ChromeDriver(ops);
		}
		return null;
	}
}
