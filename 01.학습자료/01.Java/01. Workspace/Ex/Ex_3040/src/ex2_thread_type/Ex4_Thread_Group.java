package ex2_thread_type;

public class Ex4_Thread_Group {
	public static void main(String[] args) throws Exception {
		/*	������ �׷�
		 * 		- ���� ���õ� �����带 �׷����� ����
		 * 		- ������ �׷쿡 �ٸ� �����带 �׷����� ��� ���� �����ϴ�.
		 * 		- ���� ���� ������ ���ԵǾ�����, ���� �׷��� ���� �����ϳ� �ٸ� ������ �׷��� ������ �Ұ����ϴ�.
		 * 		- ��� ������� �׷쿡 ���ԵǾ��־���ϸ�, �����ڸ� ���ؼ� �׷��� �������� ���� ������� �⺻������ �ڽ��� ������ ������� ���� �׷쿡 ���Ѵ�.
		 * 		
		 * 		�������� ���� ����
		 * 			(1) �ڹ� ���ø����̼� ����
		 * 			(2) JVM���� main, system �̶�� ������ �׷� ����
		 * 			(3) �׷��� ���� �����ϴ� ��� ������� main ������ �׷��� ���� �׷��� �Ǹ�
		 * 			(4) ���� ������ �׷��� �������� ���� ������� main ������ �׷쿡 ���Եȴ�.
		 * 
		 * 		������ �׷� ���� �޼ҵ�
		 * 			(1) getThreadGroup : ������ �ڽ��� ���� �׷� ��ȯ
		 * 			(2) uncaughtException : ������ �׷��� �����尡 ó������ ���� ���ܿ� ���� ������ ����Ǿ��� �� JVM�� ���ؼ� �ڵ����� ȣ��
		 */
		
		//  ������ �׷� ����
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		// ���� ������ �׷� ����
		ThreadGroup sub1 = new ThreadGroup(grp1, "sub1");

		// ������ �׷� grp1�� �ִ� �켱���� 3���� ����
		// �����尡 �׷쿡 �߰��Ǳ� ���� �����Ѵ�.
		grp1.setMaxPriority(3);	
		
		Runnable r = new Runnable() {
			// �޼ҵ� ������
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
			}
		};
		// ������ �׷쿡 ����
		// - �������� ���� �����Ͽ����� ������ �׷쿡 ���������Ƿ� ������ �÷����� ��� ���Ե��� �ʴ´�.
		new Thread(grp1, r, "th1").start();;
		new Thread(sub1, r, "th2").start();;
		new Thread(grp2, r, "th3").start();;
		//
		System.out.println("List of ThreadGroup : " + main.getName() + ", Active ThreadGroup : " + main.activeGroupCount() + ", Active Thread : " + main.activeCount());
		
		// ������ �׷쿡 ���� ������� ���� ������ �׷쿡���� ���� ��ȸ
		// �켱������ 3�� grp1�� sub1�� grp2���� ���� ��ȸ�ȴ�.
		main.list();
	}
}
