package ex2_work;

import java.util.Scanner;

public class Ex1_Work {
	
	public static void main(String[] args) {
		
		// ���Ǳ� Ŭ������ �����Ѵ�.
		Ex3_Work ven = new Ex3_Work();
		
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
