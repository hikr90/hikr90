package ex2_demon;

public class DaemonMain {
	
	public static void main(String[] args) {
		
		/* ���󽺷���
		 *		- ���� �������� �۾��� ���� �������� ������ �����ϴ� ������
		 *		- ���� �����尡 ����Ǹ� ���� ���� ���� �����嵵 ���� ����ȴ�. 
		 */
		DaemonTest dt = new DaemonTest();
		Thread t = new Thread(dt);
		
		// - (�߿�) start ���� setDaemon�� ������Ѵ�.
		// - setDaemon�� �����尡 �������� ����Ѵ�.
		// - t�� ���� ������μ�, ��ŸƮ��Ų ������ �����尡 ����Ǹ� ���� ������ ���� ����ȴ�.
		t.setDaemon(true);		
		t.start();
		
		// ���ο����� �۾�
		for(int i=1; i<=20;i++) {
			//
			try {
				Thread.sleep(1000);
				System.out.println("������"+i);
				
			} catch (Exception e) {

			}
		}
		//
		System.out.println("���� ������ ����");
	}	
}
