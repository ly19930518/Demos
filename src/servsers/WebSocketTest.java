package servsers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

@ServerEndpoint("/websockets/{userid}/{type}")
public class WebSocketTest {
	private static int count=0;
	
	 //与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	 //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
	//存放游客
	private static Map<String,Session> touristMap = new HashMap<String,Session>();
	//存放客服
	private static Map<String,Session> customerservice = new HashMap<String, Session>();
	/**
	 * 打开连接
	 * @param session
	 */
	@OnOpen
	public void onOpen(@PathParam("userid") String userid,@PathParam("type") String type,Session session){
		/*
		 * 根据类型分配   type  0(游客)    1(普通用户) 2(vip) -1(客户专员)
		 */
		System.out.println(userid);
		this.session=session;
		webSocketSet.add(this);//加入set
		addCount(); //新加入一个连接   
		System.out.println("新加入一个连接-----当前在线："+getCount());
	}
	
	/**
	 * 关闭连接
	 */
	@OnClose
	public void onClose(){
		webSocketSet.remove(this);//断开连接从set 中移除
		subCount();//在线人数-1
		System.out.println("一个连接断开------当前在线："+getCount());
	}
	
	/**
	 * 获取客户端消息
	 * @param message  客户端发送的消息
	 * @param session  与客户端的会话
	 */
	@OnMessage
	public void onMessage(String message,Session session){
		System.out.println("来自客户端消息："+message);
		//群发消息 发送到当前在线每一个连接
		for(WebSocketTest item:webSocketSet){
			try {
				//发送消息
				item.sendMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	
	/**
	 * 发送错误
	 */
	@OnError
	public void onError(Session session, Throwable error){
		System.out.println("发生错误");
		error.printStackTrace();
	}
	
	/**
	 * 发送消息
	 * @param message 需要发送的消息
	 */
	public void sendMessage(String message) throws IOException{
		this.session.getBasicRemote().sendText(message);
	}
	
	/**
	 * 添加在线人数
	 */
	public static void addCount(){
		WebSocketTest.count++;
	}
	
	/**
	 * 下限
	 */
	
	public static void subCount(){
		WebSocketTest.count--;
	}
	
	public static int getCount() {
		return count;
	}
	
}
