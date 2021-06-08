package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsHomePage.HomePage;
import objectsHomePage.Login;

public class TestHomePage {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Testing closing pop-ups and entering the login section.
	@Test(priority = 1)
	public void testHomePage() {
		driver.navigate().to(HomePage.URL);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		HomePage.clickAnnouncementButton(driver);
		HomePage.clickCookiesButton(driver);

		HomePage.clickLogin(driver);

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.humanity.com/app/";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}

	// Testing a login with positive credentials.
	@Test(priority = 2)
	public void testLoginPage() {

		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();
		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Login.clickLoginButton(driver);
				
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.humanity.com/app/";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
