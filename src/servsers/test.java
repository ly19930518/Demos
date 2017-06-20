package servsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("5");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println("迭代转换："+it.next());
		}
		System.out.println("转换前"+list.toString());
		Set<String> set = new HashSet<String>(list);
//		list.removeAll(list);
		list.clear();
		list.addAll(set);
		list.add("e");
		System.out.println(set.toString());
		System.out.println("listL" + list.toString());
		System.out.printf("1:%s,2:%s",list.toString(),set.toString());
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
