package january7;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSimple {
	
	
	
	
	
	@Test (dataProvider = "vegetables")
	public void verifyTitle(String keyword) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		
		driver.findElement(By.name("q")).sendKeys( keyword + Keys.ENTER);
		
		assertTrue(driver.getTitle().contains(keyword));
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	@DataProvider (name = "vegetables")
	public Object[][] provideData() {
		
		return new Object[][] {
			{"celery"},
			{"морковь"},
			{"芹菜"},
			{"Zeytinyağlı Kereviz"},
			{"soğan"},
			{"\u1f600"}
			
			
		} ;
		
		
	}
	
	
	
	

}
