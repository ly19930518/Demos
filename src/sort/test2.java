package sort;

import java.lang.reflect.Field;

public class test2 {
	public static void swap(Integer numa,Integer numb){
		int tmp = numa.intValue();
		try {
			Field field = Integer.class.getDeclaredField("value");
			field.setAccessible(true);
			field.set(numa, numb);
			field.set(numb,new Integer(tmp));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("numa="+numa+"numb="+numb);
	}
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 1;
		Integer c = 128;
		Integer d = 128;
		System.out.println("a = b"+(a == b)+"\nc == d"+(c == d));
		System.out.println("a="+a+" b="+b);
		swap(a,b);
		System.out.println("a="+a+" b="+b);
	}
}
