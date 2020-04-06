package com.mehmetpekdemir.fizzbuzz;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 03.30.2020
 *
 */
public class FizzBuzz {

	public String calculateFizzBuzz(int number) {

		if (number < 1 || number > 100) {
			throw new IllegalArgumentException();
		}
		if (number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		} else if (number % 3 == 0) {
			return "Fizz";
		} else if (number % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(number);
		}
	}
}
