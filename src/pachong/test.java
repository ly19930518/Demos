package pachong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.Document;

public class test {
	// 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    private static final String IMGSRC_REG = "[a-zA-z]+://[^\\s]*";
    
	public static void main(String[] args) {
		
//		String str = "测试";
//		try {
//			System.out.println(new String(str.getBytes("gbk"),"gbk"));
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		String url = "http://www.27270.com/tag/434.html";
		try {
			String html = test.getHtml(url);
			List<String> list = test.getImageHTML(html);
			list = test.getImageUrl(list);
			test.Download(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//获取HTML内容
    private static String getHtml(String url)throws Exception{
        URL url1=new URL(url);//使用java.net.URL
        URLConnection connection=url1.openConnection();//打开链接
        InputStream in=connection.getInputStream();//获取输入流
        InputStreamReader isr=new InputStreamReader(in);//流的包装
        BufferedReader br=new BufferedReader(isr);
        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){//整行读取
            sb.append(line,0,line.length());//添加到StringBuffer中
            sb.append('\n');//添加换行符
        }
        //关闭各种流，先声明的后关闭
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }
    
    //解析html中的IMG标签
    public static List<String> getImageHTML(String html){
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(html);
        List<String> listimgurl = new ArrayList<String>();
        while (matcher.find()){
        	String imgurl;
			try {
				imgurl = new String(matcher.group().getBytes(),"utf-8");
				System.out.println(imgurl);
	            listimgurl.add(imgurl);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return listimgurl;
    }
    //获取img 标签中的图片链接
    public static List<String> getImageUrl(List<String> list){
    	List<String> srcs = new ArrayList<String>();
    	for(String image:list){
    		Matcher matcher =  Pattern.compile(IMGSRC_REG).matcher(image);
    		while(matcher.find()){
    			String src = matcher.group();
    			src = src.substring(0,src.length()-1);
    			System.out.println(src);
    			srcs.add(src);
    		}
    	}
    	return srcs;
    }
    
    //下载图片
    private static void Download(List<String> listImgSrc) {
        try {
            //开始时间
            Date begindate = new Date();
            for (String url : listImgSrc) {
                //开始时间
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                File file = new File("C:/xxx/imagesrc/"+imageName);
                FileOutputStream fo = new FileOutputStream(file);//文件输出流
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                //关闭流
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
                //结束时间
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("耗时：" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("总耗时：" + time / 1000 + "s");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
