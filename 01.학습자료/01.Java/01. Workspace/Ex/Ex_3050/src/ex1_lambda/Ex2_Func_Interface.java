package ex1_lambda;

public class Ex2_Func_Interface {
	public static void main(String[] args) {
		/* �Լ��� �������̽�
		 * 		- ���ٽ��� �͸� Ŭ������ ��ü�� �����ϴ�.
		 * 		- �͸� Ŭ������ ���������� �־�� ��ü�� �޼ҵ带 ȣ���� �� �ִ�.
		 * 		- ���������� Ŭ������ �������̽��� �ش�ȴ�.
		 * 
		 * 		[����] ���ٽ��� �͸�ü�� ��ü ������ ����
		 * 			(1) ���ٽ��� ������ �͸� ��ü�̱⵵ �ϰ�
		 * 			(2) myFunction �������̽��� ������ �͸� ��ü�� �޼ҵ� max�� ���ٽ��� �Ű�����, Ÿ��, ������ ��ġ�ϹǷ�
		 */
		
		// �������� ��ü ����
		getFunction f = (int a, int b) -> a > b ? a : b;
		int big = f.max(1, 3);
	}
}

@FunctionalInterface	// �޼ҵ带 ȣ���� �� ���ٽ��� �����ϴ� ���������� �Ű������� �����ؾ� �Ѵ�.
interface getFunction {
	// �Լ��� �������̽��� �� �Ѱ��� �߻� �޼ҵ常 ���ǵǾ� �־�� �Ѵ�.
	public abstract int max(int a, int b);
}