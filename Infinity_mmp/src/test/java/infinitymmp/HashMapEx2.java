package infinitymmp;

import java.util.HashMap;
import java.util.Set;

public class HashMapEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Double> hMap=new HashMap<String,Double>();
		hMap.put("TCS",28.0);
		hMap.put("CTS",21.2);
		System.out.println(hMap.get("TCS"));
	
		
		Set<String>keys=hMap.keySet();
		System.out.println("Printing the value from HashMap");
		for(String s:keys)
		{
			System.out.println("Keys::"+s);
			System.out.println("Value::"+hMap.get(s));
		}
	}

}
