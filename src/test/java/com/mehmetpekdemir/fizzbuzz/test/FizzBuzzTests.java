package com.mehmetpekdemir.fizzbuzz.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import com.mehmetpekdemir.fizzbuzz.FizzBuzz;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 03.30.2020
 *
 */
public class FizzBuzzTests {

	private FizzBuzz fizzBuzz;

	@Before
	public void setUp() {
		fizzBuzz = new FizzBuzz();
	}

	@Test
	public void returnFizzWhenTheNumberIsDivededByThree() {
		assertAll("Is The Number Diveded By Three", () -> assertEquals("Fizz", fizzBuzz.calculateFizzBuzz(3)),
				() -> assertEquals("Fizz", fizzBuzz.calculateFizzBuzz(12)),
				() -> assertEquals("Fizz", fizzBuzz.calculateFizzBuzz(36)),
				() -> assertEquals("Fizz", fizzBuzz.calculateFizzBuzz(99)));
	}

	@Test
	public void returnBuzzWhenTheNumberIsDivededByFive() {
		assertAll("Is The Number Diveded By Five", () -> assertEquals("Buzz", fizzBuzz.calculateFizzBuzz(5)),
				() -> assertEquals("Buzz", fizzBuzz.calculateFizzBuzz(35)),
				() -> assertEquals("Buzz", fizzBuzz.calculateFizzBuzz(65)),
				() -> assertEquals("Buzz", fizzBuzz.calculateFizzBuzz(95)));

	}

	@Test
	public void returnFizzBuzzWhenTheNumberIsDivededBothOfThreeAndFive() {
		assertAll("Is The Number Diveded BothOf Three And Five",
				() -> assertEquals("FizzBuzz", fizzBuzz.calculateFizzBuzz(15)),
				() -> assertEquals("FizzBuzz", fizzBuzz.calculateFizzBuzz(30)),
				() -> assertEquals("FizzBuzz", fizzBuzz.calculateFizzBuzz(45)),
				() -> assertEquals("FizzBuzz", fizzBuzz.calculateFizzBuzz(90)),
				() -> assertNotEquals("FizzBuzz", fizzBuzz.calculateFizzBuzz(17)));

	}

	@Test
	public void returnTheNumberItselfWhenTheNumberIsNotDivededAnyOfThreeOrFive() {
		assertAll("IsNot The Number Diveded Any Of Three Or Five",
				() -> assertEquals("7", fizzBuzz.calculateFizzBuzz(7)),
				() -> assertEquals("2", fizzBuzz.calculateFizzBuzz(2)),
				() -> assertEquals("17", fizzBuzz.calculateFizzBuzz(17)),
				() -> assertEquals("41", fizzBuzz.calculateFizzBuzz(41)));

	}

	@Test
	public void throwsIllegalArgumentExceptionWhenTheNumberIsLessThanOne() {
		assertAll("Is The Number Less Than One",
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(0)),
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(-1)),
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(-199)),
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(-8236123)));

	}

	@Test
	public void throwsIllegalArgumentExceptionWhenTheNumberIsGreaterThanHundred() {
		assertAll("Is The Number Greater Than Hundred",
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(101)),
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(3145)),
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(263523)),
				() -> assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateFizzBuzz(434557534)));

	}

}
