package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsHomePage.Login;
import objectsSettings.ChangeLanguage;

public class TestChangeLanguage {
	
	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// Testing Add Change language section.
	@Test
	public void testChangeLanguage() {
		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();

		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		ChangeLanguage.clickSettings(driver);
		ChangeLanguage.clickLanguage(driver);
		Select language = new Select (driver.findElement(By.name("language")));
		language.selectByVisibleText("Serbian (machine)");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ChangeLanguage.clickSaveBtn(driver);	
		
		driver.navigate().refresh();
		
		String currentText = ChangeLanguage.clickLanguage(driver);
		String expectedText = "Платни списак";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentText, expectedText);
		sa.assertAll();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
