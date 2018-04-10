package netty.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import netty.websocket.bean.user.SocketUser;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Global {
	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	public static Map<String,SocketUser> map = new ConcurrentHashMap<String, SocketUser>();
}
