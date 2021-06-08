package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectsHomePage.Login;
import objectsProfile.Profile;

public class TestProfile {
	
	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// Testing Profile section changes.
	@Test
	public void testSetProfile() {
		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();
		
		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		Profile.clickProfileMenu(driver);
		Profile.clickSettings(driver);
		Profile.clickEmployeeId(driver, "0123456");
		Profile.clickEmployeeType(driver);
		Profile.clickMaxHours(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Profile.clickSave(driver);
		
		driver.navigate().to(Profile.URL);
		Assert.assertTrue(driver.getPageSource().contains("0123456"));
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
