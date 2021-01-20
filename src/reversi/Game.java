package reversi;

import java.util.Scanner;

public class Game {	
	public static int amountMatches;

	public static int turn;
	
	public static void playGame() {
		Scanner scanner = new Scanner(System.in);
		
		while (amountMatches  >= 9 || amountMatches < 1) {
			System.out.println("How many games do you wanna play? Choose between 1-9");
			amountMatches = scanner.nextInt();
		}
		
		System.out.println("Alright, let's play " + amountMatches + " matche(s).");
		System.out.println("Lets start the game, good luck!");
		
		Match.startMatch();
	}
	
	public static void endGame() {
		System.out.println("All the matches have been played.");
		System.out.println("End result is " + Player.player1.getPoint() + " - " + Player.player2.getPoint());
	}
	
}