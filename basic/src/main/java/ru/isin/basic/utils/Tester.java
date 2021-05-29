package ru.isin.basic.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Slf4j
public class Tester {

	private final Task task;
	private final String path;

	private Tester(Task task, String path) {
		this.task = task;
		this.path = Constants.rootPath + path;
	}

	public static Tester of(Task task, String path) {
		return new Tester(task, path);
	}

	public void runTest(int number) throws Exception {
		var inFile = Paths.get(path + "\\test." + number + ".in");
		var outFile = Paths.get(path + "\\test." + number + ".out");

		if (!inFile.toFile().exists() || !outFile.toFile().exists()) {
			return;
		}

		boolean result = checkTest(inFile, outFile);
		if (result) {
			log.info("Test #" + number + " - TRUE");
		} else {
			log.info("Test #" + number + " - FALSE");
			throw new Exception("Тест №" + number + " не прошел");
		}
	}

	public void runAllTest() throws Exception {
		var number = 0;
		while (true) {
			runTest(number++);
		}
	}

	private boolean checkTest(Path inFile, Path outFile) {
		try {
			var lines = Files.readAllLines(inFile, StandardCharsets.UTF_8);
			var expected = Files.lines(outFile).collect(Collectors.joining()).trim();
			var actual = task.run(lines);
			return expected.equals(actual);
		} catch (Exception e) {
			log.error(String.valueOf(e));
			return false;
		}
	}
}
