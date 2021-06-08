package objectsMainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployeePhoto {
	
	public static final String URL = "https://kompanija252.humanity.com/app/staff/list/load/true/";
	public static final By CLICK_EMPLOYEE = By.cssSelector("#\\37  > a");
	public static final By EDIT_DETAILS = By.linkText("Edit Details");
	public static final By UPLOAD_PHOTO = By.id("fileupload");
	public static final By SAVE = By.name("update");
	
	public static void clickEmployee(WebDriver driver) {
		driver.findElement(CLICK_EMPLOYEE).click();
	}
	
	public static void clickEditDetails(WebDriver driver) {
		driver.findElement(EDIT_DETAILS).click();
	}
	
	public static void clickUploadPhoto(WebDriver driver) {
		WebElement we = driver.findElement(UPLOAD_PHOTO);		
		we.sendKeys("C:\\Users\\kiputebra\\eclipse-workspace\\IT Bootcamp Zavrsni Projekat\\Foto\\Employee.jpg");
	}
	
	public static void clickSave(WebDriver driver) {
		driver.findElement(SAVE).click();
	}
	
}
