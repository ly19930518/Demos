package netty.websocket.bean.message;

import java.util.Date;

import netty.websocket.bean.content.BaseContent;

public class BaseMessage {
	//消息头 用于区分 消息内容
	private String head;
	//发送时间
	private String sendTime;
	//内容体
	private BaseContent content;
	private String senderName;
	private String senderID;
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public BaseContent getContent() {
		return content;
	}
	public void setContent(BaseContent content) {
		this.head = content.head;
		this.content = content;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	
	
	
	
}	
