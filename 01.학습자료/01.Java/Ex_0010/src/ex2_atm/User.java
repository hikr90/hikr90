package ex2_atm;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int money = 0;
		
		// ATM ����
		ATM atm = new ATM();
		//
		while(true) {
			System.out.println("1. ��	��");
			System.out.println("2. ��	��");
			System.out.println("3. �ܾ� ��ȸ");
			System.out.println("etc.����");
			System.out.print("> ");
			// �޴� ����
			select = sc.nextInt();
			// ������ �޴� ���� ó��
			switch(select) {
			// �Ա�
			case 1:
				System.out.println("---��	��---");
				System.out.println("�Ա��Ͻ� �ݾ��� �Է����ּ���.");
				System.out.print("> ");
				// ����ڰ� �Ա��Ϸ��� �ݾ�
				money = sc.nextInt();
				
				// �Ա��� �ݾ��� ������, deposit�޼��忡 �ָ� �ȴ�.
				atm.deposit(money);
				break;
			
			// ���
			case 2:
				System.out.println("---��	��---");
				System.out.println("����Ͻ� �ݾ��� �Է����ּ���.");
				System.out.print("> ");
				money = sc.nextInt();
				// ATM Ŭ���� �� withdraw ��� ����
				atm.withdraw(money);				
				break;

			// �ܾ� ��ȸ
			case 3:
				// ATM Ŭ���� �� balance ��� ����
				atm.balance();
				break;

			default:
				System.out.println("����");
				// - �������� while�� ���� �ݺ��� �����Ѵ�.
				return;
			}
		} // while
	} // main
}
