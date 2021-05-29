package ru.isin.basic.combinatorics.luckytickets;

import ru.isin.basic.utils.Task;

import java.util.List;

public class StringAlgorithm implements Task {

	@Override
	public String run(List<String> lines) {
		var size = 0;
		for (var s : lines) {
			size += s.length();
		}
		return String.valueOf(size);
	}

	@Override
	public String getPath() {
		return "combinatorics/lucky-tickets/0.String";
	}
}
