package january7;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependencyTests {
	WebDriver driver;
	
	//For 2 methods having dependency on each other at the same time TestNg throws an exception:
	//org.testng.TestNGException: The following methods have cyclic dependencies:
	
	
	
	
	@Test  (priority = 1) // to guarantee the order of multiple methods that deleteAllTest() method depends on
	public void dummyTest1() {
		System.out.println("Dummy test 1");
		assertTrue(true);
		
	}
	
	@Test  (priority = 3) 
	public void dummyTest2() {
		System.out.println("Dummy test 1");
		assertTrue(true);
		
	}
	
	@Test  (priority = 2) 
	public void positiveLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
		String actualURL = driver.getCurrentUrl();
		
		assertEquals(actualURL, expectedURL, "Urls didn't match");
	//	assertEquals(actualURL, expectedURL, "Urls didn't match"); optional argument with a failure message
	}
	
	
	@Test  (dependsOnMethods = {"dummyTest1", "positiveLogin", "dummyTest2"} ) //alwaysRun = true will make sure this test runs even though the 
	                                                             // test it depends fails
	public void deleteAllTest() {
		String expected = "List of orders is empty. In order to add new order use";
		
		driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
		driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
		
		assertTrue(driver.getPageSource().contains(expected));
		
	}
	
	
	@Test (dependsOnMethods = "deleteAllTest")
	public void clickOnLinkTest() {
		String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx";
		
		driver.findElement(By.id("ctl00_MainContent_orderLInk")).click();
		assertTrue(driver.getCurrentUrl().equals(expectedURL));
		
	}

}
