package ex1_operator;

public class Ex2_Operator {
	public static void main(String[] args) {

		// �� ������
		int n1 = 10;
		int n2 = 20;
		
		// �� �����ڴ� < (&lt;,) , > (&gt;) ��� �θ��⵵ �Ѵ�.
		boolean result = n1 < n2;
		System.out.println("n1 < n2 : " + result);
		
		result = n1 >= n2;
		System.out.println("n1 >= n2 : " + result);
		
		result = n1 == n2;
		System.out.println("n1 == n2 : " + result);
		
		result = n1 != n2;
		System.out.println("n1 != n2 : " + result);
		
		System.out.println("------------------");
		
		// �� ������
		int age = 21;
		int limit = 25;
		
		boolean res = limit - age >= 5 && (age += 2) > 20;
		System.out.println(age);
		System.out.println(res);
		//
		int i1 = 10;
		int i2 = 20;
		res = (i1 += 10) > 20 || (i2 -= 10) == 11;
		System.out.println(i2);
		System.out.println(res);
		
		// Not
		System.out.println(!res);
		
	}
}
