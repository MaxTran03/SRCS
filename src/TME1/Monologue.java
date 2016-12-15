package TME1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Monologue {
	/*public static void main (String[] argv) throws IOException{
		String ligne;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		
		while(!(ligne = entree.readLine()).equals("QUIT")){
			System.out.println("La phrase: " + ligne);
		}
		
	}*/
	
	public static void main (String[] argv) throws IOException{
		int ligne;
		InputStream entree = new BufferedInputStream(System.in);
		
		while((ligne = entree.read()) != -1){
			System.out.print((char)ligne);
		}
		
		entree.close();
	}
}
