package objectsSettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Notifications {
	
	public static final String URL = "https://kompanija252.humanity.com/app/dashboard/";
	public static final By SETTINGS = By.xpath("//*[@id=\"sn_admin\"]/span/i");
	public static final By EMAIL = By.id("pref_pref_email");
	public static final By SMS = By.id("pref_pref_sms");
	public static final By MOBILE = By.id("pref_pref_mobile_push");
	public static final By SAVE = By.id("_save_settings_button");
	
	
	public static void clickSettings(WebDriver driver) {
		driver.findElement(SETTINGS).click();
	}

	public static void clickEmail(WebDriver driver) {
		driver.findElement(EMAIL).click();
	}
	
	public static void clickSms(WebDriver driver) {
		driver.findElement(SMS).click();
	}
	
	public static void clickMobile(WebDriver driver) {
		driver.findElement(MOBILE).click();
	}
	
	public static void clickSaveBtn(WebDriver driver) {
		driver.findElement(SAVE).click();
	}
}
