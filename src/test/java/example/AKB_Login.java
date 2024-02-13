package example;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SuppressWarnings("unused")
public class AKB_Login {

	WebDriver driver;

	@Given("Lauching the Browser")
	public void browser() throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1925566\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://10.11.144.178:8111");
		driver.manage().window().maximize();
		System.out.println("Lauching Browser");
		System.out.println("Test case :TC0001");
		//ScreenshotClass.login_module(driver, "browser","TC0001");
	}

	@Given("his method validates Sign in")
	public void login() throws IOException, InterruptedException {
		// Verify Login Page

		// Path of the Excel file
		File file = new File("C:\\BFSI_test\\Automation\\AKB_Automtion_Files\\AKB3.0Data.xlsx\\");
		FileInputStream input = new FileInputStream(file);
		// Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		// Getting the sheet
		XSSFSheet sheet = workbook.getSheet("Login");
		XSSFSheet sheet1 = workbook.getSheet("SignUp");
		// Count the number of rows
		// int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		FileOutputStream outputStream = new FileOutputStream("C:\\BFSI_test\\Automation\\doc_dataentry.xlsx\\");

		// Scenario 1 Sign in without Credentials
		driver.findElement(By.id("login")).click();
		System.out.println("Passed test case: TC0011");
		Thread.sleep(8000);
		// Scenario 1 Screenshot
		System.out.println("Test case : TC0011");
		//ScreenshotClass.login_module(driver, "login","TC0011");

		// Getting error message and printing it in console and excel
		String ErrorMsg = driver.findElement(By.id("msglogin")).getText();
		System.out.println("Scenario 1: Sign in without Credentials");
		System.out.println(ErrorMsg);
		Thread.sleep(8000);
		driver.findElement(By.id("eud")).clear();
		driver.findElement(By.id("epd")).clear();
		sheet.getRow(1).createCell(2).setCellValue(ErrorMsg);

		// Scenario 2
		int username = (int) sheet.getRow(2).getCell(0).getNumericCellValue();
		driver.findElement(By.id("eud")).sendKeys(String.valueOf(username));
		driver.findElement(By.id("login")).click();
		Thread.sleep(8000);

		// Scenario 2 Screenshot
		
		System.out.println("Test case : TC0006");
		//ScreenshotClass.login_module(driver, "login","TC0006");

		// Getting error message and printing it in console and excel
		String ErrorMsg1 = driver.findElement(By.id("msglogin")).getText();
		System.out.println("Scenario 2: Sign in without Password");
		System.out.println(ErrorMsg1);
		sheet.getRow(2).createCell(2).setCellValue(ErrorMsg1);
		driver.findElement(By.id("eud")).clear();
		driver.findElement(By.id("epd")).clear();

		// Scenario 3
		String password = sheet.getRow(3).getCell(1).getStringCellValue();
		driver.findElement(By.id("epd")).sendKeys(String.valueOf(password));
		driver.findElement(By.id("login")).click();
		Thread.sleep(8000);

		System.out.println("Test case : TC0005");
		//ScreenshotClass.login_module(driver,"login", "TC0005");

		// Getting error message and printing it in console and excel
		String ErrorMsg2 = driver.findElement(By.id("msglogin")).getText();
		System.out.println("Scenario 3: Sign in without Username");
		System.out.println(ErrorMsg2);
		Thread.sleep(8000);
		sheet.getRow(3).createCell(2).setCellValue(ErrorMsg2);
		driver.findElement(By.id("eud")).clear();
		driver.findElement(By.id("epd")).clear();

		// Scenario 4
		// Iterate the Username/Password
		for (int i = 4; i <= 10; i++) {
			String username2 = sheet.getRow(i).getCell(0).getStringCellValue();
			String password1 = sheet.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.id("eud")).sendKeys(username2);
			driver.findElement(By.id("epd")).sendKeys(password1);
			driver.findElement(By.id("login")).click();

			Thread.sleep(4000);

			// Getting error message from the application and printing it on the console
			String ErrorMsg3 = driver.findElement(By.id("msglogin")).getText();
			System.out.println("Scenario 4 Invalid Credentials");
			System.out.println(ErrorMsg3);
			Thread.sleep(8000);
			sheet.getRow(i).createCell(2).setCellValue(ErrorMsg3);

			System.out.println("Test case : TC0010");
			//ScreenshotClass.login_module(driver, "login","TC0010");

			driver.findElement(By.id("eud")).clear();
			driver.findElement(By.id("epd")).clear();
		}

		// Scenario 5
		for (int i = 11; i <= 12; i++) {
			int username2 = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
			String password1 = sheet.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.id("eud")).sendKeys(String.valueOf(username2));
			driver.findElement(By.id("epd")).sendKeys(password1);
			driver.findElement(By.id("login")).click();
			Thread.sleep(4000);
			// Getting error message from the application and printing it on the console
			String ErrorMsg4 = driver.findElement(By.id("msglogin")).getText();
			System.out.println("Scenario 5 Invalid Credentials");
			System.out.println(ErrorMsg4);
			Thread.sleep(8000);
			sheet.getRow(i).createCell(2).setCellValue(ErrorMsg4);

			File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile5,
					new File("C:\\BFSI_test\\Automation\\PASS\\Login_module\\" + screenshotFile5.getName() + ".png"));

			driver.findElement(By.id("eud")).clear();
			driver.findElement(By.id("epd")).clear();

		}
		System.out.println("Passed test case:s TC0003-TC0010 - Passed");

		driver.findElement(By.id("eud")).sendKeys(
				"UIiuhiuqhduihqiudhqiudhwqiuhdiuwqehdiueqhdiuehdiuehwdiuewdiuewdiuewfdiuewfdiuewnfiudwenfiuwefiuewfiuhewrihewiurhiuehriuewhriuhewifewjnfkjnfdewjfiewjiewriewijewjfewijfiuewhfiuewhfiuewhiuhewiurhiuewhriuwehriuewhriuewhriuheurhuewhriuewhruwehriuewhiuwehuhewiufhewasmdnskjnjsdiuewriuwehriuhew");
		driver.findElement(By.id("epd")).sendKeys(
				")(!@)(!@)(!)(@HJDJABJBJWAJHWIUDHIUWHIUHIUOIHIUHQUHUIWHQIUHWIUQHWIUHQIUWHIUQHWIUHQIHWIUHQIWHIUQHWIUHQIUWHIUQHWIUHQUIHWIUHQIUWHIUQHWIU@(*(U#*(@U(*(*$)($()%)()(%I)(%)($@(@)@()@)(#)(#($@(()($$()$)()$)()(#)($()$($)($)($)($(($))($()KJJQKDJKJWDNJWJKNEDJWQNKJNDKJWNKJNDJNWJNDJWBNJBDHWBHDBWHJBDBWHJBD");
		driver.findElement(By.id("login")).click();
		System.out.println("Passed test case: TC0012- Passed");
		System.out.println("Test case : TC0012");
		//ScreenshotClass.login_module(driver, "login","TC0012");

		driver.findElement(By.id("eud")).sendKeys("   ");
		driver.findElement(By.id("epd")).sendKeys("   ");
		driver.findElement(By.id("login")).click();
		System.out.println("Passed test case: TC0013- Passed");
		System.out.println("Test case : TC0013");
		//ScreenshotClass.login_module(driver,"login", "TC0013");

		// Click Forgot Password without entering any email id
		driver.findElement(By.id("fgpd")).click();
		// Click Proceed with password Reset
		driver.findElement(By.id("fgpd-confirm")).click();
		// Print error msg in console
		String errmsg = driver.findElement(By.id("msglogin")).getText();
		System.out.println(errmsg);
		System.out.println("Test case : TC0014");
		//ScreenshotClass.login_module(driver,"login", "TC0014");
		System.out.println("Passed test case: TC0014- Passed");
		driver.navigate().refresh();

		// Scenario 6 Entering Valid Credentials using UserId
		int username3 = (int) sheet.getRow(13).getCell(0).getNumericCellValue();
		String password2 = sheet.getRow(13).getCell(1).getStringCellValue();
		Thread.sleep(4000);
		driver.findElement(By.id("eud")).sendKeys(String.valueOf(username3));
		driver.findElement(By.id("epd")).sendKeys(password2);
		driver.findElement(By.id("login")).click();
		System.out.println("Scenario 6: Entering Valid Credentials");
		System.out.println("User logged in successfully");
		System.out.println("Passed test case: TC0002- Passed");
		Thread.sleep(5000);
		sheet.getRow(13).createCell(2).setCellValue("User Logged in Successfully");
		System.out.println("Test case : TC0002");
		//ScreenshotClass.login_module(driver,"login", "TC0002");

		Thread.sleep(4000);
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File(
				"C:\\BFSI_test\\Automation\\PASS\\Login_module\\signout\\TC0615\\" + screenshot1.getName() + ".png"));

		Thread.sleep(4000);
		// Sign Out
		driver.findElement(By.id("signOutBtn")).click();
		Thread.sleep(4000);
		System.out.println("Test case : TC0016");
		//ScreenshotClass.login_module(driver, "login","TC0016");
		// Click Cancel
		// driver.findElement(By.xpath("//*[@id='signOutModal']/div/div/div[3]/button[2]")).click();
		// File screenshot5 =
		// ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(screenshot5, new
		// File("C:\\BFSI_test\\Automation\\PASS\\Login_module\\signout\\TC0618\\"+screenshot5.getName()+".png"));

		// Click Confirm
		driver.findElement(By.id("signOutProceed")).click();
		System.out.println("Test case : TC0617");
		////ScreenshotClass.login_module(driver, "login","TC0617");
		// Getting SignOut Success message and printing it on console
		String SignOutMsg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();
		System.out.println(SignOutMsg);
		// Click "To Sign in again , Click this Link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/a")).click();
		File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Test case : TC0017_1");
		//ScreenshotClass.login_module(driver,"login", "TC0017_1");
		Thread.sleep(3000);
