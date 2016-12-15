package TME2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;

public class Monthread extends Thread{
	Socket sock;
	HashMap<String, String> map = new HashMap<String, String>();
	
	public Monthread(Socket s){
		super();
		this.sock = s;
	}
	
	public void run(){
		InputStream is;
		
		try {
			is = sock.getInputStream();
			InputStreamLiner isl = new InputStreamLiner(is);
			
			String req, ligne;
			req = isl.readLineUnix();
			System.out.println("La requête est: " + req);
			HttpRequest hr = new HttpRequest(req, sock);
			
			String key = "", value = "";
			while((ligne = isl.readLineUnix()).compareTo("") != 0){
				System.out.println("Header: " + ligne);
				char c;
				int i = 0;
				while((c = ligne.charAt(i)) != ':'){
					key += c;
					i++;
				}
				value = ligne.substring(i+1, ligne.length());
				map.put(key, value);
			}
			/*
			if(req.startsWith("PUT")){
				if((ligne = isl.readLineUnix()).compareTo("") != 0)
					System.out.println("Ligne: " + ligne);
			}*/
			
			hr.processRequest();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
