package TME6;

import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import TME6.cache.FileSystemPOA;


public class Server {
	public static void main(String args[]) throws Exception {
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
		
		FileSystemPOA servant = new FileSystemImpl();
		
		org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
		NameComponent[] names = new NameComponent[] { new NameComponent("Bob", "") };
		nc.rebind(names, obj);
		
		// Traitement des requetes de clients
		orb.run();
	}
}