/**
		// Click SignUp
		driver.findElement(By.id("signUp")).click();
		System.out.println("Passed test case: TC0015 and TC0016- Passed");
		System.out.println("Test case : TC0015");
		//ScreenshotClass.login_module(driver, "login","TC0015");
		System.out.println("Test case : TC0016");
		//ScreenshotClass.login_module(driver,"login", "TC0016");
		// Click SignUp Button without entering any fields
		driver.findElement(By.id("sign-up")).click();
		System.out.println("Passed test case: TC0022- Passed");
		System.out.println("Test case : TC0022");
		//ScreenshotClass.login_module(driver, "login","TC0022");

		// Enter invalid values for Sign Up fields
		for (int i = 1; i <= 13; i++) {
			// Get value from excel
			String emailadd = sheet1.getRow(i).getCell(0).getStringCellValue();
			String fusername = sheet1.getRow(i).getCell(1).getStringCellValue();
			String lusername = sheet1.getRow(i).getCell(3).getStringCellValue();
			String title = sheet1.getRow(i).getCell(4).getStringCellValue();
			int logonId = (int) sheet1.getRow(i).getCell(5).getNumericCellValue();
			String pass = sheet1.getRow(i).getCell(6).getStringCellValue();
			String cpass = sheet1.getRow(i).getCell(7).getStringCellValue();
			Thread.sleep(5000);
			driver.findElement(By.id("ud")).sendKeys(emailadd);
			driver.findElement(By.id("fn")).sendKeys(fusername);
			driver.findElement(By.id("ln")).sendKeys(lusername);
			driver.findElement(By.id("utitle")).sendKeys(title);
			driver.findElement(By.id("user-actual-id")).sendKeys(String.valueOf(logonId));
			driver.findElement(By.id("pd")).sendKeys(pass);
			driver.findElement(By.id("pd-again")).sendKeys(cpass);
			// Click Register
			driver.findElement(By.id("register")).click();
			Thread.sleep(5000);
			// Getting error message from the application and printing it on the console and
			// excel
			String ErrorMsg4 = driver.findElement(By.id("msg")).getText();
			System.out.println(ErrorMsg4);
			Thread.sleep(8000);
			sheet1.getRow(i).createCell(9).setCellValue(ErrorMsg4);
			// Take screenshot
			System.out.println("Test case : TC0017");
			//ScreenshotClass.login_module(driver,"login", "TC0017");
			System.out.println("Test case : TC0027");
			//ScreenshotClass.login_module(driver,"login", "TC0027");
			driver.findElement(By.id("ud")).clear();
			driver.findElement(By.id("fn")).clear();
			driver.findElement(By.id("mn")).clear();
			driver.findElement(By.id("ln")).clear();
			driver.findElement(By.id("utitle")).clear();
			driver.findElement(By.id("user-actual-id")).clear();
			driver.findElement(By.id("pd")).clear();
			driver.findElement(By.id("pd-again")).clear();
		}
		System.out.println("Passed test case: TC0017-TC0027 Passed");
		// Closing the excel **/
		
	}

	@When("Sign up")
	public void signUp() throws IOException, InterruptedException {

		driver.findElement(By.id("signUp")).click();		
		System.out.println("Passed test case TC00016 & TC00015");
		//ScreenshotClass.login_module(driver,"signUp", "TC00016 & TC00015");
		driver.findElement(By.id("ud")).sendKeys("siva@tcs.com");
		System.out.println("Passed test case TC00017");
		//ScreenshotClass.login_module(driver, "signUp","TC0017");
		// limit-check
		driver.findElement(By.id("ud")).clear();
		driver.findElement(By.id("ud")).sendKeys(
				"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out.println("Passed test case TC00023");
		//ScreenshotClass.login_module(driver, "signUp","TC00023");
		System.out.println("Passed test case TC00018");
		//ScreenshotClass.login_module(driver, "signUp","TC0018");
		driver.findElement(By.id("ud")).clear();
		driver.findElement(By.id("ud")).sendKeys("siva@tcs.com");

		Thread.sleep(3000);// any name"
		driver.findElement(By.id("fn")).sendKeys("siva");
		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("fn")).sendKeys(
				"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out.println("Passed test case TC00019");
		//ScreenshotClass.login_module(driver, "signUp","TC00019");
		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("fn")).sendKeys("siva");
		Thread.sleep(3000);// any name"
		driver.findElement(By.id("ln")).sendKeys("TCS");
		Thread.sleep(3000);// any name"

		driver.findElement(By.id("utitle")).sendKeys("Author");
		System.out.println("Passed test case TC00018");
		//ScreenshotClass.login_module(driver, "signUp","TC0018");
		driver.findElement(By.id("utitle")).clear();
		driver.findElement(By.id("utitle")).sendKeys(
				"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out.println("Passed test case TC00020");
		//ScreenshotClass.login_module(driver, "signUp","TC0020");
		driver.findElement(By.id("utitle")).clear();
		driver.findElement(By.id("utitle")).sendKeys("Author");

		Thread.sleep(3000);// any name"
		driver.findElement(By.id("pd")).sendKeys("Tcs#1234");
		// pass-limit
		driver.findElement(By.id("pd")).clear();
		driver.findElement(By.id("pd")).sendKeys(
				"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		System.out.println("Passed test case TC00021");
		//ScreenshotClass.login_module(driver, "signUp","TC0021");

		Thread.sleep(3000);// any name"
		driver.findElement(By.id("pd-again")).sendKeys("Tcs#1234");
		driver.findElement(By.id("pd-again")).clear();
		driver.findElement(By.id("pd-again")).sendKeys("Tcs#124");
		System.out.println("Passed test case TC00025");
		//ScreenshotClass.login_module(driver, "signUp","TC0025");
		driver.findElement(By.id("pd-again")).clear();
		driver.findElement(By.id("pd-again")).sendKeys("Tcs#1234");

		Thread.sleep(3000);// any name"
		driver.findElement(By.id("register")).click();
		System.out.println("Passed test case TC00026");
		//ScreenshotClass.login_module(driver, "signUp","TC0026");

		Thread.sleep(3000);

		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000);

		System.out.println("Passed test case TC00024");
		//ScreenshotClass.login_module(driver, "signUp","TC00024");
	}

	@Then("Terminating the Browser for Login module")
	public void Terminate_browser() throws InterruptedException, AWTException, IOException {

		
		driver.close();
		driver.quit();
	}

	/**
	 * there is nor egiester button ** tc022,tc027
	 */

}
