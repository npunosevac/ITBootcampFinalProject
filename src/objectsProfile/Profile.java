package objectsProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Profile {
	
	public static final String URL = "https://kompanija252.humanity.com/app/dashboard/";
	public static final By PROFILE_MENU = By.id("wrap_us_menu");
	public static final By SETTINGS = By.xpath("//*[@id=\"userm\"]/div/a[2]");
	public static final By EMPLOYEE_ID = By.id("eid");
	public static final By EMPLOYEE_TYPE = By.className("edit-employee__dropdown");
	public static final By MAX_WEEKLY_HOURS = By.id("overtime");
	public static final By SAVE = By.xpath("//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[42]/td/input");
	
	public static void clickProfileMenu(WebDriver driver) {
		driver.findElement(PROFILE_MENU).click();
	}
	
	public static void clickSettings(WebDriver driver) {
		driver.findElement(SETTINGS).click();
	}
	
	public static void clickEmployeeId(WebDriver driver, String id) {
		driver.findElement(EMPLOYEE_ID).sendKeys(id);
	}
	
	public static void clickEmployeeType(WebDriver driver) {
		Select type = new Select (driver.findElement(EMPLOYEE_TYPE));
		type.selectByIndex(2);
	}
	
	public static void clickMaxHours(WebDriver driver) {
		Select hours = new Select (driver.findElement(MAX_WEEKLY_HOURS));
		hours.selectByIndex(2);
	}
	
	public static void clickSave(WebDriver driver) {
		driver.findElement(SAVE).click();
	}

}
