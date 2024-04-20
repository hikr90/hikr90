package ex3_control_statement;

public class Ex1_multiFor {
	public static void main(String[] args) {
		
		/* 
		 ���� for�� : for���ȿ� for���� ���ԵǾ��ִ� ���
		 1 2 3 4 5
		 1 2 3 4 5
		 1 2 3 4 5
		 1 2 3 4 5
		 ���� for���� ��� ���� ������ ó���� �����ϴ�.
		 
		  ���� for������ ����� ������ ���� for������ ����� �� �ִ�. 
		  ��, ���� for������ ������ ������ ���� for�������� ��������ó�� ���δ�.
		 
		 ���� for������ ���� for���� �ٽ� �����ԵǸ� �ٽ� �ʱ�ȭ�� �ϰ� �ȴ�.
		 */

		for(int i=1;i<=4;i++) { 			// y��
			
			for(int j=1;j<=5;j++) { 		// x��
				System.out.print(j + " ");
			} // inner : ���������ȿ� �ִ� for��
		
			// syso���� �ƹ��͵� ġ�� ������ ���θ� ������.
			System.out.println();
		} // outer : ���� for�� �ۿ� �ִ� for��
	
		
		System.out.println("------------------");
		
		/* ���� 
		A B C D
		E F G H
		I J K L
		*/
		
		// tip) for������ �׻� i�� j�� for���� �ϼ��� ���̶�� ���������� �������Ѵ�.
		int a = 65;
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print((char)a+" ");
				a++;
			}
			System.out.println();
		}
		
		
		/*������
		 char ch = 'A';
		 for(int i=1;i<=3;i++){
		 	for(int j=1;j<=4;j++){
		 		
		 		System.out.print(ch++ + " ");

		 	}
		 	System.out.println();
		 }
		 */
		
		
	}
}
