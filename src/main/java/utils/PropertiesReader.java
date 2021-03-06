package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import browser.SupportedBrowser;
import propertiesReaderInterface.ConfigReader;

/* Read the data from the config properties file */
public class PropertiesReader implements ConfigReader {

	private Properties prop = null;

	public PropertiesReader() {
		prop = new Properties();
		try {
			prop.load(ResourcePathHelper.getFileInputStream("\\src\\main\\resources\\testData\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Method to return value */
	public String readData(String x) {
		String data = prop.getProperty(x);
		return data;
	}

	/* Method to return value */
	public String readConfigData(String x) {
		String data = null;
		try {
			if (System.getProperty("buildWithBuildTool").equalsIgnoreCase("true")) {
				data = System.getProperty(x);
			}
		} catch (Exception e) {
			data = prop.getProperty(x);
		}
		return data;
	}

	public SupportedBrowser getBrowser() {
		SupportedBrowser data = null;
		try {
			if (System.getProperty("buildWithBuildTool").equalsIgnoreCase("true")) {
				data = SupportedBrowser.valueOf(System.getProperty("browserTorunOn"));
			}
		} catch (Exception e) {
			data = SupportedBrowser.valueOf(prop.getProperty("browserTorunOn"));
		}
		return data;
	}

	public static void main(String args[]) {
		PropertiesReader read = new PropertiesReader();
		read.getBrowser();
	}

}
