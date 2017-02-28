package fr.xebia.julien;

public class Tondeuse extends Deplacement{

	private Pelouse pel;
	
	public Tondeuse(){
		
	}
	
	public Tondeuse(int x,int y, Pelouse pe, Orientation o){

		this.setPosition(x, y);
		this.pel = new Pelouse(pe);
		this.setOri(o);
	}

	public Pelouse getPel() {
		return pel;
	}

	public void setPel(Pelouse pel) {
		this.pel = pel;
	}
	
	public boolean avancerAxeXPositif() throws MowItNowException {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if ((this.getX() + 1) <= pel.getMaxX() ) {
			this.setX(this.getX() + 1);
			b = true;
		}else {
			throw new MowItNowException("Hors périmètre pelouse");
		}

		return b;
	}
	
	public boolean avancerAxeXNegatif() throws MowItNowException {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if ((this.getX() - 1) >= pel.getMinX() ) {
			this.setX(this.getX() - 1);
			b = true;
		}else {
			throw new MowItNowException("Hors périmètre pelouse");
		}
		
		return b;
	}
	
	public boolean avancerAxeYPositif() throws MowItNowException {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if ((this.getY() + 1) <= pel.getMaxY() ) {
			this.setY(this.getY() + 1);
			b = true;
		}else {
			throw new MowItNowException("Hors périmètre pelouse");

		}

		return b;
	}
	
	public boolean avancerAxeYNegatif() throws MowItNowException {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if ((this.getY() - 1) >= pel.getMinY() ) {
			this.setY(this.getY() - 1);
			b = true;
		}else {
			throw new MowItNowException("Hors périmètre pelouse");
		}
		
		return b;
	}
	
	public boolean avancer() throws MowItNowException {
		// TODO Auto-generated method stub
		
		boolean b = false;
		
		switch (ori) {
		case N:
			avancerAxeYPositif();
			b = true;
			break;
		case E:
			avancerAxeXPositif();
			b = true;
			break;
		case S:
			avancerAxeYNegatif();
			b = true;
			break;
		case W:
			avancerAxeXNegatif();
			b = true;
			break;

		default:
			throw new MowItNowException("Orientation invalide");
		}
		
		return b;
	}
	
	public String command(char c) throws MowItNowException{
		
		switch (c) {
		case 'A':
			this.avancer();
			break;

		case 'D':
			this.tournerDroite();
			break;
			
		case 'G':
			this.tournerGauche();
			break;

		default:
			throw new MowItNowException("Commande tondeuse invalide");

		}
		
		return this.statut();
	}	
	
	public String statut() {

		Position pos = new Position(this.getX(), this.getY());
		
		String str = pos.statut();
		String str2 = String.valueOf(this.getOri());
		
		return str.concat(str2);
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		
		Position pos = new Position(this.getX(), this.getY());
		
		String str = pos.toString();
		String str2 = " Orientation : " + this.getOri();
		
		return str.concat(str2);
	}

}
