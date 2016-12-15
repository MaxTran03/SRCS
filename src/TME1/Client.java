package TME1;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
	public static void main(String[] argv){
		Socket sock = new Socket();
		InetSocketAddress localhost = new InetSocketAddress("localhost", 8080);
		SocketAddress LocalAdress;
		SocketAddress ServerAdress;
		
		try{
			sock.connect(localhost, 8080);
				
			LocalAdress = sock.getLocalSocketAddress();
			ServerAdress = sock.getRemoteSocketAddress();
			System.out.println("L'adresse local est: " + LocalAdress + " et l'adresse du serveur est: " + ServerAdress);
			sock.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
