package ex1_method;

public class Ex1_Method {
	public static void main(String[] args) {
		/*	�޼ҵ�
		 * 		- Ư�� �۾��� �����ϴ� �Ϸ��� ������� �ϳ��� ���� ��
		 * 		- �����, �����η� �����ȴ�.
		 * 		
		 * 		(1) �����
		 * 			- ��ȯŸ��, �޼ҵ��, �Ű����� Ÿ������ �����Ǿ��ִ�.
		 * 				int add(int x, int y) {
		 * 					(2) ������
		 * 						- �޼ҵ尡 ȣ������ �� ����� ������ ���� ����
		 * 					int result = x + y; 
		 * 					
		 * 					(3) return��
		 * 						- �޼ҵ��� ����� ��ȯ���� ȣ���� �޼ҵ�� �����ϴ� Ű����
		 * 						- ��� ���� Ÿ���� ��ȯŸ�԰� ��ġ�ϰų� ��� �ڵ� ����ȯ�� �����ؾ� �Ѵ�.
		 * 					return result;
		 * 				}
		 */
		MyMath mm = new MyMath();
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);
		
		System.out.println("add(5L, 3L) : " + result1);
		System.out.println("subtract(5L, 3L) : " + result2);
		System.out.println("multiply(5L, 3L) : " + result3);
		System.out.println("divide(5L, 3L) : " + result4);
	}
}

//
class MyMath {
	long add(long a, long b) {
		return a + b;
	}
	
	long subtract(long a, long b) { return a - b; }
	long multiply(long a, long b) { return a * b; }
	double divide(double a, double b) {
		return a / b;
	}
}
