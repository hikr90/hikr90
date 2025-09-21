package ex8_getInstance;

// Ŭ���� B�� �ν��Ͻ� �����ϴ� Ŭ���� A
class A {
	public void methodA(B b) {
		b.methodB();
	}
}

// �޼ҵ� B ������ Ŭ���� B
class B {
	public void methodB() {
			System.out.println("mehodB");
	}
}

public class Ex1_getInstance {
	public static void main(String[] args) {
		/* (1.1) Ŭ���� A�� Ŭ���� B�� �ν��Ͻ� ���� �� �޼ҵ� ���
		 * 	- �� ����� B�� ����ΰ� ����Ǹ�, A�� �޼ҵ� ����ε� ����Ǿ�� �Ѵ�.
		*/
		A a = new A();
		a.methodA(new B());		// �Ķ���ͷ� B Ŭ������ �ν��Ͻ� ���
	}
}
