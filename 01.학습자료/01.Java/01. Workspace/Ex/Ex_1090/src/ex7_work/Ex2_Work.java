package ex7_work;

public class Ex2_Work {
	// 입금 전용 클래스
	// - 사용자가 입금하려는 금액, ATM이 가지고있는 금액
	public int deposit(int m, int money) {
		money += m;
		System.out.println("입금이 완료되었습니다.");
		System.out.println("---------------");
		return money;
	}
}
