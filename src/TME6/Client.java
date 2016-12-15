package TME6;

import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;

import TME6.cache.FileSystem;
import TME6.cache.FileSystemHelper;


public class Client {
	public static void main(String args[]) throws Exception {
		// Initialisation de l'ORB
		ORB orb = ORB.init(args, null);
				
		String url = "corbaname::localhost:1050#Bob";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		FileSystem fs = FileSystemHelper.narrow(obj);
		
		StringHolder sh = new StringHolder();
		fs.ecrire("/users/nfs/Etu8/3000738/toto.txt", "coucou");
		fs.lire("/users/nfs/Etu8/3000738/toto.txt", sh);
		System.out.println("Affichage: " + sh.value);
	}
}
