package ex2_while;

public class Ex1_while {
	public static void main(String[] args) {
		
		/* while : ������ ������ ���� �ݺ���
		  �� �� �� ó��
		 
		 while(���ǽ�){
		 	���ǽ��� ���� ��, ����Ǵ� ����
		 }
		 
		
		���ǽ��� �� -> ���๮ ���� -> �ٽ� �� �� �� -> ���๮ ����
		��, while(true)�� �ִ� ��� ���ѹݺ��� �� �� �ִ�.
		
		 */
		
		int num = 1;
		
		while(num<=3) {
			System.out.println(num);
			num++;
		}
		
		System.out.println("---------------");
		
		
		while(true) {
			System.out.println("�ȳ�");
		}
		
		// ���� ������� �ڵ尡 ���ѹݺ��� ���, �Ʒ��� ���� ������ �ȵǹǷ� ������ ����.
		// System.out.println("---------------");
	}
}
