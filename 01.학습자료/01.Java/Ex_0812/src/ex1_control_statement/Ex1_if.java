package ex1_control_statement;

public class Ex1_if {
	
	public static void main(String[] args) {
		
		/* ���ǹ�
		 * 	- ���α׷� �帧 ���� ��������, ����̶�� �θ���.
		 * 	- �б⹮�� �ݺ������� �����Ѵ�.
		 * 
		 * 	- �б⹮ : if, if else, else if, switch
		 * 	- �ݺ��� : for, while
		 */
		int n = 51;
		String str = "";
		// �б⹮
		if(n==50) {
			// ������ ���� ��� �Ʒ��� �ڵ带 �����Ѵ�.
			str = "n�� 50�Դϴ�.";
		} 
		
		if(n!=50) {
			str = "n�� 50�� �ƴմϴ�.";
		}
		
		System.out.println(str); 
	}
}
