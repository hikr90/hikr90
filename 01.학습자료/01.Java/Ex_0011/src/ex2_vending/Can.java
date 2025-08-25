package ex2_vending;

public class Can {
	
	// 음료수 클래스
	private String canName;
	private int price;
	
	// 생성자 생성
	public Can(String name, int price) {
		canName = name;
		this.price = price;
	}
	
	public String getCanName() {
		return canName;
	}
	public int getPrice() {
		return price;
	}
}
