package http.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class httpRequest {
	public void Post(){
		//创建默认httpclient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建httpPost
		HttpPost httpPost = new HttpPost("http://wap.abcyir.com/zhuche.jsp");
		//模拟游览器
		httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpPost.setHeader("Accept-Encoding", "gzip, deflate");
		httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Mobile Safari/537.36");
		
		//创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("1","1"));
		try {
			//将参数加入到post请求实体中
			httpPost.setEntity(new UrlEncodedFormEntity(formparams,"gb2312"));
			System.out.println("executing request "+httpPost.getURI());
			CloseableHttpResponse responese = httpClient.execute(httpPost);
			try{
				HttpEntity entity = responese.getEntity();
				if(entity != null){
					System.out.println("responese content "+ EntityUtils.toString(entity,"gb2312"));
				}
			}finally{
				responese.close();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接释放资源
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void Get(){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建httpget
		HttpGet httpget = new HttpGet("http://wap.abcyir.com");
		System.out.println("executing request "+httpget.getURI());
		//模拟游览器
//		httpget.setHeader("Accept", "text/html, */*; q=0.01");
//		httpget.setHeader("Accept-Encoding", "gzip, deflate,sdch");
//		httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
//		httpget.setHeader("Connection", "keep-alive");
//		httpget.setHeader("User-Agent", "Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18124");
//		
		try {
			//执行请求
			CloseableHttpResponse response = httpClient.execute(httpget);
			try{
				//获取响应体
				HttpEntity entity = response.getEntity();
				//响应状态
				System.out.println(response.getStatusLine());
				if(entity != null){
					System.out.println("response length "+entity.getContentLength());
					System.out.println("response cpntent "+EntityUtils.toString(entity,"gb2312"));
				}
			}finally{
				response.close();
			}
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			//释放资源
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//
	}
	public static void main(String[] args) {
		httpRequest h =new httpRequest();
		h.Post();
	}
}
