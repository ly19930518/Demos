package test;

import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import sun.misc.Cleaner;

public class test4 {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		Integer [] l = {1,2,3};
		list =  Arrays.asList(l);
		System.out.println(list.toString());
		for(int i  = 0 ; i < list.size();i++){
			System.out.println(list.get(i));
		}
		list.forEach(System.out::println);
		list.forEach(e -> System.out.println("方式二："+e));
		Calendar calendar = Calendar.getInstance();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(calendar.getTime()));
		System.out.println(calendar.DAY_OF_WEEK);
	}
}
