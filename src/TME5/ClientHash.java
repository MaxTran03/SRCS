package TME5;

import org.omg.CORBA.ORB;

import TME5.Calculatrice.Calculateur;
import TME5.Calculatrice.CalculateurHelper;
import TME5.HashDistante.HashDist;
import TME5.HashDistante.HashDistHelper;
import TME5.HashDistante.HashDistOperations;

public class ClientHash {
	
	public static void main(String[] args){
		// Initialisation de l'ORB
		ORB orb = ORB.init(args, null);
				
		String url = "corbaname::localhost:1050#Bob";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		HashDist hd = HashDistHelper.narrow(obj);
		
		Calculateur calcul = CalculateurHelper.narrow(hd.get("tacfaranus"));
		
		hd.put("tacfaranus", obj);
		System.out.println("Verify: " + hd.containsKey("Morray"));
		System.out.println("Verify: " + hd.containsKey("tacfaranus"));
		System.out.println("Contenu: " + calcul.add(1, 2));
	}
}
