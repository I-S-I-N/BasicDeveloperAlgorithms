package ru.isin.basic.combinatorics.luckytickets;

import org.junit.jupiter.api.Test;
import ru.isin.basic.utils.Tester;

class StringAlgorithmTest {

	private final StringAlgorithm stringAlgorithm = new StringAlgorithm();

	@Test
	void runTest() {
		Tester tester = new Tester(stringAlgorithm, "combinatorics/lucky-tickets/0.String");
		tester.runAllTest();
	}
}