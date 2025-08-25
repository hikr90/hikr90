package ex2_static;

public class BankMain {
	
	public static void main(String[] args) {
		//
		Bank b1 = new Bank("강남점", "02-111-1111");
		Bank b2 = new Bank("신촌점", "02-111-2222");
		Bank b3 = new Bank("홍대점", "02-111-3333");
		//
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
		
		// static 변수나 static 메소드는 클래스.static변수(메소드) 방식으로 직접 호출해서 사용한다.
		Bank.interest = 0.1f;
		// 값 확인
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
	}
}
