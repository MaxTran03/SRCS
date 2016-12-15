package TME8;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class DirectoryEntry implements Serializable{
	String nom;
	String mail;
	
	public DirectoryEntry(){
		
	}
	
	public DirectoryEntry(String nom, String mail){
		this.nom = nom;
		this.mail = mail;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public String toString(){
		return "Nom: " + this.nom + " et mail: " + this.mail;
	}
}
