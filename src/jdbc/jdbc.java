package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class jdbc {
	 public ArrayList getList(){//单表查询  
         ArrayList ar=new ArrayList();//存储从数据库中取出来的数据  
         Connection conn=BaseConnection.getConnection();//获取数据库连接  
         //sql执行器对象  
         PreparedStatement ps=null;  
         //结果集对象  
         ResultSet rs=null;//查询出来的数据先放到rs中  
         try{  
               String sql="select * from dictionary";  
               ps=conn.prepareStatement(sql);  
               rs=ps.executeQuery();//执行数据库查询的方法，放到rs中  
               while(rs.next()){//rs对象相当于一个指针，指向数据库的一横行数据  
               }  
         }catch(Exception e){  
             e.printStackTrace();  
         }finally{//重点下面代码必须写，当数据库使用后必须关闭，如果没有关闭数据库的接口有限，下次就不能连接  
             try{  
                 if(rs!=null){  
                     rs.close();  
                 }if(ps!=null){  
                     ps.close();  
                 }if(conn!=null){  
                     conn.close();  
                 }  
             }catch(Exception e2){  
                 e2.printStackTrace();  
             }  
         }  
         return ar;//返回ar  
     }  
     public void insert(String sql){
    	//插入数据
         ArrayList ar=new ArrayList();//存储从数据库中取出来的数据  
         Connection conn=BaseConnection.getConnection();//获取数据库连接  
         //sql执行器对象  
         PreparedStatement ps=null;  
         //结果集对象  
         ResultSet rs=null;//查询出来的数据先放到rs中  
         try{  
               ps=conn.prepareStatement(sql);  
               ps.executeUpdate();//执行数据库查询的方法，放到rs中  
         }catch(Exception e){  
             e.printStackTrace();  
         }finally{//重点下面代码必须写，当数据库使用后必须关闭，如果没有关闭数据库的接口有限，下次就不能连接  
             try{  
                 if(rs!=null){  
                     rs.close();  
                 }if(ps!=null){  
                     ps.close();  
                 }if(conn!=null){  
                     conn.close();  
                 }  
             }catch(Exception e2){  
                 e2.printStackTrace();  
             }  
         }  
     }
     public static void main(String[] args){  
    	 jdbc jdbc =new jdbc();
    	 String sql = "INSERT INTO dictionary ( word, pinyin, `time`) VALUES('1', '1', '1')";
    	 jdbc.insert(sql);
     }  
}
