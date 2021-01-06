package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import demo.MyAnnotation;


public class TestNGDemo {

	
	
	
	@Test
	public void demoTest() {
		
		System.out.println("Testing a testNG @Test Annotation");
		throw new ArithmeticException(); // to make the test fail
	}
	
	
	@Test
	public void positiveLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
			
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
		String actualURL = driver.getCurrentUrl();
		
		assertEquals(actualURL, expectedURL);
		
	}
	
	@MyAnnotation  // Annotation is a type in Java like class or interface, they can come before methods or classes
	public void method2() {
		
	}
	

}
