package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsHomePage.Login;
import objectsMainPage.AddEmployee;
import objectsMainPage.AddingEmployeesFromList;

public class TestAddEmployee {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Testing Add Employee section.
	@Test
	public void testAddEmployee() {
		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();

		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.navigate().to(AddEmployee.URL);
		
		try {
			Thread.sleep(2000);
			AddEmployee.clickAddEmployees(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		AddEmployee.addFirstName(driver, "Danilo");		
		AddEmployee.addLastName(driver, "Stojkovic");
		AddEmployee.addEmail(driver, "danilo@stojkovic.com");
		AddEmployee.clickSaveEmployees(driver);
		AddEmployee.clickBtnEmployees(driver);

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/app/staff/list/load/true/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
