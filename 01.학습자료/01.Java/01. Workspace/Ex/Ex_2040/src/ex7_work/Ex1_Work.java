package ex7_work;

public class Ex1_Work {
	// 리턴 타입이 Parserable 인터페이스
	public static Ex3_Work getParser(String type) {
		if(type.equals("XML")) {
			return new Ex5_Work();
		} else {
			Ex3_Work p = new Ex2_Work();
			return p;
		}
	}
}
