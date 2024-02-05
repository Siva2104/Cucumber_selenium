package Tutorials_Cucumber;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("unused")
public class tut1 {
	
	protected WebDriver driver  ;
		
	
	 @Given("user is on login page")
	 public void user_is_on_login_page() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\BFSI_test\\automation\\selenium_automation_Browsers\\edgedriver_win64\\msedgedriver.exe\\");
	  	driver = new EdgeDriver();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		System.out.println("Lauching Browser");		Thread.sleep(3000);	
		
  }
	 @When("user enter login and  password")
	 public void user_enter_login_and_password() {
	  
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		By login = By.id("user-name");
//		By Password = By.id("password");
//		driver.findElement(login).sendKeys("standard_user");
//		driver.findElement(Password).sendKeys("secret_sauce");
	}
	
	 @When("click login button")
	 public void click_login_button() {
		
		driver.findElement(By.id("login-button")).click();;
		
//		By button = By.id("login-button");
//		driver.findElement(button).click();
	}
	@Then("Login to the application and navigated to Homepage")
	public void login_to_the_application_and_navigated_to_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    System.err.println("login");;
	}
	
	

}
	






