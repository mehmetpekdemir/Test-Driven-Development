package com.mehmetpekdemir.primefactors.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.mehmetpekdemir.primefactors.PrimeFactors;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 06.04.2020
 * 
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrimeFactorsTests {

	private Map<Integer, List<Integer>> primeFactorExpectations = new HashMap<Integer, List<Integer>>();

	private List<Integer> list(int... results) {
		List<Integer> list = new ArrayList<Integer>();
		for (int result : results) {
			list.add(result);
		}
		return list;
	}

	@BeforeAll
	public void setUp() {
		primeFactorExpectations.put(1, Collections.emptyList());
		primeFactorExpectations.put(2, list(2));
		primeFactorExpectations.put(3, list(3));
		primeFactorExpectations.put(4, list(2, 2));
		primeFactorExpectations.put(5, list(5));
		primeFactorExpectations.put(6, list(2, 3));
		primeFactorExpectations.put(7, list(7));
		primeFactorExpectations.put(8, list(2, 2, 2));
		primeFactorExpectations.put(9, list(3, 3));
	}

	@Test
	@DisplayName("Generate PrimeFactors")
	public void generateWithStandartTest() {

		assertEquals(Collections.EMPTY_LIST, PrimeFactors.generate(-100));
		assertEquals(Collections.EMPTY_LIST, PrimeFactors.generate(1));
		assertEquals(list(2), PrimeFactors.generate(2));
		assertEquals(list(3), PrimeFactors.generate(3));
		assertEquals(list(2, 2), PrimeFactors.generate(4));
		assertEquals(list(5), PrimeFactors.generate(5));
		assertEquals(list(2, 3), PrimeFactors.generate(6));
		assertEquals(list(7), PrimeFactors.generate(7));
		assertEquals(list(2, 2, 2), PrimeFactors.generate(8));
		assertEquals(list(3, 3), PrimeFactors.generate(9));
	}

	@RepeatedTest(9)
	public void generateWithRepeatedTest(RepetitionInfo repetitionInfo) {
		assertEquals(primeFactorExpectations.get(repetitionInfo.getCurrentRepetition()),
				PrimeFactors.generate(repetitionInfo.getCurrentRepetition()));
	}

	@ParameterizedTest(name = "Generate Prime Factors for {arguments}")
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
	public void generateWitParameterizedTest(Integer number) {
		assertEquals(primeFactorExpectations.get(number), PrimeFactors.generate(number));
	}

	@TestFactory
	public Stream<DynamicTest> generateWithDynamicTest() {
		return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.map(number -> DynamicTest.dynamicTest("Generate prime factors for " + number,
						() -> assertEquals(primeFactorExpectations.get(number), PrimeFactors.generate(number))));
	}

}
