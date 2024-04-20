package ex2_atm;

public class ATM {

	// atm����� ���� �ش� Ŭ������ �����ϰ� �� ������ ���� ������ �� ����.
	private int money;
	
	// 1. �Ա�
	// user -> atm -> Deposit
	// �ٸ� Ŭ���� �ȿ��� �� �ٸ� Ŭ���� ȣ��
	public void deposit(int m) {
		Deposit d = new Deposit();
		money = d.deposit(m, money);
	}

	
	// 2. ���
	public void withdraw(int m) {
		if(money-m<0) {
			System.out.println("�ܾ��� �����մϴ�.");
			System.out.println("---------------");
			// �ܾ��� �����ϴ� 0���� �����ϸ� �ȴ�.
		}else {
			money -= m;
			System.out.println("��� ���� : "+m);
			System.out.println("---------------");
			}
		
		}
	
	// 3. �ܾ���ȸ
	// �ܾ�Ȯ�ο��� ���� ���� ������ �Ķ���Ͱ� �ʿ����.
	public void balance() {
		 System.out.println("�ܾ� : "+money);
		 System.out.println("---------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
