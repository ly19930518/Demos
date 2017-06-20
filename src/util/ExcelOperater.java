package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

public class ExcelOperater {
	
	  public static void main(String[] args)    
	    {   
		  
	        jxl.Workbook readwb = null;   
	        try{   
	            //构建Workbook对象, 只读Workbook对象   
	            //直接从本地文件创建Workbook   
	            InputStream instream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\简品互联遗留客户导入.xls");   
	            readwb = Workbook.getWorkbook(new File("C:\\wkfbpt\\imgfile\\temp\\43037b9406db48f49b063f0ea5c0d5b9.xls"));   
	            //Sheet的下标是从0开始   
	            //获取第一张Sheet表   
	            Sheet readsheet = readwb.getSheet(0);   
	            //获取Sheet表中所包含的总列数   
	            int rsColumns = readsheet.getColumns();   
	            //获取Sheet表中所包含的总行数   
	            int rsRows = readsheet.getRows();   
	            //获取指定单元格的对象引用   
	            //存放值的List
	            List<Map> list = new ArrayList<Map>();
	            for (int i = 0; i < rsRows; i++) {   
	            	//不获取头
	            	if(i!=0){
	            		Map<String,String> map=new HashMap<String, String>();
	            		for (int j = 0; j < rsColumns; j++) {  
	            			StringBuffer sbf = new StringBuffer();
		                    Cell cell = readsheet.getCell(j, i);
		                    map.put((sbf.append(j)).toString(), cell.getContents().toString());
		                } 
	            		list.add(map);
	            	}
	            }   
	            System.out.println(list.toString());
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } finally {   
	            readwb.close();   
	        }   
	} 
	  //"C:\\Users\\Administrator\\Desktop\\简品互联遗留客户导入.xls"
	public static List<Map> getExcels(String src){
		
        jxl.Workbook readwb = null;   
        //存放值的List
        List<Map> list = new ArrayList<Map>();
        try{   
            //构建Workbook对象, 只读Workbook对象   
            //直接从本地文件创建Workbook 
            InputStream instream = new FileInputStream(src);
            readwb = Workbook.getWorkbook(instream);   
            //Sheet的下标是从0开始   
            //获取第一张Sheet表   
            Sheet readsheet = readwb.getSheet(0);   
            //获取Sheet表中所包含的总列数   
            int rsColumns = readsheet.getColumns();   
            //获取Sheet表中所包含的总行数   
            int rsRows = readsheet.getRows();   
            //获取指定单元格的对象引用   
            for (int i = 0; i < rsRows; i++) {   
            	//不获取头
            	if(i!=0){
            		Map<String,String> map=new HashMap<String, String>();
            		for (int j = 0; j < rsColumns; j++) {  
            			StringBuffer sbf = new StringBuffer();
	                    Cell cell = readsheet.getCell(j, i);
	                    map.put((sbf.append(j)).toString(), cell.getContents().toString());
	                } 
            		list.add(map);
            	}
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            readwb.close();   
        }   
		return list;
	}
}
