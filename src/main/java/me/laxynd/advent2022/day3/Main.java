package me.laxynd.advent2022.day3;

import java.util.List;

public class Main {

	public static void run(List<String> args) {
		// (Part 1)

		// For each line in the input, split it exactly in half
		// For each character in the first half, check if it's also in the second half (case-sensitive)
		// If it is, assign a value of 1-26 for characters a-z, and 27-52 for characters A-Z and stop checking
		// Sum all the values
		// Print the sum

		int sum = 0;

		for (String line : args) {
			String firstHalf = line.substring(0, line.length() / 2);
			String secondHalf = line.substring(line.length() / 2);

			for (int i = 0; i < firstHalf.length(); i++) {
				char c = firstHalf.charAt(i);
				if (secondHalf.contains(String.valueOf(c))) {
					if (c >= 'a' && c <= 'z') {
						sum += c - 'a' + 1;
					} else if (c >= 'A' && c <= 'Z') {
						sum += c - 'A' + 27;
					}
					break;
				}
			}
		}

		System.out.println(sum);

		// (Part 2)

		// For each group of 3 lines in the input, find the character that appears in all 3 lines, which can appear at any position
		// If it is, assign a value of 1-26 for characters a-z, and 27-52 for characters A-Z and stop checking
		// Sum all the values
		// Print the sum

		sum = 0;

		for (int i = 0; i < args.size(); i += 3) {
			String line1 = args.get(i);
			String line2 = args.get(i + 1);
			String line3 = args.get(i + 2);

			for (int j = 0; j < line1.length(); j++) {
				char c = line1.charAt(j);
				if (line2.contains(String.valueOf(c)) && line3.contains(String.valueOf(c))) {
					if (c >= 'a' && c <= 'z') {
						sum += c - 'a' + 1;
					} else if (c >= 'A' && c <= 'Z') {
						sum += c - 'A' + 27;
					}
					break;
				}
			}
		}

		System.out.println(sum);
	}
}