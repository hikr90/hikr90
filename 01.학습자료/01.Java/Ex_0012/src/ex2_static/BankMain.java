package ex2_static;

public class BankMain {
	
	public static void main(String[] args) {
		//
		Bank b1 = new Bank("������", "02-111-1111");
		Bank b2 = new Bank("������", "02-111-2222");
		Bank b3 = new Bank("ȫ����", "02-111-3333");
		//
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
		
		// static ������ static �޼ҵ�� Ŭ����.static����(�޼ҵ�) ������� ���� ȣ���ؼ� ����Ѵ�.
		Bank.interest = 0.1f;
		// �� Ȯ��
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
	}
}
