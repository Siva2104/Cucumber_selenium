package example;

import org.openqa.selenium.WebDriver;

import baseTest.chrome_setup;
import io.cucumber.java.en.*;
import pom_pages.tut_4_PageFactory;

public class tut_4_pageFactory extends chrome_setup {
	WebDriver driver;
	tut_4_PageFactory  pf; // create a object
	
	@Given("Login in to new application")
	public void login_in_to_new_application() {
	   System.out.println("welcome");
	}

	@When("Enter  valid the Login username and login password")
	public void enter_valid_the_login_username_and_login_password() {
		pf = new tut_4_PageFactory(driver);
	    pf.login_name("standard_user");
	    pf.password("secret_sauce");
	}

	@When("Click the Login")
	public void click_the_login() {
		pf = new tut_4_PageFactory(driver);
	   pf.click_the_login();
	}

	@Then("Confirmation of Launch of application")
	public void confirmation_of_launch_of_application() {
	    
	}




}
