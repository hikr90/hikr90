package ex2_work;

public class Ex2_Work {
	
	// 음료수 클래스
	private String canName;
	private int price;
	
	// 생성자 생성
	public Ex2_Work(String name, int price) {
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
