package ex3_polymorphism;

public class Ex2_Casting {
	public static void main(String[] args) {
		/*	���������� ����ȯ	
		 * 		- ���� ��� ���谡 �ִ� Ŭ������ ���������� ����ȯ�� �����ϴ�.
		 * 		- ����ȯ�� ����� �⺻ �ڷ����� ����.
		 * 			
		 * 		(1) Up Casting 
		 * 			- �ڽ� Ÿ�� > �θ� Ÿ��
		 * 			- ����ȯ ���� ����
		 * 
		 * 		(2) Down Casting
		 * 			- �θ� Ÿ�� > �ڼ� Ÿ��
		 * 			- ����ȯ ���� �Ұ���
		 * 
		 * 		[����] ���������� ����ȯ�� ���������� Ÿ���� �����ϴ� ������ �ν��Ͻ��� �������.
		 * 				 ����ȯ�� ���ؼ�, �����ϰ� �ִ� �ν��Ͻ����� ����� �� �ִ� ����� ������ (����) �����ϴ� �� ���̴�.
		 * 
		 * 		[����] ���� ��Ӱ��迡 �ִ� Ÿ�԰��� ����ȯ�� ��������� �����ϳ� ���������� ����Ű�� �ν��Ͻ��� �ڼ�Ÿ������ ����ȯ�� ������ �ʴ´�.
		 * 				(���������� ����Ű�� �ν��Ͻ��� Ÿ���� �������� Ȯ���ϴ� ���� �߿��ϴ�.)
		 */
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		
		// Up Casting
		car = fe; 				// car = (Car)fe; (����ȯ ����)

		// [����] CarŸ���� ���������δ� water() ȣ�� �Ұ���
		// car.water();			
		
		// Down Casting
		fe2 = (FireEngine)car;
	}
}

//
class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive");
	}
	
	void stop() {
		System.out.println("stop");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water");
	}
}