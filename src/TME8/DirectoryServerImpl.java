package TME8;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class DirectoryServerImpl implements DirectoryServerIF{
	List<DirectoryEntry> annuaire = new ArrayList<DirectoryEntry>();
	DirectoryEntry de;
	
	@Override
	public List<DirectoryEntry> listEntries(String nom) throws DirectoryEntryException {
		List<DirectoryEntry> l = new ArrayList<DirectoryEntry>();
		
		for(int i=0; i<annuaire.size(); i++){
			if(annuaire.get(i).getNom().equals(nom)){
				l.add(annuaire.get(i));
			}
		}
		return l;
	}

	@Override
	public List<DirectoryEntry> listAllEntries() {
		// TODO Auto-generated method stub
		return annuaire;
	}

	@Override
	public void addEntry(String nom, String mail)
			throws DirectoryEntryException {
		// TODO Auto-generated method stub
		de = new DirectoryEntry(nom, mail);
		annuaire.add(de);
	}

	@Override
	public void removeEntry(String nom, String mail) throws DirectoryEntryException {
		// TODO Auto-generated method stub
		for(int i=0; i<annuaire.size(); i++){
			if(annuaire.get(i).getNom().equals(nom) && annuaire.get(i).getMail().equals(mail)){
				annuaire.remove(i);
			}
		}
	}

	@Override
	public void removeEntries(String nom) throws DirectoryEntryException {
		// TODO Auto-generated method stub
		for(int i=0; i<annuaire.size(); i++){
			if(annuaire.get(i).getNom().equals(nom)){
				annuaire.remove(i);
			}
		}
	}
	

}
