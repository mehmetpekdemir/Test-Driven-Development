package com.mehmetpekdemir.fibonacci.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.mehmetpekdemir.fibonacci.Fibonacci;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 03.30.2020
 *
 */
public class FibonacciTests {

	private Fibonacci fibonacci;

	@Before
	public void setUp() {
		fibonacci = new Fibonacci();
	}

	// 1 1 2 3 5 8 13 21 34 55 89
	@Test
	@DisplayName("Find fibonacci numbers for valid number")
	public void findFibonacciNumbers() {
		assertAll("Test Fibonacci", () -> assertEquals(0, fibonacci.calculateFibonacci(0)),
				() -> assertEquals(1, fibonacci.calculateFibonacci(1)),
				() -> assertEquals(1, fibonacci.calculateFibonacci(2)),
				() -> assertEquals(2, fibonacci.calculateFibonacci(3)),
				() -> assertEquals(3, fibonacci.calculateFibonacci(4)),
				() -> assertEquals(55, fibonacci.calculateFibonacci(10)),
				() -> assertEquals(89, fibonacci.calculateFibonacci(11)),
				() -> assertEquals(28657, fibonacci.calculateFibonacci(23)),
				() -> assertEquals(514229, fibonacci.calculateFibonacci(29)));

	}

	@Test
	@DisplayName("Find fibonacci numbers for unvalid number")
	public void throwsIllegalArgumentExceptionWhenTheNumberLessThenZero() {
		assertThrows(IllegalArgumentException.class, () -> fibonacci.calculateFibonacci(-1));
		assertThrows(IllegalArgumentException.class, () -> fibonacci.calculateFibonacci(-15));
		assertThrows(IllegalArgumentException.class, () -> fibonacci.calculateFibonacci(-123123));
	}
}
