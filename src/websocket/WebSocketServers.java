package websocket;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import util.CheckUtil;


/**
 * webSocket 服务端实体类
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket1")
public class WebSocketServers {
	//记录当前在线人数
	private static int onlineCount = 0;
	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	//使用Map,key 为用户标识， value 来存放每个客户端的对应webSocket
    private static Map<String,WebSocketServers> socketMap = new HashMap<String, WebSocketServers>();
    //成功连接的用户信息
    private UserBean user;
    /**
     * 连接成功建立成功的方法
     */
    @OnOpen
    public void onOpen(Session session){
    	
    	this.session = session;
    	//并注册用户信息
    	int uid = socketMap.size() +1;
    	UserBean u = new UserBean();
    	u.setUserid("00"+uid);
    	u.setUsername("测试"+uid+"号");
    	this.user  = u;
    	socketMap.put(user.getUserid(), this);
    	addOnlineCount();
    	System.out.println("有一个新的连接:"+this.user.getUsername()+"，当前在线人数："+getOnlineCount());
    	//检测用户连接
    	//1.获取连接参数
//    	Map<String,List<String>> map = session.getRequestParameterMap();
//    	String userid = map.get("userid").get(0);
//    	String userName = map.get("username").get(0);
    	
    	//2.验证参数 （可以增加检测账号安全）
    	
    	//3.验证成功,服务器注册并保持连接 | 连接失败断开连接
    	
    	//4.检查是否存在离线内容（消息，推送）
    	
    }
    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(){
    	socketMap.remove(this.user.getUserid());
    	subOnlineCount();
    	System.out.println("有一个连接关闭:"+this.user.getUsername()+"，当前在线人数："+getOnlineCount());
    }
    /**
     * 连接错误
     */
    @OnError
    public void onError(Session session,Throwable error){
    	System.out.println("连接发送错误");
    	error.printStackTrace();
    	
    	
    }
    /**
     * 收到客户端消息后调用的方法
     * msg 为json字符串
     */
    @OnMessage
    public void onMessage(String msg,Session session){
    	System.out.println("来自客户端消息："+msg);
    	//群发消息
    	Iterator<Map.Entry<String, WebSocketServers>> iterator = socketMap.entrySet().iterator();
    	while(iterator.hasNext()){
    		Map.Entry<String, WebSocketServers> entry = iterator.next();
    		String info = "我是:"+this.user.getUsername()+"！ 这是一条群体消息("+entry.getValue().user.getUsername()+"接收)";
    		try {
				if(!this.user.getUsername().equals(entry.getValue().user.getUsername())){
					entry.getValue().senMessage(info);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	//1.检验数据包
    	//2.根据数据包进行分析（区分出数据包接收的对象-用户-还是系统（服务器））
    	//3.处理请求
    }
    
    /**
     * 发送消息
     * @throws IOException 
     */
    public void senMessage(String message) throws IOException{
    	this.session.getBasicRemote().sendText(message);
    }
    /**
     * 在线人数加一
     */
    public void addOnlineCount(){
    	onlineCount ++;
    }
    public void subOnlineCount(){
    	onlineCount --;
    }
    /**
     * 获取当前在线人数
     */
    public int getOnlineCount(){
    	return onlineCount;
    }
}
