package baseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class chrome_setup {
	protected WebDriver driver;
	protected WebDriverWait wait;
	public chrome_setup() {
//		System.setProperty("webdriver.edge.driver", "C:\\BFSI_test\\automation\\selenium_automation_Browsers\\edgedriver_win64\\msedgedriver.exe\\");
//		driver = new EdgeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\1925566\\Downloads\\selenium_automation_Browsers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("https://shiftsync.tricentis.com/");  //https://www.saucedemo.com/v1/ //https://shiftsync.tricentis.com/
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		
	}
}