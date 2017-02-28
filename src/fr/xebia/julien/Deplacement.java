package fr.xebia.julien;

public class Deplacement extends Position{
	
	protected Orientation ori;

	public boolean avancerAxeXPositif() throws MowItNowException {
		// TODO Auto-generated method stub
		this.setX(this.getX() + 1);

		return true;
	}
	
	public boolean avancerAxeXNegatif() throws MowItNowException {
		// TODO Auto-generated method stub
		this.setX(this.getX() - 1);
		
		return true;
	}
	
	public boolean avancerAxeYPositif() throws MowItNowException {
		// TODO Auto-generated method stub
		this.setY(this.getY() + 1);

		return true;
	}
	
	public boolean avancerAxeYNegatif() throws MowItNowException {
		// TODO Auto-generated method stub
		this.setY(this.getY() - 1);
		
		return true;
	}
	
	public boolean tournerDroite() throws MowItNowException {
		// TODO Auto-generated method stub
		boolean b = false;
		
		switch (ori) {
		case N:
			ori = Orientation.E;
			b = true;
			break;
		case E:
			ori = Orientation.S;
			b = true;
			break;
		case S:
			ori = Orientation.W;
			b = true;
			break;
		case W:
			ori = Orientation.N;
			b = true;
			break;

		default:
			throw new MowItNowException("Invalid Orientation");
		}
		
		return b;
	}
	
	public boolean tournerGauche() throws MowItNowException {
		// TODO Auto-generated method stub
		boolean b = false;
		
		switch (ori) {
		case N:
			ori = Orientation.W;
			b = true;
			break;
		case E:
			ori = Orientation.N;
			b = true;
			break;
		case S:
			ori = Orientation.E;
			b = true;
			break;
		case W:
			ori = Orientation.S;
			b = true;
			break;

		default:
			throw new MowItNowException("Invalid Orientation");
		}
		
		return b;
	}
	
	public Orientation getOri() {
		return ori;
	}

	public void setOri(Orientation ori) {
		this.ori = ori;
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
			throw new MowItNowException("Invalid Orientation");
		}
		
		return b;
	}
	
}
