package ex7_work;

public class Ex1_Work {

	// ATM�� ���� �ܺο��� �ǵ帱 �� �����Ƿ� private
	private int money;

	// �Ա�
	// - �Ա� Ŭ������ ���� ����
	// - ȣ��� Ŭ���� ������ �� �ٸ� Ŭ������ ȣ���Ѵ�.
	public void deposit(int m) {
		Ex2_Work d = new Ex2_Work();
		money = d.deposit(m, money);
	}

	
	// ���
	// - �ܾ��� ������ ��� �ܾ� ���� �˸��� ����ش�.
	// - ���� ������ ���� ����
	public void withdraw(int m) {
		if(money-m<0) {
			System.out.println("�ܾ��� �����մϴ�.");
			System.out.println("---------------");
		} else {
			money -= m;
			System.out.println("��� ���� : "+m);
			System.out.println("---------------");
		}
	}
	
	// �ܾ� ��ȸ
	// �ܾ� Ȯ�ο��� ���� ���� ������ �Ķ���Ͱ� �ʿ����.
	public void balance() {
		 System.out.println("�ܾ� : "+money);
		 System.out.println("---------------");
	}
}
