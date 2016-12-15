package TME4;

import java.io.Serializable;

public class Personne implements Serializable, IPersonne {
	String prenom;
	String nom;
	String adresse;
	String num;
	int nb = 0;
	
	public Personne(String nom, String prenom, String num, String adresse){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.num = num;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	public void setAdresse(String adresse){
		this.adresse = adresse;
	}
	
	public String getAdresse(){
		return this.adresse;
	}
	
	public int getNbRecherche(){
		return ++this.nb;
	}
	
	public String getNum(){
		return this.num;
	}
	
	public void setNum(String num){
		this.num = num;
	}
}
