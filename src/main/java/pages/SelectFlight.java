package pages;

import org.openqa.selenium.By;

import utils.CommonWrappers;
import utils.ConfigManifest;

/*
 * This class is design to test the Select flight page 
 */
public class SelectFlight {
	
	static By outFlight = By.xpath("//input[@name='outFlight']");
	static By inFlight = By.xpath("//input[@name='inFlight']");
	static By reserveFlights = By.xpath("//input[@name='reserveFlights']");
	
	static CommonWrappers action = new CommonWrappers();
	
	public static void selectserviceClass() {
		action.clickAction(outFlight, ConfigManifest.driver);
	}
	
	public static void selectAirline() {
		action.clickAction(inFlight, ConfigManifest.driver);
	}

	public static void selectFindFlights() {
		action.clickAction(reserveFlights, ConfigManifest.driver);
	}
	
	public static void selectFlightTest() {
		selectserviceClass();
		selectAirline();
		selectFindFlights();
	}
}