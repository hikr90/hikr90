package ex2_demon;

public class DaemonMain {
	
	public static void main(String[] args) {
		
		/* ���󽺷���
		 * ���� �������� �۾��� ���� �������� ������ �����ϴ� �������̴�.
		 * ��(����)�� ȣ���� ���ν����尡 ����Ǹ� �������� ���� �����嵵 �Բ� ���� ����� �� �ֵ��� ó���Ѵ�. 
		*/
		
		
		DaemonTest dt = new DaemonTest();
		Thread t = new Thread(dt);
		
		// (�߿�!)start���� ������Ѵ�.
		// t��� �����尡 �������� ������ش�.
		// t�� ���� ������μ�, ��ŸƮ��Ų ������ �����尡 ����Ǹ� t���� ����ȴ�.
		t.setDaemon(true);		
		t.start();
		
		// ���ο����� �۾�
		for(int i=1; i<=20;i++) {
		
			try {
				Thread.sleep(1000);
				System.out.println("������"+i);
			} catch (Exception e) {

			}
		}
		
		System.out.println("���� ������ ����");
		
		
	}	
}
