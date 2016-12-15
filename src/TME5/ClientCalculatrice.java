package TME5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;

import TME5.Calculatrice.Calculateur;
import TME5.Calculatrice.CalculateurHelper;

/**
 * 
 * Client simple
 *
 */

public class ClientCalculatrice {
	static org.omg.CORBA.Object restoreIOR(String fileName, ORB orb) throws IOException{
		// Ouverture du flux d'entrée
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// Récupère l'ior enregistrée dans le fichier
		String ior = br.readLine();
		
		br.close();
		
		// Convertit la chaine en objet CORBA
		return orb.string_to_object(ior);
	}
	
	public static void main(String[] args) throws IOException{
		// Initialisation de l'ORB
		ORB orb = ORB.init(args, null);
		
		// Récupération IOR et construction de la référence Corba
		org.omg.CORBA.Object obj = restoreIOR("calculatrice.ior", orb);
		
		// Construction du mandataire
		Calculateur cpt = CalculateurHelper.narrow(obj);
		
		// Utilisation de calculateur
		System.out.println("Calcul: " + cpt.add(1, 2));
		
	}
}
