package january7;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	WebDriver driver;
	
	@BeforeMethod
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}
	
	
	
	
	@Test
	public void verifyAllOrdersElements() {
		
		SoftAssert softAssert =  new SoftAssert();
		
		
		
		//Verify all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		softAssert.assertTrue(links.size()==5, "Links size is not 6");
		
		for (WebElement link : links) {
			softAssert.assertTrue(link.isDisplayed());
		}
		
		
		//Verify all checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
		softAssert.assertTrue(checkboxes.size()==7, "Checkboxes size is not 8");
		
		for (WebElement checkbox : checkboxes) {
			softAssert.assertTrue(checkbox.isEnabled());
		}
		//Verify delete button
		
		softAssert.assertTrue(driver.findElement(By.name("ctl00$MainContent$btnDelete")).isEnabled());
		
		
		softAssert.assertAll(); // checks for failures and throws the failure exceptions
		
	}
	

}
