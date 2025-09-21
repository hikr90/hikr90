package ex1_lambda;

public class Ex4_Lambda_Casting {
	public static void main(String[] args) {
		/* ���ٽ��� Ÿ�԰� ����ȯ 
		 *		- ���ٽ��� �͸� ��ü�̰�, �͸� ��ü�� Ÿ���� �������� �ʴ´�.
		 *			(��Ȯ���� Ÿ���� ������ �����Ϸ��� ���Ƿ� �̸��� ���ϹǷ� �� �� ����.)
		 *
		 * 			myFunction f = (myFuntion) (() -> { System.out.print("method"); })
		 * 	
		 * 			
		 */
		
		// [����] ���ٽ��� ����ȯ
		//		- ���ٽ��� �������̽��� ���� �������� ������ �� �������̽��� ������ Ŭ������ ��ü�� ������ �����ϹǷ� �Ʒ��� ���� ����ȯ�� ����Ѵ�.
		ex4_1_myFunction f = (ex4_1_myFunction) (() -> { System.out.println("f.method()"); });
		Object obj = (ex4_1_myFunction) (() -> { System.out.println("obj.method()"); });
		String str = ((Object)(ex4_1_myFunction) () -> { System.out.println("str.method()"); }).toString();
		
		f.method();
		System.out.println(obj);
		System.out.println(str);
	}
}

interface ex4_1_myFunction {
	void method();
}