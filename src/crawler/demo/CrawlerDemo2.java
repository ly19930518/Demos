package crawler.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class CrawlerDemo2 {
	int socketTimeout = 5000;
	int connectTimeout = 5000;
	/**
	 * 默认方法  获取html页面所有元素
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String[] getHTML(String url) throws ClientProtocolException, IOException{
		String [] html = new String[2];
		html[1] =null;
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout)
				.build();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(requestConfig)
				.build();
		HttpGet httpGet = new HttpGet(url);
			try {
				CloseableHttpResponse response = httpClient.execute(httpGet);
				html[0] = String.valueOf(response.getStatusLine().getStatusCode());
				html[1] = EntityUtils.toString(response.getEntity(),"utf-8");
			} catch (IOException e) {
				System.out.println("----------Connection timeout--------");
			}
	
		return html;
	}
	
	/**
	 * cookie方法的getHTMl() 
	 * 设置cookie策略,
	 * 防止cookie rejected问题,拒绝写入cookie     --重载,
	 * 3参数:url, hostName, port
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String getHTML(String url,String hostName,int port) throws ClientProtocolException, IOException{
		//采用用户自定义的cookie策略
		HttpHost proxy  = new HttpHost(hostName,port);
		DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
		CookieSpecProvider cookieSpecProvider = new CookieSpecProvider() {
			@Override
			public CookieSpec create(HttpContext context) {
				return new BrowserCompatSpec(){

					@Override
					public void validate(Cookie cookie, CookieOrigin origi)
							throws MalformedCookieException {
					}
					
				};
			}
		};
		Registry<CookieSpecProvider> r = RegistryBuilder
				.<CookieSpecProvider>create()
				.register(CookieSpecs.BEST_MATCH, new BestMatchSpecFactory())
				.register(CookieSpecs.BROWSER_COMPATIBILITY, new BrowserCompatSpecFactory())
				.register("easy", cookieSpecProvider)
				.build();
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(connectTimeout)
				.setSocketTimeout(socketTimeout)
				.build();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultCookieSpecRegistry(r)
				.setRoutePlanner(routePlanner)
				.build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		String html = "null";//用于验证是否正确取到html
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			html = EntityUtils.toString(response.getEntity(), "utf-8");			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("----Connection timeout----");
		}
		return html;
	}
	/**
	 * proxy代理IP方法
	 */
	public String getHTMLbyProxy(String targetUrl,String hostName,int port){
		HttpHost proxy = new HttpHost(hostName,port);
		String html = "null";
		DefaultProxyRoutePlanner routePlanner =new  DefaultProxyRoutePlanner(proxy);
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout)
				.build();
		
		CloseableHttpClient httpClient = HttpClients.custom()
				.setRoutePlanner(routePlanner)
				.setDefaultRequestConfig(requestConfig)
				.build();
		
		HttpGet httpGet = new HttpGet(targetUrl);
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HttpStatus.SC_OK) { //状态码200: OK
				html = EntityUtils.toString(response.getEntity(), "gb2312");
			}
			response.close();
			//System.out.println(html); //打印返回的html
		} catch (IOException e) {
			System.out.println("----Connection timeout----");
		}
		return html;
	}
	/**
	 * 验证是否存在HTML页面
	 * @param html
	 * @return
	 * @throws InterruptedException
	 */
	private boolean isExistHTML(String html) throws InterruptedException {  
        boolean isExist = false;  
        Pattern pNoResult = Pattern.compile("\\\\u6ca1\\\\u6709\\\\u627e\\\\u5230\\\\u76f8"  
                + "\\\\u5173\\\\u7684\\\\u5fae\\\\u535a\\\\u5462\\\\uff0c\\\\u6362\\\\u4e2a"  
                + "\\\\u5173\\\\u952e\\\\u8bcd\\\\u8bd5\\\\u5427\\\\uff01"); //没有找到相关的微博呢，换个关键词试试吧！（html页面上的信息）  
        Matcher mNoResult = pNoResult.matcher(html);  
        if(!mNoResult.find()) {  
            isExist = true;  
        }  
        return isExist;  
	}
	/**把所有html写到本地txt文件存储 */
	public static void writeHTML2txt(String html, int num) throws IOException {
		String savePath = "e:/weibo/weibohtml/" + num + ".txt";
		File f = new File(savePath);
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(html);
		bw.close();
	}
	
	public static void main(String[] args) {
		CrawlerDemo2 crawler = new CrawlerDemo2();
		String searchword = "ipad"; //搜索关键字为"iPad"的微博html页面
		try {
			String html = crawler.getHTML("http://s.weibo.com/weibo/"+searchword+"&nodup=1&page=50")[1];
			String savePath = "c:/xxx/html.txt"; //输出到txt文件的存放路径
			if(html != "html获取失败") {
				try {
					if(crawler.isExistHTML(html)) {
						System.out.println(html);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
