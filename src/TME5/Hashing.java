package TME5;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.Object;

import TME5.HashDistante.HashDistPOA;

public class Hashing extends HashDistPOA{
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public boolean containsKey(String key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}

	@Override
	public void put(String key, Object val) {
		// TODO Auto-generated method stub
		if(!containsKey(key))
			map.put(key, val);
		else
			System.out.println("Existing key!");
	}

}
