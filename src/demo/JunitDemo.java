package demo;

import org.junit.Test;

public class JunitDemo {

	
	@Test
	public void samleTest() {
		System.out.println("Junit demo Test");
	}
	
	
	@Test
	public void samleTest2() {
		System.out.println("Junit demo Test2");
		throw new ArithmeticException();
	}

}
