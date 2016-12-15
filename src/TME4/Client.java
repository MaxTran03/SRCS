package TME4;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
	public static void main(String[] args){
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(3002);
			Annuaire annuaire1 = (Annuaire)registry.lookup("Bob");
			System.out.println("Nom: " + annuaire1.getName());
			System.out.println("Prenom: " + annuaire1.getPrenom());
			System.out.println("Adresse: " + annuaire1.getAdresse());
			System.out.println("Tel: " + annuaire1.getNum());
			System.out.println("Cherché " + annuaire1.getNbRecherche() + " fois");
			
			System.out.println("\n####################");
			System.out.println("### Serializable ###\n");
			
			Annuaire a = (Annuaire)registry.lookup("Bob");
			Personne p = a.getP();
			
			System.out.println("Recherche: " + p.getNbRecherche());
			System.out.println("Nom: " + a.getName());
			System.out.println("Prenom personne: " + p.getPrenom());
			System.out.println("Prenom annuaire: " + a.getPrenom());
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.setPrenom("morray");
			p.setPrenom("alfred");
			System.out.println("Prenom annuaire: " + a.getPrenom());
			System.out.println("Prenom personne: " + p.getPrenom());
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
