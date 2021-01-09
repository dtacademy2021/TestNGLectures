package january9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utilities.ConfigReader;

public class PropertiesDemo {
	WebDriver driver;
	
	
	@Test
	public void readFromProperties() throws IOException {
		
	
		if(ConfigReader.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(ConfigReader.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumFiles\\browserDrivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}else if(ConfigReader.getProperty("browser").equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\SeleniumFiles\\browserDrivers\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		
		
		
		driver.get(ConfigReader.getProperty("url"));
      
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
		
		
	}

}
