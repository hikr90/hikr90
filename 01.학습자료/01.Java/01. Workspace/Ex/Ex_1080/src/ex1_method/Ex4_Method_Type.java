package ex1_method;

public class Ex4_Method_Type {
	public static void main(String[] args) {
		/*	�޼ҵ� Ÿ�� 
		 * 		(1) �ν��Ͻ� �޼ҵ�
		 *			- �Ϲ����� ������ �޼ҵ�
		 *			- �ν��Ͻ� ������ �ν��Ͻ� ���� �� ����� �� �����Ƿ� �ν��Ͻ� �޼ҵ� ���� �ݵ�� ��ü ������ ���ؼ��� ���� �����ϴ�.
		 *			- �ν��Ͻ� �޼ҵ� �������� Ŭ���� ������ ����� �����ϴ�.
		 *				(�ν��Ͻ� ������ �����ϴ� ���� �̹� Ŭ���� ������ �޸𸮿� �������� �ǹ��ϱ� �����̴�.)
		 *
		 *		(2) Ŭ���� �޼ҵ� (static)
		 *			- �ν��Ͻ� ���� Ȥ�� �ν��Ͻ� �޼ҵ�� ���� ���� �޼ҵ�
		 *			- ��ü �������� 'Ŭ������.�޼ҵ��' �� ���·� ���� �����ϴ�.
		 *			- Ŭ���� �޼ҵ� ���ο����� �ν��Ͻ� ������ ����� �� ����.
		 *				
		 *		[����] �ν��Ͻ� ������ �ݵ�� �ν��Ͻ��� ���� �ؾ��ϳ�, Ŭ���� �޼ҵ�� �ν��Ͻ� ���� ���� ȣ���� �����ϹǷ� Ŭ���� �޼ҵ� ȣ�� ��, �ν��Ͻ��� ���� �� �ִ� ��Ȳ�� �����Ͽ� �����Ǿ��ִ�.
		 */
		
		// Ŭ���� �޼ҵ� ȣ��
		System.out.println(myMath2.add(200L, 100L));
		System.out.println(myMath2.subtract(200L, 100L));
		System.out.println(myMath2.multiply(200L, 100L));
		System.out.println(myMath2.divide(200L, 100L));

		// �ν��Ͻ� �޼ҵ� ȣ��
		myMath2 m2 = new myMath2();
		m2.a = 200L;
		m2.b = 100L;
		// �ν��Ͻ� �޼ҵ�� ��ü ���� �Ŀ��� ȣ���� �����ϴ�.
		System.out.println(m2.add());
		System.out.println(m2.subtract());
		System.out.println(m2.multiply());
		System.out.println(m2.divide());
	}
}

class myMath2 {
	long a, b;
	
	// �ν��Ͻ� �������� ����ϹǷ� �Ű������� �ʿ����.
	long add() { return a + b; }
	long subtract() { return a - b; }
	long multiply () { return a * b; }
	double divide() { return a / b; }
	
	// �ν��Ͻ� ������ ������� �Ű����������ε� �۾��� ����
	static long add(long a, long b) { return a + b; }
	static long subtract(long a, long b) { return a - b; }
	static long multiply (long a, long b) { return a * b; }
	static double divide(long a, long b) { return a / b; }
}
