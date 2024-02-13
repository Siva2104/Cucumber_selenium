package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class tut_3 extends AbstractTestNGCucumberTests {
	protected WebDriver driver;
	@Given("Browser open")
	public void Browser_open() throws InterruptedException {
		System.out.println("AKB 3.0");
	}
	
	@Given("Login page")
	public void login_page() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\BFSI_test\\automation\\selenium_automation_Browsers\\edgedriver_win64\\msedgedriver.exe\\");
	  	driver = new EdgeDriver();
		driver.get("https://10.11.144.178:8111");
		driver.manage().window().maximize(); Thread.sleep(3000);	
	}

	@When("User enter the username and password")
	public void user_enter_the_username_and_password() {
		// locator
		By login = By.id("eud");
		By Password = By.id("epd");
		// Actions
		driver.findElement(login).sendKeys("1999002");
		driver.findElement(Password).sendKeys("Tcs#1234");

	}

	@Then("click the enter")
	public void click_the_enter() {
		By login_btn = By.id("login");
		WebElement login_bt = driver.findElement(login_btn);
		login_bt.click();

	}
}
