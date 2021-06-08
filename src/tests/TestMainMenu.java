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
import objectsMainPage.MainMenu;

public class TestMainMenu {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Testing Main menu section.
	@Test (priority = 1)
	public void testDashboardLink() {
		driver.navigate().to(MainMenu.URL);
		driver.manage().window().maximize();
		
		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
				
		MainMenu.clickDashboard(driver);
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/app/dashboard/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}
	
	@Test (priority = 2)
	public void testShiftPlanningLink() {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		MainMenu.clickShiftPlanning(driver);
		
		driver.navigate().to(MainMenu.URL);
		Assert.assertTrue(driver.getPageSource().contains(driver.getTitle()));	
	}
	
	@Test (priority = 3)
	public void testTimeClockLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickTimeClock(driver);
					
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/app/timeclock/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}
	
	@Test (priority = 4)
	public void testLeaveLink() {
				
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickLeave(driver);
								
		driver.navigate().to(MainMenu.URL);
		Assert.assertTrue(driver.getPageSource().contains(driver.getTitle()));	
	}
	
	@Test (priority = 5)
	public void testTrainingLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickTraining(driver);		
			
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/app/training/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}
	
	@Test (priority = 6)
	public void testStaffLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickStaff(driver);
		
		driver.navigate().to(MainMenu.URL);
		Assert.assertTrue(driver.getPageSource().contains(driver.getTitle()));		
	}
	
	@Test (priority = 7)
	public void testPayrollLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickPayroll(driver);
				
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/app/payroll/scheduled-hours/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}
	
	@Test (priority = 8)
	public void testReportsLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickReports(driver);
					
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/app/reports/dashboard/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}
	
	@Test (priority = 9)
	public void testAvailabilityLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MainMenu.clickAvailability(driver);
					
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kompanija252.humanity.com/fe/availability/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
