package ex5_sleep;

public class SleepMain {
	public static void main(String[] args) throws InterruptedException{
		//
		SleepEx se = new SleepEx();
		se.start();

		// ������ "���α׷� ����"�� ���� �� �������� �۾���Ű�� �ʹٸ� �ش� ����
		Thread.sleep(11000);
		System.out.println("���α׷� ����");
	}
}
