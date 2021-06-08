package objectsMainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddingEmployeesFromList {
	
	public static final String URL = "https://kompanija252.humanity.com/app/staff/list/load/true/";
	public static final By ADD_EMPLOYEES = By.id("act_primary");
	public static final By FIRST_NAME = By.id("_asf1");
	public static final By LAST_NAME = By.id("_asl1");
	public static final By EMAIL = By.id("_ase1");
	public static final By SAVE_EMPLOYEES = By.id("_as_save_multiple");
	public static final By BTN_EMPLOYYES = By.id("act_primary");
	
	public static void clickAddEmployees(WebDriver driver) {
		driver.findElement(ADD_EMPLOYEES).click();
	}
	
	public static void addFirstName(WebDriver driver, String firstname) {
		driver.findElement(FIRST_NAME).sendKeys(firstname);
	}
	
	public static void addLastName(WebDriver driver, String lastname) {
		driver.findElement(LAST_NAME).sendKeys(lastname);
	}
	
	public static void addEmail(WebDriver driver, String email) {
		driver.findElement(EMAIL).sendKeys(email);
	}
	
	public static void clickSaveEmployees(WebDriver driver) {
		driver.findElement(SAVE_EMPLOYEES).click();
	}
	
	public static void clickBtnEmployees(WebDriver driver) {
		driver.findElement(BTN_EMPLOYYES).click();
	}
	
}
