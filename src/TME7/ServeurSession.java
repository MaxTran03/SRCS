package TME7;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.ejb.Stateful;

@Stateful
public class ServeurSession implements SessionCalcItf{
	double val;
	
	@Override
	public double add(double d1, double d2) {
		// TODO Auto-generated method stub
		return val=d1 + d2;
	}

	@Override
	public double sub(double d1, double d2) {
		// TODO Auto-generated method stub
		return val=d1 - d2;
	}

	@Override
	public double mult(double d1, double d2) {
		// TODO Auto-generated method stub
		return val=d1 * d2;
	}

	@Override
	public double div(double d1, double d2) throws DivByZeroException {
		// TODO Auto-generated method stub
		if(d2 == 0)
			throw new DivByZeroException("Erreur: division par 0 !");
		return val=d1 / d2;
	}

	@Override
	public double add(double d) {
		// TODO Auto-generated method stub
		return val+=d;
	}

	@Override
	public double sub(double d) {
		// TODO Auto-generated method stub
		return val-=d;
	}

	@Override
	public double mult(double d) {
		// TODO Auto-generated method stub
		return val*=d;
	}

	@Override
	public double div(double d) throws DivByZeroException {
		// TODO Auto-generated method stub
		if(d == 0)
			throw new DivByZeroException("Erreur: division par 0 !");
		return val/=d;
	}

	@Override
	public void eraseMemory() {
		// TODO Auto-generated method stub
		val = 0;
		
	}

	@Override
	public void killSession() {
		// TODO Auto-generated method stub
		eraseMemory();
		
	}


}
