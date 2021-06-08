package objectsMainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu {
	
	public static final String URL = "https://kompanija252.humanity.com/app/dashboard/";
	public static final String DASHBOARD_XPATH = "//*[@id=\"sn_dashboard\"]";
	public static final String SHIFT_PLANNING_XPATH = "//*[@id=\"sn_schedule\"]";
	public static final String TIME_CLOCK_XPATH = "//*[@id=\"sn_timeclock\"]";
	public static final By LEAVE = By.cssSelector("#sn_timeclock");
	public static final String TRAINING_XPATH = "//*[@id=\"topMenu\"]/li[5]";
	public static final String STAFF_XPATH = "//*[@id=\"topMenu\"]/li[6]";
	public static final String AVAILABILITY_XPATH = "//*[@id=\"topMenu\"]/li[7]";
	public static final String PAYROLL_XPATH = "//*[@id=\"sn_payroll\"]";
	public static final String REPORTS_XPATH = "//*[@id=\"sn_reports\"]";
	
	public static void clickDashboard(WebDriver driver) {
		driver.findElement(By.xpath(DASHBOARD_XPATH)).click();
	}
	
	public static void clickShiftPlanning(WebDriver driver) {
		driver.findElement(By.xpath(SHIFT_PLANNING_XPATH)).click();
	}
	
	public static void clickTimeClock(WebDriver driver) {
		driver.findElement(By.xpath(TIME_CLOCK_XPATH)).click();
	}
	
	public static void clickLeave(WebDriver driver) {
		driver.findElement(LEAVE);
	}
	
	public static void clickTraining(WebDriver driver) {
		driver.findElement(By.xpath(TRAINING_XPATH)).click();
	}
	
	public static void clickStaff(WebDriver driver) {
		driver.findElement(By.xpath(STAFF_XPATH)).click();
	}
	
	public static void clickAvailability(WebDriver driver) {
		driver.findElement(By.xpath(AVAILABILITY_XPATH)).click();
	}
	
	public static void clickPayroll(WebDriver driver) {
		driver.findElement(By.xpath(PAYROLL_XPATH)).click();
	}
	
	public static void clickReports(WebDriver driver) {
		driver.findElement(By.xpath(REPORTS_XPATH)).click();
	}
	
}
