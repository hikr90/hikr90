package ex7_work;

public class Ex1_Work {
	// ���� Ÿ���� Parserable �������̽�
	public static Ex3_Work getParser(String type) {
		if(type.equals("XML")) {
			return new Ex5_Work();
		} else {
			Ex3_Work p = new Ex2_Work();
			return p;
		}
	}
}
