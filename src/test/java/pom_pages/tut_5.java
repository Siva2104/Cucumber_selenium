package pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.chrome_setup;

public class tut_5  {

	//https://shiftsync.tricentis.com/
	
	WebDriver driver;

	By login = By.xpath("/html/body/main/div[4]/div/div/section/div/section/ul/a");

	@FindBy(id = "modal_login")WebElement login_popup;	
	By enterUsername = By.id("login_usernameOrEmail");
	By enterPassword = By.id("login_password");
	@FindBy(xpath ="//*[@id=\"login_remember\"]") WebElement remember_checkBox;	
	@FindBy(id = "login_submit")WebElement submit;	
	@FindBy(xpath = "//*[@id=\"modal_login\"]/button")WebElement cls;
	
	
	public tut_5(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void login() {
		
		WebElement logIn = driver.findElement(login);
		logIn.click();
		
	}
	public void enterUsername(String username) {
		WebElement name = driver.findElement(enterUsername); 
		name.sendKeys(username);
	}
	public void enterPassword(String password) {
		WebElement pws_name = driver.findElement(enterPassword); 
		pws_name.sendKeys(password);

	}
	public void remember_checkBox() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click;", remember_checkBox);
	}
	public void submit() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click;", submit);
		//submit.click();
	}
	public void clse() {
		cls.click();
	}
	
}
