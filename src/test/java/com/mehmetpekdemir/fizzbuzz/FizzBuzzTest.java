package com.mehmetpekdemir.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mehmetpekdemir.fizzbuzz.FizzBuzz;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
class FizzBuzzTest {

	private FizzBuzz fizzBuzz;

	@BeforeEach
	void setUp() {
		fizzBuzz = new FizzBuzz();
	}

	@Test
	void returnFizzWhenTheNumberIsDivededByThree() {
		assertEquals("Fizz", fizzBuzz.calculate(3));
	}

	@Test
	void returnBuzzWhenTheNumberIsDivededByFive() {
		assertEquals("Buzz", fizzBuzz.calculate(5));
	}

	@Test
	void returnFizzBuzzWhenTheNumberIsDividedByBothOfThreeAndFive() {
		assertEquals("FizzBuzz", fizzBuzz.calculate(15));
	}

	@Test
	void returnTheNumberItselfWhenTheNumberIsNotDivededAnyOfThreeAndFive() {
		assertEquals("7", fizzBuzz.calculate(7));
	}

	@Test
	void throwsIllegalArgumentExceptionWhenTheNumberIsLessThanOne() {
		assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculate(-1));
	}

	@Test
	void throwsIllegalArgumentExceptionWhenTheNumberIsGreaterThanHundred() {
		assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculate(101));
	}

}
