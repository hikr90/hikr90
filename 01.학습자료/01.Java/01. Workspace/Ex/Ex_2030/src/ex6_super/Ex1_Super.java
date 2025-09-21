package ex6_super;

// �ڽ�
public class Ex1_Super extends Ex1_1_Super{
	public Ex1_Super() {
		/*	super
		 * 		- �ڽ��� �θ�κ��� ��ӹ��� ��� ������ ���Ǵ� ��������
		 * 			(�θ� Ŭ������ ���Ѵ�.)
		 * 
		 * 		- �θ�� �ڽ��� �����ϴµ� ���ȴٴ� �������� this�� ����.
		 * 			(��� �ν��Ͻ� �޼ҵ忡���� �ڽ��� ���� �ν��Ͻ��� �ּҰ� ���������� ����ȴ�.)
		 * 
		 * 		- thisó�� Ŭ���� �޼ҵ忡���� ����� �� ����.
		 * 		- super.�޼ҵ� �������� ����Ѵ�.
		 * 		- �ڽ��� �����ڰ� �����ϱ����ؼ� �ݵ�� �θ��� �����ڰ� ���� �����Ѵ�.
		 * 			(�ڽĿ��� �θ��� ����� ����� �� �����Ƿ� �θ��� ����� ���� �ʱ�ȭ �Ǿ�� �Ѵ�.)
		 * 			(�޼ҵ� �� super�� ���� ���� ��� �����Ϸ��� �ڵ����� �ڽ� �����ڿ� super(); �� �����Ͽ� �����Ѵ�.)
		 */
		
		//  �θ� Ŭ������ Parents �� �⺻ �����ڰ� ���� ���⿡, int ���� �޴� �����ڸ� ȣ���ؾ��Ѵ�. (Ȥ�� super(10)�� �����ϰ� Parents�� �⺻ �����ڸ� �߰��Ѵ�.)
		super(10);
		System.out.println("�ڽ� Ŭ������ ������");
	}

	// ���� �ڽ��� 10�� ���� �ް���� ���� ��� �ڽ� Ŭ�������� ������ �ع�����.
	@Override
	public int getNumber() {
		// ���� ����������, �ϴ��� parent�� �������ִ� 10�� �����ϰ� ���� ���� ������ ��������� �Ʒ� ���� �ٲ㼭 �������ϸ� �ȴ�.
		// super.getNumber() : �θ� Ŭ������ getNumber() �޼���
		return 100;
	}
	
	// �ڽ� Ŭ������ this�� �޾��� ������ ���� ���� ��Ī�� ������ �θ�Ŭ������ �ִ� ��� �ڽ� Ŭ������ set���� ���� �� �ִ�. 
	public void setNumber(int number) {
		super.number = number;
	}
}

// �θ�
class Ex1_1_Super {
	//
	int number = 10;
	//
	public Ex1_1_Super(int n) {
		System.out.println("�θ�Ŭ������ ������");
	}
	//
	public int getNumber() {
		return number;
	}
}

// ���� Ŭ����
class Ex1_2_Super {
	public static void main(String[] args) {
		// �ڽ� Ŭ���� ��üȭ
		Ex1_Super c = new Ex1_Super();
		
		System.out.println(c.getNumber());
		
		// - �ڽ�Ŭ���������� number ������ �����Ƿ� �θ��� int�� ����.
		c.setNumber(500);
		System.out.println(c.number);
	}
}