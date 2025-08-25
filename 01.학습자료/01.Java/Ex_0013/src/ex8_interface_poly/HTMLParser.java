package ex8_interface_poly;

public class HTMLParser implements Parseable {
	// 구문 분석 작업을 수행하는 메소드
	public void parse(String fileName) {
		System.out.println(fileName + " - HTML parsing completed.");
	}
}
