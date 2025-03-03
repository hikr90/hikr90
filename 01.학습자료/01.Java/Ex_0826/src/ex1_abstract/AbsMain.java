package ex1_abstract;

public class AbsMain {

	public static void main(String[] args) {
		
		// 자식 클래스 객체화
		AbsChild c = new AbsChild();
		c.setValue(30);
		//
		System.out.println(c.age);
		System.out.println(c.getValue());
	}
}
