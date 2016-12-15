package TME4;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {
	public static void main(String[] args){
		try {
			Personne p = new Personne("Allo", "Morray", "0102030405", "ici");
			
			Annuaire annuaire1 = new AnnuaireImpl("Bob", "0620304050", "L'Eponge", "mer");
			UnicastRemoteObject.exportObject(annuaire1, 0);
			
			Registry registry =  LocateRegistry.createRegistry(3002);
			registry.bind("Bob", annuaire1);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			annuaire1.getP().setPrenom("bouya");
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
