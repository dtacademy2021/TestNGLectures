package january9;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	
	
	public void onTestStart(ITestResult result) {
	    System.out.println("Test is starting");
	  }

	 
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test PASSED. Name: " + result.getTestName());
		
	  }

	  
	public void onTestFailure(ITestResult result) {
		System.out.println("Test FAILED Name: " + result.getTestName());
		File screenshot = ((TakesScreenshot)ListenersTestDemo.driver).getScreenshotAs(OutputType.FILE);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		try {
			FileUtils.copyFile(screenshot, new File("screenshots/screenshot"+ System.currentTimeMillis() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }

	  
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test SKIPPED Name: " + result.getTestName());
		System.out.println("The exception is " + result.getThrowable());

	  }

	 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	
	public void onStart(ITestContext context) {
		System.out.println("ON Start");

	  }

	 
	public void onFinish(ITestContext context) {
		System.out.println("ON Finish");
	  }
	
	

}
