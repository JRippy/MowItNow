package fr.xebia.julien;

public class Pelouse {

	private int maxX;
	
	private int maxY;
	
	private int minX;
	
	private int minY;

	public Pelouse() {
	}
	
	public Pelouse(int maxX, int maxY, int minX, int minY) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
	}
	
	public Pelouse(Pelouse pe) {
		this.maxX = pe.getMaxX();
		this.maxY = pe.maxY;
		this.minX = pe.minX;
		this.minY = pe.minY;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int x) {
		this.maxX = x;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int y) {
		this.maxY = y;
	}
	
}
