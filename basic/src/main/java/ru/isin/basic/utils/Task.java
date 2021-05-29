package ru.isin.basic.utils;

import java.util.List;

public interface Task {

	String run(List<String> lines);

	String getPath();

	default void checkAllTests() throws Exception {
		Tester tester = Tester.of(this, getPath());
		tester.runAllTest();
	}

	default void checkTest(int number) throws Exception {
		Tester tester = Tester.of(this, getPath());
		tester.runTest(number);
	}
}
