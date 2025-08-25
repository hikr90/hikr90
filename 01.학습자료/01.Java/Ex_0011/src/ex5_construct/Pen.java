package ex5_construct;

public class Pen {
	//
	private String company;
	private String color;
	private int price;
	
	// 의도적으로 생성자 작성
	public Pen() {
		company = "monami";
		color = "black";
		price = 500;
	}

	// - 오버로딩을 통해서 동일한 생성자를 한가지 더 생성한다.
	// - setter의 역할을 생성자가 파라미터를 받아주면서 대신한다.
	
	// - 생성자를 따로 생성하는 순간, 기본 생성자는 아예 사용할 수 없게 된다.
	// - 오버로딩 생성자를 따로 생성하면 기본 생성자도 반드시 따로 기입해줘야 한다.
	public Pen(String color, int price) {
		this.color = color;
		this.price = price;
	}
	
	// getter만 생성
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
