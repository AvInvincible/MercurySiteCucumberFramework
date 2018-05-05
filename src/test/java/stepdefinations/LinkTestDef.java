package stepdefinations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.ConfigManifest;

public class LinkTestDef {

	private WebDriver eDriver;

	/**
	 * Access the home page.
	 *
	 * @return the link test def
	 */
	@Given("^I access the home page$")
	public void accessTheHomePage() {
		this.eDriver = ConfigManifest.driver;
		eDriver.get("http://newtours.demoaut.com/");
		//return this;
	}

	/**
	 * Gets the all the link on the page.
	 *
	 * @return the all the link on the page
	 */
	@Then("^I get all the link on accessed page and verify the links$")
	public LinkTestDef verifyAllTheLinks() {
		this.eDriver = ConfigManifest.driver;
		String url;
		HttpURLConnection httpUrlCon = null;
		int respCode = 200;

		List<WebElement> links = eDriver.findElements(By.tagName("a"));

		Iterator<WebElement> itr = links.iterator();

		while (itr.hasNext()) {
			url = itr.next().getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println(url + ":URL is either not configured for anchor tag or it is empty");
				continue;
			}
			try {
				httpUrlCon = (HttpURLConnection) (new URL(url).openConnection());

				httpUrlCon.setRequestMethod("HEAD");

				httpUrlCon.connect();

				respCode = httpUrlCon.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return this;
	}
}
