package base.jvm.counter;

import java.util.HashMap;

public class test1 {
	public static void main(String[] args) {
		String s = "one two three two three three";  
		String[] sArr = s.split(" ");
		HashMap<String, Integer> counter = new HashMap<String, Integer>();
		for(String a : sArr){
			if(counter.containsKey(a)){
				int oldvalue = counter.get(a);
				counter.put(a, oldvalue+1);
			}else{
				counter.put(a, 1);
			}
		}
		System.out.println(counter.toString());
	}
	
	
}
