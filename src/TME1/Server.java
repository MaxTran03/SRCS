package TME1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
	public static void main(String[] argv) throws IOException {
		
		
		try{
			Thread.sleep(5000);
			ServerSocket ss = new ServerSocket(8080);
			SocketAddress LocalAdress;
			SocketAddress ServerAdress;
			
			Socket sock = ss.accept();
			
			LocalAdress = sock.getLocalSocketAddress();
			ServerAdress = sock.getRemoteSocketAddress();
			System.out.println("L'adresse local est: " + LocalAdress + " et l'adresse du serveur est: " + ServerAdress);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
