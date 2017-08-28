package test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		Calendar  calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println("年份："+calendar.get(Calendar.YEAR));
		System.out.println("今年第几天："+calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("本周第几天："+calendar.get(Calendar.WEEK_OF_YEAR));
	}
}
	