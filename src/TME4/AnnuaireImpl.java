package TME4;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;


public class AnnuaireImpl implements Annuaire{
	String name;
	String num;
	String prenom;
	String adresse;
	Personne p;
	int nb;
	List<IPersonne> annuaire;
	
	public AnnuaireImpl(String name, String num) throws RemoteException{
		this.name = name;
		this.num = num;
	}
	
	public AnnuaireImpl(String name, String num, String prenom, String adresse) throws RemoteException{
		this.name = name;
		this.num = num;
		p = new Personne(name, prenom, num, adresse);
	}
	
	public AnnuaireImpl(Personne p){
		this.p = p;
	}
	
	public AnnuaireImpl(){
		annuaire = new LinkedList<IPersonne>();
	}
	
	@Override
	public void saveName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void saveNum(String num) throws RemoteException {
		// TODO Auto-generated method stub
		this.num = num;
	}

	@Override
	public String findNum(String name) throws RemoteException {
		// TODO Auto-generated method stub	
		return this.num;
	}

	@Override
	public void setPrenom(String prenom) throws RemoteException {
		// TODO Auto-generated method stub
		this.prenom = prenom;
	}

	@Override
	public void setAdresse(String adresse) throws RemoteException {
		// TODO Auto-generated method stub
		this.adresse = adresse;
	}

	@Override
	public String getPrenom() throws RemoteException {
		// TODO Auto-generated method stub
		return p.getPrenom();
	}

	@Override
	public String getAdresse() throws RemoteException {
		// TODO Auto-generated method stub
		return p.getAdresse();
	}

	@Override
	public int getNbRecherche() throws RemoteException {
		// TODO Auto-generated method stub
		return p.getNbRecherche();
	}

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getNum() throws RemoteException {
		// TODO Auto-generated method stub
		return this.num;
	}

	@Override
	public Personne getP() throws RemoteException {
		// TODO Auto-generated method stub
		return this.p;
	}

	
}
