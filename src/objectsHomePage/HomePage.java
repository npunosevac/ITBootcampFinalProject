package objectsHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public static final String URL = "http://www.humanity.com";		
	public static final By ANNOUNCEMENT_CLOSE = By.xpath("//*[@id=\"tcp-modal\"]/div/div/div[1]/button");
	public static final By COOKIES_OK = By.xpath("//*[@id=\"cf-root\"]/div/div/div/div[2]/div[2]/div[1]/button");
	public static final By lOGIN_XPATH = By.xpath("//*[@id=\"navbarSupportedContent\"]/div/a[2]/p");
	
	public static void clickAnnouncementButton(WebDriver driver) {
		driver.findElement(ANNOUNCEMENT_CLOSE).click();		
	}
	
	public static void clickCookiesButton(WebDriver driver) {
		driver.findElement(COOKIES_OK).click();
	}
	
	public static void clickLogin(WebDriver driver) {
		driver.findElement(lOGIN_XPATH).click();
	}
}
