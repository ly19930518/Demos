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
		HttpPost httpPost = new HttpPost("https://www.baidu.com");
		//创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("1","1"));
		try {
			//将参数加入到post请求实体中
			httpPost.setEntity(new UrlEncodedFormEntity(formparams,"utf-8"));
			System.out.println("executing request "+httpPost.getURI());
			CloseableHttpResponse responese = httpClient.execute(httpPost);
			try{
				HttpEntity entity = responese.getEntity();
				if(entity != null){
					System.out.println("responese content "+ EntityUtils.toString(entity,"utf-8"));
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
		HttpGet httpget = new HttpGet("https://www.baidu.com/s?wd=java%20post%20%E5%8F%82%E6%95%B0%20keyvalue%20%E7%B1%BB&rsv_spt=1&rsv_iqid=0xc02f9a4000310ad0&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=0&oq=java%2520keyvalue%2520%25E7%25B1%25BB&rsv_t=704ex5iG2BQ6RrPdeP7fZu6brNtDeydAgL%2F4pGQxJWUJnMq7CQRHXXcSwfmmcZceXU7w&rsv_pq=fa9d8666002fd353&rsv_sug3=44&rsv_sug1=24&rsv_sug7=100&rsv_sug2=0&inputT=5332&rsv_sug4=6819&rsv_sug=1");
		System.out.println("executing request "+httpget.getURI());
		//模拟游览器
		httpget.setHeader("Accept", "text/html, */*; q=0.01");
		httpget.setHeader("Accept-Encoding", "gzip, deflate,sdch");
		httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpget.setHeader("Connection", "keep-alive");
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36)");
		
		
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
					System.out.println("response cpntent "+EntityUtils.toString(entity));
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
		h.Get();
	}
}
