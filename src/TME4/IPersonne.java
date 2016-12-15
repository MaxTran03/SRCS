package TME4;

import java.rmi.Remote;

public interface IPersonne extends Remote {
	public void setNom(String nom);
	public String getNom();
	public void setPrenom(String prenom);
	public String getPrenom();
	public void setAdresse(String adresse);
	public String getAdresse();
	public int getNbRecherche();
	public String getNum();
	public void setNum(String num);
}
