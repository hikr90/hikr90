package ex2_vending;

import java.util.Scanner;

/* 자판기의 사용자 및 관리자*/

public class VendingMain {
	
	public static void main(String[] args) {
		
		// 현재 식에서는 메서드없이 생성자를 생성했으므로, new선언과 동시에 호출(캔을 자판기에 넣음)이 된다. 
		Vending ven = new Vending();
		// private으로 cans를 생성했으므로 ven.cans을 사용할 수 없다. 
		
		
		// 음료수 초기화
		//ven.init();
		
		
		// 금액 투입
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 투입 : ");
		int money = sc.nextInt();		
		ven.showCans(money);
		
		System.out.println("음료 선택 : ");
		String str = sc.next();
		ven.outCan(str);
		
	}
}
