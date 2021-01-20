package reversi;

public class Player {
	private String name;
	private char content;
	private int point;
	public static Player player1 = new Player('X');
	public static Player player2 = new Player('O');
	
	Player(char newContent){
		content = newContent;
	}
	
	public void setContent(char newContent) {
		content = newContent;
	}
	
	public char getContent() {
		return content;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPoint(int newPoint) {
		point = newPoint;
	}
	
	public int getPoint() {
		return point;
	}

	public void addPoint() {
		point++;
		
	}
}
