package ex9_interface_getInstance;

// 제3의 클래스 통해서 인스턴스 받는 예제.
// JDBC의 DriverManager 클래스가 해당 방식으로 동작한다.
interface Instance {
	// DB연결을 위한 메소드 선언
	public abstract void methodB();
}

// 클래스 classB 의 인스턴스 반환하는 클래스
class instanceManager {
	public static Instance getInstance() {
		// 외부 클래스 통해서 인스턴스 생성 받음
		return new classB();
	}
}

// 클래스 classB의 인스턴스 생성하는 클래스 classA
class classA {
	public void methodA() {
		Instance i = instanceManager.getInstance(); // 제3의 클래스 (InstanceManager) 메소드 (getInstance) 통해서, 인터페이스 Instance 구현한 클래스(classB) 의 인스턴스 받는다.
		//
		if(i instanceof classB) {
			System.out.println("인스턴스 i와 ClassB의 인스턴스는 같다.");
		}
		//
		i.methodB();
		System.out.println(i.toString());
	}
}

// 인터페이스 Instance 구현하는 InstanceB 클래스
class classB implements Instance {
	// DB 연결을 위한 메소드 구현
	public void methodB() {
		System.out.println("methodB in B class.");
	}
	
	public String toString() {return "class B.";}
}

public class Ex3_InterfaceTest {
	public static void main(String[] args) {
		/* (1.3) 인스턴스 직접 생성없이, getInstance 메소드로 인스턴스 생성하는 방식
		 * 	- 나중에 타 클래스의 인스턴스로 변경되어도, 클래스 classA 의 변경없이 getInstance 메소드만 변경하면 된다는 장점이 있다.
		 */
		classA a = new classA();
		a.methodA();
	}
}
