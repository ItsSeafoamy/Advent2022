package me.laxynd.advent2022.day1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void run(List<String> args) {
		// Create an empty list of integers
		List<Integer> numbers = new ArrayList<>();

		// Add 0 to the list
		numbers.add(0);

		// For each line in the input, add the line's integer to the last integer in the list
		// If the line is empty, add 0 to the list
		for (String line : args) {
			if (line.isEmpty()) {
				numbers.add(0);
			} else {
				numbers.add(numbers.get(numbers.size() - 1) + Integer.parseInt(line));
			}
		}

		// (Part 1)
		// Find the largest value in the list
		int largest = numbers.get(0);
		for (int number : numbers) {
			if (number > largest) {
				largest = number;
			}
		}

		// Print the largest value
		System.out.println(largest);

		// (Part 2)
		// Find the 3 largest values in the list and add them together
		int largest1 = numbers.get(0);
		int largest2 = numbers.get(0);
		int largest3 = numbers.get(0);

		for (int number : numbers) {
			if (number > largest1) {
				largest3 = largest2;
				largest2 = largest1;
				largest1 = number;
			} else if (number > largest2) {
				largest3 = largest2;
				largest2 = number;
			} else if (number > largest3) {
				largest3 = number;
			}
		}

		// Print the sum of the 3 largest values
		System.out.println(largest1 + largest2 + largest3);
	}
}