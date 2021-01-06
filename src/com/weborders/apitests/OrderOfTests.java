package com.weborders.apitests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;



public class OrderOfTests {
	
	
	
	@Test (priority = -1 )
	public void testA() {
		System.out.println("A");
	}
	
	@Test (priority = 0,  enabled = false  )
	public void testB() {
		System.out.println("B");
	}
	
	@Test (priority = 1)
	public void testX() {
		System.out.println("X");
	}
	
	
	@Test (priority = 2, groups = {"smoke"})
	public void testY() {
		System.out.println("Y");
	}
	
	@Test (priority = 0)
	public void testG() {
		System.out.println("G");
	}
	
	@Test
	public void testZ() {  // if we do  not add any priority it will get the default one which is 0
		System.out.println("Z");
	}
	
	@Test
	public void testD() {
		System.out.println("Ignore");
	}
	
	

}
