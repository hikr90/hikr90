package ex2_vending;

import java.util.Scanner;

/* ���Ǳ��� ����� �� ������*/

public class VendingMain {
	
	public static void main(String[] args) {
		
		// ���� �Ŀ����� �޼������ �����ڸ� ���������Ƿ�, new����� ���ÿ� ȣ��(ĵ�� ���Ǳ⿡ ����)�� �ȴ�. 
		Vending ven = new Vending();
		// private���� cans�� ���������Ƿ� ven.cans�� ����� �� ����. 
		
		
		// ����� �ʱ�ȭ
		//ven.init();
		
		
		// �ݾ� ����
		Scanner sc = new Scanner(System.in);
		System.out.println("�ݾ� ���� : ");
		int money = sc.nextInt();		
		ven.showCans(money);
		
		System.out.println("���� ���� : ");
		String str = sc.next();
		ven.outCan(str);
		
	}
}
