package ex2_vending;

import java.util.Scanner;

public class VendingMain {
	
	public static void main(String[] args) {
		
		// ���Ǳ� Ŭ������ �����Ѵ�.
		Vending ven = new Vending();
		
		// �ݾ� ����
		Scanner sc = new Scanner(System.in);
		System.out.println("�ݾ� ���� : ");
		int money = sc.nextInt();		
		ven.showCans(money);
		//
		System.out.println("���� ���� : ");
		String str = sc.next();
		ven.outCan(str);
	}
}
