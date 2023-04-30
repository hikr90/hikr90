package ex6_super;

public class Parents {
	// 만약 이거 private인 경우에는 어떻게 받아야하지?
	int number = 10;
	
	public Parents(int n) {
		System.out.println("부모클래스의 생성자");
	}

	public int getNumber() {
		return number;
	}
	
	
	
	
}
