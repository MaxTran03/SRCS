package TME1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Chiffrement {
	CesarWriter cw;
	
	public Chiffrement(String file, int decalage) throws IOException{
		cw = new CesarWriter(new OutputStreamWriter(new FileOutputStream(file+".Cesar")), decalage);
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		InputStream is = new FileInputStream(file);
		int ligne;
		String chiffrer = "";
		
		while((ligne = is.read()) != -1) {
			chiffrer += Character.toString((char)ligne);
		}
		cw.write(chiffrer, 0, chiffrer.length());
	}
	
	public static void main(String[] argv) throws IOException {
		System.out.println("Début programme!");
		
		Chiffrement c = new Chiffrement("/users/Etu8/3000738/fic", 2);
		
		System.out.println("Fin programme!");
	}
}
