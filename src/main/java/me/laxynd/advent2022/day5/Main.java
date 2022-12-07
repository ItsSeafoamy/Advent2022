package me.laxynd.advent2022.day5;

import java.util.List;
import java.util.Stack;

public class Main {

    public static void run(List<String> args) {
        // Part 1

        // Combine all lines into one string with \n as separator
        String input = String.join("\n", args);

        // Split the input on the double newline
        String[] groups = input.split("\n\n");

        // For the first group, split on newline
        String[] firstGroup = groups[0].split("\n");

        // Create a size-9 array of stacks of characters
        Stack<Character>[] stacks = new Stack[9];

        // For each line in the first group, starting with the second last line and working backwards, get the characters in every 4th position, with an offset of 1 (so 1, 5, 9, 13, etc.)
        // Place the characters into the stacks if they are not spaces
        for (int i = firstGroup.length - 2; i >= 0; i--) {
            char[] chars = firstGroup[i].toCharArray();
            for (int j = 1; j < chars.length; j += 4) {
                if (chars[j] != ' ') {
                    if (stacks[j / 4] == null) {
                        stacks[j / 4] = new Stack<>();
                    }
                    stacks[j / 4].push(chars[j]);
                }
            }
        }

        // For the second group, split on newline
        // Each line will be of the format "move <count> from <x> to <y>"
        // Pop <count> elements from stack <x> and push them onto stack <y>, where x and y are 1-indexed

        String[] secondGroup = groups[1].split("\n");
        for (String line : secondGroup) {
            String[] parts = line.split(" ");
            int count = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]) - 1;
            int to = Integer.parseInt(parts[5]) - 1;
            for (int i = 0; i < count; i++) {
                stacks[to].push(stacks[from].pop());
            }
        }

        // Add the top of each stack to a StringBuilder, and print the result
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            sb.append(stack.pop());
        }
        System.out.println(sb);

        // Part 2

        // Reset the stacks and do the same thing again
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = firstGroup.length - 2; i >= 0; i--) {
            char[] chars = firstGroup[i].toCharArray();
            for (int j = 1; j < chars.length; j += 4) {
                if (chars[j] != ' ') {
                    if (stacks[j / 4] == null) {
                        stacks[j / 4] = new Stack<>();
                    }
                    stacks[j / 4].push(chars[j]);
                }
            }
        }

        // For the second group, split on newline
        // Each line will be of the format "move <count> from <x> to <y>"
        // Pop <count> elements from stack <x>, reverse them, and push them onto stack <y>, where x and y are 1-indexed

        for (String line : secondGroup) {
            String[] parts = line.split(" ");
            int count = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]) - 1;
            int to = Integer.parseInt(parts[5]) - 1;
            Stack<Character> temp = new Stack<>();
            for (int i = 0; i < count; i++) {
                temp.push(stacks[from].pop());
            }
            while (!temp.isEmpty()) {
                stacks[to].push(temp.pop());
            }
        }

        // Add the top of each stack to a StringBuilder, and print the result
        sb = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}