package com.junit.test.tester;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.junit.platform.suite.api.IncludeTags;

import com.junit.test.Calci;

@IncludeTags("sub")
public class TestRunner {
	
	Calci calci;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before all");
	}
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before each");
	}
	@Test
	@DisplayName("Add Test")
	public void addTest() {
		calci = new Calci(10,20);
		int expected = 30;
		int actual = calci.add();
		assertEquals(expected,actual);
	}
	@Test
	@DisplayName("Subtract Test")
	@Tag("sub")
	public void subTest() {
		calci = new Calci(10,20);
		int expected = -10;
		int actual = calci.sub();
		assertEquals(expected,actual);
	}
	@Test
	@DisplayName("Multiply Test")
	@Tag("mul")
	public void multiplyTest() {
		calci = new Calci(10,20);
		int expected = 200;
		int actual = calci.multiply();
		assertEquals(expected,actual);
	}
	@Test
	@DisplayName("Divide Test")
	@Disabled
	@Tag("div")
	public void dividTest() {
		calci = new Calci(10,0);
		int expected = 0;
//		int actual=calci.divide();
//		assertEquals(expected,actual);
		
	}
	@AfterEach
	public void afterEach() {
		System.out.println("afterEach");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("After all");
	}

}
