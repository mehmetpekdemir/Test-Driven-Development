package com.mehmetpekdemir.primefactors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 06.04.2020
 *
 */
public class PrimeFactors {

	public static List<Integer> generate(int number) {
		if (number <= 1) {
			return Collections.emptyList();
		}

		List<Integer> primeFactors = new ArrayList<Integer>();

		for (int i = 2; number > 1; i++) {
			for (; number % i == 0; number /= i) {
				primeFactors.add(i);
			}
		}

		return primeFactors;

	}

}
