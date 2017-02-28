package test;

import fr.xebia.julien.*;
import junit.framework.TestCase;

public class TondeuseTest extends TestCase {

	public TondeuseTest(String testMethodName) {
	    super(testMethodName);
	}
	
	  public void testCommand() throws Exception {
		  Pelouse p = new Pelouse(5,5,0,0);
		  Tondeuse t = new Tondeuse(0,0,p,Orientation.N);
		  
		  assertEquals("01N",t.command('A'));
		  assertEquals("01W",t.command('G'));
		  assertEquals("01S",t.command('G'));
		  assertEquals("01E",t.command('G'));
		  assertEquals("01S",t.command('D'));
		  
		try {
			Tondeuse t2 = new Tondeuse(6,6,p,Orientation.N);
			t2.command('A');
			fail("Une exception de type MowItNowException aurait du etre levee");
			} 
		catch (MowItNowException mine) {
			
			}
		  
	  }

}
