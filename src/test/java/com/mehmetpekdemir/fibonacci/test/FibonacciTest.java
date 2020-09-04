package com.mehmetpekdemir.fibonacci;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
class FibonacciTest {

	private Fibonacci fibonacci;

	@BeforeEach
	void setUp() {
		fibonacci = new Fibonacci();
	}

	// 1 1 2 3 5 8 13 21 34 55 89
	@Test
	@DisplayName("Find fibonacci numbers for valid number")
	void findFibonacciNumber() {
		assertAll("Tests Fibonacci",

				() -> assertEquals(0, fibonacci.calculate(0)), () -> assertEquals(1, fibonacci.calculate(1)),
				() -> assertEquals(1, fibonacci.calculate(2)), () -> assertEquals(2, fibonacci.calculate(3)),
				() -> assertEquals(3, fibonacci.calculate(4)), () -> assertEquals(55, fibonacci.calculate(10)),
				() -> assertEquals(89, fibonacci.calculate(11)), () -> assertEquals(28657, fibonacci.calculate(23)),
				() -> assertEquals(514229, fibonacci.calculate(29))

		);
	}

	@Test
	void throwsIllegalArgumentExceptionWhenTheNumberLessThenZero() {
		assertThrows(IllegalArgumentException.class, () -> fibonacci.calculate(-1));
	}

}
