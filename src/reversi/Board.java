package reversi;

import java.util.HashMap;

public class Board {
	static HashMap<String, Square> squares = new HashMap<String, Square>();
	static Board board = new Board();
	
	public static void createField() {
		for (int r = 1; r < 9; r++) {
			for (int c = 1; c < 9; c++) {
				squares.put("" + r + c, new Square());
			}
		}
		
		int row;
		int col;
		
		row = 4;
		col = 4;
		squares.get("" + row + col).setContent('O'); 
		col = 5;
		squares.get("" + row + col).setContent('X');
		row = 5;
		col = 4;
		squares.get("" + row + col).setContent('X');
		col = 5;
		squares.get("" + row + col).setContent('O');
	}
	
	public void print() {			
		System.out.println("+ - - - - - - - - - - +");
		System.out.println("|   A B C D E F G H   |");
		for (int r = 1; r < 9; r++) {
			System.out.print("| " + r + " ");
				for (int c = 1; c < 9; c++) {
					System.out.print(squares.get("" + r + c).getContent() + " ");
				}
			System.out.println(r + " |");
		}
		System.out.println("|   A B C D E F G H   |");
		System.out.println("+ - - - - - - - - - - +");
		

	}
	
	public static Board getBoard() {
		return board;
	}

	public static void changePieces(Player activePlayer, Player notActivePlayer, int col, int row) {
		
		int original_between = row;
		int original_test = col;
		int hit_row = 0;
		int hit_col = 0;
		
		// HORIZONTAL CHECK
		// UP AND DOWN CHECK
		if (squares.containsKey(String.valueOf(row+1) + String.valueOf(col))) { // Checks if board continues down
			while (squares.get(String.valueOf(row+1) + String.valueOf(col)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row+1) + String.valueOf(col)).getContent() == activePlayer.getContent()) {
					hit_row = (row+1);
					hit_col = col;
					row = original_between;
					while (squares.get(String.valueOf(row+1) + String.valueOf(col)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row+1) + String.valueOf(col)).setContent(activePlayer.getContent());
						row++;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				row++;
				if (!squares.containsKey("" + (row+1) + col)) {
					break;
				}
			}
		}
		
