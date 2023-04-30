package ex2_atm;

public class ATM {

	// atm기안의 돈은 해당 클래스를 제외하고 그 누구도 절대 접근할 수 없다.
	private int money;
	
	// 1. 입금
	// user -> atm -> Deposit
	// 다른 클래스 안에서 또 다른 클래스 호출
	public void deposit(int m) {
		Deposit d = new Deposit();
		money = d.deposit(m, money);
	}

	
	// 2. 출급
	public void withdraw(int m) {
		if(money-m<0) {
			System.out.println("잔액이 부족합니다.");
			System.out.println("---------------");
			// 잔액이 부족하니 0으로 리턴하면 된다.
		}else {
			money -= m;
			System.out.println("출금 성공 : "+m);
			System.out.println("---------------");
			}
		
		}
	
	// 3. 잔액조회
	// 잔액확인에는 돈이 들지 않으니 파라미터가 필요없다.
	public void balance() {
		 System.out.println("잔액 : "+money);
		 System.out.println("---------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
