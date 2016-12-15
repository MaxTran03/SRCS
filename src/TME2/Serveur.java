package TME2;

import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Thread{
	public static void main(String[] argv){
		
		try {
			ServerSocket s = new ServerSocket(2000);
			Socket sock = s.accept();
			Monthread t = new Monthread(sock);
			t.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 