package ex3_control_statement;

public class Ex1_Multi_For {
	public static void main(String[] args) {
		
		/*	���� for�� 
		 *		- ���� for���̶�� �Ѵ�.
		 *		- for�� �� for���� ���ԵǾ��ִ� �����̴�.
		 *		- ���� for���� outer��� �θ��� ���� for���� inner��� �θ���.
		 *
		 *		- ���� for���� ��� ���� �����Ͱ� ó�� �����ϴ�.
		 *
		 * 	- ���� for������ ����� ������ ���� for������ ����� �� �ִ�.
		 * 	- ���� for���� ������ ���� for�������� ���� ����ó�� ���ȴ�.
		 */
		for(int i=1;i<=4;i++) { 			// y��
			for(int j=1;j<=5;j++) { 		// x��
				System.out.print(j + " ");
			}
			System.out.println();
		}
	
		System.out.println("------------------");
		
		// ����
		// - A B C D
		// - E F G  H 
		// - I  J  K  L
		// ���� ������ �ֿܼ� �����ּ���.
		int a = 65;
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print((char)a+" ");
				a++;
			}
			System.out.println();
		}
	}
}
