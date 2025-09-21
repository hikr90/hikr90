package ex3_system;

public class Ex1_System_In_Out {
	public static void main(String[] args) {
		/*	ǥ������� (IO)
		 * 		- �ܼ��� ���� ������ �Է°� �ַܼ��� ������ ����� �ǹ��Ѵ�.
		 * 		- �ڹٿ����� ǥ�� ������� ���� �Ʒ� 3������ ����� ��Ʈ���� �����Ѵ�.
		 * 		- �� ���� �ڹ� ���ø����̼��� ����� ���ÿ� ����� �� �ְ� �ڵ������� �����ǹǷ� �����ڰ� ������ ��Ʈ���� �����ϴ� �ڵ带 �ۼ����� �ʰ� ��� �����ϴ�. 
		 * 
		 * 			(1) System.in 	: �ַܼκ��� �����͸� �Է¹޴µ� ��� 	(Java > InputStream < Console)
		 * 			(2) System.out 	: �ַܼ� �����͸� ����ϴµ� ��� 		(Java > PrintStream > Console)
		 * 			(3) System.err 	: �ַܼ� �����͸� ����ϴµ� ��� 		(Java > PrintStream > Console)
		 * 
		 * 			[����] in, out, err�� SystemŬ������ ����� Ŭ���� ���� (static)�̴�.
		 */
		try {
			int input = 0;
			
			while ((input = System.in.read()) != -1) {
				System.out.println("input : " + input + ", (char)input : " + (char)input);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
