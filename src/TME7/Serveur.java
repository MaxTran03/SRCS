package TME7;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.ejb.Stateless;

@Stateless(name="foobar")
public class Serveur implements CalcItf{

	@Override
	public double add(double d1, double d2) {
		// TODO Auto-generated method stub
		return d1+d2;
	}

	@Override
	public double sub(double d1, double d2) {
		// TODO Auto-generated method stub
		return d1-d2;
	}

	@Override
	public double mult(double d1, double d2) {
		// TODO Auto-generated method stub
		return d1*d2;
	}

	@Override
	public double div(double d1, double d2) {
		// TODO Auto-generated method stub
		if(d2 == 0)
			try {
				throw new DivByZeroException("Erreur division par 0 !");
			} catch (DivByZeroException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return d1 / d2;
	}
	
}
