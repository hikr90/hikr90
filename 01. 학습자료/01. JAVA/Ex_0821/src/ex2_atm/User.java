package ex2_atm;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int money = 0;
		
		
		// 사용자가 atm기앞에 서있는 상황
		ATM atm = new ATM();

		while(true) {
			System.out.println("1. 입	금");
			System.out.println("2. 출	금");
			System.out.println("3. 잔액 조회");
			System.out.println("etc.종료");
			System.out.print("> ");

			select = sc.nextInt();

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
				
				atm.withdraw(money);				
				break;

			// 잔액 조회
			case 3:
				atm.balance();
				break;

			default:
				System.out.println("종료");
				// 종료하는 방법
				// return으로 while 무한반복을 종료할 수 있다. (이유는, main메소드가 void형이기 때문이다.)
				// break while앞과 break뒤에 outer 라벨을 달아서 종료하는 방법
				// boolean타입의 true값을 default에서 false로 바꿔주는 방법
				return;
			}




		} // while




	} // main
}
