package ex2_vending;

public class Can {
	
	// ����� Ŭ����
	private String canName;
	private int price;
	
	// ������ ����
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
