package ex1_variable_stactic;

public class Ex2_Stactic {
		
		/*	static
		 *		- �ν��Ͻ��� ���������� ��� �� �����ϴ� Ű����
		 *		- ���� �հ� �޼ҵ� �տ� �پ� Ŭ���� ����, Ŭ���� �޼ҵ��� �θ���.
		 *		- Ŭ���� ���� �� Ŭ���� �޼ҵ�� heap ������ �ƴ� static ������ ����ȴ�.
		 *		- static ������ �Ҵ�� �޸𸮴� ��� ��ü�� �����ϹǷ� ��𿡼��� ��� �����ϴ�.
		 *		- static ������ ������ �÷����� ���� �ۿ� �־� static ���� �� �ý����� ������ �϶��Ѵ�.
		 */
		String str1 = "�Ϲ����� ��� ����";
		static String str2 = "stactic �����Դϴ�. ";
		
		// static �޼���
		public static void result() {
			// System.out.println(str1); // �Ϲ����� ��� ���� ��� �Ұ���
			System.out.println(str2);
			//
			int num = 10;				// �Ϲ����� ���������� ���� ����
			// static int num = 10;	// static ������ ���� �Ұ���
		} 

		// �Ϲ� �޼ҵ�
		public void getResult() {
			// static�� ��� ���� ��� ��� �����ϴ�.
			System.out.println(str1);			
			System.out.println(str2);
			
			// static int num = 10; 	// �Ϲ� �޼ҵ� ������ static ������ ����� �� ����.
			int num = 10;		// �Ϲ� �޼ҵ� ������ �Ϲ����� ���������� ����� �� �ִ�.
		}

		// [����] ��ü ���� ��, �θ� Ŭ������ �����ڰ� ���� �����ǰ� �� �� �ڽ� ��ü�� �����ڰ� �����ȴ�.
		// - ��, �θ� ��üȭ�ϴ� ��� �θ�� �ڽ��� �ּ� ���� ���� ��ġ�� �ʴ´�.
}
