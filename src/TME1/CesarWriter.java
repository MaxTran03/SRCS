package TME1;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CesarWriter extends FilterWriter{
	int d;
	
	protected CesarWriter(Writer out, int d) {
		super(out);
		// TODO Auto-generated constructor stub
		this.d = d;
	}
	@Override
	public void write(String str, int off, int len) throws IOException{
		String cypher = "";
		
		System.out.println("Contenu du fichier: " + str);
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'z')
				cypher += Character.toString((char)('a'+(str.charAt(i)-'a'+this.d)%26));
			else
				cypher += str.charAt(i);
		}
		
		System.out.println("Fichier chiffré: " + cypher);
		super.write(cypher, off, len);
		super.flush();
	}
	
	
}
