package ex9_interface_getInstance;

// ��3�� Ŭ���� ���ؼ� �ν��Ͻ� �޴� ����.
// JDBC�� DriverManager Ŭ������ �ش� ������� �����Ѵ�.
interface Instance {
	// DB������ ���� �޼ҵ� ����
	public abstract void methodB();
}

// Ŭ���� classB �� �ν��Ͻ� ��ȯ�ϴ� Ŭ����
class instanceManager {
	public static Instance getInstance() {
		// �ܺ� Ŭ���� ���ؼ� �ν��Ͻ� ���� ����
		return new classB();
	}
}

// Ŭ���� classB�� �ν��Ͻ� �����ϴ� Ŭ���� classA
class classA {
	public void methodA() {
		Instance i = instanceManager.getInstance(); // ��3�� Ŭ���� (InstanceManager) �޼ҵ� (getInstance) ���ؼ�, �������̽� Instance ������ Ŭ����(classB) �� �ν��Ͻ� �޴´�.
		//
		if(i instanceof classB) {
			System.out.println("�ν��Ͻ� i�� ClassB�� �ν��Ͻ��� ����.");
		}
		//
		i.methodB();
		System.out.println(i.toString());
	}
}

// �������̽� Instance �����ϴ� InstanceB Ŭ����
class classB implements Instance {
	// DB ������ ���� �޼ҵ� ����
	public void methodB() {
		System.out.println("methodB in B class.");
	}
	
	public String toString() {return "class B.";}
}

public class Ex3_InterfaceTest {
	public static void main(String[] args) {
		/* (1.3) �ν��Ͻ� ���� ��������, getInstance �޼ҵ�� �ν��Ͻ� �����ϴ� ���
		 * 	- ���߿� Ÿ Ŭ������ �ν��Ͻ��� ����Ǿ, Ŭ���� classA �� ������� getInstance �޼ҵ常 �����ϸ� �ȴٴ� ������ �ִ�.
		 */
		classA a = new classA();
		a.methodA();
	}
}
