package ex7_work;

public class Ex4_Work {
	public static void main(String[] args) {
		//
		Ex3_Work p = Ex1_Work.getParser("XML");
		p.parse("document.xml");
		//
		p = Ex1_Work.getParser("HTML");
		p.parse("document2.xml");
	}
}
