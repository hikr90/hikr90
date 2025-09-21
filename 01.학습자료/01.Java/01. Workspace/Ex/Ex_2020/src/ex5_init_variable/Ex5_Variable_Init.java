package ex5_init_variable;

public class Ex5_Variable_Init {
	public static void main(String[] args) {
		/*	��������� �ʱ�ȭ ���� 
		 * 		(1) ����
		 *			(1.1) Ŭ���� ����
		 *				- Ŭ������ ó�� �ε��� �� �ѹ� �ʱ�ȭ
		 *
		 *			(1.2) �ν��Ͻ� ����
		 *				- �ν��Ͻ��� ������ ������ �� �ν��Ͻ� ���� �ʱ�ȭ
		 *
		 *		(2) ����
		 *			(1.3) Ŭ���� ���� 
		 *				- �⺻�� > ����� �ʱ�ȭ > Ŭ���� �ʱ�ȭ ��
		 *
		 *			(1.4) �ν��Ͻ� ����
		 *				- �⺻�� > ����� �ʱ�ȭ > �ν��Ͻ� �ʱ�ȭ �� > ������
		 */
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1�� ��ǰ��ȣ (serialno) : " + p1.serialNo);
		System.out.println("p2�� ��ǰ��ȣ (serialno) : " + p2.serialNo);
		System.out.println("p3�� ��ǰ��ȣ (serialno) : " + p3.serialNo);
		System.out.println("������ ��ǰ�� ���� ��� " + Product.count + "�Դϴ�.");
	}
}

class Product {
	static int count = 0;	// ������ �ν��Ͻ��� ���� �����ϱ� ���� ����
	int serialNo = count;	// �ν��Ͻ� ���� ��ȣ
	
	{
		++count;			//  Product �ν��Ͻ��� ������ ������ count�� ���� 1�� �������Ѽ� serialNo�� ����ȴ�.
		serialNo = count;
	}
	
	public Product() {};
}