package TME2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] argv){
		
		try {
			Socket sock = new Socket();
			InetSocketAddress localhost = new InetSocketAddress("localhost", 2000);
			
			sock.connect(localhost, 2000);
			
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			Scanner sc = new Scanner(System.in);
			System.out.println("Saisir le type de requête (GET ou PUT):");
			String str = sc.nextLine();
			
			InputStream is = sock.getInputStream();
			InputStreamLiner isl = new InputStreamLiner(is);
			
			if(str.compareTo("GET") == 0){
				dos.writeBytes("GET /users/Etu8/3000738/workspace1/SRCS/src/TME2/index.html HTTP/1.0\n");
				dos.writeBytes("\n");
				
				String res = isl.readLineUnix();
				System.out.println(res);
				
				if(res.compareTo("HTTP/1.0 404 Not Found") == 0){
					while((res = isl.readLineUnix()) != null)
						System.out.println(res);
				}else{
					while((res = isl.readLineUnix()) != null)
						System.out.println(res);
				}
			}else if(str.compareTo("PUT") == 0){
				String fic = "/users/Etu8/3000738/workspace1/SRCS/src/TME2/index1.html";
				File f = new File(fic);
				
				System.out.println("Début envoie");
				
				dos.writeBytes("PUT /users/Etu8/3000738/workspace1/SRCS/src/TME2/index1.html HTTP/1.0\n");
				dos.writeBytes("Content-length: 64\n");
				dos.writeBytes("Content-type: text/html\n");
				dos.writeBytes("\n");
				dos.writeBytes("<html><head></head><body>Coucou</body></html>");
				
				System.out.println("Fin envoie");
				
				/*String res = isl.readLineUnix();
				System.out.println(res);*/
				
			}else
				System.out.println("Erreur de saisie!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
