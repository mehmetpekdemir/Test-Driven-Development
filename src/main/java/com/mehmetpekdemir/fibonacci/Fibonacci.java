package com.mehmetpekdemir.fibonacci;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 03.30.2020
 *
 */
public class Fibonacci {

	//0 1 1 2 3 5 8 13 21 34 55
	public int calculateFibonacci(int number) {
		if (number < 0) {
			throw new IllegalArgumentException();
		}
		if (number <= 1) {
			return number;
		}
		return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
	}

}
