package ex3_casting;

public class Ex2_demotion {
	public static void main(String[] args) {
		
		// 2. demotion casting : ���� �ڷ����� ū �ڷ����� ���� (���� �ս��� �Ͼ �� �����Ƿ� �ڵ����� �̷����� �ʴ´�.)
		char c = 'A'; // 2byte
		int n = c + 1; // 4byte
		
		// ���� �ڷ����� ū �ڷ����� ����
		// �������� ���� : ������ ���뷮������ ����
		// ���� ���� : ��������
		// ���� �ڷ��� = (���� �ڷ����� �ڷ�Ÿ��)ū �ڷ���
		c = (char)n;
		// 'A'�� 65�μ� +1�� 66���� ���������� ���ϸ� �ƽ�Ű�ڵ忡 �ش��ϴ� 'B'�� ���´�.
		System.out.println("c : " + c);
		
		System.out.println("------------------");
		
		float f = 5.5f; // 4.byte
		int num = 0;	// 4byte
		
		num = (int)f;
		// ���� 5�� �����鼭 ���� �ս��� ����.
		System.out.println("num : " + num);
		
		System.out.println("----------------------------");

		// �� ��ȯ������ ���� ����
		//10.59 (���� 8.43�� ����ȯ �Ǿ� 8�� �ȴ�.)
		System.out.println((int)8.43+2.59);
		//11 (11.02�� ����ȯ�Ǿ� 10�� �ȴ�.)
		System.out.println((int)(8.43+2.59));
		//10 (8+2�� �Ǿ� 10�� �ȴ�.)
		System.out.println((int)(8.43)+(int)(2.59));
		
		System.out.println("----------------------------");
		
		// CLASS TYPE�� ����ȯ
		// String�� CLASSŸ������ ����ȯ�� ���ؼ��� �� Ÿ�Կ� �´� ���� �־���Ѵ�. 
		// PARSING�� ��ȯ�� ���� ������.
		String num1 = "1";
		String num2 = "2";
		
		System.out.println(Integer.parseInt(num1)+Integer.parseInt(num2));

		
		
	}
}
