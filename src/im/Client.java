package im;

import java.util.Date;

import javax.websocket.Session;

public class Client {
	public String userid;
	public String type;
	public SocketServers socket;
	public Date uptime;
	public String ip;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	public SocketServers getSocket() {
		return socket;
	}
	public void setSocket(SocketServers socket) {
		this.socket = socket;
	}
	
}
