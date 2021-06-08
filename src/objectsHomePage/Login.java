package objectsHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public static final String URL = "https://www.humanity.com/app/";
	public static final By EMAIL = By.cssSelector("input[id='email']");
	public static final By PASSWORD = By.cssSelector("input[type='password']");
	public static final By CLICK_LOGIN = By.cssSelector("button[class='btn btn-full']");
	
	public static void typeEmail(WebDriver driver, String email) {
		WebElement we = driver.findElement(EMAIL);
		we.sendKeys(email);
	}
	
	public static void typePassword(WebDriver driver, String password) {
		WebElement we = driver.findElement(PASSWORD);
		we.sendKeys(password);
	}
	
	public static void clickLoginButton(WebDriver driver) {
		driver.findElement(CLICK_LOGIN).click();
	}
}
