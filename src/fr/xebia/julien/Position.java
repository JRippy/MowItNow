package fr.xebia.julien;

public class Position {
	
	protected int x = 0;
	protected int y = 0;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}
	
	public Position(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	public Position(Position p) {
		// TODO Auto-generated constructor stub
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPosition(Position p){
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	public String statut() {

		String str = String.valueOf(x);
		String str2 = String.valueOf(y);
		
		return str.concat(str2);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String str = "X : ".concat(String.valueOf(x)).concat(" ");
		String str2 = "Y : ".concat(String.valueOf(y));
		
		return str.concat(str2);
	}

}
