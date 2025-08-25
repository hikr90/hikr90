package ex2_vending;

import java.util.Scanner;

public class VendingMain {
	
	public static void main(String[] args) {
		
		// 자판기 클래스를 선언한다.
		Vending ven = new Vending();
		
		// 금액 투입
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 투입 : ");
		int money = sc.nextInt();		
		ven.showCans(money);
		//
		System.out.println("음료 선택 : ");
		String str = sc.next();
		ven.outCan(str);
	}
}
