package ex2_vending;

public class Can {

	// 음료수 이름을 저장할 변수
	// 캔은 아무데나서 뽑아먹을 수 없으므로 private
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
