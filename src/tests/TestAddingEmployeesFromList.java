package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectsHomePage.Login;
import objectsMainPage.AddingEmployeesFromList;

public class TestAddingEmployeesFromList {
	
	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// Testing Adding Emplyees section.
	@Test
	public void testAddEmployeeFromList() {
		driver.navigate().to(Login.URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Login.typeEmail(driver, "email@mail.com");
		Login.typePassword(driver, "lozinka");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login.clickLoginButton(driver);
		
		File f = new File ("data.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			
			for (int i = 0; i < 5; i++) {
				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);
				
				String firstname = c0.toString();
				String lastname = c1.toString();
				String email = c2.toString();
				
				driver.navigate().to(AddingEmployeesFromList.URL);
				AddingEmployeesFromList.clickAddEmployees(driver);
				AddingEmployeesFromList.addFirstName(driver, firstname);
				AddingEmployeesFromList.addLastName(driver, lastname);
				AddingEmployeesFromList.addEmail(driver, email);
				try {
					Thread.sleep(2000);
					AddingEmployeesFromList.clickSaveEmployees(driver);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				AddingEmployeesFromList.clickBtnEmployees(driver);
				
				//Checking by email address
				driver.navigate().to(AddingEmployeesFromList.URL);
				Assert.assertTrue(driver.getPageSource().contains(email));
			}			
			wb.close();			
		} 
		catch (IOException e) {		
			e.printStackTrace();
		}

	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
