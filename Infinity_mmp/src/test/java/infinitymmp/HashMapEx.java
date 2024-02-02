package infinitymmp;

import java.util.HashMap;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,String> hMap=new HashMap<String,String>();
		hMap.put("name","Nana");
		hMap.put("address","New York");
		System.out.println(hMap.get("address"));
		
		Set<String>keys=hMap.keySet();
		System.out.println("Printing the value from HashMap");
		for(String s:keys)
		{
			System.out.println("Keys::"+s);
			System.out.println("Value::"+hMap.get(s));
		}
	}

}
