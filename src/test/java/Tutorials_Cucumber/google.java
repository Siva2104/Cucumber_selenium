package Tutorials_Cucumber;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



@SuppressWarnings("unused")
public class google {
	
	protected WebDriver driver;
	
	@Given("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.edge.driver", "C:\\BFSI_test\\automation\\selenium_automation_Browsers\\edgedriver_win64\\msedgedriver.exe\\");
	  	driver = new EdgeDriver();
	  	driver.navigate().to("www.google.com");
		   driver.manage().window().maximize();
	}

	

	@When("user enter google site")
	public void user_enter_google_site() {
	    System.out.println("google");
	    driver.findElement(By.name("q")).sendKeys("Automation step by step");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}



	@Then("user is navigated to google page")
	public void user_is_navigated_to_google_page() {
	    driver.getPageSource().contains("Online Courses");
	}
	

}
