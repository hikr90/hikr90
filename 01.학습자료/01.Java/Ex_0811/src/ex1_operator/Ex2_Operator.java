package ex1_operator;

public class Ex2_Operator {
	public static void main(String[] args) {
		
		// �� ������ : ������ ����� ���� ���Ͽ� ���� ������ �Ǵ��ϴ� ������
		// ������� �ݵ�� true Ȥ�� false�θ� ��ȯ�ȴ�.
		// ���� ������ ���� booleanŸ���� �������� ���� �� �ִ�.
		int n1 = 10;
		int n2 = 20;
		// �񱳿������� �ؼ��� �¿��� �� �̹Ƿ�, n1�� n2���� �۴�. (jsp������ <�� it, >�� gt�� �θ���.)
		boolean result = n1 < n2;
		System.out.println("n1 < n2 : " + result);
		
		result = n1 >= n2;
		System.out.println("n1 >= n2 : " + result);
		
		result = n1 == n2;
		System.out.println("n1 == n2 : " + result);
		
		result = n1 != n2;
		System.out.println("n1 != n2 : " + result);
		
		System.out.println("------------------");
		
		// �� ������ : �񱳿����ڸ� ���� ������ �ΰ� �̻� �ʿ��� ��, ����ϴ� ������ (�񱳿����ڸ� �����ִ� ����)
		// �� ������ ���� ������� �� �Ǵ� �������� ��ȯ�ȴ�.
		int age = 21;
		int limit = 25;
		
		// &&(and)������ : &&�� �������� ���� ������ �Ǵ��� �� ���� ������ �Ǵ��Ѵ�. �հ� ���� �����ڰ� ��� ���� ��� ������ ��ȯ�Ѵ�. 
		//���� ���� ������ ������ ���, ���� ������ ���� �ʴ´�. 
		// true && true --> true
		// true && false --> false
		// false && true --> false
		// false && false --> false
		
		boolean res = limit - age >= 5 && (age += 2) > 20;
		System.out.println(age);
		System.out.println(res);
		
		// ||(or)������ : ||�� �������� �� �� �ϳ��� �����̸� ������ ��ȯ�Ѵ�.
		// ���� ���� ������ ���� ��� ���� ������ �������� �ʴ´�.
		// false || false --> false
		// false || true --> true
		// true || false --> true
		// true || true --> true

		int i1 = 10;
		int i2 = 20;
		res = (i1 += 10) > 20 || (i2 -= 10) == 11;
		System.out.println(i2);
		System.out.println(res);
		
		// !(not)������ : !�� boolean���� �տ����� ����� �� �ִ�. boolean���� �տ� ���̴� ���, ���� �������� ������ ������ ��ȯ���ش�. 
		// !�� ���������� ���� �������� �ʴ´�. 
		// ���������� ���� �����ϰ����ϸ� booleanŸ���� ������ �������Ѵ�. (res = !res;)
		System.out.println(!res);
		
	}
}
