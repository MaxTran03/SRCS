package TME1;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

public class CryptoLog {
	public static void main(String[] argv) throws IOException {
		int ligne;
		String chiffrer = "";
		Writer os = new FileWriter("/users/Etu8/3000738/log");
		InputStream entree = new BufferedInputStream(System.in);
		CesarWriter cf = new CesarWriter(os, 2);
		
		while((ligne = entree.read()) != -1) {
			if((char)ligne == '\n'){
				cf.write(chiffrer, 0, chiffrer.length());
				chiffrer = "";
			}else{
				chiffrer += (char)ligne;
			}
		}
		os.close();
	}
}
