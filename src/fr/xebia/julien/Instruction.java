package fr.xebia.julien;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import test.InstructionTest;

public class Instruction{

	public Instruction() {
		// TODO Auto-generated constructor stub
	}
	
	//Envoi de la liste des instructions aux tondeuses.
	public String listCommand(String strCmd) throws MowItNowException{

		String statutFinal = new String();
		 Pattern p = Pattern.compile("^[0-9]{2}([0-9]{2}[N|E|S|W][A|G|D]+)+$");
		 Matcher m = p.matcher(strCmd);
		 boolean b = m.matches();
		 
		 if (b) {
			 
			 int pelouseX = Integer.valueOf(strCmd.substring(0,1));
			 int pelouseY = Integer.valueOf(strCmd.substring(1,2));
			 
			 Pattern pattern = Pattern.compile("[0-9]{2}[N|E|S|W][A|G|D]+");
			 Matcher matcher = pattern.matcher(strCmd);
			 
			 while (matcher.find()) {
				 
				 int tondeuseXinitial = Integer.valueOf(matcher.group().substring(0,1));
				 int tondeuseYinitial = Integer.valueOf(matcher.group().substring(1,2));
				 Orientation tondeuseOrientattion = Orientation.valueOf(matcher.group().charAt(2));
				 String tondeuseDeplacement = matcher.group().substring(3);
				 
				 System.out.println("Tondeuse: \"" + tondeuseXinitial + " " + tondeuseYinitial + " " + tondeuseOrientattion + " " + tondeuseDeplacement + "\"");
			    
				 Pelouse pelouse = new Pelouse(pelouseX, pelouseY, 0, 0);
				 Tondeuse t = new Tondeuse(tondeuseXinitial, tondeuseYinitial, pelouse, tondeuseOrientattion);
					
				 synchronized (t) {
						List<Character> list = new ArrayList<Character>();

						for(char c : tondeuseDeplacement.toCharArray()) {
						    list.add(c);
						}
						
						for (char cmdTondeuse : list) {
							t.command(cmdTondeuse);
						}
						
						statutFinal = statutFinal.concat(t.statut());
						System.out.println(t.toString() + "\n");
					
				}
				 
			 }

		}
		 else {
			throw new MowItNowException("Invalid Instruction list");	
		}
		
		return statutFinal;
	}

	//Récupération du fichier d'instruction.
	public String getCommand(String fileName) {

		String cmd = new String();
		File f = new File(fileName);
	    
	    try
	    {
	        FileReader fr = new FileReader (f);
		    try
		    {
		        int c = fr.read();
		        while (c != -1)
		        {
		        	if (c != '\r' && c != '\n') {
		        		cmd = cmd.concat(String.valueOf((char) c));
					}
		        	
		        	c = fr.read();
		        }
		        
		        cmd = cmd.trim();
		        fr.close();
		        
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
	    }
	    catch (FileNotFoundException exception)
	    {
	        System.out.println ("Le fichier n'a pas été trouvé");
	    }
	    
	    return cmd;
	}
}
