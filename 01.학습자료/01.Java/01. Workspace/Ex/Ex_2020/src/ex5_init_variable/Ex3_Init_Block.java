
package ex5_init_variable;

public class Ex3_Init_Block {
	public static void main(String[] args) {
		/*	�ʱ�ȭ ��
		 * 		(1) Ŭ���� �ʱ�ȭ ��
		 * 			- Ŭ���� ������ �ʱ�ȭ
		 * 			- Ŭ���� �� �ν��Ͻ� �� { } �տ� static�� �ٿ� ����Ѵ�.
		 * 			- Ŭ������ �޸𸮰� ó�� �ε��� �� �ѹ� ����ȴ�. (���� ���� ����)
		 * 
		 * 		(2) �ν��Ͻ� �ʱ�ȭ ��
		 * 			- �ν��Ͻ� ������ �ʱ�ȭ
		 * 			- Ŭ���� �� �� { } �� �ۼ��� �� �ȿ� ������ �����Ѵ�.
		 * 			- �����ڿ� ����, �ν��Ͻ� ���� �ø��� ����ȴ�. (�����ں��� �ν��Ͻ� �ʱ�ȭ ���� ���� ����ȴ�.)
		 * 			- �ν��Ͻ� ������ �ʱ�ȭ�� �����ڿ���, �ν��Ͻ� �ʱ�ȭ ������ ��� �����ڿ��� ���������� �����ϴ� ������ �ִ´�.
		 */
		
		System.out.println("Ex5_1_Block b1 = new Ex5_1_Block();");
		Ex5_1_Block b1 = new Ex5_1_Block();

		System.out.println("Ex5_1_Block b2 = new Ex5_1_Block();");
		Ex5_1_Block b2 = new Ex5_1_Block();

	}
}

class Ex5_1_Block {
	static {
		System.out.println("static { } ");
	}
	
	{
		System.out.println(" { } ");
	}
	
	public Ex5_1_Block() {
		System.out.println("������");
	}
}