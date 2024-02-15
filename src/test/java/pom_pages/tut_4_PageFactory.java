package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;

public class tut_4_PageFactory {

	protected WebDriver driver;
	@FindBy(id = "user-name")
	public WebElement login;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(id = "login-button")
	public WebElement login_btn;
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div")
	public WebElement logo;

	public tut_4_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void login_in_to_new_application() throws InterruptedException {
	/**	System.setProperty("webdriver.edge.driver",
				"C:\\BFSI_test\\automation\\selenium_automation_Browsers\\edgedriver_win64\\msedgedriver.exe\\");
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize(); **/
		System.out.println("Lauching Browser");
		Thread.sleep(3000);

	}

	
	public void login_name(String str) {
		login.sendKeys(str);
	}

	public void password(String input) {
	password.sendKeys(input);
	}

	public void click_the_login() {
		login_btn.click();
	}
	public void confirmation_of_launch_of_application() {

	/**	if (logo.isDisplayed()) {
			System.out.println("done");
		} else {
			System.out.println("NOT done");
		} **/
		System.out.println("logged in ");
	}
}
