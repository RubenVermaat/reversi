package reversi;

public class Square {
	boolean status;
	private char content;
	
	Square(){
		content = '.';
	}
	
	public char getContent() {
		return content;
	}
	
	public void setContent(char input) {
		content = input;
	}
}
