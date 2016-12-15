
package TME6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.StringHolder;

import TME6.cache.DoesNotExist;
import TME6.cache.FileSystemPOA;

public class FileSystemImpl extends FileSystemPOA{
	Map<String, StringHolder> map = new HashMap<String, StringHolder>();
	
	@SuppressWarnings("resource")
	@Override
	public boolean lire(String ref, StringHolder data) throws DoesNotExist {
		// TODO Auto-generated method stub
		InputStream is = null;
		String s = "";
		
		if(map.containsKey(ref)){
			System.out.println("toto");
			try {
				is = new FileInputStream(ref);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			try {
				s = br.readLine();
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data.value = s;
			System.out.println("allo: " + data.value);
			return true;
		}
		return false;
	}

	@Override
	public boolean ecrire(String ref, String data) {
		// TODO Auto-generated method stub
		
		if(!map.containsKey(ref)){
			StringHolder sh = new StringHolder(data);
			map.put(ref, sh);
		}
		
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(ref);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter bw = new BufferedWriter(fw);
			
		try {
			bw.flush();
			bw.write(data);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
}
