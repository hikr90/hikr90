package ex2_static;

public class BankMain {
	
	public static void main(String[] args) {
		
		Bank b1 = new Bank("강남점", "02-111-1111");
		Bank b2 = new Bank("신촌점", "02-111-2222");
		Bank b3 = new Bank("홍대점", "02-111-3333");
		
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();

		// b1에 접근하여 이자율을 바꾸는 것은 가능하나 만약 b100까지 있다고 가정하였을 때, 모든 값을 바꿔줘야한다면?
		// static변수나 메서드는 클래스.static변수(메서드)로 직접 호출해서 사용한다.
		Bank.interest = 0.1f;

		// interest를 static으로 지정한 후, 모든 값이 변경되는 것을 확인
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();

		
		
	
		
		
		
	}
}
