package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import baseTest.chrome_setup;
import io.cucumber.java.en.*;
import pom_pages.tut_5;

public class tut_5_TestFile extends chrome_setup {

	tut_5 t = new tut_5(driver);  //object creation
	
	@Given("chrome lanch")
	public void chrome_lanch() {
		 System.out.println("welcome" );  
	}

	@When("welcome")
	public void welcome() {
	 System.out.println("welcome" );   
	}

	@Then("Login click")
	public void login_click() {
		
		t.login();
	   
	}

	@Then("username and password")
	public void username_and_password() {
	   t.enterUsername("sss");
	   t.enterPassword("sss");
	   
	}

	@Then("Submit")
	public void submit() {
		t.remember_checkBox();
	    t.submit();
	}
	@Then("cls")
	public void cls() {
	    t.clse();
	}


	
}
