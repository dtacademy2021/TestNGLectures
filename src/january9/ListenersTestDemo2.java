package january9;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;






public class ListenersTestDemo2 {
	
	
  static WebDriver driver;
	
	@BeforeMethod
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
      
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

	}
	
	@Test (testName = "test1")
	public void test1() {
		
		assertTrue(true);
		
	}
	
	
	@Test (testName = "test2")
	public void test2() {
		
		assertTrue(false);
		
	}
	
	
	@Test (testName = "test3")
	public void test3() {
		
		throw new SkipException("test is skipped");
		
	}

}
