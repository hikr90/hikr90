package ex8_interface_poly;

public class ParserManager {
	// 리턴 타입이 Parserable 인터페이스
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
		}
	}
}
