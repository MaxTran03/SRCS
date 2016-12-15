package TME8;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;

public class DirectoryClient {
	public static void main(String args[]) throws Exception {
		Hashtable<String,String> env = new Hashtable<String,String>();
		env.put(Context.PROVIDER_URL, "127.0.0.1:PORTNUMBER");
		
		javax.naming.Context ic = new javax.naming.InitialContext(env);
		DirectoryServerIF bean = (DirectoryServerIF)ic.lookup("java:global/Annuaire/DirectoryServerImpl");
		
		bean.addEntry("Tac", "tac@morray.fr");
		bean.addEntry("Tac", "tacfarinas.ainas@etu.upmc.fr");
		bean.addEntry("Max", "maxime.tran@etu.upmc.fr");
		
		List<DirectoryEntry> l = bean.listAllEntries();
		
		System.out.println("####### Initial #######");
		System.out.println("Liste de l'annuaire:");
		for(int i=0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
		
		List<DirectoryEntry> l2 = bean.listEntries("Tac");
		
		System.out.println("#######################");
		System.out.println("Les mails de Tac le Morray:");
		for(int i=0; i<l2.size(); i++){
			System.out.println(l2.get(i));
		}
		
		System.out.println("\n##### Supression #####");
		bean.removeEntry("Tac", "tac@morray.fr");
		l = bean.listAllEntries();
		l2 = bean.listEntries("Tac");
		
		System.out.println("Liste de l'annuaire:");
		for(int i=0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
		
		System.out.println("######################");
		System.out.println("Les mails de Tac le Morray:");
		for(int i=0; i<l2.size(); i++){
			System.out.println(l2.get(i));
		}
	} 
}
