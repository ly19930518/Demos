package cash;

public class ChargeFactory {
	Content content;
	public Content CreateContent(String type){
		switch (type) {
		case "正常":
			content = new Content(new ChargeNormal(100));
			break;
		case "discount":
			break;
		default:
			break;
		}
		return content;
	}
}
