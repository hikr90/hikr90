package ex2_atm;

public class Deposit {
	// �Ա� ���� Ŭ����
	// - ����ڰ� �Ա��Ϸ��� �ݾ�, ATM�� �������ִ� �ݾ�
	public int deposit(int m, int money) {
		money += m;
		System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
		System.out.println("---------------");
		return money;
	}
}
