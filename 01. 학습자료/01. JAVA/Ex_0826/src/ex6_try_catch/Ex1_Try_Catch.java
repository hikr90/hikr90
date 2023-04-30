package ex6_try_catch;

public class Ex1_Try_Catch {
	
	public static void main(String[] args) {
		
		
		/* try-catch(����ó��)
		�ڹٿ��� ���α׷��� ����Ǵ� ���� ����(����)�� �߻��ϸ�, �� �������� ���α׷��� ���������� ����ȴ�.
		�� ���� �ùٸ� �Ǵ������� ���δ� ���󰡴��� ������ �߻����� ��, ���α׷� ���� ������� ������ �۾��� �����ؾ��ϴ� ��찡 �ִ�.
		
		����ó���� ���ؼ� ���α׷��� ���������� ���Ḧ ���̰�, ���������� ����� �� �ֵ��� �غ���
		
		
		*/
		
		// ���������� ����
		// java.lang.ArithmeticException: / by zero - exception(��� exception�� �θ��)�� ������ ���ܻ���
		// �� ������ ���� ������ 0���� ������ ���� ����
		int n = 0;
		int result = 0;
		int [] arr = {1,2,3,4};
		
		// try-catch : ���� �ڵ带 {}���� ���´�. 
		// try ���� �ȿ��� �� ������ �״�� catch�� �Ѿ�� catch������ �����Ѵ�.
		// ���� try�������� ������ �߻����� ������ catch�� �������� �ʰ� �״�� ����������. 
		
		// try���������� �� �ϳ��� ������ ó���ϰԵǴµ�
		// ó���ϴ� ������ �ش��ϴ� catch������ �߻��ϰ� �ȴ�.
		

		try {
		
		result = 10 / n;
		arr [3] = 4;
		
		}catch(ArithmeticException e) {
			// ���� �߻��� ������ �̸��� ����ϴ� �޼���
			// ������ �˷��ֵ�, ����� ������ ���ش�.
			// e.printStackTrace();
			System.out.println("0���δ� ���� �� �����ϴ�.");
			result = -1;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� �������� �ʴ� �ε����� ������");
		// ���ܹ߻� ������ ������� ������ ȣ��Ǵ� ����
		}finally {
			System.out.println("finally");
		}
		
		
		System.out.println(result);
		
		
	}
}
