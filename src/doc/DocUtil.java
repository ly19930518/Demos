package doc;

import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

import jdbc.jdbc;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import pinyin4j.PinYinUtil;
import util.HopenDateUtil;

/**
 * 读取 world 文件信息
 * 所需jar包：poi-3.17.jar,poi-scratchpad.jar  ,poi-ooxml ，xmlbeans-2.6.0.jar 
 * @author tlj
 *
 */
public class DocUtil {
	public static String readDocx(String url){
		 File file = new File(url);
	        String str = "";
	        try {
	        	 FileInputStream fis = new FileInputStream(file);
	             XWPFDocument xdoc = new XWPFDocument(fis);
	             XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
	             String doc1 = extractor.getText();
	             System.out.println(doc1);
	             fis.close();
	             return doc1;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
	public static void main(String[] args) {
		String doc = DocUtil.readDocx("C:\\Users\\ZEVUN-ZY\\Downloads\\3500.docx");
		doc = doc.replace(" ", "");
		doc = doc.replace("\n", "");
		String [] suzu = doc.split("");
		int count = suzu.length;
		int success = 0;
		String error = "";
		jdbc jdbc = new jdbc();
		for(String zi : suzu){
			if(zi != null){
				try {
					Set<String> set = PinYinUtil.getPinYinSet(zi);
					for(String py : set){
						try {
							String sql = "INSERT INTO dictionary ( word, pinyin, `time`) VALUES('"+zi+"', '"+py+"', '"+HopenDateUtil.getNowDate()+"')";
							jdbc.insert(sql);
						} catch (Exception e) {
							System.out.println(zi+"拼音重复："+py);
						}
					}
					success++;
				} catch (Exception e) {
					// TODO: handle exception
					error += zi;
				}
				
			}
		}
		System.out.println(success+" / "+count);
		System.err.println(error);
	}
}
