package ex3_demon;

public class Ex1_Demon_Thread {
	
	public static void main(String[] args) {
		/* ���󽺷���
		 *		- ���� �������� �۾��� ���� �������� ������ �����ϴ� ������
		 *		- ���� �����尡 ����Ǹ� ���� ���� ���� �����嵵 ���� ����ȴ�. 
		 *				(������ �÷���, �������μ��� �ڵ�����, ȭ�� �ڵ� ����)
		 *
		 *			[����] �ֿ� �޼ҵ�
		 *				- isDemon : �����尡 ���� ���������� ����
		 *				- setDemon : �����忡�� ���� ������ Ȥ�� ����� ������� ����
		 *					(���� ������ ������ �����尡 �����ϱ� ���� ����Ǿ�� �Ѵ�.)
		 */
		Ex2_Demon_Thread dt = new Ex2_Demon_Thread();
		Thread t = new Thread(dt);
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
