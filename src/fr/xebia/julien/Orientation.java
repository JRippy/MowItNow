package fr.xebia.julien;

public enum Orientation {

	N,
	E,
	W,
	S;

	public static Orientation valueOf(char charAt) {
		// TODO Auto-generated method stub
		
		Orientation o;
		
		switch (charAt) {
		case 'N':
			
			o = N;
			break;

		case 'E':
			
			o = E;
			break;
			
		case 'S':
			
			o = S;
			break;

		case 'W':
			
			o = W;
			break;

		default:
			
			o = null;
			
			break;
		}
		
		return o;
	}
}
