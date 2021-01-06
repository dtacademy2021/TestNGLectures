package com.weborders.apitests;

import org.testng.annotations.Test;

public class AdHocTests {
	
	@Test 
	public void TC_001_DB() {
		System.out.println("DB");
	}
	
	@Test (groups = { "ui"})
	public void TC_002_UI() {
		System.out.println("UI");
	}
	
	@Test (groups = { "ui"})
	public void TC_003_UI() {
		System.out.println("UI2");
	}
	
	@Test 
	public void TC_004_DB() {
		System.out.println("DB2");
	}
	
	
	@Test 
	public void TC_005_API() {
		System.out.println("API");
	}

}
