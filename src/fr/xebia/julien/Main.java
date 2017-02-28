package fr.xebia.julien;

public class Main {

	public static void main(String[] args) throws MowItNowException {
		// TODO Auto-generated method stub

		Instruction instr = new Instruction();
		String strCmd = instr.getCommand("ressource/cmd.txt");
		instr.listCommand(strCmd);	  
		
		
		
	}

}
