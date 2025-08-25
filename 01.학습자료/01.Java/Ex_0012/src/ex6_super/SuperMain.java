package ex6_super;

public class SuperMain {
	
	public static void main(String[] args) {
		// 자식 클래스 객체화
		Child c = new Child();
		
		System.out.println(c.getNumber());
		
		// - 자식클래스에서는 number 변수가 없으므로 부모의 int로 들어간다.
		c.setNumber(500);
		System.out.println(c.number);
	}
}
