package ex2_static;

public class BankMain {
	
	public static void main(String[] args) {
		
		Bank b1 = new Bank("������", "02-111-1111");
		Bank b2 = new Bank("������", "02-111-2222");
		Bank b3 = new Bank("ȫ����", "02-111-3333");
		
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();

		// b1�� �����Ͽ� �������� �ٲٴ� ���� �����ϳ� ���� b100���� �ִٰ� �����Ͽ��� ��, ��� ���� �ٲ�����Ѵٸ�?
		// static������ �޼���� Ŭ����.static����(�޼���)�� ���� ȣ���ؼ� ����Ѵ�.
		Bank.interest = 0.1f;

		// interest�� static���� ������ ��, ��� ���� ����Ǵ� ���� Ȯ��
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();

		
		
	
		
		
		
	}
}
