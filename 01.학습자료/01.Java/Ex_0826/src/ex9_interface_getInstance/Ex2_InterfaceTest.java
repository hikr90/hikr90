package ex9_interface_getInstance;

// 추상 메소드 B 소유한 인터페이스
interface I {
	public abstract void methodB();
}

// 인터페이스 I 받아서 B 메소드 실행하는 클래스 A
class TestA {
	public void methodA(I i) {
		i.methodB();
	}
}

// 인터페이스 I 구현하는 클래스 B
class TestB implements I{
	public void methodB() {
			System.out.println("mehodB in TestB class.");
	}
}

//인터페이스 I 구현하는 클래스 C
class TestC implements I{
	public void methodB() {
			System.out.println("mehodB in TestC class.");
	}
}

public class Ex2_InterfaceTest {
	public static void main(String[] args) {
		/* (1.2) 매개변수로 인터페이스 인스턴스 동적으로 받는 경우
		 *		- TestA가 작성되는 동안, TestB는 아무 영향을 받지 않는다.
		 *		- TestA는 인터페이스 i을 통해서 실제로 사용하는 클래스의 명칭을 몰라도, 실제로 구현된 클래스가 존재하지 않아도 무방하다.
		 *		- 인터페이스 interface.java는 실제 구현 내용 (TestB)을 감싸고있는 껍데기이며, TestA는 껍데기 안에 어떤 알맹이 (클래스)가 들어있는지 몰라도 된다.
		 */
		TestA a = new TestA();
		a.methodA(new TestB());
		a.methodA(new TestC());
	}
}
