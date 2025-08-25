package ex5_construct;

public class Pen {
	//
	private String company;
	private String color;
	private int price;
	
	// �ǵ������� ������ �ۼ�
	public Pen() {
		company = "monami";
		color = "black";
		price = 500;
	}

	// - �����ε��� ���ؼ� ������ �����ڸ� �Ѱ��� �� �����Ѵ�.
	// - setter�� ������ �����ڰ� �Ķ���͸� �޾��ָ鼭 ����Ѵ�.
	
	// - �����ڸ� ���� �����ϴ� ����, �⺻ �����ڴ� �ƿ� ����� �� ���� �ȴ�.
	// - �����ε� �����ڸ� ���� �����ϸ� �⺻ �����ڵ� �ݵ�� ���� ��������� �Ѵ�.
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
