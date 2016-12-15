package TME4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Annuaire extends Remote {
	public void saveName(String name) throws RemoteException;
	public void saveNum(String num) throws RemoteException;
	public String getName() throws RemoteException;
	public String getNum() throws RemoteException;
	public String findNum(String name) throws RemoteException;
	public void setPrenom(String prenom) throws RemoteException;
	public void setAdresse(String adresse) throws RemoteException;
	public String getPrenom() throws RemoteException;
	public String getAdresse() throws RemoteException;
	public int getNbRecherche() throws RemoteException;
	public Personne getP() throws RemoteException;
}
