package me.laxynd.advent2022.day4;

import java.util.List;

public class Main {

	public static void run(List<String> args) {
		// Part 1

		// For each line in the input, split on ','
		// For each split, split again on the dash, and parse the first and second parts as integers called min and max
		// If the first min is greater than equal to the second min and the first max is less than or equal to the second max, add 1 to a counter
		// If the second min is greater than equal to the first min and the second max is less than or equal to the first max, add 1 to a counter
		// Print the counter

		int counter = 0;

		for (String line : args) {
			String[] split = line.split(",");
			String[] split1 = split[0].split("-");
			String[] split2 = split[1].split("-");

			int min1 = Integer.parseInt(split1[0]);
			int max1 = Integer.parseInt(split1[1]);
			int min2 = Integer.parseInt(split2[0]);
			int max2 = Integer.parseInt(split2[1]);

			if (min1 >= min2 && max1 <= max2) {
				counter++;
			} else if (min2 >= min1 && max2 <= max1) {
				counter++;
			}
		}

		System.out.println(counter);

		// Part 2

		// For each line in the input, split on ','
		// For each split, split again on the dash, and parse the first and second parts as integers called min and max
		// If any of the following are true, add 1 to a counter:
		// - The first min is greater than equal to the second min and the first min is less than or equal to the second max
		// - The first max is greater than equal to the second min and the first max is less than or equal to the second max
		// - The second min is greater than equal to the first min and the second min is less than or equal to the first max
		// - The second max is greater than equal to the first min and the second max is less than or equal to the first max
		// Print the counter

		counter = 0;

		for (String line : args) {
			String[] split = line.split(",");
			String[] split1 = split[0].split("-");
			String[] split2 = split[1].split("-");

			int min1 = Integer.parseInt(split1[0]);
			int max1 = Integer.parseInt(split1[1]);
			int min2 = Integer.parseInt(split2[0]);
			int max2 = Integer.parseInt(split2[1]);

			if ((min1 >= min2 && min1 <= max2) || (max1 >= min2 && max1 <= max2) || (min2 >= min1 && min2 <= max1) || (max2 >= min1 && max2 <= max1)) {
				counter++;
			}
		}

		System.out.println(counter);
	}
}
