package TME1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MonoLog {
	public static void main(String[] argv) throws IOException {
		int ligne;
		OutputStream os = new FileOutputStream("/users/Etu8/3000738/fic");
		InputStream entree = new BufferedInputStream(System.in);
		
		while((ligne = entree.read()) != -1) {
			os.write(ligne);
			System.out.print((char)ligne);
		}
		os.close();
	}
	
}
