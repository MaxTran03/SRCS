package TME5;

import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import TME5.Calculatrice.CalculateurPOA;
import TME5.HashDistante.HashDistPOA;

public class ServeurHash {
	public static void main(String[] args) throws InvalidName, AdapterInactive, IOException, ServantNotActive, WrongPolicy, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName{
		Properties props = new Properties();
		props.put("org.omg.CORBA.ORBInitialPort", "1050");
		props.put("org.omg.CORBA.ORBInitialHost", "localhost");
		ORB orb = ORB.init(args, props);
			
		// Récupération RootPOA, conversions et activation
		org.omg.CORBA.Object rootobj = orb.resolve_initial_references("RootPOA");
		POA poa = POAHelper.narrow(rootobj);
		poa.the_POAManager().activate();
		
		org.omg.CORBA.Object ncobj = orb.resolve_initial_references("NameService");
		NamingContext nc = NamingContextHelper.narrow(ncobj);
		
		HashDistPOA servant = new Hashing();
		org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
		NameComponent[] names = new NameComponent[] { new NameComponent("Bob", "") };
		nc.rebind(names, obj);
		
		CalculateurPOA servant2 = new Calculette();
		org.omg.CORBA.Object obj2 = poa.servant_to_reference(servant2);
		servant.put("tacfaranus", obj2);
		
		// Traitement des requetes de clients
		orb.run();
	}
}
