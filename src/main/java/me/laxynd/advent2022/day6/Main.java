package me.laxynd.advent2022.day6;

import java.util.List;

public class Main {

    public static void run(List<String> args) {
        // Part 1

        // Our input is only the first line in args
        // Find the index of the first 4-character sequence which contains only unique characters
        // Print the index + 4
        // break

        String input = args.get(0);

        for (int i = 0; i < input.length() - 3; i++) {
            String sub = input.substring(i, i + 4);
            if (sub.chars().distinct().count() == 4) {
                System.out.println(i + 4);
                break;
            }
        }

        // Part 2

        // Our input is only the first line in args
        // Find the index of the first 14-character sequence which contains only unique characters
        // Print the index + 14

        for (int i = 0; i < input.length() - 13; i++) {
            String sub = input.substring(i, i + 14);
            if (sub.chars().distinct().count() == 14) {
                System.out.println(i + 14);
                return;
            }
        }
    }
}