package january7;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.GroupsHelper;

public class SharingStateAndDataBetweenMethods {
	
	
	WebDriver driver;
	String title;
	
	
	
	@Test  (priority = 1)
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		title = driver.getTitle();
	}
	
	
	
	@Test  (groups = {"login"}, priority = 2)
	public void positiveLogin() {
		
		
		System.out.println("The title is " + title);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
		String actualURL = driver.getCurrentUrl();
		
		assertEquals(actualURL, expectedURL, "Urls didn't match");
	//	assertEquals(actualURL, expectedURL, "Urls didn't match"); optional argument with a failure message
	}
	
	
	

}
