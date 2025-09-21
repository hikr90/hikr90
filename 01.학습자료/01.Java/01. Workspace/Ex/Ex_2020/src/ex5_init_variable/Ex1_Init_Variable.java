package ex5_init_variable;

public class Ex1_Init_Variable {
	public static void main(String[] args) {	
		/*	������ �ʱ�ȭ
		 * 	- ���� ���� ��, ó������ ���� �����ϴ� ��.
		 * 	- ����� ���ÿ� ������ ������ �����ϴ� ���� ����.
		 * 	- ��� ������ �ʱ�ȭ ���� �ڵ������� ������ �ڷ����� �´� �⺻ ������ �ʱ�ȭ������, ���������� �׷��� �����Ƿ� ��� ���� �ݵ�� �ʱ�ȭ�ؾ� �Ѵ�.
		 * 	
		 * 		�ʱ�ȭ ���
		 * 			(1) ����� �ʱ�ȭ
		 * 			(2) ������ ����
		 * 			(3) �ʱ�ȭ ��
		 */
		
		// �����ڰ� ȣ��Ǹ鼭 ���� �ʱ�ȭ �� ����
		Ex1_2_Init_Variable p1 = new Ex1_2_Init_Variable();
		
		// - �̹� setter�� ������ ����Ǿ����Ƿ� ���� ������ ���� ����.
		// - (���ϼ� ������ �� �ڽŵ� ���ٲ۴�.)
		System.out.println(p1.getCompany());
		System.out.println(p1.getColor());
		System.out.println(p1.getPrice());
		
		System.out.println("-------------");
		
		// - �����ڸ� �Ķ���͸� �޾Ƽ� �����ϴ� �����ε� �����ڸ� ���������
		// - ���ο� ��ü�� �Ķ���Ϳ� �Բ� ���Ӱ� ȣ��
		Ex1_2_Init_Variable p3 = new Ex1_2_Init_Variable("gold",20000);
		System.out.println(p3.getColor());
	}
}

class Ex1_2_Init_Variable {
	//
	private String company;
	private String color;
	private int price;
	
	// �ǵ������� ������ �ۼ�
	public Ex1_2_Init_Variable() {
		company = "monami";
		color = "black";
		price = 500;
	}

	// �����ε��� ���ؼ� ������ �����ڸ� �Ѱ��� �� �����Ѵ�.
	// setter�� ������ �����ڰ� �Ķ���͸� �޾��ָ鼭 ����Ѵ�.
	// �����ڸ� ���� �����ϴ� ����, �⺻ �����ڴ� �ƿ� ����� �� ���� �ȴ�.
	// �����ε� �����ڸ� ���� �����ϸ� �⺻ �����ڵ� �ݵ�� ���� ��������� �Ѵ�.
	public Ex1_2_Init_Variable(String color, int price) {
		this.color = color;
		this.price = price;
	}

	// getter�� ����
	public String getCompany() {
		return company;
	}

	public String getColor() {
		return color;
	}

	public int getPrice() {
		return price;
	}
}

