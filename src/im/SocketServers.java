package im;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

@ServerEndpoint("/imServers/{userid}/{type}")
public class SocketServers {
	private static int count=0;
	
	 //与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	 //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<SocketServers> webSocketSet = new CopyOnWriteArraySet<SocketServers>();
	private static Map<String,Client> maps = new HashMap<String, Client>();
	//存放游客
	private static Map<String,Object> touristMap = new HashMap<String,Object>();
	//存放客服
	private static Map<String,Object> customerservice = new HashMap<String, Object>();
	//对话存储
	private static Map<String,String> dialogue = new HashMap<String, String>();
	/**
	 * 打开连接
	 * @param session
	 */
	@OnOpen
	public void onOpen(@PathParam("userid") String userid,@PathParam("type") String type,Session session){
		/*
		 * 根据类型分配   type  0(游客)    1(普通用户) 2(vip) -1(客户专员)
		 */
		this.session = session;
		System.out.println(session.getMessageHandlers());
		Client client = new Client();
		client.setUserid(userid);
		client.setType(type);
		client.setSocket(this);
		maps.put(userid, client);
		System.out.println("成功连接"+userid);
//		if(type.equals("0")){
//			Message ms = new Message();
//			ms.setSendtime(new Date().toString());
//			Map<String, Object> fp = new HashMap<String, Object>();
//			fp.put("type", "1");
//			ms.setSendMessage(fp);
//			ms.setType(1);
//			this.sendMessage(ms);
//		}else if(type.equals("-1")){
//			
//		}
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
	 * @param message  客户端发送的消息    //后续消息变成json 对象
	 * @param session  与客户端的会话
	 */
	@OnMessage
	public void onMessage(String message,Session session){
		JSONObject json = JSONObject.fromObject(message);
		System.out.println(json.toString());
		if(maps.containsKey(json.get("receiveid"))){
//			System.out.println("存在");
			Message ms = (Message) JSONObject.toBean(json,Message.class);
			String receiveid = json.get("receiveid").toString();
			System.out.println(maps.get(receiveid).getSocket());
			maps.get(receiveid).getSocket().sendMessage(ms);
		}else{
			Message ms = new Message();
			ms.setSendtime(new Date().toString());
			ms.setSendMessage("当前客服没有在线");
			ms.setType(3);
			this.sendMessage(ms);
		}
//		for(Map.Entry<String, Client> entry : maps.entrySet()){
//			Client client = entry.getValue();
//			if(client.getSocket() != this){
//				try {
//					client.getSocket().sendMessage(message);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
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
	public void sendMessage(Message message){
		try {
			this.session.getBasicRemote().sendText(JSONObject.fromObject(message).toString());
//			this.session.getBasicRemote().sendObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加在线人数
	 */
	public static void addCount(){
		SocketServers.count++;
	}
	
	/**
	 * 下限
	 */
	
	public static void subCount(){
		SocketServers.count--;
	}
	
	public static int getCount() {
		return count;
	}
	

}
