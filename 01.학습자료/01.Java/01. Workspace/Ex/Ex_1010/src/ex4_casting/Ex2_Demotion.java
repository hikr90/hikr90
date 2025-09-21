package ex4_casting;

public class Ex2_Demotion {
	public static void main(String[] args) {
		
		/*	Demotion Casting 
		 * 	- ���� �ڷ����� ū �ڷ����� ���ԵǾ� ����ȯ�� �̷������ ���
		 * 	- ���� �ս��� �Ͼ �� �����Ƿ� �ڵ����� ������� �ʴ´�.
		 * 
		 * 	��� ���
		 * 		- (���� �ڷ���)ū �ڷ��� 
		 */
		char c = 'A'; 		// 2byte
		int n = c + 1; 	// 4byte
		
		// c (2byte) �� n (4byte)�� ����
		c = (char)n;
		System.out.println("c : " + c);
		
		System.out.println("------------------");
	
		// ���� �ս��� ���� ���
		float f = 5.5f; 	// 4.byte
		int num = 0;		// 4byte
		
		num = (int)f;	// ���� 5�� ����Ǹ鼭 0.5�� ���� �սǵȴ�.
		System.out.println("num : " + num);
		
		System.out.println("----------------------------");

		// [����] �� ��ȯ������ ���� �ս�
		System.out.println((int)8.43+2.59);				// 8.43�� 8�� �� �ս�
		System.out.println((int)(8.43+2.59));			// �հ� 11.02�� 11�� �� �ս�
		System.out.println((int)(8.43)+(int)(2.59));	// �հ� 11.02�� 10���� �� �ս�
		
		System.out.println("----------------------------");
		
		/*	Class Type�� ����ȯ
		 *		- String�� Ŭ���� Ÿ������ ����ȯ�� ���ؼ��� �ش� Ÿ���� Ŭ������ �޼ҵ�� ��ȯ�ؾ��Ѵ�.
		 *		- Parsing�� ��ȯ�� ���� ������.
		 */		
		String num1 = "1";
		String num2 = "2";
		System.out.println(Integer.parseInt(num1)+Integer.parseInt(num2));
	}
}
