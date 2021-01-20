package reversi;

import java.util.Scanner;

public class Main {
	public static String inputPlayer1="";
	public static String inputPlayer2="";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to 'Reversi'!");
		
		while (inputPlayer1 == "") {
			System.out.println("What's the name of player 1?");
			inputPlayer1 = scanner.nextLine();
		}
		Player.player1.setName(inputPlayer1);
		System.out.println("Nice to meet you " + Player.player1.getName());
		
		while (inputPlayer2 == "") {
			System.out.println("What's the name of player 2?");
			inputPlayer2 = scanner.nextLine();
		}
		Player.player2.setName(inputPlayer2);
		System.out.println("Nice to meet you to " + Player.player2.getName());
		
		
		Game.playGame();
	}

}
