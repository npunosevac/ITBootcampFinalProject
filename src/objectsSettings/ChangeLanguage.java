package objectsSettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguage {

	public static final String URL = "https://kompanija252.humanity.com/app/dashboard/";
	public static final By SETTINGS = By.xpath("//*[@id=\"sn_admin\"]/span/i");
	public static final By LANGUAGE = By.name("language");
	public static final By SAVE = By.id("_save_settings_button");

	public static void clickSettings(WebDriver driver) {
		driver.findElement(SETTINGS).click();
	}

	public static String clickLanguage(WebDriver driver) {
		String language = driver.findElement(LANGUAGE).getText();	
		return language;
	}
	
	public static void clickSaveBtn(WebDriver driver) {
		driver.findElement(SAVE).click();
	}	

}
