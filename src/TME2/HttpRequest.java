package TME2;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;


public class HttpRequest {
	String req, header;
	InputStreamLiner isl;
	Socket sock;
	HashMap<String, String> map = new HashMap<String, String>();
	
	public HttpRequest(String request, Socket sock){
		this.req = request;
		this.sock = sock;
	}
	
	public void processRequest(){
		
		if(req.startsWith("GET") == true){
			processGet(req.substring(4, req.length()));
		}
		if(req.startsWith("PUT") == true){
			processPut(req.substring(4, req.length()));
		}
	}
	
	public void processGet(String s){
		char c;
		int i = 0;
		String fic = "", version = "";
		
		while((c = s.charAt(i)) != ' '){
			fic += c;
			i++;
		}
		version = s.substring(i+1, s.length());
		
		System.out.println("Le fichier est: " + fic + " et la version est: " + version);
		
		File f = new File(fic);
		
		try {
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				
				dos.writeBytes(version + " 200 OK\n");
				dos.writeBytes("Content-type: text/html\n");
				dos.writeBytes("\n");
				
				String contenuFic = "";
				int x;
				while((x = fis.read()) != -1){
					contenuFic += Character.toString((char)x);
				}
				dos.writeBytes(contenuFic);
				
			}else{
				dos.writeBytes(version + " 404 Not Found\n");
				dos.writeBytes("\n");
				dos.writeBytes("Fichier inexistant\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void processPut(String s){
		char c;
		int i = 0;
		String fic = "", version = "";
		
		while((c = s.charAt(i)) != ' '){
			fic += c;
			i++;
		}
		version = s.substring(i+1, s.length());
		
		System.out.println("Le fichier est: " + fic + " et la version est: " + version);
		
		File f = new File(fic);
		
		try {
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			FileWriter fw = new FileWriter(fic, false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			InputStream is = sock.getInputStream();
			InputStreamLiner isl = new InputStreamLiner(is);
			
			if(f.exists()){
				String contenuFic = "", ligne;
				while((ligne = isl.readLineUnix()) != null){
					if(ligne != null)
						contenuFic = ligne;
					System.out.println("Contenu fichier: " + contenuFic);
				}
				bw.write(contenuFic);
				bw.flush();
				bw.close();
				System.out.println("Message envoyé!");
				
				/*dos.writeBytes(version + " 200 OK\n");*/
			}else{
				System.out.println("EXITE PAS\n");
				dos.writeBytes(version + " 404 Not Found\n");
				dos.writeBytes("\n");
				dos.writeBytes("Fichier inexistant\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public boolean verifHTTP(String v){
		if(v.equals("HTTP/1.0"))
			return true;
		if(v.equals("HTTP/1.1"))
			return true;
		return false;
	}
}
