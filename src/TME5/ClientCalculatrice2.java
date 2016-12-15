package TME5;

import java.io.IOException;

import org.omg.CORBA.ORB;

import TME5.Calculatrice.Calculateur;
import TME5.Calculatrice.CalculateurHelper;

/**
 * 
 * Client avec service de nommage
 *
 */

public class ClientCalculatrice2 {
	
	public static void main(String[] args) throws IOException{
		// Initialisation de l'ORB
		ORB orb = ORB.init(args, null);
		
		String url = "corbaname::localhost:1050#Bob";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		Calculateur calcul = CalculateurHelper.narrow(obj);
		
		System.out.println("Calcul: " + calcul.add(1, 2));
	}
}
