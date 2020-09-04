package com.mehmetpekdemir.fibonacci;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
class Fibonacci {

	public int calculate(int number) {

		if (number < 0) {
			throw new IllegalArgumentException();
		}

		if (number <= 1) {
			return number;
		}
		
		return calculate(number - 1) + calculate(number - 2);
	}

}
