package stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SignIn;

public class SignIndef {
	
	@Given("^Navigate to mercury site website$")
	public void Navigate_to_mercury_site_website() throws Throwable {
		SignIn.getMercury();
	}

	@Given("^Click on signin link to navigate to signIn page$")
	public void Click_on_signin_link_to_navigate_to_signIn_page() throws Throwable {
		SignIn.clickSignIn();
	}

	@When("^Input userName and userPassword$")
	public void Input_userName_and_userPassword() throws Throwable {
		SignIn.signInTestValidData();
	}

	@When("^Click submit button$")
	public void Click_submit_button() throws Throwable {
		SignIn.clickSignIn();
	}

	@Then("^User is successfully get logged into MercurySite$")
	public void User_is_successfully_get_logged_into_MercurySite() throws Throwable {
	    SignIn.siginTitle();
	}
}
