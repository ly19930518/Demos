package websocket;

/**
 * 数据包
 * 用于客户端与服务端进行交互
 */
public class DataPacket {
	//接收者唯一标识
	private String targetUserid;
	//发送者唯一标识
	private String sendUserID;
	//发送时间(为方便解析为字符串 yyyy-MM-dd HH:mm:ss)
	private String sendTime;
	//数据包类型
	private String dataType;
	//数据内容
	private Object data;
	
	public String getTargetUserid() {
		return targetUserid;
	}
	public void setTargetUserid(String targetUserid) {
		this.targetUserid = targetUserid;
	}
	public String getSendUserID() {
		return sendUserID;
	}
	public void setSendUserID(String sendUserID) {
		this.sendUserID = sendUserID;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
