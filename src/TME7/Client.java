package TME7;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {
	public static void main(String args[]) throws Exception {
		Hashtable<String,String> env = new Hashtable<String,String>();
		env.put(Context.PROVIDER_URL, "127.0.0.1:PORTNUMBER");
		
		javax.naming.Context ic = new javax.naming.InitialContext(env);
		SessionCalcItf bean = (SessionCalcItf)ic.lookup("foobar");
		double res = bean.add(3,3);
		res = bean.add(1);
		 
		System.out.println("Résultat = " + res);
	 } 
}
