package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectsHomePage.Login;
import objectsMainPage.ChangingNameEmployee;
import objectsMainPage.MainMenu;

public class TestChangingEmployeeName {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Testing Changing Employee name section.
	@Test
	public void testChangingEmployeeName() {
		driver.navigate().to(MainMenu.URL);
		driver.manage().window().maximize();
		
		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		try {
			Thread.sleep(4000);
			driver.navigate().to(ChangingNameEmployee.URL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ChangingNameEmployee.clickEmployeeName(driver);
		ChangingNameEmployee.clickEditDetails(driver);
		ChangingNameEmployee.changeFirstNameClear(driver);
		ChangingNameEmployee.changeFirstNameInput(driver, "Zivorad");
		ChangingNameEmployee.changeLastNameClear(driver);
		ChangingNameEmployee.changeLastNameInput(driver, "Milosevic");
		ChangingNameEmployee.clickSave(driver);
	
		driver.navigate().to(ChangingNameEmployee.URL);
		Assert.assertTrue(driver.getPageSource().contains("Milosevic"));
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}	
}