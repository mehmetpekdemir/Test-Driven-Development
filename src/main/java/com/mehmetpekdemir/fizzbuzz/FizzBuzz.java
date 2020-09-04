package com.mehmetpekdemir.fizzbuzz;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class FizzBuzz {

	public String calculate(int number) {

		if (number < 1 || number > 100) {
			throw new IllegalArgumentException();

		}

		if (number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		}

		if (number % 3 == 0) {
			return "Fizz";
		}

		if (number % 5 == 0) {
			return "Buzz";
		}

		return String.valueOf(number);
	}

}
