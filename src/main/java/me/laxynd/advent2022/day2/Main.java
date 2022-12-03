package me.laxynd.advent2022.day2;

import java.util.List;

public class Main {

	public static void run(List<String> args) {
		// Part 1
		// Create a variable for score
		int score = 0;

		// For each line in args
		for (String line : args) {
			// Convert 'A' to "Rock", 'B' to "Paper", 'C' to "Scissors", 'X' to "Rock", 'Y' to "Paper", 'Z' to "Scissors"
			String convertedLine = line.replace('A', 'X').replace('B', 'Y').replace('C', 'Z').replace('X', 'R').replace('Y', 'P').replace('Z', 'S');

			// Split the line into two parts at the space
			String[] parts = convertedLine.split(" ");

			// If the first part is "Rock" and the second part is "Scissors", or the first part is "Paper" and the second part is "Rock", or the first part is "Scissors" and the second part is "Paper"
			if (parts[0].equals("R") && parts[1].equals("S") || parts[0].equals("P") && parts[1].equals("R") || parts[0].equals("S") && parts[1].equals("P")) {
				// Add 0 to score
				score += 0;
			}
			// If the first part is "Rock" and the second part is "Paper", or the first part is "Paper" and the second part is "Scissors", or the first part is "Scissors" and the second part is "Rock"
			else if (parts[0].equals("R") && parts[1].equals("P") || parts[0].equals("P") && parts[1].equals("S") || parts[0].equals("S") && parts[1].equals("R")) {
				// Add 6 to score
				score += 6;
			}
			// If the first part is "Rock" and the second part is "Rock", or the first part is "Paper" and the second part is "Paper", or the first part is "Scissors" and the second part is "Scissors"
			else if (parts[0].equals("R") && parts[1].equals("R") || parts[0].equals("P") && parts[1].equals("P") || parts[0].equals("S") && parts[1].equals("S")) {
				// Add 3 to score
				score += 3;
			}

			// If the second part is "Rock", add 1 to the score
			// If the second part is "Paper", add 2 to the score
			// If the second part is "Scissors", add 3 to the score
			score += parts[1].equals("R") ? 1 : parts[1].equals("P") ? 2 : 3;
		}

		// Print the score
		System.out.println(score);

		// Part 2
		// Create a variable for score
		score = 0;

		// For each line in args
		for (String line : args) {
			// Split the line into two parts at the space
			String[] parts = line.split(" ");

			// Create a variable "opponent", equal to "Rock" if part 0 is 'A', "Paper" if part 0 is 'B', "Scissors" if part 0 is 'C'
			String opponent = parts[0].equals("A") ? "R" : parts[0].equals("B") ? "P" : "S";

			// Create a variable "result", equal to "Win" if part 1 is 'Z', "Lose" if part 1 is 'X', "Draw" if part 1 is 'Y'
			String result = parts[1].equals("Z") ? "W" : parts[1].equals("X") ? "L" : "D";

			// Create a variable for the player's move
			String player;

			// If the opponent is "Rock" and the result is "Win", or the opponent is "Paper" and the result is "Draw", or the opponent is "Scissors" and the result is "Lose"
			if (opponent.equals("R") && result.equals("W") || opponent.equals("P") && result.equals("D") || opponent.equals("S") && result.equals("L")) {
				// Set player to "Paper"
				player = "P";
			}
			// If the opponent is "Rock" and the result is "Lose", or the opponent is "Paper" and the result is "Win", or the opponent is "Scissors" and the result is "Draw"
			else if (opponent.equals("R") && result.equals("L") || opponent.equals("P") && result.equals("W") || opponent.equals("S") && result.equals("D")) {
				// Set player to "Scissors"
				player = "S";
			}
			// Otherwise, set player to "Rock"
			else {
				player = "R";
			}

			// If result is win, add 6 to score, if result is draw, add 3 to score, if result is lose, add 0 to score
			score += result.equals("W") ? 6 : result.equals("D") ? 3 : 0;

			// If player is rock, add 1 to score, if player is paper, add 2 to score, if player is scissors, add 3 to score
			score += player.equals("R") ? 1 : player.equals("P") ? 2 : 3;
		}

		// Print the score
		System.out.println(score);
	}
}