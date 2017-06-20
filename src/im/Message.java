package im;

public class Message {
	public int type;//消息类型   0 普通 文本   1 对话分配信息  3  系统信息
	public String receiveid;//接收人ID
	public String sendid;//发送人ID
	public String sendtime;//发送时间
	public Object sendMessage;//发送的内容
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(String receiveid) {
		this.receiveid = receiveid;
	}
	public String getSendid() {
		return sendid;
	}
	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public Object getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(Object sendMessage) {
		this.sendMessage = sendMessage;
	}
	@Override
	public String toString() {
		return "{type=" + type + ", receiveid=" + receiveid
				+ ", sendid=" + sendid + ", sendtime=" + sendtime
				+ ", sendMessage=" + sendMessage + "}";
	}
	
	
	
	
}
