package ex8_interface_poly;

public class ParserTest {
	public static void main(String[] args) {
		//
		Parseable p = ParserManager.getParser("XML");
		p.parse("document.xml");
		//
		p = ParserManager.getParser("HTML");
		p.parse("document2.xml");
	}
}
