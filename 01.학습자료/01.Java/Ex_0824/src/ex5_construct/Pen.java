package ex5_construct;

	// �𳪹� ������ �뷮�����Ѵٰ� ����
public class Pen {
		private String company;
		private String color;
		private int price;
	
	// ������ �ǵ������� ����
	public Pen() {
		company = "monami";
		color = "black";
		price = 500;
	}
	
	// �������� ���� �����ڸ� �ϳ� �� ����
	// setter�� ������ �����ڰ� �Ѵ�.
	// �����ڰ� �����ε��� �� ��
	// �ɹ������� �ʱ�ȭ
	public Pen(String color, int price) {
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
