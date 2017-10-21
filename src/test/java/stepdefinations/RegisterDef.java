package stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Registration;

public class RegisterDef {
	
	@Given("^Navigate to mercury site website registration page$")
	public void Navigate_to_mercury_site_website_registration_page() throws Throwable {
	    Registration.loadRegPage();
	}

	@When("^User enters the registration details$")
	public void User_enters_the_registration_details() throws Throwable {
		Registration.registerTest();
	}

	@When("^Click register button$")
	public void Click_register_button() throws Throwable {
		Registration.clickRegister();
	}

	@Then("^User is successfully registered to MercurySite$")
	public void User_is_successfully_registered_to_MercurySite() throws Throwable {
		Registration.regStatus();
	}

}
