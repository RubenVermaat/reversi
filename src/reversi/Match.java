package reversi;

import java.util.Scanner;

public class Match {
	private static int matches;
	private static Player activePlayer;
	private static Player notActivePlayer;
	private static Player victoriousPlayer;
	private static int cross = 0;
	private static int circle = 0;
	private static int row;
	private static int col;
	private static boolean greenLight;
	private static int turnCounter = 0;
	
	public static void startMatch() {
		if (matches < Game.amountMatches) {
			Board.createField();
			turnCounter = 0;
			playTurn();
		}else {
			Game.endGame();
		}
	}
	
	public static void playTurn() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Turn Counter " + turnCounter);
		
		if (turnCounter == 0) {
			if (matches % 2 == 0) { // Number is even
				System.out.println("Number is even " + matches);
				Player.player1.setContent('X');
				Player.player2.setContent('O');
				activePlayer = Player.player1;
				notActivePlayer = Player.player2;
			}else { // Number is odd
				System.out.println("Number is odd " + matches);
				Player.player2.setContent('X');
				Player.player1.setContent('O');
				activePlayer = Player.player2;
				notActivePlayer = Player.player1;

			}
		}else {
			if (activePlayer == Player.player1) {
				activePlayer = Player.player2;
				notActivePlayer = Player.player1;
			}else {
				activePlayer = Player.player1;
				notActivePlayer = Player.player2;
			}
		}
		
		turnCounter++;		
		
		Board.board.print();
		
		String s = "";
		
		int possibleMoves = 0;
		
		for (int r = 1; r < 9; r++) {
			for (int c = 1; c < 9; c++) {
				if (Board.checkMove(activePlayer, notActivePlayer, c, r)) {			
					possibleMoves++;
				}
			}
		}
		
		if (possibleMoves == 0) { // If there are no possible moves end match
			System.out.println("There are no possible moves anymore");
			endMatch();
		}else {
			while (!greenLight) {
				System.out.println("Type where you wanna place your piece " + activePlayer.getName() + " (" + activePlayer.getContent() + ")");
				s = scanner.nextLine();

				
				if (s.length() != 0) {
					col = (s.charAt(0) - 96);
					row = Character.getNumericValue(s.charAt(1));
					
					if (Board.checkMove(activePlayer, notActivePlayer, col, row)) { // Checks if pieces would be changed making this move
						greenLight = true;
					}else {
						if (row > 8 || row < 1) { // Checking if row exist
							System.out.println("Row doesn't exist"); 
						}else if (col > 8 || col < 1) { // Checking if col exist
							System.out.println("Col doesn't exist"); 
						} else if (s.length() >= 3) {
							System.out.println("Given location is to long and not recognized"); // If location is entered where the piece can't be placed
						}else {
							System.out.println("You can't place a piece there, you need to atleast turn one stone of the other player"); // If location is entered where the piece can't be placed
						}
						
					}
				}else {
					System.out.println("Please give a location where you want to place the piece"); // If location is entered where the piece can't be placed
				}

			}
			
			greenLight = false;
			
			Board.squares.get(String.valueOf(row) + String.valueOf(col)).setContent(activePlayer.getContent()); //PLaces piece
			
			System.out.println(s.charAt(1) + " " + row + " " );

			Board.changePieces(activePlayer, notActivePlayer, col, row); // Changer all the pieces
			
			System.out.println("You placed a piece at " + s);
			
			playTurn();
		}
	}
	
	public static void countPieces() {
		cross = 0;
		circle = 0;
		
		for (int r = 1; r < 9; r++) {
			for (int c = 1; c < 9; c++) {
				if (Board.squares.get(String.valueOf(r) + String.valueOf(c)).getContent() == 'X') { // Counting all the X on the board
					cross++;
				}else if (Board.squares.get(String.valueOf(r) + String.valueOf(c)).getContent() == 'O'){ // Counting all the O on the board
					circle++;
				}
			}
		}
	}
	
	public static boolean checkMoveLegit() {
		boolean check = false;
		if (Board.squares.get(String.valueOf(row+1) + String.valueOf(col)).getContent() == activePlayer.getContent()) {
			check = true;
		}
		if (Board.squares.get(String.valueOf(row-1) + String.valueOf(col)).getContent() == activePlayer.getContent()) {
			check = true;
		}
		if (Board.squares.get(String.valueOf(row) + String.valueOf(col+1)).getContent() == activePlayer.getContent()) {
			check = true;
		}
		if (Board.squares.get(String.valueOf(row) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
			check = true;
		}
		return check;
	}
	
	public static void endMatch() {
		Game.turn++;
		countPieces(); // Counting pieces of players on the board

		if (cross > circle) { // Checking who has the most points and there for won the match
			if (Player.player1.getContent() == 'X') {
				victoriousPlayer = Player.player1;
				Player.player1.addPoint(); // Add a point to winning player
			}else {
				victoriousPlayer = Player.player2;
				Player.player2.addPoint(); // Add a point to winning player
			}
		}else {
			if (Player.player2.getContent() == 'O') {
				victoriousPlayer = Player.player2;
				Player.player2.addPoint(); // Add a point to winning player
			}else {
				victoriousPlayer = Player.player1;
				Player.player1.addPoint(); // Add a point to winning player
			}
		}
		Board.board.print();
		System.out.println(victoriousPlayer.getName() + " has won by " + cross + " - " + circle);
		System.out.println("The score is now: " + Player.player1.getName() + " - " + Player.player2.getName() + " " + Player.player1.getPoint() + " - " + Player.player2.getPoint() );
		if (Player.player1.getPoint() != Player.player2.getPoint()) { // Only counting the matches that did not and in a draw
			matches++;
		}
		startMatch();
	}
}
