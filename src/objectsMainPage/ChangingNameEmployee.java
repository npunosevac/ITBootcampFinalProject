package objectsMainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangingNameEmployee {
	
	public static final String URL = "https://kompanija252.humanity.com/app/staff/list/load/true/";
	public static final String CLICK_NAME  = "//*[@id=\"7\"]/a";
	public static final By EDIT_DETAILS = By.partialLinkText("Edit Detail");
	public static final By EDIT_FIRSTNAME = By.id("first_name");
	public static final By EDIT_LASTNAME = By.id("last_name");
	public static final By SAVE_EMPLOYEE = By.className("dia_submit");
	
	public static void clickEmployeeName(WebDriver driver) {
		driver.findElement(By.xpath(CLICK_NAME)).click();
	}
	
	public static void clickEditDetails(WebDriver driver) {
		driver.findElement(EDIT_DETAILS).click();
	}
	
	public static void changeFirstNameClear(WebDriver driver) {
		driver.findElement(EDIT_FIRSTNAME).clear();
	}
	
	public static void changeFirstNameInput(WebDriver driver, String firstname) {
		driver.findElement(EDIT_FIRSTNAME).sendKeys(firstname);
	}
	
	public static void changeLastNameClear(WebDriver driver) {
		driver.findElement(EDIT_LASTNAME).clear();
	}
	
	public static void changeLastNameInput(WebDriver driver, String lastname) {
		driver.findElement(EDIT_LASTNAME).sendKeys(lastname);
	}
	
	public static void clickSave(WebDriver driver) {
		driver.findElement(SAVE_EMPLOYEE).click();
	}
	
}
