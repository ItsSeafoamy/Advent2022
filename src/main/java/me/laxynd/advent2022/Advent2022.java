package me.laxynd.advent2022;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Advent2022 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		int day = 3;

		List<String> input = Files.readAllLines(Paths.get("src", "main", "resources", "day" + day + ".txt"));

		Class.forName("me.laxynd.advent2022.day" + day + ".Main").getMethod("run", List.class).invoke(null, input);
	}
}