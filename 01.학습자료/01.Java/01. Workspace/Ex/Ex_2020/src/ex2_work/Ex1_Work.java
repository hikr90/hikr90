package ex2_work;

import java.util.Scanner;

public class Ex1_Work {
	
	public static void main(String[] args) {
		
		// 자판기 클래스를 선언한다.
		Ex3_Work ven = new Ex3_Work();
		
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
