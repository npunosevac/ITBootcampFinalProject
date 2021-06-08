package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsHomePage.AboutUs;
import objectsHomePage.HomePage;

public class TestAboutUs {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Testing About us section.
	@Test
	public void testAboutUsPage() {
		driver.navigate().to(HomePage.URL);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		HomePage.clickAnnouncementButton(driver);
		HomePage.clickCookiesButton(driver);

		AboutUs.clickAboutUsNavBar(driver);
		AboutUs.clickAboutUsSection(driver);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\kiputebra\\eclipse-workspace\\IT Bootcamp Zavrsni Projekat\\Screenshot Zavrsni Projekat\\Screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = AboutUs.URL;

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(currentUrl, expectedUrl);
		sa.assertAll();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
