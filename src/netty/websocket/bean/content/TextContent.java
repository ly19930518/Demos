package netty.websocket.bean.content;

public class TextContent extends BaseContent{
	private String text;//文本内容
	
	public TextContent() {
		this.head = "100";//普通文本消息
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
