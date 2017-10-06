package propertiesReaderInterface;

import browser.SupportedBrowser;

/* Interface for all the key-value pair defined in .properties files */
public interface ConfigReader {
	public String readData(String x);
	public SupportedBrowser getBrowser(); 
}
