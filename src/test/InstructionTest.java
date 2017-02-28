package test;

import fr.xebia.julien.*;
import junit.framework.TestCase;

public class InstructionTest extends TestCase {

	public InstructionTest(String testMethodName) {
	    super(testMethodName);
	}
	  public void testListCommand() throws Exception {
			String strCmd = "5512NGAGAGAGAA";
			Instruction instr = new Instruction();
			assertEquals("13N", instr.listCommand(strCmd));
			
			String strCmd2 = "5533EAADAADADDA";
			Instruction instr2 = new Instruction();
			assertEquals("51E", instr2.listCommand(strCmd2));
		  
			String strCmd3 = "5512NGAGAGAGAA33EAADAADADDA";
			Instruction instr3 = new Instruction();
			assertEquals("13N51E", instr3.listCommand(strCmd3));
	    
			try {
				String strCmd4 = "TOTO";
				Instruction instr4 = new Instruction();
				instr4.listCommand(strCmd4);
				fail("Une exception de type MowItNowException aurait du etre levee");
				} 
			catch (MowItNowException mine) {
				
				}
	  }
	  
}
