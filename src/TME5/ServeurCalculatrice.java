package TME5;

import java.io.FileWriter;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import TME5.Calculatrice.CalculateurPOA;


/**
 *
 * Serveur simple
 * 
 **/

public class ServeurCalculatrice {
	
	static void saveIOR(String fileName, ORB orb, org.omg.CORBA.Object obj) throws IOException{
		// Représentation sous forme de string de l'ior
		String ior = orb.object_to_string(obj);
		
		// Un flux de sortie vers un fichier
		FileWriter fw = new FileWriter(fileName);
		
		// Rempli avec l'ior
		fw.write(ior);
		
		fw.close();
	}
	
	public static void main(String[] args) throws InvalidName, AdapterInactive, IOException, ServantNotActive, WrongPolicy{
		// Initialisation de l'ORB
		ORB orb = ORB.init(args, null);
	
		// Récupération RootPOA, conversions et activation
		org.omg.CORBA.Object rootobj = orb.resolve_initial_references("RootPOA");
		POA poa = POAHelper.narrow(rootobj);
		poa.the_POAManager().activate();
		
		// Création de l'objet serveur
		CalculateurPOA servant = new Calculette();
		
		org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
		
		// Sauvegarde l'ior de obj dans calculatrice.ior
		saveIOR("calculatrice.ior", orb, obj);
		
		// Traitement des requetes de clients
		orb.run();
	}
}
