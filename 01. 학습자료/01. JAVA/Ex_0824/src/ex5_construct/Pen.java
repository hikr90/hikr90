package ex5_construct;

	// 모나미 볼펜을 대량생산한다고 가정
public class Pen {
		private String company;
		private String color;
		private int price;
	
	// 생성자 의도적으로 노출
	public Pen() {
		company = "monami";
		color = "black";
		price = 500;
	}
	
	// 한정판을 위한 생성자를 하나 더 생성
	// setter의 역할을 생성자가 한다.
	// 생성자가 오버로딩이 된 것
	// 맴버변수의 초기화
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
