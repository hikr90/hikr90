package ex3_casting;

public class Ex1_promtion {
	public static void main(String[] args) {
		/* Promotion Casting
		 *		- ū �ڷ����� ���� �ڷ����� �����Ͽ� �ڵ����� ����ȯ�� �Ǵ� ����̴�.
		 *	
		 *		ĳ������ ����
		 *			 ���� > �Ǽ�
		 * 			- 8byte�� double�� 4byte�� int���� ���ԵǴ� ��� 8 > 4 �̹Ƿ� �ڵ����� ����ȯ�� �̷������.
		 */
		double d = 100.5;
		int n = 200;
		//
		d = n;
		System.out.println("d : " + d);

		// [����] c�� ���������� �ƽ�Ű�ڵ忡 ���ؼ� �������·� �� ��ȯ�� �ȴ�. 
		char c = 'A';
		int n2 = c + 1;		
		System.out.println("n2 : " + n2);
		
	}
}
