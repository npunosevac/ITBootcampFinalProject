package objectsHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUs {
	
	public static final String URL = "https://www.humanity.com/about";
	public static final By ABOUT_US_NAV = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a");
	public static final By ABOUT_US_SECTION = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a");
	
	public static void clickAboutUsNavBar(WebDriver driver) {
		driver.findElement(ABOUT_US_NAV).click();		
	}
	
	public static void clickAboutUsSection(WebDriver driver) {
		driver.findElement(ABOUT_US_SECTION).click();
	}
}
