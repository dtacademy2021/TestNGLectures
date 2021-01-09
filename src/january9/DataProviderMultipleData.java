package january9;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviderMultipleData {

	WebDriver driver;
	
//	@BeforeMethod
//	public void login() {
//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
//		driver= new ChromeDriver();
//		
//		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//      
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
//
//	}
	
	
	@DataProvider 
	public Object[][] getData(){
		
		// Utility method that reads the data from excel file or database
		// and returns Object[][]
		
		
		
		return new Object[][] {
			{"1000000", "Владимир Владимирович Путин,", "кремл москва 100001 ", "москва", "центр", "ыававы", "вымвымвывмыы", "вмвымвымв"},
			{"1", "John Doe", "8607 Westwood Center Dr", "Vienna", "Virginia", "22182", "4356234512345678", "01/22"},
			{"200", "Barack Obama", "1600 Pennsylvania Ave", "Washington", "DC", "20000", "4632764685673456", "09/29"},
			{"1000", "Владимир Владимирович Путин,", "кремл москва 100001 ", "москва", "центр", "10000", "9876567845673425", "13/2020"}
			
			
			
		};
	}
	
	
	
	@Test (dataProvider = "getData")
	public void placeOrder(String quantity, String name, 
			String street, String city,String state, String zip, String cardNo, String expiry ) {
		  	driver.findElement(By.linkText("Order")).click();
	        
	        //5. Enter a random quantity between 1 and 100
		  	
		  	
		  
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE + quantity);
	        
	        //6. Enter Customer Name: Mid Name  - should enter a random String of length 5 everytime
	       
	        
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
	        
	        //7. Enter street: 8607 Westwood Center Dr
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
	        
	        //8. Enter city: Vienna
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
	        
	        //9. Enter state: Virginia
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
	        
	     
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
	        
	        //11. Select any card type. Every time your code should select a different type.
	        int randCardNum = (int)(Math.random()*3);
	        String str = String.valueOf(randCardNum);
	        String chooseCard = "ctl00_MainContent_fmwOrder_cardList_" + str;
	        driver.findElement(By.id(chooseCard)).click();
	        
	        
	      
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNo);
	        
	        
	        //13. Enter a valid expiration date (newer than the current date)
	        
	       ;
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expiry);
	        
	        //14. Click on process
	        
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	        
	        
	        assertTrue(driver.getPageSource().contains("New order has been successfully added."));
		
		
	}
	
	@Test (enabled = false)   // enabled=false and @Ignore is not going to run the test and it will not show up in the report 
	public void softAssertDemo() {
		SoftAssert sa = new SoftAssert();
		System.out.println("FAIL");
		sa.assertTrue(false);
		System.out.println("PASS");
		sa.assertTrue(true);
		System.out.println("PASS");
		sa.assertTrue(true);
		System.out.println("PASS");
		sa.assertTrue(true);
		sa.assertAll();
	}
	
	@Test (dependsOnMethods = "softAssertDemo")
	public void softAssertDemo1() {
		SoftAssert sa = new SoftAssert();
		System.out.println("FAIL");
		sa.assertTrue(false);
		System.out.println("PASS");
		sa.assertTrue(true);
		System.out.println("PASS");
		sa.assertTrue(true);
		System.out.println("PASS");
		sa.assertTrue(true);
		sa.assertAll();
	}
	

}
