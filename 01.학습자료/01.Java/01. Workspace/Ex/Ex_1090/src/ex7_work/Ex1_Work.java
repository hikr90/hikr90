package ex7_work;

public class Ex1_Work {

	// ATM의 돈은 외부에서 건드릴 수 없으므로 private
	private int money;

	// 입금
	// - 입금 클래스는 따로 보관
	// - 호출된 클래스 내에서 또 다른 클래스를 호출한다.
	public void deposit(int m) {
		Ex2_Work d = new Ex2_Work();
		money = d.deposit(m, money);
	}

	
	// 출금
	// - 잔액이 부족한 경우 잔액 부족 알림을 띄워준다.
	// - 돈이 있으면 돈을 차감
	public void withdraw(int m) {
		if(money-m<0) {
			System.out.println("잔액이 부족합니다.");
			System.out.println("---------------");
		} else {
			money -= m;
			System.out.println("출금 성공 : "+m);
			System.out.println("---------------");
		}
	}
	
	// 잔액 조회
	// 잔액 확인에는 돈이 들지 않으니 파라미터가 필요없다.
	public void balance() {
		 System.out.println("잔액 : "+money);
		 System.out.println("---------------");
	}
}