		row = original_between;
		if (squares.containsKey(String.valueOf(row-1) + String.valueOf(col))) { // Checks if board continues up
			while (squares.get(String.valueOf(row-1) + String.valueOf(col)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row-1) + String.valueOf(col)).getContent() == activePlayer.getContent()) {
					hit_row = (row-1);
					hit_col = col;
					row = original_between;
					while (squares.get(String.valueOf(row-1) + String.valueOf(col)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row-1) + String.valueOf(col)).setContent(activePlayer.getContent());
						row--;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				row--;
				if (!squares.containsKey("" + (row-1) + col)) {
					break;
				}
			}
		}
		
		// RIGHT AND LEFT CHECK
		row = original_between;
		if (squares.containsKey(String.valueOf(row) + String.valueOf(col+1))) { // Checks if board continues to the right
			while (squares.get(String.valueOf(row) + String.valueOf(col+1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row) + String.valueOf(col+1)).getContent() == activePlayer.getContent()) {
					hit_row = row;
					hit_col = (col+1);
					col = original_test;
					while (squares.get(String.valueOf(row) + String.valueOf(col+1)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row) + String.valueOf(col+1)).setContent(activePlayer.getContent());
						col++;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col++;
				if (!squares.containsKey("" + row + (col+1))) {
					break;
				}
			}
		}
		
		col = original_test;
		if (squares.containsKey(String.valueOf(row) + String.valueOf(col-1))) { // Checks if board continues to the left
			while (squares.get(String.valueOf(row) + String.valueOf(col-1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
					hit_row = row;
					hit_col = (col-1);
					col = original_test;
					while (squares.get(String.valueOf(row) + String.valueOf(col-1)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row) + String.valueOf(col-1)).setContent(activePlayer.getContent());
						col--;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col--;
				if (!squares.containsKey("" + row + (col-1))) {
					break;
				}
			}
		}
		
		// VERTICAL CHECK
		// LEFT AND UP
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row-1) + String.valueOf(col-1))) { // Checks if board continues to left and up
			while (squares.get(String.valueOf(row-1) + String.valueOf(col-1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row-1) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
					hit_row = (row-1);
					hit_col = (col-1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row-1) + String.valueOf(col-1)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row-1) + String.valueOf(col-1)).setContent(activePlayer.getContent());
						col--;
						row--;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col--;
				row--;
				if (!squares.containsKey("" + (row-1) + (col-1))) {
					break;
				}
			}
		}
		
		// LEFT AND DOWN
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row+1) + String.valueOf(col-1))) { // Checks if board continues to left and up
			while (squares.get(String.valueOf(row+1) + String.valueOf(col-1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row+1) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
					hit_row = (row+1);
					hit_col = (col-1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row+1) + String.valueOf(col-1)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row+1) + String.valueOf(col-1)).setContent(activePlayer.getContent());
						col--;
						row++;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col--;
				row++;
				if (!squares.containsKey("" + (row+1) + (col-1))) {
					break;
				}
			}
		}
		
		// RIGHT AND DOWN
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row+1) + String.valueOf(col+1))) { // Checks if board continues right and down
			while (squares.get(String.valueOf(row+1) + String.valueOf(col+1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row+1) + String.valueOf(col+1)).getContent() == activePlayer.getContent()) {
					hit_row = (row+1);
					hit_col = (col+1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row+1) + String.valueOf(col+1)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row+1) + String.valueOf(col+1)).setContent(activePlayer.getContent());
						col++;
						row++;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col++;
				row++;
				if (!squares.containsKey("" + (row+1) + (col+1))) {
					break;
				}
			}
		}
		
		// RIGHT AND UP
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row-1) + String.valueOf(col+1))) { // Checks if board continues right and down
			while (squares.get(String.valueOf(row-1) + String.valueOf(col+1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row-1) + (col+1)).getContent() == activePlayer.getContent()) {
					hit_row = (row-1);
					hit_col = (col+1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row-1) + String.valueOf(col+1)) != squares.get("" + hit_row + hit_col)) { // Checks if value down has content of other player
						squares.get(String.valueOf(row-1) + String.valueOf(col+1)).setContent(activePlayer.getContent());
						col++;
						row--;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col++;
				row--;
				if (!squares.containsKey("" + (row-1) + (col+1))) {
					break;
				}
			}
		}
	}
	
	public static boolean checkMove(Player activePlayer, Player notActivePlayer, int col, int row) {
		
		int original_between = row;
		int original_test = col;
		int hit_row = 0;
		int hit_col = 0;
		boolean check = false;
		
		// HORIZONTAL CHECK
		// UP AND DOWN CHECK
		if (squares.containsKey(String.valueOf(row+1) + String.valueOf(col))) { // Checks if board continues down
			while (squares.get(String.valueOf(row+1) + String.valueOf(col)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row+1) + String.valueOf(col)).getContent() == activePlayer.getContent()) {
					hit_row = (row+1);
					hit_col = col;
					row = original_between;
					while (squares.get(String.valueOf(row+1) + String.valueOf(col)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						row++;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				row++;
				if (!squares.containsKey("" + (row+1) + col)) {
					break;
				}
			}
		}
		
		row = original_between;
		if (squares.containsKey(String.valueOf(row-1) + String.valueOf(col))) { // Checks if board continues up
			while (squares.get(String.valueOf(row-1) + String.valueOf(col)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row-1) + String.valueOf(col)).getContent() == activePlayer.getContent()) {
					hit_row = (row-1);
					hit_col = col;
					row = original_between;
					while (squares.get(String.valueOf(row-1) + String.valueOf(col)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						row--;
						check = true;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				row--;
				if (!squares.containsKey("" + (row-1) + col)) {
					break;
				}
			}
		}
		
		// RIGHT AND LEFT CHECK
		row = original_between;
		if (squares.containsKey(String.valueOf(row) + String.valueOf(col+1))) { // Checks if board continues to the right
			while (squares.get(String.valueOf(row) + String.valueOf(col+1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row) + String.valueOf(col+1)).getContent() == activePlayer.getContent()) {
					hit_row = row;
					hit_col = (col+1);
					col = original_test;
					while (squares.get(String.valueOf(row) + String.valueOf(col+1)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						col++;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col++;
				if (!squares.containsKey("" + row + (col+1))) {
					break;
				}
			}
		}
		
		col = original_test;
		if (squares.containsKey(String.valueOf(row) + String.valueOf(col-1))) { // Checks if board continues to the left
			while (squares.get(String.valueOf(row) + String.valueOf(col-1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
					hit_row = row;
					hit_col = (col-1);
					col = original_test;
					while (squares.get(String.valueOf(row) + String.valueOf(col-1)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						col--;
						//System.out.println("hit");
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col--;
				if (!squares.containsKey("" + row + (col-1))) {
					break;
				}
			}
		}
		
		// VERTICAL CHECK
		// LEFT AND UP
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row-1) + String.valueOf(col-1))) { // Checks if board continues to left and up
			while (squares.get(String.valueOf(row-1) + String.valueOf(col-1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row-1) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
					hit_row = (row-1);
					hit_col = (col-1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row-1) + String.valueOf(col-1)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						col--;
						row--;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col--;
				row--;
				if (!squares.containsKey("" + (row-1) + (col-1))) {
					break;
				}
			}
		}
		
		// LEFT AND DOWN
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row+1) + String.valueOf(col-1))) { // Checks if board continues to left and up
			while (squares.get(String.valueOf(row+1) + String.valueOf(col-1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row+1) + String.valueOf(col-1)).getContent() == activePlayer.getContent()) {
					hit_row = (row+1);
					hit_col = (col-1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row+1) + String.valueOf(col-1)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						col--;
						row++;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col--;
				row++;
				if (!squares.containsKey("" + (row+1) + (col-1))) {
					break;
				}
			}
		}
		
		// RIGHT AND DOWN
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row+1) + String.valueOf(col+1))) { // Checks if board continues right and down
			while (squares.get(String.valueOf(row+1) + String.valueOf(col+1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row+1) + String.valueOf(col+1)).getContent() == activePlayer.getContent()) {
					hit_row = (row+1);
					hit_col = (col+1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row+1) + String.valueOf(col+1)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						col++;
						row++;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col++;
				row++;
				if (!squares.containsKey("" + (row+1) + (col+1))) {
					break;
				}
			}
		}
		
		// RIGHT AND UP
		col = original_test;
		row = original_between;
		if (squares.containsKey(String.valueOf(row-1) + String.valueOf(col+1))) { // Checks if board continues right and down
			while (squares.get(String.valueOf(row-1) + String.valueOf(col+1)).getContent() != '.') { // Checks if value down has content of other player
				if (squares.get(String.valueOf(row-1) + (col+1)).getContent() == activePlayer.getContent()) {
					hit_row = (row-1);
					hit_col = (col+1);
					col = original_test;
					row = original_between;
					while (squares.get(String.valueOf(row-1) + String.valueOf(col+1)) != squares.get(String.valueOf(hit_row) + String.valueOf(hit_col))) { // Checks if value down has content of other player
						check = true;
						col++;
						row--;
					}
					hit_row = 0;
					hit_col = 0;
					break;
				}
				col++;
				row--;
				if (!squares.containsKey("" + (row-1) + (col+1))) {
					break;
				}
			}
		}
		
		return check;
	}
}
