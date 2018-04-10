package base.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap 底层
 * @author tlj
 *
 */
public class test1 {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "111");
		map.put("b", "222");
		Set<Entry<String,String>> set = map.entrySet();
		for(Entry<String,String> entry:set){
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
		}
		
	}
}
	