package ex2_atm;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int money = 0;
		
		
		// ����ڰ� atm��տ� ���ִ� ��Ȳ
		ATM atm = new ATM();

		while(true) {
			System.out.println("1. ��	��");
			System.out.println("2. ��	��");
			System.out.println("3. �ܾ� ��ȸ");
			System.out.println("etc.����");
			System.out.print("> ");

			select = sc.nextInt();

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
				
				atm.withdraw(money);				
				break;

			// �ܾ� ��ȸ
			case 3:
				atm.balance();
				break;

			default:
				System.out.println("����");
				// �����ϴ� ���
				// return���� while ���ѹݺ��� ������ �� �ִ�. (������, main�޼ҵ尡 void���̱� �����̴�.)
				// break while�հ� break�ڿ� outer ���� �޾Ƽ� �����ϴ� ���
				// booleanŸ���� true���� default���� false�� �ٲ��ִ� ���
				return;
			}




		} // while




	} // main
}
