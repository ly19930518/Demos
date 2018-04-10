package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HopenDateUtil {
	
	public  static Date coverDate(String strdate,String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		try {
			return sf.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public  static String dateAddoneday(String strdate){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=HopenDateUtil.coverDate(strdate,"yyyy-MM-dd");				
		return sdf.format(new Date(date.getTime()+24*3600*1000));
	}
	
	
	
	/**
	 * 
	 * @return  yyyy-MM-dd HH:mm:ss 格式
	 */
	public  static String getNowDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	public  static String formartTime(Object obj){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(obj);
	}
	
	/**
	 * @return 返回格式为yyyyMMddHHmmss的当前时间字符串形式
	 */
	public  static String getNowDate_1(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	
	
	/**
	 * 得到当前时间
	 */
	public  static String getNowDatewu(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	/**
	 * 得到当前时间ymd
	 * 
	 */
	public  static String getNowDateymd(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	/**
	 * 转换某个字符串时间 成另一种格式
	 *  
	 * @param beforeStr 之前的格式
	 * @param afterStr 要转换后的格式
	 */
	public  static String changerDateTimeString(String date,String beforeStr,String afterStr)throws ParseException{
		SimpleDateFormat spw=new SimpleDateFormat(beforeStr);
		Date parse = spw.parse(date);
		SimpleDateFormat sdf=new SimpleDateFormat(afterStr);
		return sdf.format(parse);
	}
	/**
	 * 比较字符串时间大小
	 * @param dateStr
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static int compareDateTime(String dateStr,String dateStr2,String formatStr) throws ParseException{
		SimpleDateFormat spw=new SimpleDateFormat(formatStr);
		Date parse = spw.parse(dateStr);
		
		Date parse2 = spw.parse(dateStr2);
		
		if(parse.getTime()>parse2.getTime()){
			return 1;
		}else if(parse.getTime()<parse2.getTime()){
			return -1;
		}else{
			return 0;
		}
	}
	/**
	 * 得到当前时间ymd
	 * 
	 */
	public  static String getNowDateymd2(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	
	public  static String getNowDateymd3(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		return sdf.format(new Date());
	}
	
	/**
	 * 获取数据库的时间
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date getDataDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date parse = sdf.parse(date);
		return parse;
	}
	
	
	public static Date getDataDate2(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date parse = sdf.parse(date);
		return parse;
	}
	
	
	public static String getfat(String datestr){
		String nian=datestr.substring(0, 4);
		String yue=datestr.substring(4, 6);
		String ri=datestr.substring(6, 8);
		String shi=datestr.substring(8, 10);
		String fen=datestr.substring(10, 12);
		
		return nian+"年"+yue+"月"+ri+"日" +" "+shi+":"+fen+"分";
	}
	
	public static String getfat2(String datestr){
		String nian=datestr.substring(0, 4);
		String yue=datestr.substring(4, 6);
		String ri=datestr.substring(6, 8);
		String shi=datestr.substring(8, 10);   
		String fen=datestr.substring(10, 12);
		
		return nian+"/"+yue+"/"+ri+" "+shi+":"+fen;
	}
	/**
	 * 由带中文和其他字符的日期格式变回日期
	 * @param datestr
	 * @return
	 */
	public static Date getReFat(String datestr) {
		
		String newStr = datestr.replaceAll("[\\D]*", "");
	
		try {
			return getDataDate(newStr+"00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static Date getString2Date(String fat,String datestr){
		
		Date date = null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(fat);//小写的mm表示的是分钟  
			
			  date=sdf.parse(datestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 return date;
		
	}
	
	
	public static Date getNowDateTime(){
		return new Date();
	}
	public  static String getNowDateByFormat(String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	public  static String getYearMonth(String strdate){
		String year=strdate.substring(0,4);
		String month=strdate.substring(5,7);
		return year+month;
	}
	public static Date getDateBeforYear(int year){
		return new Date(new Date().getYear()+year,new Date().getMonth(),new Date().getDay()+1);
	}
	public static Date getDateAddDay(int day){
		Date now=new Date();
		return new Date(now.getTime()+(long)24*3600*1000*day);
	}
	/**
	 * 现在时间减去多少天
	 * @param day：天数
	 * @return
	 */
	public static Date getDateMinusDay(int day){
		Date now=new Date();
		return new Date(now.getTime()-(long)24*3600*1000*day);
	}
	
	
	/**
	 * 现在时间减去多少天
	 * @param day：天数
	 * @return
	 */
	public static String getDateMinusDay2(int day){
		Date now=new Date();
		String _fmt="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(_fmt);
		
		return sdf.format(new Date(now.getTime()-(long)24*3600*1000*day));
	}
	
	
	
	public  static String date2fmtstring(Date date,String fmt){
		String _fmt="yyyy-MM-dd";
		if(fmt!=null){
			_fmt=fmt;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(_fmt);
		return sdf.format(date);
	}	
	
	
	public  static List getNMonth(String begindate,String enddate){
	   List list=new ArrayList();
	   int endyear=Integer.parseInt(enddate.substring(0,4));
	   int endmonth=Integer.parseInt(enddate.substring(5,7));
	   int end=Integer.parseInt(enddate.substring(0,4)+enddate.substring(5,7));
	   
	   int beginyear=Integer.parseInt(begindate.substring(0,4));
	   int beginmonth=Integer.parseInt(begindate.substring(5,7));
	   int begin=Integer.parseInt(begindate.substring(0,4)+begindate.substring(5,7));
	   
	   int cha= Math.abs((endyear*12+endmonth)-(beginyear*12+beginmonth));
	  
	   for(int i=0;i<=cha;i++){
		   if(end>begin){
			   String month=(((beginmonth+i-1)%12+1)+"").length()>1?(((beginmonth+i-1)%12+1)+""):("0"+((beginmonth+i-1)%12+1));
			   list.add((beginyear+(((beginmonth+i)-1)/12))+""+month);
		   }else{
			   String month=(((endmonth+i-1)%12+1)+"").length()>1?(((endmonth+i-1)%12+1)+""):("0"+((endmonth+i-1)%12+1));
			   list.add(((endyear+(((endmonth+i)-1)/12))+""+month));
		   }
		   
	   }
	   return list;
	}
	
//	//毫秒转天 小 分
//	public static String formatDuring(long mss) {  
//	    long days = mss / (1000 * 60 * 60 * 24);  
//	    long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);  
//	    long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);  
//	   String tou=" ";
//	    if(minutes<0){
//	    	tou="(超期)";
//	    	
//	    }
//	    
//	    return tou+" "+StringUtil.twoString(Math.abs(days)+"")+ "天" + StringUtil.twoString(Math.abs(hours)+"") + "小" + StringUtil.twoString(Math.abs(minutes)+"") + "分";
//	} 
	
	//格式化时间-年月日
	public static String formatTime(Object time){
		try{
			String timeStr = time.toString();
			if(timeStr.length()==14){
				return timeStr.substring(0, 4) +"年"+timeStr.substring(4, 6)+"月"+
					timeStr.substring(6, 8)+"日"+" "+timeStr.substring(8, 10)+":"+timeStr.substring(10,12)+
					":"+timeStr.substring(12, 14);
			}else{
				return timeStr.substring(0, 4) +"年"+timeStr.substring(4, 6)+"月"+
						timeStr.substring(6, 8)+"日";
			}
		}catch (Exception e) {
			return "-";
		}
	}
	
	public static String formatTimeNew(Object time){
		try{
			String timeStr = time.toString();
			if(timeStr.length()==14){
				return timeStr.substring(0, 4) +"-"+timeStr.substring(4, 6)+"-"+
					timeStr.substring(6, 8)+" "+timeStr.substring(8, 10)+":"+timeStr.substring(10,12)+
					":"+timeStr.substring(12, 14);
			}else{
				return timeStr.substring(0, 4) +"-"+timeStr.substring(4, 6)+"-"+
						timeStr.substring(6, 8);
			}
		}catch (Exception e) {
			return "--";
		}
	}
	
	/**
	 * 计算endTime与beginTime之间相差的天数
	 * @param beginTime 以yyyyMMdd形式字符串表示的开始时间
	 * @param endTime   以yyyyMMdd形式字符串表示的截止时间
	 */
	public static long calculateApartDays(String beginTime,String endTime){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    long to = 0;
	    long from = 0;
		try {
			from = df.parse(beginTime).getTime();
			to = df.parse(endTime).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return (to - from) / (1000);
	}
	
	/**
	 * 根据开始时间与增加的时间算出目标日期
	 * @param beginTime
	 * @param apartdays
	 * @return
	 */
	public static String calculateEndDay(String beginTime,long apartdays){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long endtime = 0;
		try {
			endtime = df.parse(beginTime).getTime()+apartdays*24*60*60*1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return df.format(new Date(endtime));
	}
	
	/**
	 * 根据现在时间与相差的时间算出开始时间
	 * @param endTime
	 * @param apartdays 天数
	 * @return 返回的字符串格式为yyyyMMdd
	 */
	public static String calculateStartDay(String endTime,long apartdays){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		long endtime = 0;
		try {
			endtime = df.parse(endTime).getTime()-apartdays*24*60*60*1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return df.format(new Date(endtime));
	}
	
	public static java.sql.Date getSqlDateNow(){
		return new java.sql.Date(new Date().getTime());
	} 
	
	public static String formatStartTimeFrom000000(Date date){
		return new SimpleDateFormat("yyyyMMdd").format(date)+"000000";
	}
	
	public static String formatEndTimeTo235959(Date date){
		return new SimpleDateFormat("yyyyMMdd").format(date)+"235959";
	}
	
	
	
	public static long from1970se(){
//		Long nowTime = System.currentTimeMillis();
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(nowTime);
		
		   Date dt= new Date();
		  Long time= dt.getTime();//这就是距离1970年1月1日0点0分0秒的毫秒数
//		  System.out.println(System.currentTimeMillis());//与上面的相同
       
		return time;
	}
	
	public static void main(String[] args) {
//		System.out.println(HopenDateUtil.coverDate2("20111112"));
//		System.out.println(HopenDateUtil.coverDate("2011-11-13").getTime());
//		System.out.println(HopenDateUtil.getNMonth("2011-05-05","2013-01-01"));
//		System.out.println(HopenDateUtil.getNowDate().substring(0, 10));
//		System.out.println(HopenDateUtil.getNowDate().substring(11, 19));
//		System.out.println(HopenDateUtil.coverDate("2011-11-24").getTime()-HopenDateUtil.coverDate("2011-11-25").getTime());
//		System.out.println(HopenDateUtil.date2fmtstring(HopenDateUtil.getDateAddDay(-1),"yyyy-MM-dd"));
//		System.out.println(HopenDateUtil.coverDate("2011-08-01 00:01:12", "yyyy-MM-dd HH:mm:ss"));
//		long time=new Date().getTime();
//		System.out.println(time);
//		System.out.println(new Date(time));
//		String a="73AZ";
//		System.out.println(a.startsWith("8"));
//		System.out.println(a.endsWith("AZ"));

		System.out.println(lxstrtoFat("20150909"));
//		System.out.println(calculateApartDays("20140604", "20140627"));
//		System.out.println(calculateApartDays("20140516", "20140715"));
		
//		System.out.println(from1970se()/1000);
		calculateApartDays("2015-10-01 12:00:00","2015-10-01 12:05:00");
		
		System.out.println(calculateApartDays("2015-10-01 12:00:00","2015-10-01 12:05:00"));
//		System.out.println(getDateMinusDay2(1));
	}
	
	/**
	 * 
	 * 20150423
	 * @param datestr
	 * @return
	 */
	public static String lxstrtoFat(String datestr){
		String dates="";
		String yearstr=datestr.substring(0, 4);
		String MMstr=datestr.substring(4, 6);
		String daystr=datestr.substring(6, 8);
		dates=yearstr+"-"+MMstr+"-"+daystr;
		
		
		return dates;
		
		
	}
	
}

