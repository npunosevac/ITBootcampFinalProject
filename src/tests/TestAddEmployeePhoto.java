package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectsHomePage.Login;
import objectsMainPage.AddEmployeePhoto;

public class TestAddEmployeePhoto {
	
	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Testing Add Employee photo section.
	@Test
	public void testAddEmployeePhoto() {
		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();
		
		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		try {
			Thread.sleep(5000);
			driver.navigate().to(AddEmployeePhoto.URL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		AddEmployeePhoto.clickEmployee(driver);
		AddEmployeePhoto.clickEditDetails(driver);
		try {
			Thread.sleep(5000);
			AddEmployeePhoto.clickUploadPhoto(driver);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		AddEmployeePhoto.clickSave(driver);
		
		try {
			Thread.sleep(5000);
			driver.navigate().to(AddEmployeePhoto.URL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
