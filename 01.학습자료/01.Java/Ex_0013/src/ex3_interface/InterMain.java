package ex3_interface;

public class InterMain {

	public static void main(String[] args) {
		// 인터페이스는 구현부 없는 메소드 (추상 메소드) 가 강제적이다.
		InterChild c = new InterChild();
		System.out.println(c.getValue());
	}
}
