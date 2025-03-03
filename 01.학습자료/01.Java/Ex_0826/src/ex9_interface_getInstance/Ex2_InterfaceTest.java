package ex9_interface_getInstance;

// �߻� �޼ҵ� B ������ �������̽�
interface I {
	public abstract void methodB();
}

// �������̽� I �޾Ƽ� B �޼ҵ� �����ϴ� Ŭ���� A
class TestA {
	public void methodA(I i) {
		i.methodB();
	}
}

// �������̽� I �����ϴ� Ŭ���� B
class TestB implements I{
	public void methodB() {
			System.out.println("mehodB in TestB class.");
	}
}

//�������̽� I �����ϴ� Ŭ���� C
class TestC implements I{
	public void methodB() {
			System.out.println("mehodB in TestC class.");
	}
}

public class Ex2_InterfaceTest {
	public static void main(String[] args) {
		/* (1.2) �Ű������� �������̽� �ν��Ͻ� �������� �޴� ���
		 *		- TestA�� �ۼ��Ǵ� ����, TestB�� �ƹ� ������ ���� �ʴ´�.
		 *		- TestA�� �������̽� i�� ���ؼ� ������ ����ϴ� Ŭ������ ��Ī�� ����, ������ ������ Ŭ������ �������� �ʾƵ� �����ϴ�.
		 *		- �������̽� interface.java�� ���� ���� ���� (TestB)�� ���ΰ��ִ� �������̸�, TestA�� ������ �ȿ� � �˸��� (Ŭ����)�� ����ִ��� ���� �ȴ�.
		 */
		TestA a = new TestA();
		a.methodA(new TestB());
		a.methodA(new TestC());
	}
}
