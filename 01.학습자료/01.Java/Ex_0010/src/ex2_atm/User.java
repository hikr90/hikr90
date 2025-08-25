package ex2_atm;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int money = 0;
		
		// ATM 동작
		ATM atm = new ATM();
		//
		while(true) {
			System.out.println("1. 입	금");
			System.out.println("2. 출	금");
			System.out.println("3. 잔액 조회");
			System.out.println("etc.종료");
			System.out.print("> ");
			// 메뉴 선택
			select = sc.nextInt();
			// 선택한 메뉴 동작 처리
			switch(select) {
			// 입금
			case 1:
				System.out.println("---입	금---");
				System.out.println("입금하실 금액을 입력해주세요.");
				System.out.print("> ");
				// 사용자가 입금하려는 금액
				money = sc.nextInt();
				
				// 입금할 금액을 적으면, deposit메서드에 주면 된다.
				atm.deposit(money);
				break;
			
			// 출금
			case 2:
				System.out.println("---출	금---");
				System.out.println("출금하실 금액을 입력해주세요.");
				System.out.print("> ");
				money = sc.nextInt();
				// ATM 클래스 내 withdraw 기능 동작
				atm.withdraw(money);				
				break;

			// 잔액 조회
			case 3:
				// ATM 클래스 내 balance 기능 동작
				atm.balance();
				break;

			default:
				System.out.println("종료");
				// - 리턴으로 while의 무한 반복을 종료한다.
				return;
			}
		} // while
	} // main
}
