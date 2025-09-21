package ex8_getInstance;

// 클래스 B의 인스턴스 생성하는 클래스 A
class A {
	public void methodA(B b) {
		b.methodB();
	}
}

// 메소드 B 소유한 클래스 B
class B {
	public void methodB() {
			System.out.println("mehodB");
	}
}

public class Ex1_getInstance {
	public static void main(String[] args) {
		/* (1.1) 클래스 A는 클래스 B의 인스턴스 생성 후 메소드 사용
		 * 	- 이 방식은 B의 선언부가 변경되면, A의 메소드 선언부도 변경되어야 한다.
		*/
		A a = new A();
		a.methodA(new B());		// 파라미터로 B 클래스의 인스턴스 사용
	}
}
