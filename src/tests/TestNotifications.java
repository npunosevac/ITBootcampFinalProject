package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectsHomePage.Login;
import objectsSettings.Notifications;

public class TestNotifications {
	
	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// Testing Notifications selection.
	@Test
	public void testNotifications() {
		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();

		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		Notifications.clickSettings(driver);
		Notifications.clickEmail(driver);
		Notifications.clickSms(driver);
		Notifications.clickMobile(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Notifications.clickSaveBtn(driver);
		
		driver.navigate().refresh();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}